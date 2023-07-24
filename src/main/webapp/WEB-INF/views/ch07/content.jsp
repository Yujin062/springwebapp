<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/common/header.jsp" %>

<%-- index.jsp의 중앙 내용 --%>
<div class="card m-2">
   <div class="card-header">모델(데이터) 전달</div>
   <div class="card-body">
   	<div class="m-2">
   		<div>   		
	   		<a href="useRequest1" class="btn btn-info btn-sm">request 이용1</a>
	   		<a href="useRequest2" class="btn btn-info btn-sm">request 이용2</a>
	   		<a href="useRequest3" class="btn btn-info btn-sm">request 이용3</a>
	   		<a href="useRequest4?bno=1&btitle=제목1&bcontent=내용1&bwriter=글쯘이1&bdate=2023-07-24" class="btn btn-info btn-sm">request 이용4</a>
	   		<a href="useRequest5?bno=2&btitle=제목2&bcontent=내용2&bwriter=글쯘이2&bdate=2023-07-24" class="btn btn-info btn-sm">request 이용5</a>
   		</div>
   	</div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>