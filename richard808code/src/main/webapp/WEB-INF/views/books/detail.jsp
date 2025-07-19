<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Book Detail</title>
</head>
<body>
<h1>Book Detail</h1>
<table border="1" cellpadding="5" cellspacing="0">
    <tr><th>ID</th><td>${book.id}</td></tr>
    <tr><th>ISBN</th><td>${book.isbn}</td></tr>
    <tr><th>Title</th><td>${book.title}</td></tr>
    <tr><th>Author</th><td>${book.author}</td></tr>
    <tr><th>Publisher</th><td>${book.publisher}</td></tr>
    <tr><th>Type</th><td>${book.type}</td></tr>
</table>
<a href="${pageContext.request.contextPath}/admin/books/all">Back to list</a>
</body>
</html>