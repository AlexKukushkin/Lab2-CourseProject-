<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <c:set var="context" value="${pageContext.request.contextPath}"/>
    <link type="text/css" rel="stylesheet" href="${context}/css/style_2.css"/>
    <%--<link rel="stylesheet" href="${context}/css/bootstrap.min.css">--%>
    <title>Выбор местоположения медцентра</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>

<form action="${pageContext.servletContext.contextPath}/create" method="POST">
    <table style="width:100%">
        <tr>
            <th>Выберите из списка населённый пункт (регион) : </th>
            <td>
                <p><select name="select" style="width: 400px">
                    <option>Москва</option>
                    <option>Санкт-Петербург</option>
                    <option>Ростов-на-Дону</option>
                    <option>Казань</option>
                </select></p>
            </td>
        </tr>
        <tr>
            <th>Выберите из списка район : </th>
            <td>
                <p><select name="select" style="width: 400px">
                    <option>Октябрьский район</option>
                    <option>Ворошиловский район</option>
                    <option>Будённовский район</option>
                    <option>Сельмаш район</option>
                </select></p>
            </td>
        </tr>
        <tr>
            <th>Выберите Медицинский центр : </th>
            <td>
                <p><select name="select" style="width: 400px">
                    <option>Здоровье-1</option>
                    <option>Здоровье-2</option>
                    <option>Центральный МедЦентр №1</option>
                    <option>Центральный МедЦентр №2</option>
                </select></p>
            </td>
        </tr>
        <tr>
            <th>Выберите специализацию врача : </th>
            <td>
                <p><select name="select" style="width: 400px">
                    <option>Стоматология</option>
                    <option>Хирургия</option>
                    <option>Пульмонология</option>
                    <option>Кардиология</option>
                </select></p>
            </td>
        </tr>
        <tr>
            <th>Выберите врача и дату : </th>
            <td>
                <p><select name="select" style="width: 400px">
                    <option>Иванов И. И.</option>
                    <option>Петров П.П.</option>
                    <option>Сидоров С. С.</option>
                    <option>Кондратьев К.К.</option>
                </select></p>
                <p><select name="select" style="width: 400px">
                    <option>yyyy-mm-dd 1</option>
                    <option>yyyy-mm-dd 2</option>
                    <option>yyyy-mm-dd 3</option>
                    <option>yyyy-mm-dd 4</option>
                </select></p>
            </td>
        </tr>
        <tr>
            <th>Выберите время приёма : </th>
            <td>
                <p><select name="select" style="width: 400px">
                    <option>9:00 - 9:30</option>
                    <option>9:30 - 10:00</option>
                    <option>10:00 - 10:30</option>
                    <option>10:30 - 11:00</option>
                </select></p>
            </td>
        </tr>
    </table>
    <div>
        </br>
        <button class="button button1" type="addButton" formaction="/web/patient_doctor_schedule_2"
                style="margin: auto; display: block">Получить талон на приём к врачу
        </button>
        </br>
        <button class="button button2" type="returnBack" name="return" formaction="/web/patient_main"
                style="margin: auto; display: block">Вернуться на главную страницу
        </button>
    </div>
</form>
</body>
</html>