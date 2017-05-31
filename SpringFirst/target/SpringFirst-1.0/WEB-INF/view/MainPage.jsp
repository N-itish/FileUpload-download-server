<%-- 
    Document   : MainPage
    Created on : May 5, 2017, 4:39:54 PM
    Author     : Nitish
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="${pageContext.request.contextPath}/static/css/index_Css.css" rel="stylesheet" type="text/css"/>
    </head>
    <style>
         table{
             height: 100%;
             width: 500px;
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
        <h1>${LoginSuccessMessage}</h1>
        <h2>Welcome ${sessionScope.uName} to Upload/Download Server</h2>
        <!--<h2>Welcome </h2>-->
        <h3>Upload files using</h3>
        <form method="post" action="${pageContext.request.contextPath}/UploadServlet" enctype="multipart/form-data">
            Choose name of file:<input type="text" name = "filename"/><br>
            <input type="file" size="50" name ="file" />
            <input type="submit" value="save"/>
        </form>
        ${Upload_Response}
        <br>
        <h3>Download files using</h3>
        <form method="post" action="${pageContext.request.contextPath}/DownloadServlet">
            filename<input type="text" name ="file_name"/>
            <button type="submit">Download File</button>
        </form>
            <h3>view all available files</h3>
            .<form method="get" action="${pageContext.request.contextPath}/FileListServlet">
            <button type="submit">view</button>
        </form>
            <table>
               <tr>
                   <th>S.no</th>
                   <th>File name</th>
                   <th>Added Date</th>
                   <th>file type</th>
                   <th>file size</th>
               </tr>
               <c:forEach var="File_data" items="${File_Record}">
                   <tr>
                       <td><c:out value="${File_data.id}"/></td>
                       <td><c:out value="${File_data.filename}"/></td>
                       <td><c:out value="${File_data.added_date}"/></td>
                       <td><c:out value="${File_data.file_type}"/></td>
                       <td><c:out value="${File_data.file_size}"/></td>
                   </tr>
               </c:forEach>
            </table>
            <form id = "logoff" action="${pageContext.request.contextPath}/LogOffServlet" method="post">
                <input type="submit" value="log off">
            </form>
            
            <p id = "vid">To view videos click here</p>  <br>
            <form action="${pageContext.request.contextPath}/VideoSite" method="post">
               
                <button type="submit" id="linktoVideosite" >video</button>
            </form>
    </body>
</html>
