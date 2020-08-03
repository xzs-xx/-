new Vue({
	el:'#apply',
	data:{
		username:'',
		password:'',
		apply:'请输入用户名',
		applyusernamecolor:'red'
	},
	methods:{
		ReturnLogin:function(){
			window.location="VueLogin.jsp";
		},
		ApplyTo:function(){
			this.$http.post('apply.do',
					{username:this.username,password:this.password},
					{emulateJSON:true})
			.then(function(res){
				alert(res.body);
				if(res.body == "注册成功"){
					window.location="VueLogin.jsp";
				}
            },function(res){
                console.log(res.status);
            });
		}
	},
	watch:{
		username:function(){
			this.$http.post('findUsername.do',
					{username:this.username},
					{emulateJSON:true})
			.then(function(res){
				if(this.username ==''){
					this.apply = '请输入用户名';
					this.applyusernamecolor = 'red';
				}else if(res.body == 1){
					this.apply = '用户名可以使用';
					this.applyusernamecolor = 'blue';
				}else{
					this.apply = "用户名不可以用";
					this.applyusernamecolor = 'red';
				}
            },function(res){
                console.log(res.status);
            });
		}
	}
})