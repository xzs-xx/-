new Vue({
	el : '#vue_det',
	data : {
		username:'',
		password:''
	},
	methods:{
		login:function(){
			this.$http.post('login.do',
					{username:this.username,password:this.password},
					{emulateJSON:true})
			.then(function(res){
				this.username = '';
				this.password = '';
				if(res.body=='登录成功'){
					window.location="headLogin.do";
				}else{
					
				}
            },function(res){
                console.log(res.status);
            });
		},
		Apply:function(){
			window.location="Apply.jsp";
		}
	}
})