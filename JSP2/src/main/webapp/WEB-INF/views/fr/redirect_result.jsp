<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>redirect 결과페이지</title>
</head>
<body>
  <h3>/fr/redirect 요청시 재요청되어 보여지는 페이지</h3>

  <h3 id="print"> </h3>
  <p>-> /redirect로 요청했는데 /result가 답해줌</p>

  <hr>

  <h3>request cope로 전달된 값이 존재하는지 확인</h3>
  <ul>
    <li>redirectInput1 : ${param.redirectInput1}</li>
    <li>redirectInput2 : ${param.redirectInput2}</li>
    <li>str : ${str}</li>
    <li>param, request scope 둘다 못넘어옴</li>
  </ul>

  <h3>session scope로 전달된 값 : ${sessionNum}</h3>
  <p>session은 만료되거나 브라우저 꺼질때까지 남아있어서 존재함</p>
  

  <script>
  // id가 print인 요소에 내부내용으로
  // 현재페이지의 주소를 대입
    document.querySelector("#print").innerText = location.pathname;
  </script>
</body>
</html>