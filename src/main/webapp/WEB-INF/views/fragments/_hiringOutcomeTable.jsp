<%--@elvariable id="hiredCandidateCount" type="java.lang.Long"--%>
<%--@elvariable id="rejectedCandidateCount" type="java.lang.Long"--%>
<div class="dashtable">
    <h2 class="text-2xl font-bold mb-4">Hiring Outcomes</h2>
    <table class="w-full table-auto">
        <thead>
        <tr>
            <th class="px-4 py-2">Outcome</th>
            <th class="px-4 py-2">Count</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td class="px-4 py-2">Rejected</td>
            <td class="px-4 py-2">${rejectedCandidateCount}</td>
        </tr>
        <tr>
            <td class="px-4 py-2">Hired</td>
            <td class="px-4 py-2">${hiredCandidateCount}</td>
        </tr>
        </tbody>
    </table>
</div>