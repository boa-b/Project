<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<script  src="jquery/jquery.js"></script>
<script  src="jquery/jquery.validate.min.js"></script>
<script  src="jquery/messages_zh.js"></script>
<meta charset="UTF-8">

    <!-- base href="http://localhost:8080/video/" -->
    <meta name="viewport" content="initial-scale=1, maximum-scale=1, user-scalable=no">
    
        
<!--<base href="http://localhost:8080/Voids/">--><base href=".">
    <meta name="renderer" content="webkit">
    <meta name="keywords" content="Web前端视频教程,大数据视频教程,HTML5视频教程,UI视频教程,PHP视频教程,java视频教程,python基础教程">
    <meta name="description" content="智游教育在线课程视频,为您提供java,python,HTML5,UI,PHP,大数据等学科经典视频教程在线浏览学习,精细化知识点解析,深入浅出,想学不会都难,智游教育,学习成就梦想！">
    <link rel="stylesheet" href="z/base.css">
    <link rel="stylesheet" href="z/profile.css">
    <link rel="icon" href="z/favicon.png" type="image/png">
    <title>在线公开课-智游教育|java|大数据|HTML5|python|UI|PHP视频教程</title>
</head>
<body class="w100">
                        <div class="profile_ifo_area">
                            <form action="updatepwd2" method="post">
                                <div class="form_group">
                                    <span class="dd">旧　密　码：</span>
                                    <input id="oldpassword" name="oldpassword"  type="password" onblur="onn()">${msg} <i id="i1"></i><span id="oldMsg"></span>
                                </div>
                                <div class="form_group">
                                    <span class="dd">新　密　码：</span>
                                    <input  type="password" id="newpwd1" name="password">
                                </div>
                                <div class="form_group">
                                    <span class="dd">确认新密码：</span>
                                    <input  type="password" id="newpwd2" name="password2" onblur="onn1()">${msg1}<span id="passMsg"><i id="i2"></i></span>
                                </div>
                                <div class="form_submit dd">
                                    <input value="保　存" type="submit">
                                    <a >取消</a>
                                </div>
                            </form>
                        </div>
                        
                        <script type="text/javascript">
		function onn() {
			
			$.ajax({
				url:"oldpassword",	// 指定请求URL
				type:"get",		// 指定请求方式	
				data:{			// 请求附带的参数
					oldpassword:$("#oldpassword").val()
				},
				success:function(data){	// 成功后的回调函数      data代表服务器响应的数据
					if (data=="false") {
						alert("密码为空或者错误")
											
					}
				},
				error:function(XMLHttpRequest,textStatus,errorThrown){	// 失败回调的函数
					alert("textStatus");	
				}
			})
		}
		function onn1(){
			if($("#newpwd1").val()!=$("#newpwd2").val()){
				alert("两次密码不一致")
				
			}
			
			
		}
	</script>
</body>
</html>