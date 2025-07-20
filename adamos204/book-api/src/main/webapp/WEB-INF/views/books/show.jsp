<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Book info</title>
</head>
<body>
    <c:if test="${book != null}">
        <h1>${book.title}</h1>
        <p><strong>ISBN: </strong>${book.isbn}</p>
        <p><strong>Author: </strong>${book.author}</p>
        <p><strong>Publisher: </strong>${book.publisher}</p>
        <p><strong>Type: </strong>${book.type}</p>
    </c:if>
    <c:if test="${book == null}">
        <h1>Book not found</h1>
    </c:if>
</body>
</html>
