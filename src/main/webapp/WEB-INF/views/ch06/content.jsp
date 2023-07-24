<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/common/header.jsp" %>

<%-- index.jsp의 중앙 내용 --%>
<div class="card m-2">
   <div class="card-header">Forward와 Redirect </div>
   <div class="card-body">
   	<div class="m-2">
   		<a href="forward" class="btn btn-info btn-sm">Forward</a>
   	</div>
   	<div class="m-2">
   		<a href="redirect" class="btn btn-info btn-sm">Redirect</a>
   	</div>
   	</div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>