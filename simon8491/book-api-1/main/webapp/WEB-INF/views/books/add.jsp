<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add book</title>
</head>
<body>
<h2>New Book</h2>
<form:form method="post" modelAttribute="book" action="${pageContext.request.contextPath}${form}">
    ISBN: <form:input path="isbn"/>
    <form:errors path="isbn" cssStyle="color: red"/><br/>
    Title: <form:input path="title"/>
    <form:errors path="title" cssStyle="color: red"/><br/>
    Author: <form:input path="author"/>
    <form:errors path="author" cssStyle="color: red"/><br/>
    Publisher: <form:input path="publisher"/>
    <form:errors path="publisher" cssStyle="color: red"/><br/>
    Type: <form:input path="type"/>
    <form:errors path="type" cssStyle="color: red"/><br/>
    <input type="submit" value="Add"/>
</form:form>
</body>
</html>
