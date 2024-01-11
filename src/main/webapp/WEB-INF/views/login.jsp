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
    <header class="py-4 px-6 flex flex-col items-center justify-between">
        <a class="text-4xl font-bold items-center" href="/">Hire.me</a>
    </header>
    <h1 class="text-3xl font-bold mb-4 text-center">Login</h1>
    <section class="container mx-auto p-4 flex items-center w-2/5 shadow-sm m-6 p-6">
        <form action="/login" method="post" class="colorpurple flex flex-col w-full items-center p-6">
            <div class="mb-4">
                <label for="username" class="block text-white font-bold mb-2">Username:</label>
                <input type="text" id="username" name="username"
                    class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
                    required>
            </div>
            <div class="mb-6">
                <label for="password" class="block text-white font-bold mb-2">Password:</label>
                <input type="password" id="password" name="password"
                    class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
                    required>
            </div>
            <div class="flex items-center justify-between">
                <button type="submit" style="background-color: #EDF67D; color: #564592"
                    class="font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline">Login</button>
                <p class="text-white">Don't have an account? Register here. <a href="/register"
                        class="underline hover:text-blue-700">Register</a>
                </p>
            </div>
        </form>
    </section>
</body>

</html>