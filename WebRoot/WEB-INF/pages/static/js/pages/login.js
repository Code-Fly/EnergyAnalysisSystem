$(document).ready(function() {
	$("#login").click(function(e) {
		$("#login").addClass("disabled");
		$.ajax({
			url : _ctx + "/api/login/query?opNm=" + $("#userName").val() + "&opPwd=" + $("#password").val(),
			cache : false,
			success : function(data, textStatus, jqXHR) {
				
				if ("" != data && null != data) {
					SessionCache.update("opID", data);
					window.location.href = _ctx + "/web/index";
				} else {
					SessionCache.remove("opID");
					alert("认证失败");
				}
				$("#login").removeClass("disabled");
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				SessionCache.remove("opID");
				alert("认证异常");
				$("#login").removeClass("disabled");
			}
		});
	});
});