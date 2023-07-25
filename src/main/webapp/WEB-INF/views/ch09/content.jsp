<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="/WEB-INF/views/common/header.jsp" %>

<%-- index.jsp의 중앙 내용 --%>
<div class="card m-2">
   <div class="card-header">
       	파일 업로드와 다운로드
   </div>
   <div class="card-body">
   	<div class="card">
         <div class="card-header">
            Form 태그를 이용한 FileUpload
         </div>
         <div class="card-body">
            <form method="post" enctype="multipart/form-data" action="fileupload">
               <div class="form-group">
                  <label for="title">File Title</label> 
                  <input type="text" class="form-control" id="title" name="title" placeholder="제목">
               </div>
               <div class="form-group">
                  <label for="desc">File Description</label> 
                  <input type="text" class="form-control" id="desc" name="desc" placeholder="설명">
               </div>
               <div class="form-group">
                   <label for="attach">Example file input</label>
                   <input type="file" class="form-control-file" id="attach" name="attach">
                 </div>
                 <!-- 방법1 -->
                 <button class="btn btn-info btn-sm">Form 파일 업로드</button>
                 <!-- 방법2 -->
                 <a href="javascript:fileupload()" class="btn btn-info btn-sm">AJAX 파일 업로드</a>
            </form>
         </div>
         <script>
            function fileupload() {
               //입력된 정보를 얻기
               const title = $("#title").val();
               const desc = $("#desc").val();
               //파일에서 선택된 것은 배열형태이고, 그 중 첫번 째 파일(multiple 속성 추가시 여러개 파일 업로드 가능)
               const attach = document.querySelector("#attach").files[0]; 
               
               //Multipart/form-data
               const formData = new FormData();
               formData.append("title", title);
               formData.append("desc", desc);
               formData.append("attach", attach);
               
               //Ajax로 서버로 전송(응답으로 json)
               $.ajax({
                  url: "fileuploadAjax",
                  method: "post",
                  data: formData,
                  cache: false,        //파일이 포함되어 있으니, 브라우저 메모리에 저장하지 마라
                  processData: false,  //title=xxx&desc=yyy& 씩으로 만들지 마라
                  contentType: false,   //파트마다 Content-Type이 포함되기 때문에 따로 헤더에 Content-Type에 추가하지 마라(mutiple-> 파일마다 모두 다름)
               	  success: function(data){
               		  console.log(data);
	                  if(data.result === "success") {
	                     window.alert("파일 전송이 성공됨");
	                  }  
               	  }
               });
            }
         </script>
      </div>
   
      <div class="card">
         <div class="card-header">
            File Downlaod
         </div>
         <div class="card-body">
            <a href="filedownload?fileNo=1"
               class="btn btn-info btn-sm" onclick="filedownload(1)">파일 다운로드</a>
            <hr/>
            <!-- <img src="filedownload?fileNo=1" width="200px"/> -->
            <img id="downloadImg" width="200px"/>
         </div>
         <script type="text/javascript">
            function filedownload(fileNo) {
               $("#downloadImg").attr("src", "filedownload?fileNo="+fileNo);
            }
         </script>
      </div>
   </div>		
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>