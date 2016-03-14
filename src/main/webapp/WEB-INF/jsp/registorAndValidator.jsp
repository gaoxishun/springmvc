<%--
  Created by IntelliJ IDEA.
  User: gaoxs
  Date: 2016/3/11
  Time: 15:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title></title>
</head>
<body>
  <form:form commandName="user">
    <form:errors path="*" cssStyle="color:red"></form:errors><br>
    username:<form:input path="username"></form:input>
    <form:errors path="username" cssStyle="color:red"></form:errors><br>
    password:<form:input path="password"></form:input>
    <form:errors path="password" cssStyle="color:red"></form:errors><br>
    <input type="submit" value="注册">
  </form:form>
</body>
</html>
