$(document).ready(function() {
	var dataSource = new kendo.data.DataSource({
		transport : {
			read : {
				url : _ctx + "/api/meter/query",
				dataType : "jsonp"
			}
		},
		pageSize : 10,
	});

	$("#grid").kendoGrid({
		dataSource : dataSource,
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
			alert(JSON.stringify(selectedDataItems));
			refreshGrid();
		},
		dataBound : function(e) {
			var grid = $("#grid").data("kendoGrid");
			var data = grid.dataSource.data();
			$.each(data, function(i, row) {
				if (row.ch == 2) {
					$('tr[data-uid="' + row.uid + '"] ').css("background-color", "#ffb6a6").css("color", "#fff");
				}
			});
		},
		columns : [ {
			locked : true,
			field : "adr",
			title : "表具编号",
			width : 200
		}, {
			template : function(dataItem) {
				if (3 == dataItem.ch) {
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

	$("#export").click(function(e) {
		var grid = $("#grid").data("kendoGrid");
		grid.saveAsExcel();
	});
	// var grid = $("#grid").data("kendoGrid");
	// grid.bind("change", grid_change);

	function grid_change(e) {
		var selectedCells = this.select();
		var selectedDataItems = [];
		for (var i = 0; i < selectedCells.length; i++) {
			var dataItem = this.dataItem(selectedCells[i].parentNode);
			if ($.inArray(dataItem, selectedDataItems) < 0) {
				selectedDataItems.push(dataItem);
			}
		}
		// selectedDataItems contains all selected data items

		var selected = $.map(this.select(), function(item) {
			return $(item).text();
		});
		refreshGrid();
		// alert("Selected: " + selected.length + " item(s), [" +
		// selected.join(", ") + "]");
		alert(JSON.stringify(selectedDataItems));
	}

	function refreshGrid() {
		dataSource.read();
	}
});