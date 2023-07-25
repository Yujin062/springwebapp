<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="/WEB-INF/views/common/header.jsp" %>

<%-- index.jsp의 중앙 내용 --%>
<div class="card m-2">
   <div class="card-header">
       	파일 업로드와 다운로드
   </div>
   <div class="card-body">
	   	<div>
	   		<a href="handleingException" class="btn btn-info btn-sm">try-catch</a>
	   	</div>
	   	<div class="mt-2">
	   		<a href="handleingException2" class="btn btn-info btn-sm">NullPointerException</a>
	   	</div>
	    <div class="mt-2">
	   		<a href="handleingException3" class="btn btn-info btn-sm">ClasscastException</a>
	   	</div>
	   	<div class="mt-2">
	   		<a href="handleingException4" class="btn btn-info btn-sm">Ch10soldOutException</a>
	   	</div>
	   	<div class="mt-2">
	   		<a href="handleingException5" class="btn btn-info btn-sm">Exception</a>
	   	</div>
   </div>		
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>