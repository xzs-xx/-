<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<script src="https://unpkg.com/vue/dist/vue.js"></script>
<script src="https://cdn.staticfile.org/vue/2.4.2/vue.min.js"></script>
<script src="https://cdn.staticfile.org/vue-resource/1.5.1/vue-resource.min.js"></script>
<title>注册</title>
</head>
<body>
	<div id="apply">
		<p>
			用户:<input type="text" v-model="username">
			<span v-bind:style="{color:applyusernamecolor,fontSize:'8px'}">{{ apply }}</span>
		</p>
		<p>
			密码:<input type="password" v-model="password">
		</p>
		<button @click="ApplyTo()">注册</button>
		<button @click="ReturnLogin()">登录</button>
	</div>
</body>
<script type="text/javascript" src="./javascript/Apply.js"></script>
</html>