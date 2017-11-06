<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <c:set var="context" value="${pageContext.request.contextPath}"/>
    <link type="text/css" rel="stylesheet" href="${context}/css/style_2.css"/>
    <title>Просмотр графика записей врача</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>

<form method="post">
    <table style="width:100%">
        <tr>
            <th>ID Талона</th>
            <th>ФИО врача</th>
            <th>Кабинет</th>
            <th>Специализация</th>
            <th>Время записи</th>
            <th>Дата записи</th>
        </tr>
        <c:forEach items="${tickets}" var="ticket">
            <tr>
                <td><p><c:out value="${ticket.idTicket}"></c:out></p></td>
                <td><p><c:out value="${ticket.doctorFIO}"></c:out></p></td>
                <td><p><c:out value="${ticket.office}"></c:out></p></td>
                <td><p><c:out value="${ticket.specialization}"></c:out></p></td>
                <td><p><c:out value="${ticket.time}"></c:out></p></td>
                <td><p><c:out value="${ticket.date}"></c:out></p></td>
            </tr>
        </c:forEach>
    </table>
    <div>
        </br>
        <button class="button button1" type="returnBack" name="return" formaction="/web/patient_main/ticket_date_time"
                style="margin: auto; display: block">Вернуться и сделать запись к врачу
        </button>
    </div>
</form>
</body>
</html>