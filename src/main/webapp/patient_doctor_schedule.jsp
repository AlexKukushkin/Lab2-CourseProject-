<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <c:set var="context" value="${pageContext.request.contextPath}"/>
    <link type="text/css" rel="stylesheet" href="${context}/css/style_2.css"/>
    <%--<link rel="stylesheet" href="${context}/css/bootstrap.min.css">--%>
    <title>График работы врачей</title>
    <%--<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>--%>
</head>
<body>

<form action="${pageContext.servletContext.contextPath}/create" method="POST">
    <table style="width:100%">
        <tr>
            <th>Введите пожалуйста Фамилию врача : </th>
        </tr>
        <tr>
            <td>
                <p><input type="text" id="familyName" name="familyName" size="50"  placeholder="Фамилия врача">
            </td>
        </tr>
    </table>
    <div>
        </br>
        <button class="button button1" type="addButton" formaction="/web/patient_doctor_schedule_2"
                style="margin: auto; display: block">Посмотреть расписание
        </button>
        </br>
        <button class="button button2" type="returnBack" name="return" formaction="/web/patient_main"
                style="margin: auto; display: block">Вернуться на главную страницу
        </button>
    </div>
</form>
</body>
</html>