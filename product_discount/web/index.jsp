<%--
  Created by IntelliJ IDEA.
  User: AMIN
  Date: 8/17/2020
  Time: 8:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Product Discount Calculator</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
  </head>
  <body>
  <h2>Discount Calculator</h2>
  <form action="/calculator" method="post">
    <input type="text" name="txtDescription" placeholder="Enter product's description: "/><br>
    <input type="text" name="txtPrice" placeholder="Enter product's price: "/><br>
    <input type="text" name="txtPercent" placeholder="Enter discount percent: "/><br>
    <input type = "submit" id = "submit" value = "Calculator"/>
  </form>
  </body>
</html>
