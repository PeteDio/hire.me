<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
        <html>

        <head>
            <title>Add Candidates</title>
            <script src="https://cdn.tailwindcss.com"></script>
            <link href="/pub/css/main.css" rel="stylesheet">
            <link rel="preconnect" href="https://fonts.googleapis.com">
            <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
            <link href="https://fonts.googleapis.com/css2?family=Lemon&display=swap" rel="stylesheet">
        </head>

        <body class="min-h-screen bg-gray-100">
            <jsp:include page="fragments/_header.jsp" />
            <div class="container mx-auto p-4">
                <h1 class="text-2xl font-bold mb-4">Add new Candidate</h1>
                <%--@elvariable id="candidate" type="com.dillo.hireme.entity.Candidate" --%>
                    <form:form action="/candidate/add" method="post" modelAttribute="candidate" class="space-y-4">
                        <div class="grid grid-cols-2 gap-4">
                            <div class="mb-4">
                                <label for="email" class="block text-gray-700 font-bold mb-2">Email</label>
                                <input type="email" id="email" name="email"
                                    class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
                                    required>
                            </div>
                            <div class="mb-4">
                                <label for="firstName" class="block text-gray-700 font-bold mb-2">First Name</label>
                                <input type="text" id="firstName" name="firstName"
                                    class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
                                    required>
                            </div>
                            <div class="mb-4">
                                <label for="lastName" class="block text-gray-700 font-bold mb-2">Last Name</label>
                                <input type="text" id="lastName" name="lastName"
                                    class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
                                    required>
                            </div>
                            <div class="mb-6">
                                <label for="jobTitle" class="block text-gray-700 font-bold mb-2">Job Title</label>
                                <select type="text" id="jobTitle" name="jobTitle"
                                    class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
                                    required>
                                    <option value="Software Developer">Software Developer</option>
                                </select>
                            </div>
                            <div class="mb-4">
                                <label for="bio" class="block text-gray-700 font-bold mb-2">Bio</label>
                                <input type="text" id="bio" name="bio"
                                    class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
                                    required>
                            </div>
                        </div>
                        <input type="submit" value="Add Candidate"
                            class="px-4 py-2 bg-blue-500 text-white font-bold rounded hover:bg-blue-700 focus:outline-none focus:shadow-outline" />
                    </form:form>
            </div>
        </body>
        </html>