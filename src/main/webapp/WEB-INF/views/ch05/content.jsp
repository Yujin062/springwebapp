<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/common/header.jsp" %>

<%-- index.jsp의 중앙 내용 --%>
<div class="card m-2">
   <div class="card-header">요청 해더 얻기 및 쿠키 사용 </div>
   <div class="card-body">
   	<div class="m-2">
   		<a href="getHeaderValue" class="btn btn-info btn-sm">요청 헤더값 얻기</a>
   	</div>
   </div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>