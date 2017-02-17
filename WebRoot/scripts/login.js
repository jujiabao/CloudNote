$(function(){
	$("#login").click(function(){
		//清除提示信息
		$("#count_span").html("");
		$("#password_span").html("");
		//alert("----");
		//获取请求提交参数
		var name=$("#count").val().trim();
		var password=$("#password").val().trim();
		//检查参数格式
		var ok=true;//表单数据通过检测
		if(name==""){
			ok=false;
			$("#count_span").html("用户名为空");
		}
		if(password==""){
			ok=false;
			$("#password_span").html("密码为空");
		}
		//发送Ajax请求
		if(ok){//通过检查
			$.ajax({
				url:"user/login.do",
				type:"post",
				data:{"name":name,"password":password},
				dataType:"json",
				success:function(result){
					if(result.status==0){//正确
						//将用户ID存入Cookie
						var userId=result.data;
						addCookie("userId",userId,0.5);
						window.location.href="edit.html";
					}else if(result.status==1){//用户名错误
						$("#count_span").html(result.msg);
					}else if(result.status==2){//密码错误
						$("#password_span").html(result.msg);
					}
				},
				error:function(){
			    alert("登录失败，稍后重试");
				}
			});
		}
	});
});