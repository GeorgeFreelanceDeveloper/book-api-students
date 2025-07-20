<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Edit Book</title>
</head>
<body>
<h2>Edit Book</h2>

<form:form method="post" modelAttribute="book">
    <form:hidden path="id"/>

    <div>
        <form:label path="title">Title:</form:label>
        <form:input path="title"/>
        <form:errors path="title" cssClass="error"/>
    </div>

    <div>
        <form:label path="author">Author:</form:label>
        <form:input path="author"/>
        <form:errors path="author" cssClass="error"/>
    </div>

    <div>
        <form:label path="isbn">ISBN:</form:label>
        <form:input path="isbn"/>
        <form:errors path="isbn" cssClass="error"/>
    </div>

    <div>
        <form:label path="publisher">Publisher:</form:label>
        <form:input path="publisher"/>
        <form:errors path="publisher" cssClass="error"/>
    </div>

    <div>
        <form:label path="type">Type:</form:label>
        <form:input path="type"/>
        <form:errors path="type" cssClass="error"/>
    </div>

    <div>
        <button type="submit">Update</button>
    </div>
</form:form>

<a href="${pageContext.request.contextPath}/admin/books/all">Back to list</a>

</body>
</html>
