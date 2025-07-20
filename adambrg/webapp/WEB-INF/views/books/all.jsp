<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Book List</title>
</head>
<body>
<h2>All Books</h2>
<a href="${pageContext.request.contextPath}/admin/books/add">Add New Book</a>
<table border="1">
    <thead>
    <tr>
        <th>ISBN</th>
        <th>Title</th>
        <th>Author</th>
        <th>Publisher</th>
        <th>Type</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${books}" var="book">
        <tr>
            <td><c:out value="${book.isbn}"/></td>
            <td><c:out value="${book.title}"/></td>
            <td><c:out value="${book.author}"/></td>
            <td><c:out value="${book.publisher}"/></td>
            <td><c:out value="${book.type}"/></td>
            <td>
                <a href="${pageContext.request.contextPath}/admin/books/view/${book.id}">View</a> |
                <a href="${pageContext.request.contextPath}/admin/books/edit/${book.id}">Edit</a> |
                <a href="${pageContext.request.contextPath}/admin/books/remove/${book.id}"
                   onclick="return confirm('Delete this book?');">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>