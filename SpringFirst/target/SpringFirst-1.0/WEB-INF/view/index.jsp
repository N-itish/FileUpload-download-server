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
        <link href="${pageContext.request.contextPath}/static/css/Css_For_Index.css" rel="stylesheet" type="text/css"/>
        <script src="${pageContext.request.contextPath}/static/JQuery/JQuery.min.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/static/JQuery/Animations_For_Index.js" type="text/javascript"></script>
        <title>JSP Page</title>
    </head>
    <body id="index_body">
        
        <div id ="Register_container">
        <p id = "dynamically_set_text_register"></p>
        <h1>Register</h1>
        <form action="${pageContext.request.contextPath}/RegisterServlet" method="get">
            username:<br><input id = "register_username" type="text" name="name" placeholder = "Enter your name"><br>
            password:<br><input id = "register_password" type="password" name="pass" placeholder="Enter your password"><br>
            <p>show password<input type="checkbox" id ="revel_password" ><br></p>
            <p><input id = "Register" type ="submit" value="Register"/></p>
        </form>
        </div>
        
        <div id = "sign_in_container">
        <h1>Sign In</h1>
        <p id = "dynamically_set_text_login"></p>
        <form action="${pageContext.request.contextPath}/LoginServlet" method="post">
            username:<br><input id = "password" type = "text" name = "loginuser" placeholder="Enter your name"><br>
            password:<br><input id = "username" type ="password" name="loginpass" placeholder="Enter your password"><br>
            <p><input id = "login" type="submit" value="Login"/></p>
        </form>
        </div>
         ${LoginFailedMessage}
         <h1>${message}</h1>
        <h1 id ="logOffMessage">${Username} ${LoggedOffmessage}</h1>
    </body>
</html>
