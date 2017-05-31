<%-- 
    Document   : index
    Created on : Apr 30, 2017, 1:50:33 PM
    Author     : Nitish
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="${pageContext.request.contextPath}/static/css/index_Css.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body id="index_body">
        <h1>Create a new Account</h1>
        <form action="${pageContext.request.contextPath}/RegisterServlet" method="get">
            username:<input type="text" name="name"><br>
            password:<input type="password" name="pass"><br>
            <button type ="submit">Register</button>
        </form>
    <p>
        <h1>If you already have an account</h1>
        <form action="${pageContext.request.contextPath}/LoginServlet" method="post">
            username:<input type = "text" name = "loginuser"><br>
            password:<input type ="password" name="loginpass"><br>
            <button type="submit">Login</button>
        </form>
         ${LoginFailedMessage}
    </p>
    <p>
       
    </p>
        <h1>${message}</h1>
        <h1>${Username} ${LoggedOffmessage}</h1>
    </body>
</html>
