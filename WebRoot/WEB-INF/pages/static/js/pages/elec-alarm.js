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
		var user1 = $("#errClass").data("kendoComboBox");
		end.max(new Date(2099, 11, 31));
		end.min(new Date(1900, 0, 1));
		end.value(null);
		start.max(new Date(2099, 11, 31));
		start.min(new Date(1900, 0, 1));
		start.value(null);
		user1.value(200);
		
	});

	$("#tab-chart").on('shown.bs.tab', function(e) {
		reloadChart();
	})

	$("#tab-data").on('shown.bs.tab', function(e) {
		reloadGrid();
	})

	$("#submit-dp").click(function() {
		
		
			reloadGrid();
	
	});

	var today = new Date();

	var start = $("#start").kendoDateTimePicker({
		change : startChange,
		format : "yyyy-MM-dd HH:mm:ss",
		culture : "zh-CN"
	}).data("kendoDateTimePicker");
	start.value(new Date(today.getFullYear(),today.getMonth(),today.getDate()-1));
	var end = $("#end").kendoDateTimePicker({
		change : endChange,
		format : "yyyy-MM-dd HH:mm:ss",
		culture : "zh-CN"
	}).data("kendoDateTimePicker");
	end.value(today);
	
	$("#errClass").kendoComboBox({
		placeholder : "请选择",
		dataTextField : "errText",
		dataValueField : "errClass",
		dataSource:[
		 { errClass: 200, errText: "全部报警" },
		 { errClass: 201, errText: "低电压" },
		 { errClass: 202, errText: "超低电压" },
		 { errClass: 210, errText: "掉电，电压正常" },
		 { errClass: 211, errText: "掉电，低电压" },
		 { errClass: 212, errText: "掉电，电压超低" }
		],
		index: 0	
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
					url : _ctx + "/api/error/query?errClass=" + $("#errClass").data("kendoComboBox").value() + "&beginDate=" + $("#start").val() + "&endDate=" + $("#end").val(),
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
//		change : function(e) {
//			var selectedRows = this.select();
//			var selectedDataItems = [];
//			for (var i = 0; i < selectedRows.length; i++) {
//				var dataItem = this.dataItem(selectedRows[i]);
//				selectedDataItems.push(dataItem);
//			}
//			// selectedDataItems contains all selected data items
//			// alert(JSON.stringify(selectedDataItems));
//			this.dataSource.read();
//		},
		dataBound : function(e) {
			var data = this.dataSource.data();
			$.each(data, function(i, row) {
				if (row.errProcessFlag == 0) {
					$('tr[data-uid="' + row.uid + '"] ').css("color", "red");
				}
			});
		},
		columns : [ {
			field : "nm",
			title : "用户名称",
			width : 200
		},
		{
			field : "info",
			title : "故障信息",
			width : 500
		},
		{
			field : "readTime",
			title : "通讯时间",
			width : 300
		}],

	});

	function startChange() {
		var endDateMax = new Date(start.value().getFullYear() + 1, 0, 0, 23, 59, 59);

		var startDate = start.value(), endDate = end.value();

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
		var startDateMin = new Date(end.value().getFullYear(), 0, 1);

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
		start.min(startDateMin);
	}

	function initDateTimePicker() {
		start.max(end.value());
		end.min(start.value());
		var endDateMax = new Date(start.value().getFullYear() + 1, 0, 0, 23, 59, 59);
		var startDateMin = new Date(end.value().getFullYear(), 0, 1);
		end.max(endDateMax);
		start.min(startDateMin);
	}

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
						url : _ctx + "/api/error/query?errClass=" + $("#errClass").data("kendoComboBox").value() + "&beginDate=" + $("#start").val() + "&endDate=" + $("#end").val(),
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
		if (!validate()) {
			alert("请输入查询参数");
			return;
		}
		var grid = $("#grid").data("kendoGrid");
		grid.setOptions({
			dataSource : {
				transport : {
					read : {
						url : _ctx + "/api/error/query?errClass=" + $("#errClass").data("kendoComboBox").value() + "&beginDate=" + $("#start").val() + "&endDate=" + $("#end").val(),
						dataType : "jsonp"
					}
				},
				pageSize : 20,
			}
		});
	}

	function validate() {
		if ($("#errClass").data("kendoComboBox").value() == "" || $("#start").val() == "" || $("#end").val() == "") {
			return false;
		}
		return true;
	}
});