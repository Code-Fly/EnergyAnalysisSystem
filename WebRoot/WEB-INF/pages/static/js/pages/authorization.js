$(document).ready(function() {
	var opID = SessionCache.get("opID");

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

	$("#submit-dp").click(function() {
		reloadGrid();
	});

	var today = new Date();

	var start = $("#start").kendoDatePicker({
		depth : "decade",
		start : "decade",
		format : "yyyy",
		culture : "zh-CN"
	}).data("kendoDatePicker");
	// start.value(new Date());
	$("#user-1").kendoComboBox({
		placeholder : "请选择",
		dataTextField : "nm",
		dataValueField : "infoID",
		dataSource : {
			transport : {
				read : {
					url : _ctx + "/api/tree/area/query",
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
						url : _ctx + "/api/tree/area/query?infoID=" + user1.value(),
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

	$("#grid").kendoGrid({
		excel : {
			fileName : "Export.xlsx",
			filterable : true,
			allPages : true
		},
		autoBind : false,
		sortable : true,
		filterable : true,
		pageable : {
			refresh : true,
			pageSizes : true,
			buttonCount : 5
		},
		selectable : "row",
		dataBound : function(e) {
			var data = this.dataSource.data();
			$.each(data, function(i, row) {
				if (null == row.infoID || "" == row.infoID) {
					$('tr[data-uid="' + row.uid + '"] ').find(".btn-remove").hide();
				} else {
					$('tr[data-uid="' + row.uid + '"] ').find(".btn-add").hide();
				}
				$('tr[data-uid="' + row.uid + '"] ').find(".k-button").removeClass("k-button k-button-icontext").addClass("btn btn-default");
			});
		},
		columns : [ {
			field : "nm",
			title : "表具名称",
		}, {
			field : "mem",
			title : "用户名"
		}, {
			command : [ {
				name : "add",
				text : "&nbsp;添加",
				className : "btn-add fa fa-plus",
				click : function(e) {
					// e.target is the DOM element representing the button
					var tr = $(e.target).closest("tr");
					// get the current table row (tr)
					// get the data bound to the current table row
					var data = this.dataItem(tr);
					// alert("Details for: " + data.mID);
					reloadGrid();
				}
			}, {
				name : "remove",
				text : "&nbsp;删除",
				className : "btn-remove fa fa-remove",
				click : function(e) {
					// e.target is the DOM element representing the button
					var tr = $(e.target).closest("tr");
					// get the current table row (tr)
					// get the data bound to the current table row
					var data = this.dataItem(tr);
					// alert("Details for: " + data.mID);
					reloadGrid();
				}
			} ],
			title : "&nbsp;",
			width : "100px"
		} ],
		editable : "inline"
	});

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
						url : _ctx + "/api/lience/query?opID=1",
						dataType : "jsonp"
					},
					update : {
						url : "/Products/Update",
						dataType : "jsonp"
					},
					destroy : {
						url : "/Products/Destroy",
						dataType : "jsonp"
					},
					create : {
						url : "/Products/Create",
						dataType : "jsonp"
					},
					parameterMap : function(options, operation) {
						if (operation !== "read" && options.models) {
							return {
								models : kendo.stringify(options.models)
							};
						}
					}
				},
				pageSize : 20,
			}
		});
		grid.dataSource.read();
	}

	function validate() {
		if ($("#user-2").data("kendoComboBox").value() == "" || $("#start").val() == "") {
			return false;
		}
		return true;
	}
});