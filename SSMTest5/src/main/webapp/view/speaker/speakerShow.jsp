<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>courseShow</title>
<script src="js/jquery-1.js"></script>
<script src="js/bootstrap.js"></script>
<script src="js/confirm.js"></script>
<script src="js/jquery.js"></script>
<script src="js/message_cn.js"></script>
<script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
<link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet" />

<style type="text/css">
th {
	text-align: center;
}
</style>
</head>
<body>

	<div class="jumbotron" style="padding-top: 15px; padding-bottom: 15px;">
		<div class="container">
			<h2>主讲人管理</h2>
		</div>
	</div>

		<div class="container">
			<a  type="button"  href="speakerAdd"
				class="btn btn-info dropdown-toggle" target="ifram">添加</a>


			<button onclick="deleteAll()" type="submit" id="btn"
				class="btn btn-info dropdown-toggle">批量删除</button>
		</div>

	<form action="http://localhost:8080/Voids/Course/deleteall.do">
		<div class="container" style="margin-top: 20px;">


			<table class="table table-bordered table-hover"
				style="text-align: center; table-layout: fixed;">
				<thead>
					<tr class="active">
						<th><input type="checkbox" id="all"></th>
						<th>序号</th>
						<th style="width: 10%">名称</th>
						<th style="width: 60%">简介</th>
						<th style="width: 10%">职位</th>
						<th>编辑</th>
						<th>删除</th>
					</tr>
				</thead>
				<tbody>
		<c:forEach items="${list}" var="list">
					<tr>
						<td><input type="checkbox" name="c" value="${list.id}"></td>
						<td>${list.id}<input type="hidden" id="video_id" value="${list.id}"></td>
						<td>${list.speaker_name}</td>
						<td style="overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">${list.speaker_desc}</td>
						<td>${list.speaker_job}</td>
						
						<td><a href="speakerUp?id=${list.id}">✎</a></td>
						<td><a onclick="Delete(${list.id })" >X</a></td>
					</tr>
		</c:forEach>
        
        </tbody>
      </table>
    
	</div>
	  </form>

		共${count}条数据,共${Math.round(count/10)}页
		<c:forEach var="page" begin="1" end="${Math.ceil(count/10)}">
			<a href="speakerShow?page=${page}">第${page}页</a>
		</c:forEach>
		<br>
		<button type="button" onclick="pre()">上一页</button>
		<input type="button" value="下一页" onclick="next(${Math.ceil(count/10)})">

	<script type="text/javascript">
	
	function a() {
		var stuts=document.getElementById("all").checked;
		var c = document.getElementsByName("c");
		for (var i = 0; i < c.length; i++) {
			c[i].checked=stuts;
		}
	}
	
	function deleteAll() {
		var checkedNum = $("input[name='c']:checked").length;
		var userIds = new Array();
		$("input[name='c']:checked").each(function() {
			userIds.push($(this).val());
		});
		
		  if(confirm("确定删除所选项？")){
              $.post("dAllS",{userIds:userIds},
                 function(data){
            	  alert(userIds);
					if(data =='success'){
						Confirm.show('温馨提示：', '操作失败');						
					}else{												
						 location.reload();						 
							alert("删除成功");
					}
              	 });
         	}


    }
	
	function Delete(a){
	
		var d = a;
		  if (confirm("确定删除嘛?")) {
			 
			  $.ajax({
					url:"deleteSpeaker",	
					type:"get",		
					data:{			
						id:d
					},
					success:function(data){
						 location.reload();
						 
						alert("删除成功");
					}
				})
		  }
	}
	
	function pre() {
		  if (${page-1}==0) {				  
			  alert("已经是首页");
				location.href="speakerShow?page=${page}"; 
		}else {				
			location.href="speakerShow?page=${page-1}";
		} 
	}
	 function next(c) {
		  if (${page+1}>c) {
			alert("已经是尾页");
			location.href="speakerShow?page=${page}";
		}else {
			location.href="speakerShow?page=${page+1}";
		} 
	} 
	</script>


</body>
</html>