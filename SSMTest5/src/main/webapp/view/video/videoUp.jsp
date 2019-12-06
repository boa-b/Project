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
			<h2>修改视频信息</h2>
		</div>
	</div>
	
<form action="UpAdd" method="post" enctype="multipart/form-data">

      <input  type="hidden" name="video_id" value="${video.video_id}">

  	<div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">视频标题</label>
      <input type="text" name="title" value="${video.title}">
  	</div>
  	
  	<div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">主讲人</label>
    <select name="speaker_id">
    	<c:forEach items="${list2}" var="list2">
    		<option value="${list2.id}"
    		<c:if test="${(video.speaker_id).equals(list2.id)}">selected</c:if>
    		>${list2.speaker_name}</option>
    	</c:forEach>
    </select>
			
   </div>
  
  	<div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">所属课程</label>
    
   <%--  <select name="name1" >
		<c:forEach items="${list}" var="list">
			<option value ="${list.username}"
			<c:if test="${receiver.equals(list.username)}">selected</c:if>
			>${list.username}</option>
			</c:forEach>
		</select> 
		<c:if test="${course.subject_id.equals(list.subject_id)}">selected</c:if>
		<c:if test="${course.subject_id.equals(list.subject_id)}">selected</c:if>
		--%>
    <select name="course_id">
    	<c:forEach items="${list}" var="list">
    		<option value="${list.subject_id}"
    		<c:if test="${(video.course_id).equals(list.subject_id)}">selected</c:if>
    		>${list.subject_name}</option>
    	</c:forEach>
    </select>		
   </div>
   
   <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">视频时长(秒)</label>
      <input type="text" name="time" value="${video.time}">
  	</div>
  	<div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">封面图片地址</label>
      <input type="file" name="image" value="">
  	</div>
  	<div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">视频播放地址</label>
      <input type="file" name="videourl" value="">
  	</div>
   
   <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">备注</label>
      <input type="text" name="detail" value="${video.detail}">
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