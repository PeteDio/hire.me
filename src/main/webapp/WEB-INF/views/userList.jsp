<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <html>

    <head>
        <title>User List</title>
        <script src="https://cdn.tailwindcss.com"></script>
        <link href="/pub/css/main.css" rel="stylesheet">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Lemon&display=swap" rel="stylesheet">
    </head>

    <body class="min-h-screen bg-gray-100">
    <jsp:include page="fragments/_header.jsp" />
    <div class="container mx-auto p-4">
        <h1 class="text-2xl font-bold mb-4">List of Users</h1>
        <table class="min-w-full divide-y divide-gray-200">
            <thead class="bg-gray-50">
            <tr>
                <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">ID</th>
                <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider"> Name</th>
                <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Role</th>
                <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Actions</th>
            </tr>
            </thead>
            <tbody class="bg-white divide-y divide-gray-200">
            <%--@elvariable id="users" type="com.dillo.hireme.entity.User"--%>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td class="px-6 py-4 whitespace-nowrap">
                        <span class="text-sm font-medium">${user.id}</span>
                    </td>
                    <td class="px-6 py-4 whitespace-nowrap">
                        <span class="text-sm font-medium">${user.firstName} ${user.lastName}</span>
                    </td>
                    <td class="px-6 py-4 whitespace-nowrap">
                        <span class="text-sm font-medium">${user.role.name}</span>
                    </td>
                    <td class="px-6 py-4 whitespace-nowrap text-right text-sm font-medium">
                        <a href="/user/edit/${user.id}" class="text-blue-600 hover:text-blue-900">Edit</a>
                        <a href="/user/delete/${user.id}" class="text-red-600 hover:text-red-900">delete</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    </body>

    </html>