<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet" />
</head>

<body>

	<div class="jumbotron" style="padding-top: 15px; padding-bottom: 15px;">
		<div class="container">
			<h2>添加主讲人信息</h2>
		</div>
	</div>
	
<form action="alertSpeaker"  method="post" enctype="multipart/form-data">

      <input  type="hidden" name="id" value="">

  	<div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">姓名</label>
      <input type="text" name="speaker_name" value="">
  	</div>
   
   <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">简介</label>
      <input type="text" name="speaker_desc" value="">
  	</div>
  	
   <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">职位</label>
      <input type="text" name="speaker_job" value="">
  	</div>
  	<div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">头像地址</label>
      <input type="file" name="pic" value="">
  	</div>
  	
   
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
     				<br><br>
      <button type="submit" class="btn btn-default" >保存</button>
	  <a  class="btn btn-default" href="show">返回</a>
    </div>
  </div>
  
</form>
</body>
</html>