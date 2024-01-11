<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <html>

    <head>
        <title>User List</title>
        <link href="/pub/css/main.css" rel="stylesheet">
        <link href="/pub/css/index.css" rel="stylesheet">
        <script src="https://cdn.tailwindcss.com"></script>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Lemon&display=swap" rel="stylesheet">
    </head>

    <body>
        <jsp:include page="fragments/_header.jsp" />
        <div class="container mx-auto p-4">
            <h1 class="text-4xl font-bold p-4 mb-4 w-full text-center">List of Users</h1>
            <table class="min-w-full" >
                <thead class="bg-gray-50">
                    <tr>
                        <th scope="col"
                            class="px-6 py-3 text-left text-xs font-medium uppercase tracking-wider">ID
                        </th>
                        <th scope="col"
                            class="px-6 py-3 text-left text-xs font-medium uppercase tracking-wider"> Name
                        </th>
                        <th scope="col"
                            class="px-6 py-3 text-left text-xs font-medium uppercase tracking-wider">Role
                        </th>
                        <th scope="col"
                            class="px-6 py-3 text-left text-xs font-medium uppercase tracking-wider">
                            Actions</th>
                    </tr>
                </thead>
                <tbody class="">
                    <%--@elvariable id="users" type="com.dillo.hireme.entity.User" --%>
                        <c:forEach items="${users}" var="user">
                            <tr class="shadow-md">
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
                                    <form action="/user/delete/${user.id}" method="post">
                                        <button class="text-red-600 hover:text-red-900"
                                            onclick="return confirm('Are you sure you want to delete this item?')">Delete</button>
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                </tbody>
            </table>
        </div>
    </body>

    </html>