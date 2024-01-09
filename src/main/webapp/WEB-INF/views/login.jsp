<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Hire.me login</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <link href="/pub/css/main.css" rel="stylesheet">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Lemon&display=swap" rel="stylesheet">
</head>

<body>
    <section>
        <form action="${pageContext.request.contextPath}/login" method="post">
            <!-- Username field -->
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required><br><br>

            <!-- Password field -->
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required><br><br>

            <!-- Submit button for the form -->
            <input type="submit" value="Login">
            <p>
                don't have an account? register here. <a class="register-button" href="${pageContext.request.contextPath}/register">register</a>
            </p>
        </form>
    </section>
</body>

</html>