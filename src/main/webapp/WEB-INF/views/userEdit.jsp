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
<body class="min-h-screen bg-gray-100">
<jsp:include page="fragments/_header.jsp" />
<div class="container mx-auto p-4">
    <h1 class="text-2xl font-bold mb-4">Edit User</h1>
    <%--@elvariable id="user" type="com.dillo.hireme.entity.User"--%>
    <%--@elvariable id="role" type="com.dillo.hireme.entity.Role"--%>
<%--    TODO: fix action --%>
    <form:form action="/user/update/${user.id}/" id="form" method="post" modelAttribute="user" class="space-y-4">
        <div class="grid grid-cols-2 gap-4">
            <div class="col-span-1">
                <label for="id" class="block text-gray-700 font-bold mb-2">ID:</label>
            </div>
            <div class="col-span-1">
                <span class="text-gray-700">${user.id}</span>
            </div>
            <div class="col-span-1">
                <label for="firstName" class="block text-gray-700 font-bold mb-2">Name:</label>
            </div>
            <div class="col-span-1">
                <form:input path="firstName" class="appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline" />
            </div>
            <div class="col-span-1">
                <label class="block text-gray-700 font-bold mb-2">Role:</label>
            </div>
            <div class="col-span-1">
                <form:select path="role.name" class="appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline">
                    <%--@elvariable id="roles" type="com.dillo.hireme.entity.Role"--%>
                    <c:forEach items="${roles}" var="role">
                        <form:option value="${role.name}" label="${role.name}" />
                    </c:forEach>
                </form:select>
            </div>
        </div>
        <div class="flex items-center justify-end">
            <input type="submit" value="Update" class="px-4 py-2 bg-blue-500 text-white font-bold rounded hover:bg-blue-700 focus:outline-none focus:shadow-outline" />
        </div>
    </form:form>
</div>
<script src="/pub/js/user.js"></script>
</body>
</html>