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


		<div id="cellSelection"></div>

		<script>
			alert(_ctx + "/api/meter/query");
			$(document).ready(function() {
				var dataSource = new kendo.data.DataSource({
					transport : {
						read : {
							url : "http://127.0.0.1:8080/EnergyAnalysisSystem/api/meter/query",
							dataType : "jsonp"
						}
					},
					pageSize : 10
				});
				$("#cellSelection").kendoGrid({
					dataSource : dataSource,
					pageable : true
				});

			});
		</script>
	</div>
</body>
</html>
