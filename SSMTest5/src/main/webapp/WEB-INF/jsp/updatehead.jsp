<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <!-- base href="http://localhost:8080/video/" -->
    <meta name="viewport" content="initial-scale=1, maximum-scale=1, user-scalable=no">
    
            
<!--<base href="http://localhost:8080/Voids/">--><base href=".">
    <meta name="renderer" content="webkit">
    <meta name="keywords" content="Web前端视频教程,大数据视频教程,HTML5视频教程,UI视频教程,PHP视频教程,java视频教程,python基础教程">
    <meta name="description" content="智游教育在线课程视频,为您提供java,python,HTML5,UI,PHP,大数据等学科经典视频教程在线浏览学习,精细化知识点解析,深入浅出,想学不会都难,智游教育,学习成就梦想！">
    <link rel="stylesheet" href="z/base.css">
    <link rel="stylesheet" href="z/profile.css">
    <link rel="stylesheet" href="js/jquery.css">
    <title>在线公开课-智游教育|java|大数据|HTML5|python|UI|PHP视频教程</title>
</head>
<body class="w100">                        
                        <div class="profile_avatar_area">                           
                                 <img id="avatar" width="200px;" src="${user.imgurl} ">                           
                            <p style="text-align: center;">当前头像</p>
                        </div>
                        <div class="profile_ifo_area">
                            <form id="upload_form" action="uploadhead2" method="post" enctype="multipart/form-data">
                                <!-- hidden crop params -->                             
                                <p>第一步：请选择图像文件</p>
                                <div><input name="fileName" id="image_file"  type="file" ></div>

                                <div class="error"></div>

                                <div class="step2">
                                    <p>第二步：请确定,然后按上传</p>                           
                                    <input value="上传" type="submit">
                                </div>
                            </form>
                        </div>

<script src="js/jquery-1.js"></script>
<script src="js/gVerify.js"></script>
<script src="js/index.js"></script>

<script src="js/jquery.js"></script>
<script src="js/Jcrop_upload.js"></script>
</body>
</html>