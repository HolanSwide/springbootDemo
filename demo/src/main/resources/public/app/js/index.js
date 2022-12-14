new Vue({
    el:"#app",
    data() {
        var validatePass = (rule, value, callback) => {
            if (value === "") {
                callback(new Error("请输入用户信息"));
            } else {
                if (this.userData.password !== "") {
                    this.$refs.userData.validateField("password");
                }
                callback();
            }
        };
        var validatePass2 = (rule, value, callback) => {
            if (value === "") {
                callback(new Error("请输入密码"));
            } else if (value.length < 8 || value.length > 13) {
                callback(new Error("长度必须在8-12之内!"));
            } else {
                callback();
            }
        };
        return {
            loading: false,
            ruleForm: {
                pass: "",
                checkPass: "",
            },
            rules: {
               username: [{ validator: validatePass, trigger: "blur" }],
                password: [{ validator: validatePass2, trigger: "blur" }],
            },
            isLogin:true,
            userData:{
                username:'',
                password:''
            },
            url:{
                login:'http://localhost/user/login',
                register:'http://localhost/user/register'
            }
        };
    },
    created() {
    },
    methods:{
        login() {
            this.loading=true;
            axios({
                method: 'post',
                url: this.url.login,
                data: JSON.stringify(this.userData),
                headers: {
                    'Content-Type': 'application/json;charset=UTF-8'
                }
            }).then(res=>{
                if(res.data["sign"]) {
                    this.$message({
                        message:res.data["msg"]+" 3秒后跳转...",
                        type:'success',
                        showClose:true,
                        duration:0
                    });
                    setTimeout(function () {
                        location.href=res.data["url"];
                    }, 3000);
                } else {
                    this.loading=false;
                    this.$message.error({
                        message:res.data["msg"],
                        showClose: true,
                        duration: 0
                    });
                }
            }).catch(err=>{
                console.log(err);
            })
        }
    }
})