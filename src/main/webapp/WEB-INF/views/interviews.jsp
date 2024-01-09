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