<%--
  Created by IntelliJ IDEA.
  User: AMIN
  Date: 8/19/2020
  Time: 5:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Management Application</title>
</head>
<body>
<center>
    <h1>User Management</h1>
    <h2>
        <a href="users?action=users">List All Users</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <tr>
            <th>Find by country:</th>
            <td>
                <input type="text" name="findByCountry"  id="findByCountry" size="45"
                       value="<c:out value="hehe" />"
                />
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="Find"/>
            </td>
        </tr>
    <table border="1" cellpadding="5">
        <caption><h2>List of Users find by country</h2></caption>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Country</th>

        </tr>
        <c:forEach var="user" items="${listUserByCountry}">
            <tr>
                <td><c:out value="${user.id}"/></td>
                <td><c:out value="${user.name}"/></td>
                <td><c:out value="${user.email}"/></td>
                <td><c:out value="${user.country}"/></td>

            </tr>
        </c:forEach>
    </table>
    </form>
</div>
</body>
</html>
