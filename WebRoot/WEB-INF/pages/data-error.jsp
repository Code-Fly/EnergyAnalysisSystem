<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="meta/config.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>能源监测系统</title>
<%@ include file="meta/meta.jsp"%>
<script type="text/javascript" src="${ctx}/static/js/pages/data-error.js"></script>
</head>
<body>
	<div id="wrapper">
		<%@ include file="meta/navigator.jsp"%>
		<!-- /#Navigation -->
		<div id="page-wrapper">
			<div class="container-fluid">
				<div class="row">
					<div class="col-lg-12">
						<h1 class="page-header">数据异常</h1>
						<div class="row show-grid">
							<div class="col-md-5 text-center">
								开始时间：<input id="start" />
							</div>
							<div class="col-md-5 text-center">
								结束时间：<input id="end" />
							</div>
							<div class="col-md-2 text-center">
								<button id="submit-dp" class='k-button'>提交</button>
								<button id="reset-dp" class='k-button'>重置</button>
							</div>
						</div>
						<div class="panel panel-default">
							<div class="panel-heading">
								<i class="fa fa-bar-chart-o fa-fw"></i> 信息
								<div class="pull-right">
									<div class="btn-group">
										<button type="button" class="btn btn-default btn-xs dropdown-toggle" data-toggle="dropdown">
											导出 <span class="caret"></span>
										</button>
										<ul class="dropdown-menu pull-right" role="menu">
											<li><a href="#" id="export-excel">导出Excel</a></li>
										</ul>
									</div>
								</div>
							</div>
							<!-- /.panel-heading -->
							<div class="panel-body">
								<div id="grid" style="margin-top: 1em;"></div> </div>
								<!-- /.panel-body -->
						</div>
						<!-- /.panel -->
					</div>
					<!-- /.col-lg-12 -->
				</div>
				<!-- /.row -->
			</div>
			<!-- /.container-fluid -->
		</div>
		<!-- /#page-wrapper -->
	</div>
	<!-- /#wrapper -->
</body>
</html>
