<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <c:set var="context" value="${pageContext.request.contextPath}"/>
    <link type="text/css" rel="stylesheet" href="${context}/css/style_2.css"/>
    <link type="text/css" rel="stylesheet" href="${context}/assets/signup-form.css">
    <link rel="stylesheet" href="${context}/css/bootstrap.min.css">
    <title>Врачи</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>

<form method="POST">
    <table style="width:100%">
        <b> Уважаемый пациент, Вы можете записаться к выбранному врачу в свободное время с 8:00 до 17:00 в любой день
            кроме выходных.</b>
        <br>
        <br>
        <b>Выберите пожалуйста ниже дату и затем проверьте, чтобы Ваше время записи не было занято </b>
        <br>
        <br>
        <button class="btn btn-lg btn-info btn-block" type="checkDate" name="checkDate" formaction="/web/patient_main/check_date_time"
                style="margin: auto; display: block">Просмотреть график записей
        </button>
        <br>
        <br>
        <br>
        <br>
        <tr>
            <th>Дата записи</th>
            <%--<th>День записи</th>--%>
            <th>Время записи</th>
            <th>Действие :</th>
        </tr>
        <tr>
            <td>
                <%--<p><input type="text" id="patientDate" name="patientDate" size="25" class="form-control"--%>
                <%--placeholder="Дата записи : yyyy-mm-dd"--%>
                <%--required autofocus></p>--%>
                <p><input type="date" id="patientDate" name="patientDate" size="25" class="form-control" required
                          autofocus>
                </p>
            </td>
            <td>
                <p>
                    <select name="timevar" required>
                        <c:forEach items="${time_list}" var="time">
                            <option>
                                <c:out value="${time}"></c:out>
                            </option>
                        </c:forEach>
                    </select>
                </p>
            </td>
            <td>
                <button class="btn btn-lg btn-success btn-block" type="returnBack" name="time" formaction="/web/patient_main/get_ticket"
                        style="margin: auto; display: block">Получить талон
                </button>
            </td>
        </tr>
    </table>
    <div>
        </br>
        <button class="button button1" type="returnBack" name="return" formaction="/web/patient_main/patient_doctor"
                style="margin: auto; display: block">Вернуться назад
        </button>
        </br>
        </br>
        <button class="button button1" type="returnBack" name="return" formaction="/web/patient_main"
                style="margin: auto; display: block">Вернуться на главную страницу
        </button>
    </div>
</form>
</body>
</html>