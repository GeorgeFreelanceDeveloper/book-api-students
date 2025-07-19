<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Book List</title>
</head>
<body>

<h2>Book List</h2>

<p><a href="${pageContext.request.contextPath}/admin/books/add">Add a new book</a></p>

<table border="1">
    <thead>
    <tr>
        <th>ISBN</th>
        <th>Title</th>
        <th>Author</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${books}" var="book">
        <tr>
            <td><c:out value="${book.isbn}"/></td>
            <td><a href="${pageContext.request.contextPath}/admin/books/${book.id}"><c:out value="${book.title}"/></a></td>
            <td><c:out value="${book.author}"/></td>
            <td>
                <a href="${pageContext.request.contextPath}/admin/books/edit/${book.id}">Edit</a> |
                <a href="${pageContext.request.contextPath}/admin/books/delete/${book.id}" onclick="return confirm('Are you sure?')">Delete</a> |
                <a href="${pageContext.request.contextPath}/admin/books/${book.id}">View</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>