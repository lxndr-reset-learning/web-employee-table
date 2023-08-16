<%@ page import="com.reset.spring.mvc_hibernate_aop.entity.Employee, java.util.List, java.util.Collection" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: lxndr
  Date: 8/15/2023
  Time: 6:16 PM
  To change this template use File | Settings | File Templates.

--%>
<html lang="en">
<head>
    <title>All Employees</title>
</head>
<body>

<table>
    <tr>
        <th>Name</th>
        <th>Surname</th>
        <th>Department</th>
        <th>Salary</th>
        <th>Operations</th>
    </tr>

    <%
        List<Employee> empList = List.copyOf((List<Employee>) request.getAttribute("allEmps"));
        for (Employee emp : empList) {
    %>
    <tr>
        <td><%= emp.getName() %>
        </td>
        <td><%= emp.getSurname() %>
        </td>
        <td><%= emp.getDepartment() %>
        </td>
        <td><%= emp.getSalary() %>
        </td>

        <%String updateURL = request.getContextPath() + "/updateInfo?empId=" + emp.getId();%>
        <%String deleteURL = request.getContextPath() + "/deleteEmployee?empId=" + emp.getId();%>
        <!--request - один из аргументов, которые передаются в любой jsp автоматически-->

        <td>
            <input type="button" onclick="window.location.href='<%=updateURL%>'" value="update">
            <input type="button" onclick="window.location.href='<%=deleteURL%>'" value="delete">
        </td>
    </tr>
    <%
        }
    %>

</table>

<br>
<br>
<input type="button" value="add"
       onclick="window.location.href='/addNewEmployee'"/>
<!--Переходим по данному пути-->
</body>
</html>