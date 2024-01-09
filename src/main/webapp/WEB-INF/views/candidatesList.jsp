<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Candidates List</title>
</head>
<body>
<h1>Candidates List</h1>
<table>
    <thead>
    <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Email</th>
        <th>Job Title</th>
        <th>Bio</th>
        <th>Candidate Status</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${candidates}"

               var="candidate">
        <tr>
            <td>${candidate.firstName}</td>
            <td>${candidate.lastName}</td>
            <td>${candidate.email}</td>
            <td>${candidate.jobTitle}</td>
            <td>${candidate.bio}</td>
            <td>${candidate.candidateStatus.name}</td>
            <td>
                <a href="/interview/new/${candidate.id}">Schedule Interview</a>  </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>