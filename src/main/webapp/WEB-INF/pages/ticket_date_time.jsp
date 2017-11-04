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
            <th>Дата записи</th>
            <th>День записи</th>
            <th>Время записи</th>
            <th>Действие :</th>
        </tr>
        <tr>
            <td>
                <p><input type="text" id="patientDate" name="patientDate" size="25" class="form-control"
                          placeholder="Дата записи : yyyy-mm-dd"
                          required autofocus></p>
            </td>
            <td>
                <p><input type="text" id="patientDay" name="patientDay" size="25" class="form-control"
                          placeholder="День записи"
                          required autofocus></p>
            </td>
            <td><p><input type="text" id="patientTime" name="patientTime" size="25" class="form-control"
                          placeholder="Время записи : hh:mm"
                          required autofocus></p>
            </td>
            <td>
                <button class="button button1" type="returnBack" name="return" formaction="/web/patient_main/get_ticket"
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