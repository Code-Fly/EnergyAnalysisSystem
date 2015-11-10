<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div data-role="footer" data-position="fixed">
	<div data-role="navbar" id="footer-nav">
		<ul>
			<li><a id="nav_bar_btn_home" href="${ctx}/mobile/home" data-icon="home" data-ajax="false">首页</a></li>
			<li><a id="nav_bar_btn_order" href="${ctx}/mobile/order-list" data-icon="shop" data-ajax="true">订单</a></li>
			<li><a id="nav_bar_btn_favs" href="${ctx}/mobile/space" data-icon="user" data-ajax="true">我的</a></li>
		</ul>
	</div>
	<!-- /navbar -->
</div>
