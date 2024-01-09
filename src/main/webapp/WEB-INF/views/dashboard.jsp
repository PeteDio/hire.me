<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Hire.me landing page</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <link href="/pub/css/normalize.css" rel="stylesheet">
    <link href="/pub/css/main.css" rel="stylesheet">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Lemon&display=swap" rel="stylesheet">
</head>

<body>
    <jsp:include page="fragments/_header.jsp" />

    <main class="container flex w-screen">
        <section class="flex items center p-6">
            <jsp:include page="fragments/_hiringOutcomeTable.jsp" />
            <jsp:include page="fragments/_completedInterviewsTable.jsp" />
            <jsp:include page="fragments/_candidateStatusTable.jsp" />
            <jsp:include page="fragments/_roleCountTable.jsp" />
        </section>
    </main>
</body>

</html>