<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Edit Book</title>
</head>
<body>
<h2>Edit Book</h2>

<form:form method="post"
           action="${pageContext.request.contextPath}/admin/books/edit"
           modelAttribute="book">
    <form:hidden path="id"/>
    ISBN:      <form:input path="isbn"/><form:errors path="isbn"/><br/>
    Title:     <form:input path="title"/><form:errors path="title"/><br/>
    Author:    <form:input path="author"/><form:errors path="author"/><br/>
    Publisher: <form:input path="publisher"/><form:errors path="publisher"/><br/>
    Type:      <form:input path="type"/><form:errors path="type"/><br/>
    <input type="submit" value="Save"/>
</form:form>

<a href="<c:url value='/admin/books/all'/>">Back to list</a>
</body>
</html>
