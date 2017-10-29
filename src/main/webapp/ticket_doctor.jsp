<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <c:set var="context" value="${pageContext.request.contextPath}"/>
    <link type="text/css" rel="stylesheet" href="${context}/css/style_2.css"/>
    <%--<link rel="stylesheet" href="${context}/css/bootstrap.min.css">--%>
    <title>Врачи</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>

<form method="POST">
    <table style="width:100%">
        <tr>
            <th>ID Врача</th>
            <th>Имя</th>
            <th>Фамилия</th>
            <th>Отчество</th>
            <th>Специализация</th>
            <th>Кабинет</th>
            <th>МедЦентр</th>
            <th>Выбор времени и даты записи<th>
        </tr>
        <c:forEach items="${doctors}" var="doctor">
            <tr>
                <td><p><c:out value="${doctor.idDoctor}"></c:out></p></td>
                <td><p><c:out value="${doctor.firstName}"></c:out></p></td>
                <td><p><c:out value="${doctor.patronymic}"></c:out></p></td>
                <td><p><c:out value="${doctor.familyName}"></c:out></p></td>
                <td><p><c:out value="${doctor.specialization}"></c:out></p></td>
                <td><p><c:out value="${doctor.office}"></c:out></p></td>
                <td><p><c:out value="${doctor.medcenterName}"></c:out></p></td>
                <td>
                    <button class="button button1" type="addButton" name="idDoctor" value="${doctor.idDoctor}" formaction="/web/ticket_date_time"
                            style="margin: auto; display: block">Выбрать время/дату записи и перейти на следующую страницу
                    </button>
                </td>
            </tr>
        </c:forEach>
    </table>
    <div>
        </br>
        <button class="button button1" type="returnBack" name="return" formaction="/web/patient_main"
                style="margin: auto; display: block">Вернуться на главную страницу
        </button>
    </div>
</form>
</body>
</html>