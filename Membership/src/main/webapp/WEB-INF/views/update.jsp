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

  <form action="/membership/updateMember" method="post">
  회원 전화번호 입력 : <input type="number" name="phone">
  <button>입력</button>
  </form>
  <br>
  <hr>
  <form action="/">
    <button>돌아가기</button>
  </form>

</body>
</html>