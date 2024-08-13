<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>html문서 제목</title>
  <link rel="stylesheet" href="/resources/css/base.css">
</head>
<body>
  
  <h1>회원정보 수정하기</h1>

  <form action="/membership/update" method="post">
  <div>
  <h4>회원이름 : <input type="text" name="name" value="${member.name}"></h4>
  <h4>전화번호 : <input type="text" name="phone" value="${member.phone}"></h4>
  </div>
  <button name="beforePhone" value="${member.phone}">수정하기</button>
  </form>

  <hr>

  <form action="/">
    <button>돌아가기</button>
  </form>

  <%-- 
    전화번호 입력받고 일치하면
    수정할 회원 개인정보띄우고 수정할 페이지로 더넘기자
    여기가 떠넘겨지는 페이지
   --%>
</body>
</html>