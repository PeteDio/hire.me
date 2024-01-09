<header class="bg-gray-800 text-white py-4 px-6 flex items-center sm:justify-between justify-start">
    <a href="/" class="text-2xl font-bold tracking-tight">hire.me</a>
    <div class="hidden sm:block">
        <ul class="flex items-center space-x-4">
            <%--@elvariable id="user" type="com.dillo.hireme.entity.User"--%>
            <c:if test="${not empty user}">
                <li><a href="/candidate/" class="hover:text-blue-500">Candidates</a></li>
                <li><a href="/interview/" class="hover:text-blue-500">Interviews</a></li>
                <c:if test="${user.role == 'ADMIN'}">
                    <li><a href="/user/getAll" class="hover:text-blue-500">Users</a></li>
                </c:if>
                <li><a href="/logout" class="hover:text-blue-500">Log Out</a></li> </c:if>
        </ul>
    </div>
</header>