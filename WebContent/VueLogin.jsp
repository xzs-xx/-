<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>VUE Login</title>
<script src="https://unpkg.com/vue/dist/vue.js"></script>
<script src="https://cdn.staticfile.org/vue/2.4.2/vue.min.js"></script>
<script src="https://cdn.staticfile.org/vue-resource/1.5.1/vue-resource.min.js"></script>
</head>
<body>
	<div id="vue_det">
		<input type="text" v-model="username" width="100"> <br> <input
			type="password" v-model="password" width="100"> <br>
		<button @click="login()">登录</button>
		<button @click="Apply()">注册</button>
	</div>
</body>
<script type="text/javascript" src="./javascript/VueLogin.js"></script>
</html>