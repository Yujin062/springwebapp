<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="/WEB-INF/views/common/header.jsp" %>

<%-- index.jsp의 중앙 내용 --%>
<div class="card m-2">
   <div class="card-header">
       	세션 이용
   </div>
   <div class="card-body">
   	<form method="post" action="addCart">
   		<div class="form-group"> 
	   		<label for="name">상품선택: </label>
	   		<select class="form-control" id="name" name="name">
	   			<option value="item1">아이템 1</option>
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

<%@ include file="/WEB-INF/views/common/footer.jsp" %>