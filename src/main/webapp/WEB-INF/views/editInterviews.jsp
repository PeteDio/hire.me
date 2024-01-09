%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

        <html>

        <head>
            <title>Edit Interview</title>
        </head>

        <body>
            <jsp:include page="fragments/_header.jsp" />
            <h1>Edit Interview</h1>

            <%--@elvariable id="interview" type="com.dillo.hireme.entity.Interview" --%>
                <form:form action="/edit/${interview.id}" method="post" modelAttribute="interview">
                    <table>
                        <tr>
                            <td>Date Time:</td>
                            <td>
                                <form:input path="datetime" type="datetime-local" />
                            </td>
                        </tr>
                        <tr>
                            <td>Interviewer:</td>
                            <td>
                                <form:select path="employee.id">
                                    <c:forEach items="${interviewers}" var="user">
                                        <option value="${user.id}" ${user.id==interview.employee.id
                                            ? 'selected="selected"' : '' }>${user.firstName}</option>
                                    </c:forEach>
                                </form:select>
                            </td>
                        </tr>
                        <tr>
                            <td>Notes:</td>
                            <td>
                                <form:textarea path="notes" />
                            </td>
                        </tr>
                    </table>
                    <input type="submit" value="Save Changes" />
                </form:form>
        </body>

        </html>