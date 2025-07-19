<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    String actionUrl = request.getContextPath() + (request.getAttribute("book") != null && ((pl.coderslab.model.Book) request.getAttribute("book")).getId() != null
            ? "/admin/books/edit/" + ((pl.coderslab.model.Book) request.getAttribute("book")).getId()
            : "/admin/books/add");
    request.setAttribute("actionUrl", actionUrl);
%>

<html>
<head>
    <title>
        <c:choose>
            <c:when test="${book.id == null}">Add Book</c:when>
            <c:otherwise>Edit Book</c:otherwise>
        </c:choose>
    </title>
</head>
<body>
<h1>
    <c:choose>
        <c:when test="${book.id == null}">Add Book</c:when>
        <c:otherwise>Edit Book</c:otherwise>
    </c:choose>
</h1>

<form:form method="post" modelAttribute="book" action="${actionUrl}">
    <table>
        <tr>
            <td>ISBN:</td>
            <td><form:input path="isbn" /></td>
        </tr>
        <tr>
            <td>Title:</td>
            <td><form:input path="title" /></td>
        </tr>
        <tr>
            <td>Author:</td>
            <td><form:input path="author" /></td>
        </tr>
        <tr>
            <td>Publisher:</td>
            <td><form:input path="publisher" /></td>
        </tr>
        <tr>
            <td>Type:</td>
            <td><form:input path="type" /></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Save" /></td>
        </tr>
    </table>
</form:form>

<a href="${pageContext.request.contextPath}/admin/books/all">Back to list</a>
</body>
</html>