<header class="bg-gray-800 text-white py-4 px-6 flex items-center sm:justify-between justify-start">
    <a href="/" class="text-2xl font-bold tracking-tight">hire.me</a>
    <div class="hidden sm:block">
        <ul class="flex items-center flex-row">
            <%--@elvariable id="user" type="com.dillo.hireme.entity.User"--%>
            <c:if class="flex items-center flex-row" test="${not empty user}">
                <li><a href="/candidate/" class="hover:text-blue-500 px-6">Candidates</a></li>
                <li><a href="/interview/" class="hover:text-blue-500 px-6">Interviews</a></li>
                <c:if test="${user.role == 'ADMIN'}">
                    <li><a href="/user/getAll" class="hover:text-blue-500 px-6">Users</a></li>
                </c:if>
                <li><a href="/logout" class="hover:text-blue-500 px-6">Log Out</a></li> </c:if>
        </ul>
    </div>
</header>