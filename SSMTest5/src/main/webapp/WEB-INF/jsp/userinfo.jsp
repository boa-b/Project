<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body class="w100">


                        <div class="profile_avatar_area" style="float:left">
                            
                           <img id="avatar"  src="${user.imgurl} " height="250px"  alt="">                      
                            <p>欢迎回来！</p>
                        </div>
                        <div class="profile_ifo_area" style="float:left; margin-top:60px">
                           <ul class="profile_ifo_area">
                            <li><span class="dd">昵　称： </span>${user.nickname}</li>
                            <li><span class="dd">性　别： </span>${user.sex}</li>
                            <li><span class="dd">生　日： </span>${user.birthday}</li>
                            <li><span class="dd">邮　箱：</span>${user.accounts} </li>
                            <li><span class="dd">所在地：</span>${user.address}</li>
                        </ul>
                        </div>
                        

</body>
</html>