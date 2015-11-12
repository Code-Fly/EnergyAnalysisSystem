<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!-- Navigation -->
<nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
	<div class="navbar-header">

		<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
			<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
		</button>
		<a class="navbar-brand" href="index">能源监测系统</a>
	</div>
	<!-- /.navbar-header -->

	<ul class="nav navbar-top-links navbar-right">
		<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#"> <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
		</a>
			<ul class="dropdown-menu dropdown-user">
				<li><a href="#"><i class="fa fa-user fa-fw"></i> 用户</a></li>
				<li><a href="#"><i class="fa fa-gear fa-fw"></i> 设置</a></li>
				<li class="divider"></li>
				<li><a href="login"><i class="fa fa-sign-out fa-fw"></i> 登出</a></li>
			</ul> <!-- /.dropdown-user --></li>
		<!-- /.dropdown -->
	</ul>
	<!-- /.navbar-top-links -->

	<div class="navbar-default sidebar" role="navigation">
		<div class="sidebar-nav navbar-collapse">
			<ul class="nav" id="side-menu">
				<li class="sidebar-search">
					<div class="input-group custom-search-form">
						<input type="text" class="form-control" placeholder="放logo"> <span class="input-group-btn">
							<button class="btn btn-default" type="button">
								<i class="fa fa-search"></i>
							</button>
						</span>
					</div> <!-- /input-group -->
				</li>
				<li><a href="meter"><i class="fa fa-dashboard fa-fw"></i> 主状态表</a></li>
				<li><a href="readrec"><i class="fa fa-bar-chart-o fa-fw"></i> 趋势分析</a></li>
				<li><a href="#"><i class="fa fa-table fa-fw"></i> Tables</a></li>
				<li><a href="#"><i class="fa fa-edit fa-fw"></i> Forms</a></li>
				<li><a href="#"><i class="fa fa-wrench fa-fw"></i> UI Elements</a></li>
				<li><a href="#"><i class="fa fa-sitemap fa-fw"></i> Multi-Level Dropdown</a></li>
				<li><a href="#"><i class="fa fa-files-o fa-fw"></i> Sample Pages</a></li>
			</ul>
		</div>
		<!-- /.sidebar-collapse -->
	</div>
	<!-- /.navbar-static-side -->
</nav>
