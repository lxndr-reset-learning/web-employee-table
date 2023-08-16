<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: lxndr
  Date: 8/16/2023
  Time: 6:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Employee</title>
</head>


<body>
<h2>Employee Info</h2>
<form:form action="saveEmployee" modelAttribute="employee">
<%--saveEmployee - путь, по которому мы перейдём после того как нажмём Submit--%>

    Name <form:input path="name"/>
    <br>
    Surname <form:input path="surname"/>
    <br>
    Department <form:input path="department"/>
    <br>
    Salary <form:input path="salary"/>
    <br>
    <br>
    <input type="submit" value="submit"/>


</form:form>
</body>
</html>
