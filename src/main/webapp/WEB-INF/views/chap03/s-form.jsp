<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Web Study</title>
</head>
<body>

<h1>로그인 화면</h1>
<form action="/hw/s-login-check" method="post">
    <input type="text" name="id" placeholder="ID"><br>
    <input type="password" name="pw" placeholder="PASSWORD"><br>
    <button type="submit"> 로그인 </button>
</form>

</body>
</html>