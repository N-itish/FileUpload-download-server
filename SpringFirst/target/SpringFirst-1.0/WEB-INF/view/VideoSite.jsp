<%-- 
    Document   : VideoSite
    Created on : May 15, 2017, 5:03:18 PM
    Author     : Nitish
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <script src="${pageContext.request.contextPath}/static/JQuery/JQuery.min.js" type="text/javascript"></script>
         <script>
            function getid(value)
            { 
                
                var id = value.toString();
                $.post('${pageContext.request.contextPath}/StreamVideo',{ident:id},function(data){
                    alert(data.toString());
                    var sorted = data.toString().split(";");
//                     alert(sorted[0]);
                    var video = $("#video_id")[0];
                    $("#video_source").attr({
                        "src":sorted[0],
                        "type":sorted[1]
                    });
                    video.load();
                    video.play();
                 });
            }
         </script>
    </head>
    <style>
         table{
             height: 100%;
             width: 800px;
             border-collapse: collapse;
         }
        
         td,th{
            padding: 8px;
            text-align: left;
            border-bottom: 1px solid #ddd;
         }
         tr:hover{
                 background-color: lightgrey;
         }
    </style>
    <body>
        ${result}
        <h1>Hello World!</h1>
        <h2>Insert video's from here</h2>
        <form method = "post" action="${pageContext.request.contextPath}/UploadVideos" enctype="multipart/form-data">
            Enter name of video:<input type ="text" name ="name"><br>
            <input type="file" size="50" name="video">
            <button type = "submit">save</button>
        </form><br>
        ${UploadVideoMessage}<br>
        List of Video's<br>
        <form method="post" action="${pageContext.request.contextPath}/VideoList">
               <button type = "submit">show</button>
        </form>
        <table class="video_list">
         <tr>
             <th>id</th>
             <th>Video name</th>
             <th>Uploaded By</th>
             <th>Uploaded Date</th> 
             <th>File type</th>
             <th>File size</th>   
        </tr>
        <c:forEach items="${VideoList}" var="vidlist">
            <tr onclick="getid(${vidlist.id})">
               <td><c:out value="${vidlist.id}"/></td>
               <td><c:out value="${vidlist.videoname}"/></td>
               <td><c:out value="${vidlist.uploaded_by}"/></td>
               <td><c:out value="${vidlist.uploadedDate_date}"/></td>
               <td><c:out value="${vidlist.file_type}"/></td>
               <td><c:out value="${vidlist.filesize}"/></td>
           </tr>
        </c:forEach>
        </table>
              
               <video id = "video_id" width="300px" height="300px" controls>
                   <source id="video_source">
               </video>
    </body>
</html>
