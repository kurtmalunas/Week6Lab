<%-- 
    Document   : shoppingList
    Created on : 16-Oct-2022, 6:45:48 PM
    Author     : kurtm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <form method="post" action="ShoppingList">
            Hello ${username} <input type="submit" value="Logout">
            <input type="hidden" name="action" value="Logout">
        </form>
            <h1>List</h1>
        <form method="post" action="ShoppingList">
            <input type="text" name="item" required>
            Add item: <input type="submit" value="Add">
            <input type="hidden" name="action" value="Add">
        </form>
            <form method="post" action="ShoppingList">
             <c:forEach items="${items}" var="item">
                <li><input type="radio" name="item" value="${item}">${item}</li>
             </c:forEach>
                <input type="submit" value="Delete">
            <input type="hidden" name="action" value="Delete">
            </form>
    </body>
</html>
