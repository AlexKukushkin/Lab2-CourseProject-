<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <%--<style>--%>
    <%--table, th, td {--%>
    <%--border: 1px solid black;--%>
    <%--border-collapse: collapse;--%>
    <%--}--%>

    <%--th, td {--%>
    <%--padding: 5px;--%>
    <%--}--%>

    <%--th {--%>
    <%--text-align: left;--%>
    <%--}--%>
    <%--</style>--%>
    <c:set var="context" value="${pageContext.request.contextPath}"/>
    <link type="text/css" rel="stylesheet" href="${context}/css/style_2.css"/>
    <title>Личные данные</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>

<form action="${pageContext.servletContext.contextPath}/patient_save" method="post">
<table style="width:100%">
    <tr>
        <th>Id Пациента</th>
        <th>Имя</th>
        <th>Фамилия</th>
        <th>Отчество</th>
        <th>Дата рождения</th>
        <th>Паспорт</th>
        <th>СНИЛС</th>
        <th>Медполис</th>
        <th>Адрес регистрации</th>
        <th>Адрес проживания</th>
        <th>Пол</th>
        <th>Действие</th>
    </tr>
    <tr>
        <td>
            <p><input type="text" name="id_patient" size="10" value="<c:out value="${patient.idPatient}"></c:out>"/>
            </p>
        </td>
        <td>
            <p><input type="text" name="first_name" size="10" value="<c:out value="${patient.firstName}"></c:out>"/>
            </p>
        </td>
        <td>
            <p><input type="text" name="family_name" size="10"
                      value="<c:out value="${patient.familyName}"></c:out>"/></p>
        </td>
        <td>
            <p><input type="text" name="patronymic" size="10"
                      value="<c:out value="${patient.patronymic}"></c:out>"/></p>
        </td>
        <td>
            <p><input type="text" name="birth_date" size="10" value="<c:out value="${patient.birthDate}"></c:out>"/>
            </p>
        </td>
        <td>
            <p><input type="text" name="passport" size="10" value="<c:out value="${patient.passport}"></c:out>"/>
            </p>
        </td>
        <td>
            <p><input type="text" name="SNILS" size="10" value="<c:out value="${patient.SNILS}"></c:out>"/>
            </p>
        </td>
        <td>
            <p><input type="text" name="medpolis" size="10" value="<c:out value="${patient.medPolis}"></c:out>"/>
            </p>
        </td>
        <td>
            <p><input type="text" name="registration" size="10"
                      value="<c:out value="${patient.registerLocation}"></c:out>"/>
            </p>
        </td>
        <td>
            <p><input type="text" name="address" size="10" value="<c:out value="${patient.address}"></c:out>"/>
            </p>
        </td>
        <td>
            <p><input type="text" name="sextype" size="10" value="<c:out value="${patient.sexType}"></c:out>"/>
            </p>
        </td>
        <td>
            <p>
                <button type="submit" name="save" formaction="/web/patient_main/patient_save">Сохранить
                </button>
            </p>
        </td>
    </tr>
</table>
</br>
</br>
</br>
</br>

<button class="button button1" type="returnBack" name="return" formaction="/web/patient_main"
        style="margin: auto; display: block">Вернуться на главную страницу
</button>
</form>
</body>
</html>