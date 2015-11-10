<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="meta/config.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>能源监测系统</title>
<%@ include file="meta/meta.jsp"%>
</head>
<body>
	<div id="example">


		<button id="export">Export to Excel</button>
		<div id="grid"></div>

		<script>
			$(document).ready(function() {
				var dataSource = new kendo.data.DataSource({
					transport : {
						read : {
							url : _ctx + "/api/meter/query",
							dataType : "jsonp"
						}
					},
					pageSize : 10
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
					columns : [ {
						locked : true,
						field : "adr",
						title : "表具编号",
						width : 200
					}, {
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
					} ]
				});
				$("#export").click(function(e) {
					var grid = $("#grid").data("kendoGrid");
					grid.saveAsExcel();
				});
			});
		</script>
	</div>
</body>
</html>
