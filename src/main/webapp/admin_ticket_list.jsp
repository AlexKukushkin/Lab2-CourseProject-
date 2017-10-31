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
            <th>ID Талона</th>
            <th>Имя пациента</th>
            <th>Фамилия пациента</th>
            <th>Отчество пациента</th>
            <th>ФИО врача</th>
            <th>Кабинет</th>
            <th>Специализация</th>
            <th>Время записи</th>
            <th>Дата записи</th>
            <th>День</th>
            <th>Медицинский центр</th>
        </tr>
        <c:forEach items="${ticket_list}" var="ticket">
            <tr>
                <td><p><c:out value="${ticket.idTicket}"></c:out></p></td>
                <td><p><c:out value="${ticket.firstName}"></c:out></p></td>
                <td><p><c:out value="${ticket.familyName}"></c:out></p></td>
                <td><p><c:out value="${ticket.patronymic}"></c:out></p></td>
                <td><p><c:out value="${ticket.doctorFIO}"></c:out></p></td>
                <td><p><c:out value="${ticket.office}"></c:out></p></td>
                <td><p><c:out value="${ticket.specialization}"></c:out></p></td>
                <td><p><c:out value="${ticket.patientTime}"></c:out></p></td>
                <td><p><c:out value="${ticket.patientDay}"></c:out></p></td>
                <td><p><c:out value="${ticket.patientDate}"></c:out></p></td>
                <td><p><c:out value="${ticket.centerName}"></c:out></p></td>
            </tr>
        </c:forEach>
    </table>
    <div>
        </br>
        <button class="button button1" type="returnBack" name="return" formaction="/web/admin_main"
                style="margin: auto; display: block">Вернуться на главную страницу
        </button>
    </div>
</form>
</body>
</html>