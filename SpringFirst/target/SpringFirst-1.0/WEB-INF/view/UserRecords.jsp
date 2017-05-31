<%-- 
    Document   : UserRecords
    Created on : May 3, 2017, 9:55:17 AM
    Author     : Nitish
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="${pageContext.request.contextPath}/static/css/index_Css.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
     </head>
     <style>
         table{
             height: 100%;
             width: 500px;
             border-collapse: collapse;
         }
         th{
             background-color: crimson;
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
    <body id="user_record_body">
        <h1 id="hellomessage">Welcome to my WebSite</h1>
        <form method="get" action="${pageContext.request.contextPath}/AdminServlet">
                <button type ="submit">Show Records</button>
        </form>
        <table id = "User_Record_table">
            <tr>
                <th>id</th>
                <th>name</th>
                <th>password</th>
                <th>status</th>
           </tr>
           
          <c:forEach var="user_list" items="${user}">
                    <tr>    
                   <td><c:out value="${user_list.id}"/></td>
                   <td><c:out value="${user_list.username}"/></td>
                   <td><c:out value="${user_list.password}"/></td>
                    
          </c:forEach>
          <c:forEach var="users" items="${sessionScope.uName}"> 
              <td>
                  <c:choose>
                      <c:when test="${users != null}">
                          <c:out value="${'Active'}"/>
                      </c:when>
                      <c:when test="${users == null}">
                          <c:out value="${'InActive'}"/>
                      </c:when>
                  </c:choose>
              </td>
              </tr>
          </c:forEach>
               
         </table>
        <form method="get" action="${pageContext.request.contextPath}/LogOffServlet">
            <input type="hidden" value="${userName}" name="username">
            <button type="submit">log out</button>
        </form>
            <a href="${pageContext.request.contextPath}/MainPage">go to main page</a>    
    </body>
</html>
