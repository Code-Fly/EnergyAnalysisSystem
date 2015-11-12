$(document).ready(function() {
	$("#export-excel").click(function(e) {
		var grid = $("#grid").data("kendoGrid");
		grid.saveAsExcel();
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
					url : _ctx + "/api/meter/query",
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
			field : "adr",
			title : "表具编号",
			width : 200
		}, {
			template : function(dataItem) {
				if (null == dataItem.ch) {
					return "<div style='color:red;'>" + kendo.htmlEncode(dataItem.ch) + "</div>";
				} else {
					return dataItem.ch;
				}
			},
			field : "ch",
			title : "通道号",
			width : 200
		}, {
			field : "curNumber",
			title : "累计流量",
			width : 200
		}, {
			field : "dayDosage_hi",
			title : "日用量上限",
			width : 200
		}, {
			field : "dayDosage_low",
			title : "日用量下限",
			width : 200
		}, {
			field : "dayNum",
			title : "日用量",
			width : 200
		}, {
			field : "meterRange_Hi",
			title : "瞬时流量上限",
			width : 200
		}, {
			field : "meterRange_Low",
			title : "瞬时流量下限",
			width : 200
		}, {
			field : "mID",
			title : "系统ID",
			width : 200
		}, {
			field : "minDayNum",
			title : "初始日用量",
			width : 200
		}, {
			field : "minMonNum",
			title : "初始月用量",
			width : 200
		} ],

	});
});