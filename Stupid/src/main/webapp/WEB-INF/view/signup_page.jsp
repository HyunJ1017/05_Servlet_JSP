<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Signup성공</title>
</head>
<body>
  
  <h1>페이지 바뀜 성공</h1>

  <hr>

  <h3>입력정보</h3>

  <table>
  <tr>
    <td>ID :</td>
    <td><p>${param.inputId}</p></td>
  </tr>
  <tr>
    <td>PW :</td>
    <td><p>${param.inputPw}</p></td>
  </tr>
  <tr>
    <td>PW Check :</td>
    <td><p>${param.inputPwCheck}</p></td>
  </tr>
  <tr>
    <td>NAME :</td>
    <td><p>${param.inputName}</p></td>
  </tr>
  <tr>
    <td>AGE :</td>
    <td><p>${param.inputAge}</p></td>
  </tr>
  </table>

  <hr>

  
</body>
</html>