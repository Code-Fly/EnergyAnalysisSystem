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
		var user1 = $("#user-1").data("kendoComboBox");
		var user2 = $("#user-2").data("kendoComboBox");
		var user3 = $("#user-3").data("kendoComboBox");
		start.value(null);
		user1.text(null);
		user1.value(null);
		user2.text(null);
		user2.value(null);
		user3.text(null);
		user3.value(null);
	});

	$("#tab-chart").on('shown.bs.tab', function(e) {
		reloadChart();
	})

	$("#tab-data").on('shown.bs.tab', function(e) {
		reloadGrid();
	})

	$("#submit-dp").click(function() {
		if($("#tab-content-chart").hasClass("active")){
			reloadChart();
		}
		if($("#tab-content-data").hasClass("active")){
			reloadGrid();
		}
	});

	var today = new Date();

	var start = $("#start").kendoDatePicker({
		depth : "decade",
		start : "decade",
		format : "yyyy",
		culture : "zh-CN"
	}).data("kendoDatePicker");

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
					url : _ctx + "/api/monthaccount/query?mID=" + $("#user-3").data("kendoComboBox").value() + "&year=" + $("#start").val(),
					dataType : "jsonp"
				}
			}
		},
		series : [ {
			field : "monthNumber",
			name : "日用量 [kwh]",
			type : "column",
			categoryField : "collectMon",
			markers : {
				visible : false
			},
			color : "#007eff",
			axis : "monthNumber"
		} ],
		valueAxes : [ {
			name : "monthNumber",
			color : "#007eff"
		} ],
		legend : {
			position : "bottom"
		},
		title : {
			text : $("#start").val()
		},
		categoryAxis : {
			majorGridLines : {
				visible : false
			},
			majorTicks : {
				visible : false
			},
			type : "date",
			baseUnit : "months",
			labels : {
				rotation : "auto",
				culture : "zh-CN",
				dateFormats : {
					months: "MMM-yy"
				}
			}
		// axisCrossingValues : [ 999999 ],
		},
		tooltip : {
			visible : true,
			template : "<div>#= series.name #: #= value #</div><div> #= dataItem.collectMon#</div>"
		},
		chartArea : {
			background : "transparent"
		},
		dataBound : function(e) {
			// alert($("#user-3").data("kendoComboBox").value())
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
					url : _ctx + "/api/monthaccount/query?mID=" + $("#user-3").data("kendoComboBox").value() + "&year=" + $("#start").val(),
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
			field : "monthNumber",
			title : "月用量",
			width : 300
		}, {
			template : function(dataItem) {
				if (null == dataItem.areaID) {
					return "<div style='color:red;'>" + kendo.htmlEncode(dataItem.areaID) + "</div>";
				} else {
					return dataItem.areaID;
				}
			},
			field : "areaID",
			title : "区域ID",
			width : 300
		}, {
			field : "collectMon",
			title : "采集时间",
			width : 300
		} ],

	});

	function reloadChart() {
		if (!validate()) {
			alert("请输入查询参数");
			return;
		}
		var chart = $("#chart").data("kendoChart");
		chart.setOptions({
			dataSource : {
				transport : {
					read : {
						url : _ctx + "/api/monthaccount/query?mID=" + $("#user-3").data("kendoComboBox").value() + "&year=" + $("#start").val(),
						dataType : "jsonp"
					}
				}
			},
			title : {
				text : $("#start").val()
			},
		});
	}

	function reloadGrid() {
		if (!validate()) {
			alert("请输入查询参数");
			return;
		}
		var grid = $("#grid").data("kendoGrid");
		grid.setOptions({
			dataSource : {
				transport : {
					read : {
						url : _ctx + "/api/monthaccount/query?mID=" + $("#user-3").data("kendoComboBox").value() + "&year=" + $("#start").val(),
						dataType : "jsonp"
					}
				},
				pageSize : 20,
			}
		});
	}
	
	function validate() {
		if ($("#user-3").data("kendoComboBox").value() == "" || $("#start").val() == "") {
			return false;
		}
		return true;
	}
});