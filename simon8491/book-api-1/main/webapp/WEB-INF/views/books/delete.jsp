<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Confirm Delete</title>
</head>
<body>
<h2>Confirm Delete</h2>

<p>You are about to delete this book.</p>
<p>Title: ${book.title}</p>

<form action="${pageContext.request.contextPath}/admin/books/delete/${book.id}" method="post">
    <input type="submit" value="Delete">
</form>

<a href="${pageContext.request.contextPath}/admin/books/all">Cancel</a>

</body>
</html>
