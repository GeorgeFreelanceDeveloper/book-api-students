<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Add Book</title>
</head>
<body>
<h2>Add a Book</h2>

<form:form method="post"
           modelAttribute="book"
           action="${pageContext.request.contextPath}/admin/books/add">

    <table>
        <tr>
            <td><label for="isbn">ISBN:</label></td>
            <td><form:input path="isbn" id="isbn"/></td>
        </tr>
        <tr>
            <td><label for="title">Title:</label></td>
            <td><form:input path="title" id="title"/></td>
        </tr>
        <tr>
            <td><label for="author">Author:</label></td>
            <td><form:input path="author" id="author"/></td>
        </tr>
        <tr>
            <td><label for="publisher">Publisher:</label></td>
            <td><form:input path="publisher" id="publisher"/></td>
        </tr>
        <tr>
            <td><label for="type">Type:</label></td>
            <td><form:input path="type" id="type"/></td>
        </tr>
    </table>

    <p>
        <input type="submit" value="Add Book"/>
        <a href="${pageContext.request.contextPath}/admin/books/all">Cancel</a>
    </p>
</form:form>
</body>
</html>
