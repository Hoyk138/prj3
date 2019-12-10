<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="MypageMember"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지 회원정보수정</title>
<link rel="stylesheet" type="text/css" href="http://localhost:8080/team1_user_prj3/common/css/main.css">
<link rel="stylesheet" type="text/css" href="http://localhost:8080/team1_user_prj3/common/css/mypageMenu.css">
<style type="text/css">

	/* container 시작 */
	#MainContainer{ width: 900px; min-height: 1800px; margin:0px auto; text-align: center;}
	#nav_Content{border-bottom: 1px solid #333; width: 700px;margin-left: 30px; margin-top: 10px}
	.container1{ max-width: 700px;width: 100%; padding-right: 15px;padding-left: 15px;margin-right: auto;margin-left: auto;}
	.row1{display: flex;flex-wrap: wrap;}
	.navbar-brand{font-weight: bold;}
	.lately_td{ width : 160px}
	/* container 끝 */
	
	.clickColor a:hover{text-decoration: none;}
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
<div id="books">
<!-- header 시작  -->		
<div id="header">
	<jsp:include page="../../../../common/jsp/jinibooks_header.jsp"/>
</div>
<!-- header 끝  -->	
<div id="booksContent" class="row" style="margin-top: 80px">

<!-- haside 시작  -->	
<div class="haside" class="col-4">
	<jsp:include page="../../../../common/jsp/jinibooks_mypageMenu.jsp"/>
</div>
<!-- haside 끝  -->

<!-- container 시작  -->	
<div id="MainContainer" class="col-8">
<nav class="navbar navbar-light" id="nav_Content">
  <span class="navbar-brand">
    <img src="http://localhost:8080/team1_user_prj3/common/images/images_mypage/person_icon.png" width="50" height="50" class="d-inline-block">
   회원정보 수정
  </span>
</nav>
<div id="login" style="width: 800px"><!-- 회원정보 수정 테이블 시작 -->
	<form class="loginFrm">
		<table class="table table-bordered">
		    <tr>
		      <th width="200px">아이디</th>
		      <td width="500px"><input type="text" class="form-control" readonly="readonly" id="inputId" placeholder="아이디"></td>
		    </tr>
		    <tr>
		      <th>회원이름</th>
		      <td height=30px>
			     <div class="input-group mb-2" >
			      <input type="text" class="form-control"  id="inputName" placeholder="이름" style="margin-right: 40px">
			      <button type="button" class="btn btn-outline-secondary btn-sm mb-2">회원탈퇴</button>
			     </div>
		      </td>
		    </tr>
		    <tr>
		      <th>전화번호</th>
		      <td><input type="text" class="form-control"  id="inputPhone" placeholder="전화번호"></td>
		    </tr>
		    <tr>
		      <th>이메일</th>
		      <td><input type="text" class="form-control"  id="inputEmail" placeholder="이메일 주소"></td>
		    </tr>
		    <tr>
		      <th>비밀번호 변경</th>
		      <td><input type="text" class="form-control"  id="inputPwOk" placeholder="변경할 비밀번호"></td>
		    </tr>
		    <tr>
		      <th>변경할 비밀번호 확인</th>
		      <td>   <input type="text" class="form-control"  id="inputPwOk" placeholder="변경할 비밀번호 확인"></td>
		    </tr>
		    <tr>
		      <td colspan="2"> <button type="submit" class="btn btn-danger"  id="joinBtn">회원정보 수정</button></td>
		    </tr>
		</table>
	</form>
</div> <!-- 회원정보 수정 테이블 끝  -->
</div>
<!-- container 끝  -->		
</div>  <!-- booksContent -->
<!-- footer 시작  -->	
<hr>
<div id ="footer">
  <jsp:include page="../../../../common/jsp/jinibooks_footer.jsp"/>
</div>
<!-- footer 끝  -->	
</div>

</body>
</html>
