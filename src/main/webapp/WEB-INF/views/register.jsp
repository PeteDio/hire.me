<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <title>Hire.me register page</title>
        <script src="https://cdn.tailwindcss.com"></script>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Lemon&display=swap" rel="stylesheet">
        <link href="/pub/css/main.css" rel="stylesheet">
    </head>

    <body>
    <header class="bg-gray-800 text-white py-4 px-6 flex items-center justify-between">
        <h1 class="text-2xl font-bold">Hire.me</h1>
        <nav>
            <a href="/" class="text-white hover:text-blue-500 ml-4">Home</a>
        </nav>
    </header>
        <div class="container mx-auto p-4">
            <h1 class="text-3xl font-bold mb-4">Register</h1>
            <form action="/register/save" method="post">
                <div class="mb-4">
                    <label for="email" class="block text-gray-700 font-bold mb-2">Email</label>
                    <input type="email" id="email" name="email"
                        class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
                        required>
                </div>
                <div class="mb-4">
                    <label for="firstName" class="block text-gray-700 font-bold mb-2">First Name</label>
                    <input type="text" id="firstName" name="firstName"
                        class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
                        required>
                </div>
                <div class="mb-4">
                    <label for="lastName" class="block text-gray-700 font-bold mb-2">Last Name</label>
                    <input type="text" id="lastName" name="lastName"
                        class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
                        required>
                </div>
                <div class="mb-6">
                    <label for="password" class="block text-gray-700 font-bold mb-2">Password</label>
                    <input type="password" id="password" name="password"
                        class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
                        required>
                </div>
                <button type="submit" style="background-color: #EDF67D; color: #564592"
                    class="font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline">Register</button>
            </form>

        </div>

    </body>

    </html>