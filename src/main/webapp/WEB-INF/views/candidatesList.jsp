<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <html>

    <head>
        <title>Candidates List</title>
        <script src="https://cdn.tailwindcss.com"></script>
        <link href="/pub/css/main.css" rel="stylesheet">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Lemon&display=swap" rel="stylesheet">
    </head>

    <body>
        <jsp:include page="fragments/_header.jsp" />
        <h1>Candidates List</h1>
        <a href="/candidate/add" class="bg-purple-500 hover:bg-purple-700 text-white font-bold rounded">Add new Candidate</a>
        <div class="overflow-auto rounded-lg shadow-md">
            <table class="w-full text-left table-auto">
                <thead>
                    <tr>
                        <th class="px-4 py-2 font-bold text-gray-500 bg-gray-100 border-b">First Name</th>
                        <th class="px-4 py-2 font-bold text-gray-500 bg-gray-100 border-b">Last Name</th>
                        <th class="px-4 py-2 font-bold text-gray-500 bg-gray-100 border-b">Email</th>
                        <th class="px-4 py-2 font-bold text-gray-500 bg-gray-100 border-b">Job Title</th>
                        <th class="px-4 py-2 font-bold text-gray-500 bg-gray-100 border-b">Bio</th>
                        <th class="px-4 py-2 font-bold text-gray-500 bg-gray-100 border-b">Candidate Status</th>
                        <th class="px-4 py-2 font-bold text-gray-500 bg-gray-100 border-b">Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <%--@elvariable id="candidates" type="com.dillo.hireme.entity.Candidate" --%>
                        <c:forEach items="${candidates}" var="candidate">
                            <tr>
                                <td class="px-4 py-2 border-b">${candidate.firstName}</td>
                                <td class="px-4 py-2 border-b">${candidate.lastName}</td>
                                <td class="px-4 py-2 border-b">${candidate.email}</td>
                                <td class="px-4 py-2 border-b">${candidate.jobTitle}</td>
                                <td class="px-4 py-2 border-b text-sm">${candidate.bio}</td>
                                <td class="px-4 py-2 border-b font-semibold capitalize">
                                    ${candidate.candidateStatus.name}</td>
                                <td class="px-4 py-2 border-b flex items-center gap-2">
                                    <a href="/interview/new/${candidate.id}"
                                        class="text-blue-500 hover:underline">Schedule Interview</a>
                                </td>
                            </tr>
                        </c:forEach>
                        </c>
                </tbody>
            </table>
        </div>
    </body>

    </html>