<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="아이디 찾기"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="http://localhost:8080/servlet_prj/common/css/main.css"/>
<style type="text/css">
	#class4Wrap{height: 750px; margin:0px auto; }
	/* 헤더 시작 */
	#header{ height: 150px; position:relative; background: #FFFFFF;}
	#hLogo{width:900px;height: 80px; margin:10px auto; margin-top:20px; text-align: center;}
	#logo{font-size: 30px; font-weight: bold; color: #EE4137; margin: 10px}
	/* 헤더 끝 */
	/* container 시작 */
	#container{ height: 750px; background-color: #FFC7AD}
	.loginFrm{width:600px; height:400px; margin: 0px auto;}
	#login_Input{padding-left:140px;margin-top: 20px}
	#login{padding-top: 80px}
	#idLabel{font-size: 20px; font-weight: bold; font-family:san-serif; color: #dc3545; padding-left: 120px; padding-bottom: 30px}
	#inputEmail,#inputName,#idSearchBtn{width:320px}
	#btn{padding-top: 20px}
	#coment,#coment2{padding-left:120px; font-size: 14px;}
	
	/* container 끝 */
</style>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<script type="text/javascript">
$(function(){
	
});
</script>
</head>	
<body>
<div id="class4Wrap">
<!-- header 시작  -->		
<div id="header">
	<hr color="#EE4137"/>
	<div id="hLogo">
	<nav>
 		<a class="navbar-brand" href="#">
   		<img src="http://localhost:8080/Team1_prj3/user_book/images/header_logo.PNG" class="d-inline-block align-top" alt=""><span id="logo">JINI BOOKS</span>
		</a>
	</nav>
	</div>
	<hr color="#EE4137"/>
</div>
<!-- header 끝  -->
<!-- container 시작  -->	
<div id="container">
<div id="login">
<form class="loginFrm">
<div id="login_Input">
	<div class="form-group row">
	<label class="form-check-label" for="gridCheck1" id="idLabel">아이디 찾기</label>
	</div>
  <div class="form-group row">
    <div class="col-sm-10">
      <input type="text" class="form-control"  id="inputEmail" placeholder="이메일주소">
    </div>
  </div>
  <div class="form-group row">
    <div class="col-sm-10">
      <input type="text" class="form-control"  id="inputName" placeholder="이름">
    </div>
  </div>
  <div class="form-group row">
    <div class="col-sm-10" id="btn">
      <button type="submit" class="btn btn-danger"  id="idSearchBtn">찾기</button>
    </div>
  </div>
</div>
<div style="padding-top: 10px">
  <hr color="#F58E69" width="400px"/>
  <span id="coment">이메일이 기억나지 않는다면 고객센터로 문의해주세요!</span><br/>
  <span id="coment2"><img src="images/images_join/join_phone.png">&nbsp;1588-1588</span>
  
  </div>
</form>
</div>
</div>
<!-- container 끝  -->		

</div>

</body>
</html>