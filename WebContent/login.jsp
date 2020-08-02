<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>登录</title>
<!-- 注意开始的首页不能在WEB-INF下面的文件夹中,除非经过特殊处理这是默认的方式，但是不安全不建议采用 -->
<script type="text/javascript">
    function login(){
    	//查看是否取到用户名称
    	var tf=$("#username").val();
      	//alert(tf);
    	$.ajax({
				type:"post",
				url:"login.do",
				data:$("#myForm").serialize(),	
				success:function(result){  					
					//追加默认还原
					$("#username").val("");
					$("#password").val("");
					if(result=="登录成功"){
						alert(1);
					}else{
						alert(2);
						window.location="login.jsp";
					}     
				}			
			}); 
    }
    //注册跳转
    function apply(){
    	window.location="apply.jsp";
    }
    </script>
</head>
<body>
	<div id="content">
		<form action="login.do" method="post" id="myForm" class="yuyue">
			<ul>
				<li><span>登录</span></li>
				<li><input id="username" type="text" name="username"
					placeholder="姓名" /></li>
				<li><input id="password" type="text" name="password"
					placeholder="密码" /></li>
				<li><button id="u246_input" type="button" value="立刻登录"
						onclick="login()">立即登录</button></li>
				<li><button id="u247_input" type="button" value="注册"
						onclick="apply()">注册</button></li>
			</ul>
		</form>
	</div>
</body>
</html>