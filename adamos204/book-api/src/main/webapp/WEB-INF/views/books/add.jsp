<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
  <title>Add Book</title>
</head>
<body>

<h2>Add a new book</h2>

<form:form method="post" modelAttribute="book" action="/admin/books/add">
  <div>
    <form:label path="isbn">ISBN:</form:label>
    <form:input path="isbn" />
    <form:errors path="isbn" cssClass="error" />
  </div>

  <div>
    <form:label path="title">Title:</form:label>
    <form:input path="title" />
    <form:errors path="title" cssClass="error" />
  </div>

  <div>
    <form:label path="author">Author:</form:label>
    <form:input path="author" />
    <form:errors path="author" cssClass="error" />
  </div>
  <div>
    <form:label path="publisher">Publisher:</form:label>
    <form:input path="publisher" />
  </div>
  <div>
    <form:label path="type">Type:</form:label>
    <form:input path="type" />
  </div>
  <button type="submit">Add Book</button>
</form:form>

</body>
</html>

<style>
  .error {
    color: red;
    font-size: 0.9em;
  }
</style>
