<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="meta/config.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>能源监测系统</title>
<%@ include file="meta/meta.jsp"%>
<script type="text/javascript" src="${ctx}/static/js/pages/daily-use.js"></script>
</head>
<body>
	<div id="wrapper">
		<%@ include file="meta/navigator.jsp"%>
		<!-- /#Navigation -->
		<div id="page-wrapper">
			<div class="container-fluid">
				<div class="row">
					<div class="col-lg-12">
						<h1 class="page-header">日用量分析</h1>
						<div class="row show-grid">
							<div class="col-md-4">
								<input id="user-1" style="width: 100%;" />
							</div>
							<div class="col-md-4">
								<input id="user-2" style="width: 100%;" />
							</div>
							<div class="col-md-4">
								<input id="user-3" style="width: 100%;" />
							</div>
						</div>
						<div class="row show-grid">
							<div class="col-md-5">
								<input id="start" style="width: 100%;" />
							</div>
							<div class="col-md-5">
								<input id="end" style="width: 100%;" />
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
											<li><a href="#" id="export-img">导出PNG图</a></li>
											<li><a href="#" id="export-svg">导出SVG图</a></li>
											<li class="divider"></li>
											<li><a href="#" id="export-excel">导出Excel</a></li>
										</ul>
									</div>
								</div>
							</div>
							<!-- /.panel-heading -->
							<div class="panel-body">
								<!-- Nav tabs -->
								<ul class="nav nav-tabs">
									<li class="active"><a id="tab-chart" href="#tab-content-chart" data-toggle="tab">柱状图</a></li>
									<li><a id="tab-data" href="#tab-content-data" data-toggle="tab">数据表</a></li>
								</ul>

								<!-- Tab panes -->
								<div class="tab-content">
									<div class="tab-pane fade in active" id="tab-content-chart">
										<div id="chart" style="position: relative; background: url(${ctx}/static/images/world-map.png) 50% 50% no-repeat;"></div>
									</div>
									<div class="tab-pane fade" id="tab-content-data">
										<div id="grid" style="margin-top: 1em;"></div>
									</div>

								</div>
							</div>
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
