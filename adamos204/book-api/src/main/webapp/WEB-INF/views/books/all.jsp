<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Book List</title>
</head>
<body>

<table border="1">
    <thead>
    <tr>
        <th>isbn</th>
        <th>title</th>
        <th>author</th>
        <th>publisher</th>
        <th>type</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${books}" var="book">
        <tr>
            <td><c:out value="${book.isbn}" /></td>
            <td><c:out value="${book.title}" /></td>
            <td><c:out value="${book.author}" /></td>
            <td><c:out value="${book.publisher}" /></td>
            <td><c:out value="${book.type}" /></td>
            <td>
                <form method="get" action="${pageContext.request.contextPath}/admin/books/edit/${book.id}" style="display:inline;">
                    <button type="submit">Edit</button>
                </form>
                <form action="${pageContext.request.contextPath}/admin/books/delete/${book.id}" method="post">
                    <button type="submit" onclick="return confirm('Do you really want to continue with this operation?');">Delete</button>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
