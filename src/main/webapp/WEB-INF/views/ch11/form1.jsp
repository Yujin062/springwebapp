<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ include file="/WEB-INF/views/common/header.jsp" %>

<%-- index.jsp의 중앙 내용 --%>
<div class="card m-2">
   <div class="card-header">
       	스프링 태그 라이브러리
   </div>
   <div class="card-body">
		<form:form method="post" modelAttribute="member">
			<form:input path="mid"/>
		</form:form>
   </div>		
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>