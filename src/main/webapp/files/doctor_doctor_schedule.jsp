<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <c:set var="context" value="${pageContext.request.contextPath}"/>
    <link type="text/css" rel="stylesheet" href="${context}/css/style_2.css"/>
    <%--<link rel="stylesheet" href="${context}/css/bootstrap.min.css">--%>
    <title>График работы врачей</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>

<form method="POST">
    <table style="width:100%">
        <tr>
            <th>ID Графика</th>
            <th>ID Врача</th>
            <th>Имя</th>
            <th>Отчество</th>
            <th>Фамилия</th>
            <th>Специализация</th>
            <th>Оффис</th>
            <th>Понедельник</th>
            <th>Вторник</th>
            <th>Среда</th>
            <th>Четверг</th>
            <th>Пятница</th>
            <th>Суббота</th>
            <th>Воскресенье</th>
        </tr>
        <c:forEach items="${list}" var="item">
            <tr>
                <td><p><c:out value="${item.idCalendar}"></c:out></p></td>
                <td><p><c:out value="${item.idDoctor}"></c:out></p></td>
                <td><p><c:out value="${item.firstName}"></c:out></p></td>
                <td><p><c:out value="${item.patronymic}"></c:out></p></td>
                <td><p><c:out value="${item.familyName}"></c:out></p></td>
                <td><p><c:out value="${item.specialization}"></c:out></p></td>
                <td><p><c:out value="${item.office}"></c:out></p></td>
                <td><p><c:out value="${item.monDay}"></c:out></p></td>
                <td><p><c:out value="${item.tuesDay}"></c:out></p></td>
                <td><p><c:out value="${item.wednesDay}"></c:out></p></td>
                <td><p><c:out value="${item.thursDay}"></c:out></p></td>
                <td><p><c:out value="${item.friDay}"></c:out></p></td>
                <td><p><c:out value="${item.saturDay}"></c:out></p></td>
                <td><p><c:out value="${item.sunDay}"></c:out></p></td>

            </tr>
        </c:forEach>
    </table>
    <div>
        </br>
        <button class="button button1" type="returnBack" name="return" formaction="/web/doctor_main"
                style="margin: auto; display: block">Вернуться на главную страницу
        </button>
    </div>
</form>
</body>
</html>