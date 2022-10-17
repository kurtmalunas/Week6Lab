<%-- 
    Document   : register
    Created on : 16-Oct-2022, 6:45:36 PM
    Author     : kurtm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <form method="post" action="ShoppingList">
            Username: <input type="text" name="username" required="">
        <input type="submit" value="Register">
        <input type="hidden" name="action" value="Register">
        </form>
    </body>
</html>
