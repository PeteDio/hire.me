<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Edit User</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <link href="/pub/css/main.css" rel="stylesheet">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Lemon&display=swap" rel="stylesheet">
</head>
<body>
<h1>Edit User</h1>
<%--@elvariable id="user" type="com.dillo.hireme.entity.User"--%>
<%--@elvariable id="roles" type="com.dillo.hireme.entity.Role"--%>
<form:form action="/user/update" method="post" modelAttribute="user">
    <table>
        <tr>
            <td>ID:</td>
            <td>${user.id}</td> </tr>
        <tr>
            <td>Name:</td>
            <td><form:input path="firstName" /></td>
        </tr>
        <tr>
            <td>Role:</td>
            <td>
                <form:select path="role.id">
                    <c:forEach items="${roles}" var="role">
                        <form:option value="${role.id}" label="${role.name}" />
                    </c:forEach>
                </form:select>
            </td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Update" /></td>
        </tr>
    </table>
</form:form>
</body>
</html>