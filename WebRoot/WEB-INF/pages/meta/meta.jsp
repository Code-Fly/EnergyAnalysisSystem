<%@page import="net.sf.json.JSONObject"%>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<SCRIPT type="text/javascript">
	var _ctx = "${ctx}";
	var _user = <%=JSONObject.fromObject(u)%>;
</SCRIPT>
<!-- external js -->
<script type="text/javascript" src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=1.2"></script>
<!-- common js -->
<script type="text/javascript" src="${ctx}/mobile/static/js/jquery.js"></script>
<script type="text/javascript" src="${ctx}/mobile/static/js/jquery.mobile-1.4.5.min.js"></script>
<script type="text/javascript" src="${ctx}/mobile/static/js/jquery.sliderPro.min.js"></script>
<script type="text/javascript" src="${ctx}/mobile/static/js/jquery.ui.datepicker.js"></script>
<script type="text/javascript" src="${ctx}/mobile/static/js/jquery.mobile.datepicker.js"></script>
<script type="text/javascript" src="${ctx}/mobile/static/js/sha.js"></script>
<!-- mobile js  -->
<script type="text/javascript" src="${ctx}/mobile/static/js/mobile/const-mlmjwys.js"></script>
<script type="text/javascript" src="${ctx}/mobile/static/js/mobile/global.js"></script>
<script type="text/javascript" src="${ctx}/mobile/static/js/mobile/home.js"></script>
<script type="text/javascript" src="${ctx}/mobile/static/js/mobile/order-list.js"></script>
<script type="text/javascript" src="${ctx}/mobile/static/js/mobile/space.js"></script>
<script type="text/javascript" src="${ctx}/mobile/static/js/mobile/product-list.js"></script>
<script type="text/javascript" src="${ctx}/mobile/static/js/mobile/product-detail.js"></script>
<script type="text/javascript" src="${ctx}/mobile/static/js/mobile/purchase-select-employee.js"></script>
<script type="text/javascript" src="${ctx}/mobile/static/js/mobile/purchase-select-time.js"></script>
<script type="text/javascript" src="${ctx}/mobile/static/js/mobile/purchase-confirm.js"></script>
<script type="text/javascript" src="${ctx}/mobile/static/js/mobile/purchase-input-address.js"></script>
<script type="text/javascript" src="${ctx}/mobile/static/js/mobile/technician.js"></script>
<script type="text/javascript" src="${ctx}/mobile/static/js/mobile/purchase-select-shop.js"></script>
<script type="text/javascript" src="${ctx}/mobile/static/js/mobile/shop-list.js"></script>
<script type="text/javascript" src="${ctx}/mobile/static/js/mobile/shop-detail.js"></script>
<script type="text/javascript" src="${ctx}/mobile/static/js/mobile/technician-comment-list.js"></script>
<script type="text/javascript" src="${ctx}/mobile/static/js/mobile/scratch-card.js"></script>
<script type="text/javascript" src="${ctx}/mobile/static/js/mobile/wScratchPad.js"></script>
<%-- <script type="text/javascript" src="${ctx}/mobile/static/js/mobile/json2.js"></script> --%>

<!--  mobile css -->
<link rel="shortcut icon" href="${ctx}/mobile/static/images/favicon.ico">
<link rel="stylesheet" href="${ctx}/mobile/static/css/themes/default/jquery.mobile-1.4.5.min.css">
<link rel="stylesheet" href="${ctx}/mobile/static/css/themes/manicure/manicure.css" />
<link rel="stylesheet" href="${ctx}/mobile/static/css/themes/manicure/jquery.mobile.icons.min.css" />
<link rel="stylesheet" href="${ctx}/mobile/static/css/slider-pro.min.css">
<link rel="stylesheet" href="${ctx}/mobile/static/css/listview-grid.css">
<link rel="stylesheet" href="${ctx}/mobile/static/css/jquery.mobile.datepicker.css" />

<link rel="stylesheet" href="${ctx}/mobile/static/css/mobile/global.css" />
