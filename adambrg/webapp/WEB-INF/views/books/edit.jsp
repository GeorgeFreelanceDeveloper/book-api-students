<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Edit Book</title>
</head>
<body>
<h2>Edit Book</h2>
<form:form modelAttribute="book"
           method="post"
           action="${pageContext.request.contextPath}/admin/books/edit">

    <form:hidden path="id"/>

    <table>
        <tr>
            <td><form:label path="isbn">ISBN:</form:label></td>
            <td><form:input path="isbn"/></td>
        </tr>
        <tr>
            <td><form:label path="title">Title:</form:label></td>
            <td><form:input path="title"/></td>
        </tr>
        <tr>
            <td><form:label path="author">Author:</form:label></td>
            <td><form:input path="author"/></td>
        </tr>
        <tr>
            <td><form:label path="publisher">Publisher:</form:label></td>
            <td><form:input path="publisher"/></td>
        </tr>
        <tr>
            <td><form:label path="type">Type:</form:label></td>
            <td><form:input path="type"/></td>
        </tr>
    </table>

    <p>
        <input type="submit" value="Update Book"/>
        <a href="${pageContext.request.contextPath}/admin/books/all">Cancel</a>
    </p>
</form:form>
</body>
</html>