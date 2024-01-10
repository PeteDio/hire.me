<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
        <html>

        <head>
            <title>Schedule Interview</title>
            <script src="https://cdn.tailwindcss.com"></script>
            <link href="/pub/css/main.css" rel="stylesheet">
            <link rel="preconnect" href="https://fonts.googleapis.com">
            <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
            <link href="https://fonts.googleapis.com/css2?family=Lemon&display=swap" rel="stylesheet">
        </head>

        <body class="container mx-auto p-4">
            <h1 class="text-2xl font-bold mb-4">Schedule Interview for ${candidate.firstName}</h1>
          
            <%--@elvariable id="interview" type="com.dillo.hireme.entity.Interview"--%>
            <form:form action="/interview/new/${candidate.id}" method="post" modelAttribute="interview" class="bg-white shadow-md rounded px-8 pt-6 pb-8 mb-4">
              <table class="w-full mb-4">
                <tr>
                  <td class="px-6 py-4 font-medium text-gray-700">Date Time:</td>
                  <td class="px-6 py-4">
                    <form:input path="datetime" type="datetime-local" class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline" />
                  </td>
                </tr>
                <tr>
                  <td class="px-6 py-4 font-medium text-gray-700">Interviewer:</td>
                  <td class="px-6 py-4">
                    <form:select path="employee.id" class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline">
                      <c:forEach items="${interviewers}" var="user">
                        <option value="${user.id}">${user.firstName}</option>
                      </c:forEach>
                    </form:select>
                  </td>
                </tr>
              </table>
          
              <input type="submit" value="Schedule Interview" class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline" />
            </form:form>
          </body>

        </html>