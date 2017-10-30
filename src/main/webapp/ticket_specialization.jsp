<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <c:set var="context" value="${pageContext.request.contextPath}"/>
    <link type="text/css" rel="stylesheet" href="${context}/css/style_2.css"/>
    <%--<link rel="stylesheet" href="${context}/css/bootstrap.min.css">--%>
    <title>Выбор специализации</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="js/jquery-1.11.1.js" type="text/javascript"></script>
</head>
<body>

<form method="post">
    <table style="width:100%">
        <tr>
            <th>Выбор специализации :</th>
            <th>Действие:</th>
        </tr>
        <c:forEach items="${specializations}" var="specialization">
            <tr>
                <td><p><c:out value="${specialization}"></c:out></p></td>
                <td>
                    <button class="button button1" type="addButton" name="specialization" value="${specialization}" formaction="/web/patient_main/ticket_doctor"
                            style="margin: auto; display: block">Выбрать специализацию и перейти на следующую страницу
                    </button>
                </td>
            </tr>
        </c:forEach>
    </table>
    <div>
        </br>
        </br>
        <button class="button button2" type="returnBack" name="return" formaction="/web/patient_main"
                style="margin: auto; display: block">Вернуться на главную страницу
        </button>
    </div>
</form>
</body>
</html>