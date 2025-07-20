<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book Details</title>
</head>
<body>
<h2>Book Details</h2>
<table border="1">
    <thead>
        <th>isbn</th>
        <th>title</th>
        <th>author</th>
        <th>publisher</th>
        <th>type</th>
    </thead>
    <tbody>
        <tr>
            <td>${book.isbn}</td>
            <td>${book.title}</td>
            <td>${book.author}</td>
            <td>${book.publisher}</td>
            <td>${book.type}</td>
        <tr>
    <tbody>
</table>
<a href="${pageContext.request.contextPath}/admin/books/all">Go Back</a>
</body>
</html>
