<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="meta/config.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>能源监测系统</title>
<%@ include file="meta/meta.jsp"%>
<script type="text/javascript" src="${ctx}/static/js/pages/meter.js"></script>
</head>
<body>
	<div id="wrapper">
		<%@ include file="meta/navigator.jsp"%>
		<!-- /#Navigation -->
		<div id="page-wrapper" style="padding-top: 2em;padding-bottom: 2em;">
			<div id="grid"></div>
		</div>
		<!-- /#page-wrapper -->
	</div>
	<!-- /#wrapper -->
</body>
</html>
