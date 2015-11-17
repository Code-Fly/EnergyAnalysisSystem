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
				<li><a href="#"><i class="fa fa-user fa-fw"></i> <span id="nav-userName">用户</span></a></li>
				<li><a href="authorization"><i class="fa fa-gear fa-fw"></i> 设置</a></li>
				<li class="divider"></li>
				<li><a id="logout" href="#"><i class="fa fa-sign-out fa-fw"></i> 登出</a></li>
			</ul> <!-- /.dropdown-user --></li>
		<!-- /.dropdown -->
	</ul>
	<!-- /.navbar-top-links -->

	<div class="navbar-default sidebar" role="navigation">
		<div class="sidebar-nav navbar-collapse">
			<ul class="nav" id="side-menu">
				<li class="sidebar-search" style="background-image: url(${ctx}/static/images/logo.jpg);background-origin:content;background-position:50% 50%;background-size:contain;background-repeat:no-repeat;height:82px;">
					<div class="input-group custom-search-form" >
						&nbsp;
					</div> <!-- /input-group -->
				</li>
				<li><a href="meter"><i class="fa fa-table fa-fw"></i> 主状态表</a></li>
				<li><a href="readrec"><i class="fa fa-bar-chart-o fa-fw"></i> 趋势分析</a></li>
				<li><a href="daily-use"><i class="fa fa-calendar-minus-o fa-fw"></i> 日用量分析</a></li>
				<li><a href="monthly-use"><i class="fa fa-calendar-plus-o fa-fw"></i> 月用量分析</a></li>
				<li><a href="yearly-use"><i class="fa fa-calendar-times-o fa-fw"></i> 年用量分析</a></li>
				<li><a href="elec-alarm"><i class="fa fa-flash fa-fw"></i> 供电故障</a></li>
				<li><a href="gas-alarm"><i class="fa fa-fire fa-fw"></i> 停气报警</a></li>
				<li><a href="data-error"><i class="fa fa-exclamation-triangle fa-fw"></i> 数据异常</a></li>
				<li><a href="meter-log"><i class="fa fa-files-o fa-fw"></i> 抄电压记录</a></li>
				<li><a href="log"><i class="fa fa-database fa-fw"></i> 系统日志</a></li>
			</ul>
		</div>
		<!-- /.sidebar-collapse -->
	</div>
	<!-- /.navbar-static-side -->
</nav>
