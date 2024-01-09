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
    <section class="container mx-auto p-4 bg-white rounded-lg shadow-md">
        <form action="/login" method="post" class="flex flex-col space-y-4">
            <div class="mb-4">
                <label for="username" class="block text-gray-700 font-bold mb-2">Username:</label>
                <input type="text" id="username" name="username"
                    class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
                    required>
            </div>
            <div class="mb-6">
                <label for="password" class="block text-gray-700 font-bold mb-2">Password:</label>
                <input type="password" id="password" name="password"
                    class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
                    required>
            </div>
            <div class="flex items-center justify-between">
                <button type="submit"
                    class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline">Login</button>
                <p class="text-gray-600">Don't have an account? Register here. <a href="/register"
                        class="underline text-blue-500 hover:text-blue-700">Register</a>
                </p>
            </div>
        </form>
    </section>
</body>

</html>