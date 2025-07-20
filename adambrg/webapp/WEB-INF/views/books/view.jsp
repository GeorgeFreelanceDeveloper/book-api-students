<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>View Book</title>
</head>
<body>
<h2>Book Details</h2>
<p><strong>ISBN:</strong> <c:out value="${book.isbn}"/></p>
<p><strong>Title:</strong> <c:out value="${book.title}"/></p>
<p><strong>Author:</strong> <c:out value="${book.author}"/></p>
<p><strong>Publisher:</strong> <c:out value="${book.publisher}"/></p>
<p><strong>Type:</strong> <c:out value="${book.type}"/></p>
<p>
    <a href="${pageContext.request.contextPath}/admin/books/all">Back to list</a>
    |
    <a href="${pageContext.request.contextPath}/admin/books/edit/${book.id}">Edit</a>
    |
    <a href="${pageContext.request.contextPath}/admin/books/remove/${book.id}"
       onclick="return confirm('Delete this book?');">Delete</a>
</p>
</body>
</html>