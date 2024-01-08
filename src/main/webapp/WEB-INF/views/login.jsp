<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <section>
        <form method="post" role="form" action="@{/login}">
            <div>
                <label>Email</label>
                <input type="text" id="username" name="username" placeholder="Enter Email" />
            </div>
            <div>
                <label> Password</label>
                <input type="password" id="password" name="password" placeholder="Enter Password" />
            </div>
            <div>
                <button type="submit">Submit</button>
                <span> Not registered ?
                    <a href="@{/register}">Register/Signup here</a>
                </span>
            </div>
        </form>
    </section>
</body>
</html>