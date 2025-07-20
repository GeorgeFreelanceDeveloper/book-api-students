<%--
  Created by IntelliJ IDEA.
  User: sehes
  Date: 7/15/2025
  Time: 2:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Book</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/table.css">
</head>
<body>
<h1>Book:</h1>
<%--@elvariable id="book" type="cz.kocabek.bookapispringbootmysql.model.Book"--%>
<ul>
    <li> Tile: ${book.title}</li>
    <li>ISBN: ${book.isbn}</li>
    <li> Author: ${book.author}</li>
    <li>Publisher: ${book.publisher}</li>
    <li>Type: ${book.type}</li>
</ul>
<a href="${pageContext.request.contextPath}/books" class="btn">Back</a>
</body>
</html>
