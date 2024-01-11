<%@ page import="java.time.LocalDateTime" %>
    <%@ page import="java.util.Date" %>
        <%@ page import="java.time.ZoneId" %>
            <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
                <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
                    <%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
                        <html>
                        <head>
                            <title>All Interviews</title>
                            <script src="https://cdn.tailwindcss.com"></script>
                            <link href="/pub/css/main.css" rel="stylesheet">
                            <link rel="preconnect" href="https://fonts.googleapis.com">
                            <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
                            <link href="https://fonts.googleapis.com/css2?family=Lemon&display=swap" rel="stylesheet">
                        </head>
                        <body>
                            <jsp:include page="fragments/_header.jsp" />
                            <h1 class="text-2xl font-bold mb-4">All Interviews</h1>
                            <div class="overflow-auto rounded-lg shadow-md">
                                <table class="w-full text-left table-auto">
                                    <thead class="bg-gray-50">
                                        <tr>
                                            <th scope="col"
                                                class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
                                                Candidate
                                            </th>
                                            <th scope="col"
                                                class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
                                                Employee
                                            </th>
                                            <th scope="col"
                                                class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
                                                Date Time
                                            </th>
                                            <th scope="col"
                                                class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
                                                Notes
                                            </th>
                                            <th scope="col"
                                                class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
                                                Actions
                                            </th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${interviews}" var="interview">
                                            <tr>
                                                <td class="px-6 py-4 whitespace-nowrap">${interview.candidate.firstName}
                                                    ${interview.candidate.lastName}
                                                </td>
                                                <td class="px-6 py-4 whitespace-nowrap">${interview.employee.firstName}
                                                    ${interview.employee.lastName}
                                                </td>
                                                <td class="px-6 py-4 whitespace-nowrap">
                                                        ${interview.datetime}
                                                </td>
                                                <td class="px-6 py-4 whitespace-nowrap">
                                                    <a href="/interview/notes/${interview.id}">Add Notes</a>
                                                </td>
                                                <td class="px-6 py-4 whitespace-nowrap">
                                                    <a href="/interview/edit/${interview.id}">Edit</a>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <script src="/pub/js/main.js"></script>
                        </body>
                        </html>