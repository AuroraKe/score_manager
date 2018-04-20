/*
 * 首页用户登录时进行认证
 * */

$(function() {
	$("input").click(function() {
		$(":input[name='username']").mousemove(function(){
			var username = $(this).val().trim();
			if(username==null || username.length==0){
				$("#error").html("<font color='red' align='right'>用户名不能为空</font>");
			}else{
				$(":input[name='password']").mousemove(function(){
					var password = $(this).val().trim();
					if(password==null || password.length==0){
						$("#error").html("<font color='red'>密码不能为空</font>");
					}else{
						$("#error").html("&nbsp;");
					}
				});
			}
		});
	});
	$(":input[name='verifyCode']").change(function() {
		var verifyCode = $(this).val().trim();
		if(verifyCode != null && verifyCode.length > 0){
			var url = "user/authentication";
			//待发送的key-value参数
			var args = {"verifyCode": verifyCode};
			$.post(url, args, function(data) {
				$("#error").html(data);
			});
		}
	});
});