<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:set value="${pageContext.request.contextPath}" var="path" scope="page"/>
<script src="https://unpkg.com/vue/dist/vue.js"></script>
<script src="https://cdn.staticfile.org/vue/2.4.2/vue.min.js"></script>
<script src="https://cdn.staticfile.org/vue-resource/1.5.1/vue-resource.min.js"></script>
<link rel="stylesheet" href="${path}/css/ChildrenHead.css" type="text/css" />
<title>儿童网站首页</title>
</head>
<body>
	<button onclick="websocket()">good</button>
</body>
<script>
var demo = new Vue({
	el: '#main',
	data: {
		active: 'home'
	},
	methods: {
		makeActive: function(item){
			this.active = item;
		}
	}
});

ws = new WebSocket("ws://localhost:8080/JAVAWEBJDBC/websocket/"+"${sessionScope.username}");
ws.onopen = function(){
	alert("通信打开");
};
ws.onclose = function(){
	 alert("不在线，对方接受不到信息");
};
ws.onmessage = function (evt) { 
	alert(evt.data);
};
ws.onerror = function() {
	
};
function websocket(){
	ws.send("xzs" + "|" +"123");
} 


</script>
</html>