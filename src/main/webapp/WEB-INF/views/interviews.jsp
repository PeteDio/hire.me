<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>All Interviews</title>
</head>
<body>
<h1>All Interviews</h1>
<table>
    <thead>
    <tr>
        <th>Candidate</th>
        <th>Employee</th>
        <th>Date Time</th>
        <th>Notes</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <%--@elvariable id="interviews" type="com.dillo.hireme.entity.Interview"--%>
    <c:forEach items="${interviews}" var="interview">
        <tr>
            <td>${interview.candidate.firstName} ${interview.candidate.lastName}</td>
            <td>${interview.employee.firstName} ${interview.employee.lastName}</td>
            <td>${interview.datetime}</td>
            <td>${interview.notes}</td>
            <td>
                <a href="/interviews/edit/${interview.id}">Edit</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>