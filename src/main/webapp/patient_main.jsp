<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <c:set var="context" value="${pageContext.request.contextPath}"/>
    <link type="text/css" rel="stylesheet" href="${context}/css/style_2.css"/>
    <%--<link rel="stylesheet" href="${context}/css/bootstrap.min.css">--%>
    <title>Students</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>

<form action="${pageContext.servletContext.contextPath}/create" method="POST">
    <table style="width:100%">
        <tr>
            <th>Id Patient</th>
            <th>First Name</th>
            <th>Action</th>
        </tr>
        <c:forEach items="${list}" var="item">
            <tr>
                <td><p><c:out value="${item.idPatient}"></c:out></p></td>
                <td><p><c:out value="${item.firstName}"></c:out></p></td>
                <td>
                    <p>
                        <button class="button button3" name="delete" value="${item.id}" formaction="/web/deleteById">Delete</button>
                        <button class="button button2" name="edit" value="${item.id}" formaction="/web/editById">Edit</button>
                    </p>
                </td>
            </tr>
        </c:forEach>
    </table>
    <div>
        </br>
        <button class="button button1" type="addButton" name="add" value="${item.id}" formaction="/web/add"
                style="margin: auto; display: block">Add smth
        </button>
    </div>
</form>
</body>
</html>