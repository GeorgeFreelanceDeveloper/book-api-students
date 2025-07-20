<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit Book</title>
</head>
<body>
<h2>Edit Book</h2>
<form:form method="post" modelAttribute="book" action="${pageContext.request.contextPath}${form}${book.id}">
    <form:hidden path="id"/>
    <form:input path="isbn"/>
    <form:errors path="isbn" cssStyle="color: red"/><br/>
    <form:input path="title"/>
    <form:errors path="title" cssStyle="color: red"/><br/>
    <form:input path="author"/>
    <form:errors path="author" cssStyle="color: red"/><br/>
    <form:input path="publisher"/>
    <form:errors path="publisher" cssStyle="color: red"/><br/>
    <form:input path="type"/>
    <form:errors path="type" cssStyle="color: red"/><br/>
    <input type="submit" value="Save">
</form:form>
</body>
</html>
