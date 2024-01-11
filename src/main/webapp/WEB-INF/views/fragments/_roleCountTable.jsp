<div class="dashtable">
    <h2 class="text-2xl font-bold mb-4">Employee Role Distribution</h2>
    <table class="w-full table-auto">
        <thead>
        <tr>
            <th class="px-4 py-2">Role</th>
            <th class="px-4 py-2">Count</th>
        </tr>
        </thead>
        <tbody>
        <%--@elvariable id="roleCounts" type="java.util.List"--%>
        <c:forEach var="roleCount" items="${roleCounts}">
            <tr>
                <td class="px-4 py-2">${roleCount.key}</td>
                <td class="px-4 py-2">${roleCount.value}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
