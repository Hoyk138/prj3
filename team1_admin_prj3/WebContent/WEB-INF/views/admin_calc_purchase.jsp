<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info=""
    session="true"
    isELIgnored="false"
    %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%
 	request.setCharacterEncoding("UTF-8");  //request.setCharacterEncoding ->POST 방식에서만 적용된다.
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>E-Book 구매 관리</title>
<link rel="stylesheet" type="text/css" href="http://localhost:8080/jsp_prj/common/css/main.css"/>
<link rel="stylesheet" type="text/css" href="http://localhost:8080/team1_admin_prj3/common/css/admin_main_design.css"/>
<style type="text/css">
   
</style>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script> 
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
 
<script type="text/javascript">

</script>
</head>
<body>
<div id="books">

<div id="header">

 <%@ include file="../../common/jsp/admin_include_header.jsp" %>
   
</div>

<div id="container">

<div id="snb">

 <%@ include file="../../common/jsp/admin_include_snb_ebook_calc.jsp" %>

</div>

<div id="content">

<h6>구매 대여 관리 > 구매 현황 관리</h6>
<h3>| 구매 현황 관리</h3>
<br/>

<form class="form-inline" action="search_purchase_process.do" id="searchFrm">

	<div style="margin: 0px auto;"> <!-- 검색조건 시작  -->
	
	<input type="hidden" name="cmd" value="board_list"/>
	  <select class="custom-select mr-sm-2" name="field" id="field">
	    <option value="subject"<%-- ${param.field eq 'subject'?" selected='selected'":""} --%>>도서명</option>
	    <option value="content"<%-- ${param.field eq 'content'?" selected='selected'":""} --%>>저자</option>
	  </select>
	  <input type="text" style="vertical-align: top;" class="form-control mb-2 mr-sm-2" id="keyword" name="keyword"<%--  value="${param.keyword}" --%>/>
	
	  <input type="button" class="btn btn-dark" id="searchBtn" value="검색" height="100px"/>
	
	</div> <!-- 검색조건 끝  -->
</form>

<!-- <label for="exampleFormControlSelect1" style="width: 110px;">상품 등록일</label>
	<div class="input-group date">
	  <input type="text" class="form-control form-control-sm" style="width: 100px;">
	  <span class="input-group-addon">
	    <img src="http://localhost:8080/Team1_prj3/common/images/icon_calendar.png" style="margin-top: 5px; margin-left: 2px;"/>
	  </span>
	</div>
	 ~ 
	<div class="input-group date">
	  <input type="text" class="form-control form-control-sm" style="width: 100px;">
	  <span class="input-group-addon">
	    <img src="http://localhost:8080/Team1_prj3/common/images/icon_calendar.png" style="margin-top: 5px; margin-left: 2px;"/>
	  </span>
	</div> -->
	
<table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">결제코드</th>
      <th scope="col">ID</th>
      <th scope="col">도서명</th>  <!-- 에 따른 도서명 출력 -->
      <th scope="col">CASH</th>
      <th scope="col">POINT</th>
      <th scope="col">결제금액</th>
      <th scope="col">결제방식</th>
      <th scope="col">결제일</th>
    </tr>
  </thead>
  <tbody>
	    <c:forEach var="purchase" items="${purchaseData }">  <!-- ${purchaseData }" Controller에 설정되어있음 -->
	<tr>
		<td><c:out value="${ purchase.code }"/></td>	
		<td><c:out value="${ purchase.id }"/></td>	
		<td><c:out value="${ purchase.title }"/></td>	
		<td><c:out value="${ purchase.use_cash }"/></td>	
		<td><c:out value="${ purchase.use_point }"/></td>	
		<td><c:out value="${ purchase.total_price }"/></td>	
		<td><c:out value="${ purchase.pay_method }"/></td>	
		<td><c:out value="${ purchase.pay_date }"/></td>	
	</tr>
	</c:forEach>
	<c:if test="${empty purchaseData }">
	<tr>
		<td colspan="10">등록된 책 정보가 없습니다.</td>
	</tr>
	</c:if>

  </tbody>
</table>

	<div id="bookIndexList" >
		<div style="margin:0px auto; width:400px;">
			<nav aria-label="Page navigation example">
			  <ul class="pagination">
				<c:out value="${ indexList }" escapeXml="false"/>
			  </ul>
			</nav>
		</div>
	</div><!-- boardIndexList 끝 -->

</div><!-- content 끝 -->
</div> <!-- container 끝 -->

<div id="footer">

 <%@ include file="../../common/jsp/admin_include_footer.jsp" %>

</div>
</div>
</body>
</html>