<%--
  Created by IntelliJ IDEA.
  User: Alex Kukushkin
  Date: 10/10/2017
  Time: 12:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Signin form</title>
    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
    <%--<link rel="stylesheet" href="<c:url value='/css/bootstrap.min.css'/>">--%>
    <%--<link rel="stylesheet" href="<c:url value='/css/style.css'/>">--%>
    <link rel="stylesheet" href="../web/css/bootstrap.min.css">
    <link rel="stylesheet" href="../web/css/style.css">

</head>
<body>
<div class="container">
    <form class="form-signin" id="myForm" method="post">
        <h2 class="form-signin-heading">Электронная запись к врачу</h2>
        <label for="inputLogin" class="sr-only">Login</label>
        <input type="login" id="inputLogin" name="inputLogin" class="form-control" placeholder="Username" required
               autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" name="inputPassword" class="form-control" placeholder="Password"
               required>
        <div class="checkbox">
            <label>
                <input type="checkbox" value="remember-me"> Запомнить
            </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" formaction="/web/auth" value="login" type="submit">
            Войти в личный кабинет
        </button>
    </form>
</div>
<div class="row">
    <div class="col-sm-12">
        <div class="text-center">
            <a class="btn btn-lg btn-success" style="width: 22%" href="WEB-INF/pages/registration.jsp" value="register"
               type="submit">Регистрация
            </a>
        </div>
    </div>
</div>
</body>
</html>
