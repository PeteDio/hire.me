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
<body>
<%--@elvariable id="candidate" type="com.dillo.hireme.entity.Candidate"--%>
<h1>Schedule Interview for ${candidate.firstName}</h1>
<%--@elvariable id="interview" type="com.dillo.hireme.entity.Interview"--%>
<form:form action="/interview/new/${candidate.id}" method="post" modelAttribute="interview">
    <table>
        <tr>
            <td>Date Time:</td>
            <td><form:input path="datetime" type="datetime-local" /></td>
        </tr>
        <tr>
            <td>Interviewer:</td>
            <td><form:select path="employee.id">
                <%--@elvariable id="interviewers" type="com.dillo.hireme.entity.User"--%>
                <c:forEach items="${interviewers}" var="user">
                    <option value="${user.id}">${user.firstName}</option>
                </c:forEach>
            </form:select>
            </td>
        </tr>
    </table>
    <input type="submit" value="Schedule Interview" />
</form:form>
</body>
</html>