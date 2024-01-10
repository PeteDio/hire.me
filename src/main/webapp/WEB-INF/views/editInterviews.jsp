<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
        <html>
        <head>
            <title>Edit Interview</title>
            <script src="https://cdn.tailwindcss.com"></script>
            <link href="/pub/css/main.css" rel="stylesheet">
            <link rel="preconnect" href="https://fonts.googleapis.com">
            <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
            <link href="https://fonts.googleapis.com/css2?family=Lemon&display=swap" rel="stylesheet">
        </head>
        <body class="min-h-screen bg-gray-100">
        <jsp:include page="fragments/_header.jsp" />
        <div class="container mx-auto p-4">
            <h1 class="text-2xl font-bold mb-4">Edit Interview</h1>
            <%--@elvariable id="interview" type="com.dillo.hireme.entity.Interview" --%>
            <form:form action="/edit/${interview.id}" method="post" modelAttribute="interview" class="space-y-4">
                <div class="grid grid-cols-2 gap-4">
                    <div class="col-span-1">
                        <label class="block text-gray-700 font-bold mb-2">Date Time:</label>
                    </div>
                    <div class="col-span-1">
                        <form:input path="datetime" type="datetime" class="appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline" />
                    </div>
                    <div class="col-span-1">
                <%--@elvariable id="interviewers" type="com.dillo.hireme.entity.User"--%>
                <label class="block text-gray-700 font-bold mb-2">Interviewer:</label>
            </div>
            <div class="col-span-1">
                <form:select path="employee.id" class="appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline">
                    <c:forEach items="${interviewers}" var="user">
                        <option value="${user.id}" ${user.id==interview.employee.id ? 'selected="selected"' : '' }>${user.firstName}</option>
                    </c:forEach>
                </form:select>
            </div>
            <div class="col-span-1">
                <label for="notes" class="block text-gray-700 font-bold mb-2">Notes:</label>
            </div>
            <div class="col-span-1">
                <form:textarea path="notes" class="resize-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline" />
            </div>
        </div>
        <div class="flex items-center justify-end">
            <input type="submit" value="Save Changes" class="px-4 py-2 bg-blue-500 text-white font-bold rounded hover:bg-blue-700 focus:outline-none focus:shadow-outline" />
        </div>
    </form:form>
</div>
</body>
</html>