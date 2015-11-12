<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="meta/config.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>能源监测系统</title>
<%@ include file="meta/meta.jsp"%>
<script type="text/javascript" src="${ctx}/static/js/pages/readrec.js"></script>
</head>
<body>
	<div id="example">
		<div class="box wide">
			<h4>Advanced Export options</h4>
			<div class="box-col">
				<button class='export-img k-button'>Export as Image</button>
			</div>
			<div class="box-col">
				<button class='export-svg k-button'>Export as SVG</button>
			</div>
		</div>
		<div style="width: 20em;">
			<h4>Start date</h4>
			<input id="start" style="width: 100%;" />

			<h4 style="margin-top: 2em;">End date</h4>
			<input id="end" style="width: 100%;" />
			
			<h4 style="margin-top: 2em;">Reset</h4>
			<button id="reset-dp" class='k-button'>Reset</button>

		</div>
		<div id="chart" style="position: relative; background: url(${ctx}/static/images/world-map.png) 50% 50% no-repeat;"></div>
	</div>
</body>
</html>
