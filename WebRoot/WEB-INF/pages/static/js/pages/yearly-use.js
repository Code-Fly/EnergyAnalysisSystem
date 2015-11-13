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
		end.max(new Date(today.getFullYear(), today.getMonth() + 1, 0));
		end.value(today);
		start.max(end.value());
		start.value(today);
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
		reloadChart();
		reloadGrid();
	});

	var today = new Date();

	var start = $("#start").kendoDatePicker({
		depth : "decade",
		start : "decade",
		value : today,
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
		dataSource : null
	});

	$("#chart").kendoChart({
		dataSource : {
			transport : {
				read : {
					url : _ctx + "/api/yearaccount/query?infoID=" + $("#user-2").data("kendoComboBox").value() + "&year=" + $("#start").val(),
					dataType : "jsonp"
				}
			}
		},
		series : [ {
			field : "janNumber",
			name : "一月 [kwh]",
			type : "column",
			markers : {
				visible : false
			},
			color : "#da3b36",
		// axis : "janNumber"
		}, {
			field : "febNumber",
			name : "二月 [kwh]",
			type : "column",
			markers : {
				visible : false
			},
			color : "#e67d4a",
		// axis : "febNumber"
		}, {
			field : "marNumber",
			name : "三月 [kwh]",
			type : "column",
			markers : {
				visible : false
			},
			color : "#f2b661",
		// axis : "marNumber"
		}, {
			field : "aprNumber",
			name : "四月 [kwh]",
			type : "column",
			markers : {
				visible : false
			},
			color : "#5cb85c",
		// axis : "aprNumber"
		}, {
			field : "mayNumber",
			name : "五月 [kwh]",
			type : "column",
			markers : {
				visible : false
			},
			color : "#5bc0de",
		// axis : "mayNumber"
		}, {
			field : "junNumber",
			name : "六月 [kwh]",
			type : "column",
			markers : {
				visible : false
			},
			color : "#428bca",
		// axis : "junNumber"
		}, {
			field : "julNumber",
			name : "七月 [kwh]",
			type : "column",
			markers : {
				visible : false
			},
			color : "#e5f5fa",
		// axis : "julNumber"
		}, {
			field : "augNumber",
			name : "八月 [kwh]",
			type : "column",
			markers : {
				visible : false
			},
			color : "#eaf7ec",
		// axis : "augNumber"
		}, {
			field : "sepNumber",
			name : "九月 [kwh]",
			type : "column",
			markers : {
				visible : false
			},
			color : "#fbeed5",
		// axis : "sepNumber"
		}, {
			field : "octNumber",
			name : "十月 [kwh]",
			type : "column",
			markers : {
				visible : false
			},
			color : "#ffe0d9",
		// axis : "octNumber"
		}, {
			field : "novNumber",
			name : "十一月 [kwh]",
			type : "column",
			markers : {
				visible : false
			},
			color : "#ebebeb",
		// axis : "novNumber"
		}, {
			field : "decNumber",
			name : "十二月 [kwh]",
			type : "column",
			markers : {
				visible : false
			},
			color : "#cccccc",
		// axis : "decNumber"
		} ],
		// valueAxes : [ {
		// name : "janNumber",
		// color : "#007eff"
		// }, {
		// name : "febNumber",
		// color : "#007eff"
		// }, {
		// name : "marNumber",
		// color : "#007eff"
		// }, {
		// name : "aprNumber",
		// color : "#007eff"
		// }, {
		// name : "mayNumber",
		// color : "#007eff"
		// }, {
		// name : "junNumber",
		// color : "#007eff"
		// }, {
		// name : "julNumber",
		// color : "#007eff"
		// }, {
		// name : "augNumber",
		// color : "#007eff"
		// }, {
		// name : "sepNumber",
		// color : "#007eff"
		// }, {
		// name : "octNumber",
		// color : "#007eff"
		// }, {
		// name : "novNumber",
		// color : "#007eff"
		// }, {
		// name : "decNumber",
		// color : "#007eff"
		// }],
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
			}
		// axisCrossingValues : [ 999999 ],
		},
		tooltip : {
			visible : true,
			template : "<div>#= series.name #: #= value #</div>"
		},
		chartArea : {
			background : "transparent"
		},
		dataBound : function(e) {
			// alert($("#user-2").data("kendoComboBox").value())
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
					url : _ctx + "/api/yearaccount/query?infoID=" + $("#user-2").data("kendoComboBox").value() + "&year=" + $("#start").val(),
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
			field : "ID",
			title : "ID",
			width : 200
		}, {
			field : "collectYear",
			title : "采集时间",
			width : 200
		}, {
			field : "janNumber",
			title : "一月",
			width : 200
		}, {
			field : "febNumber",
			title : "二月",
			width : 200
		}, {
			field : "marNumber",
			title : "三月",
			width : 200
		}, {
			field : "aprNumber",
			title : "四月",
			width : 200
		}, {
			field : "mayNumber",
			title : "五月",
			width : 200
		}, {
			field : "junNumber",
			title : "六月",
			width : 200
		}, {
			field : "julNumber",
			title : "七月",
			width : 200
		}, {
			field : "augNumber",
			title : "八月",
			width : 200
		}, {
			field : "sepNumber",
			title : "九月",
			width : 200
		}, {
			field : "octNumber",
			title : "十月",
			width : 200
		}, {
			field : "novNumber",
			title : "十一月",
			width : 200
		}, {
			field : "decNumber",
			title : "十二月",
			width : 200
		} ],

	});

	function reloadChart() {
		var chart = $("#chart").data("kendoChart");
		chart.setOptions({
			dataSource : {
				transport : {
					read : {
						url : _ctx + "/api/yearaccount/query?infoID=" + $("#user-2").data("kendoComboBox").value() + "&year=" + $("#start").val(),
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
		var grid = $("#grid").data("kendoGrid");
		grid.setOptions({
			dataSource : {
				transport : {
					read : {
						url : _ctx + "/api/yearaccount/query?infoID=" + $("#user-2").data("kendoComboBox").value() + "&year=" + $("#start").val(),
						dataType : "jsonp"
					}
				},
				pageSize : 20,
			}
		});
	}
});