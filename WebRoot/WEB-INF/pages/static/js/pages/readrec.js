$(document).ready(function() {
	$("#export-img").click(function() {
		var chart = $("#chart").getKendoChart();
		chart.exportImage().done(function(data) {
			kendo.saveAs({
				dataURI : data,
				fileName : "chart.png",
			});
		});
	});

	$("#export-svg").click(function() {
		var chart = $("#chart").getKendoChart();
		chart.exportSVG().done(function(data) {
			kendo.saveAs({
				dataURI : data,
				fileName : "chart.svg",
			});
		});
	});

	$("#export-excel").click(function(e) {
		var grid = $("#grid").data("kendoGrid");
		grid.saveAsExcel();
	});

	$("#reset-dp").click(function() {
		end.max(new Date(today.getFullYear(), today.getMonth() + 1, 0));
		end.value(today);
		start.max(end.value());
		start.value(today);
	});

	$("#tab-chart").on('shown.bs.tab', function(e) {
		reloadChart();
	})

	$("#tab-data").on('shown.bs.tab', function(e) {
		reloadGrid();
	})

	$("#submit-dp").click(function() {
		reloadChart();
		reloadGrid();
	});

	var today = new Date();

	var start = $("#start").kendoDateTimePicker({
		value : today,
		change : startChange,
		format : "yyyy-MM-dd HH:mm:ss",
		culture : "zh-CN"
	}).data("kendoDateTimePicker");

	var end = $("#end").kendoDateTimePicker({
		value : today,
		change : endChange,
		format : "yyyy-MM-dd HH:mm:ss",
		culture : "zh-CN"
	}).data("kendoDateTimePicker");

	initDateTimePicker();

	$("#user-1").kendoComboBox({
		placeholder : "请选择",
		dataTextField : "nm",
		dataValueField : "infoID",
		dataSource : {
			transport : {
				read : {
					url : _ctx + "/api/tree/query",
					dataType : "jsonp"
				}
			}
		},
		change : function(e) {
			var user1 = $("#user-1").data("kendoComboBox");
			var user2 = $("#user-2").data("kendoComboBox");
			user2.setDataSource({
				transport : {
					read : {
						url : _ctx + "/api/tree/query?infoID=" + user1.value(),
						dataType : "jsonp"
					}
				}
			});
			user2.text(null);
			user2.value(null);
		}
	});

	$("#user-2").kendoComboBox({
		placeholder : "请选择",
		dataTextField : "nm",
		dataValueField : "infoID",
		dataSource : null,
		change : function(e) {
			var user2 = $("#user-2").data("kendoComboBox");
			var user3 = $("#user-3").data("kendoComboBox");
			user3.setDataSource({
				transport : {
					read : {
						url : _ctx + "/api/tree/query?infoID=" + user2.value(),
						dataType : "jsonp"
					}
				}
			});
			user3.text(null);
			user3.value(null);
		}
	});

	$("#user-3").kendoComboBox({
		placeholder : "请选择",
		dataTextField : "nm",
		dataValueField : "infoID",
		dataSource : null
	});

	$("#chart").kendoChart({
		dataSource : {
			transport : {
				read : {
					url : _ctx + "/api/readrec/query?mID=" + $("#user-3").data("kendoComboBox").value() + "&beginDate=" + $("#start").val() + "&endDate=" + $("#end").val(),
					dataType : "jsonp"
				}
			}
		},
		series : [ {
			field : "tFlow",
			name : "瞬时流量 [kwh]",
			style : "smooth",
			type : "line",
			markers : {
				visible : false
			},
			color : "#ff1c1c",
			axis : "tFlow"
		}, {
			field : "p",
			name : "压力 [pa]",
			style : "smooth",
			type : "line",
			markers : {
				visible : false
			},
			color : "#ffae00",
			axis : "p"
		}, {
			field : "t",
			name : "温度 [&deg;C]",
			style : "smooth",
			type : "line",
			markers : {
				visible : false
			},
			color : "#73c100",
			axis : "t"
		} ],
		valueAxes : [ {
			name : "tFlow",
			color : "#ff1c1c"
		}, {
			name : "p",
			color : "#ffae00"
		}, {
			name : "t",
			color : "#73c100"
		} ],
		legend : {
			position : "bottom"
		},
		title : {
			text : $("#start").val() + " ~ " + $("#end").val()
		},
		categoryAxis : {
			majorGridLines : {
				visible : false
			},
			majorTicks : {
				visible : false
			},
			axisCrossingValues : [ 999999, 999999, 0 ],
		},
		tooltip : {
			visible : true,
			template : "<div>#= series.name #: #= value #</div><div> #= dataItem.readTime#</div>"
		},
		chartArea : {
			background : "transparent"
		},
		dataBound : function(e) {
			//alert($("#user-3").data("kendoComboBox").value())
		}
	});

	$("#grid").kendoGrid({
		excel : {
			fileName : "Export.xlsx",
			filterable : true,
			allPages : true
		},
		dataSource : {
			transport : {
				read : {
					url : _ctx + "/api/readrec/query?mID=" + $("#user-3").data("kendoComboBox").value() + "&beginDate=" + $("#start").val() + "&endDate=" + $("#end").val(),
					dataType : "jsonp"
				}
			},
			pageSize : 10,
		},
		sortable : true,
		filterable : true,
		pageable : {
			refresh : true,
			pageSizes : true,
			buttonCount : 5
		},
		selectable : "row",
		change : function(e) {
			var selectedRows = this.select();
			var selectedDataItems = [];
			for (var i = 0; i < selectedRows.length; i++) {
				var dataItem = this.dataItem(selectedRows[i]);
				selectedDataItems.push(dataItem);
			}
			// selectedDataItems contains all selected data items
			// alert(JSON.stringify(selectedDataItems));
			this.dataSource.read();
		},
		dataBound : function(e) {
			var data = this.dataSource.data();
			$.each(data, function(i, row) {
				if (row.stopFlag == 1) {
					$('tr[data-uid="' + row.uid + '"] ').css("color", "red");
				}
			});
		},
		columns : [ {
			locked : true,
			field : "nm",
			title : "表具名称",
			width : 200
		}, {
			field : "curNumber",
			title : "当前数值",
			width : 200
		}, {
			field : "tFlow",
			title : "瞬时流量",
			width : 200
		}, {
			template : function(dataItem) {
				if (null == dataItem.p) {
					return "<div style='color:red;'>" + kendo.htmlEncode(dataItem.p) + "</div>";
				} else {
					return dataItem.p;
				}
			},
			field : "p",
			title : "压力",
			width : 200
		}, {
			field : "t",
			title : "温度",
			width : 200
		}, {
			field : "readTime",
			title : "读数时间",
			width : 200
		}, {
			field : "comTime",
			title : "结束时间",
			width : 200
		} ],

	});

	function startChange() {
		var startDate = start.value(), endDate = end.value();
		var endDateMax = new Date(start.value().getFullYear(), start.value().getMonth() + 1, 0);

		if (startDate) {
			startDate = new Date(startDate);
			startDate.setDate(startDate.getDate());
			end.min(startDate);
		} else if (endDate) {
			start.max(new Date(endDate));
		} else {
			endDate = new Date();
			start.max(endDate);
			end.min(endDate);
		}
		end.max(endDateMax);
	}

	function endChange() {
		var endDate = end.value(), startDate = start.value();

		if (endDate) {
			endDate = new Date(endDate);
			endDate.setDate(endDate.getDate());
			start.max(endDate);
		} else if (startDate) {
			end.min(new Date(startDate));
		} else {
			endDate = new Date();
			start.max(endDate);
			end.min(endDate);
		}
	}

	function initDateTimePicker() {
		start.max(end.value());
		end.min(start.value());
		var endDateMax = new Date(start.value().getFullYear(), start.value().getMonth() + 1, 0);
		end.max(endDateMax);
	}

	function reloadChart() {
		var chart = $("#chart").data("kendoChart");
		chart.setOptions({
			dataSource : {
				transport : {
					read : {
						url : _ctx + "/api/readrec/query?mID=" + $("#user-3").data("kendoComboBox").value() + "&beginDate=" + $("#start").val() + "&endDate=" + $("#end").val(),
						dataType : "jsonp"
					}
				}
			},
			title : {
				text : $("#start").val() + " ~ " + $("#end").val()
			},
		});
	}

	function reloadGrid() {
		var grid = $("#grid").data("kendoGrid");
		grid.setOptions({
			dataSource : {
				transport : {
					read : {
						url : _ctx + "/api/readrec/query?mID=" + $("#user-3").data("kendoComboBox").value() + "&beginDate=" + $("#start").val() + "&endDate=" + $("#end").val(),
						dataType : "jsonp"
					}
				},
				pageSize : 20,
			}
		});
	}
});