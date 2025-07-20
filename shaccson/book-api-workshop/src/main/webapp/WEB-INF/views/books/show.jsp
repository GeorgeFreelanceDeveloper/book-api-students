<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Book Details</title>
</head>
<body>
<table border="1">
    <tr><th>ISBN</th><td><c:out value="${book.isbn}"/></td></tr>
    <tr><th>Title</th><td><c:out value="${book.title}"/></td></tr>
    <tr><th>Author</th><td><c:out value="${book.author}"/></td></tr>
    <tr><th>Publisher</th><td><c:out value="${book.publisher}"/></td></tr>
    <tr><th>Type</th><td><c:out value="${book.type}"/></td></tr>
</table>
<a href="<c:url value='/admin/books/all'/>">Back to list</a>
</body>
</html>
