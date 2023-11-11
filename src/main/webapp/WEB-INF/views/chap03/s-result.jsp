<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>로그인 테스트</title>
</head>
<body>
<h1 class="Check-title">
<c:if test="${c eq '1'}">
    <h1>로그인 성공입니다!</h1>
</c:if>
<c:if test="${c eq '2'}">
    <h1>일치하지 않는 비밀번호 입니다.</h1>
</c:if>
<c:if test="${c eq '0'}">
    <h1>존재하지 않는 회원정보 입니다.</h1>
</c:if>
</h1>
<a href="/hw/s-login-form">다시 로그인하기</a>



<%--<script>--%>
<%--    let Check = '${Check}';--%>
<%--    console.log(Check);--%>

<%--    const $h1 = document.querySelector('.Check-title');--%>
<%--    switch (Check) {--%>
<%--        case '0':--%>
<%--            $h1.textContent = '아이디가 존재하지 않습니다.';--%>
<%--            break;--%>
<%--        case '2':--%>
<%--            $h1.textContent = '비밀번호가 틀렸습니다.';--%>
<%--            break;--%>
<%--        case '1':--%>
<%--            $h1.textContent = '로그인 성공.';--%>
<%--            break;--%>
<%--    }--%>
<%--</script>--%>

</body>
</html>