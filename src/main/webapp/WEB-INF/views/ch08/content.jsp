<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="/WEB-INF/views/common/header.jsp" %>

<%-- index.jsp의 중앙 내용 --%>
<div class="card m-2">
   <div class="card-header">
       	세션 이용: 로그인
   </div>
   <div class="card-body">
   		<c:if test="${login == null}">
	   		<form method="POST" action="login">
		        <div class="form-group">
		          <label for="exampleInputEmail1">Member ID:</label>
		          <input type="text" class="form-control" id="mid" name="mid">
		        </div>
		        <div class="form-group">
		          <label for="exampleInputPassword1">Member Password: </label>
		          <input type="password" class="form-control" id="mpassword" name="mpassword">
		        </div>
		        <div class="form-group">
			        <button type="submit" class="btn btn-primary btn-sm">로그인</button>          
		        </div>
	      </form>
   		</c:if>
   		
   		<c:if test="${login != null}">
   			<img src="${pageContext.request.contextPath}/resources/images/face/${login.mid}.png" width="30">
   			현재 ${login.mid} 로그인 됨
   			<a href="logout" class="btn btn-primary btn-sm">로그아웃</a>
   		</c:if>
   </div>
</div>

<%-- <c:if test="${login != null}"> --%>
	<div class="card m-2">
	   <div class="card-header">
	       	세션 이용: 장바구니
	   </div>
	   <div class="card-body">
	   	<form method="post" action="addCart">
	   		<div class="form-group"> 
		   		<label for="name">상품선택: </label>
		   		<select class="form-control" id="name" name="name">
		   			<option value="item1" selected>아이템 1</option>
		   			<option value="item2">아이템 2</option>
		   			<option value="item3">아이템 3</option>
		   			<option value="item4">아이템 4</option>
		   			<option value="item5">아이템 5</option>
		   		</select>
	   		</div>
	   		<div class="form-group">
	   			<label for="ammound">수량:</label>
		   		<input type="number" name="amount" value="1">
	   		</div>
	   		<button type="submit" class="btn btn-info btn-sm mt-2">장바구니 넣기</button>
	   	</form>
	   	<a href="clearCart" class="btn btn-info btn-sm mt-2">장바구니 비우기</a>
	   	
	   	<hr/>
	   	<p>장바구니 내용</p>
	   	<ul>
	   		<c:forEach var="item" items="${cart}">
	   			<li>${item.name}, ${item.amount}개</li>
	   		</c:forEach>
	   	</ul>
	   </div>
	</div>
<%-- </c:if> --%>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>