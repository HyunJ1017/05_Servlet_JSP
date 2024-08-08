<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>EL/JSTL 기초연습</title>
</head>
<body>
  <pre>
    브라우저 주소창에 서버 컴퓨터 주소(ip:portNum, ex : localhost:8080) 만 작성하면
    
    index.jsp가 변환된 index_jsp.class 파일로 요청이 매핑
    -> 클라이언트에게 index.jsp 코드가 그대로 출력됨

    [ index.html과 index.jsp의 차이점 ]

    - html : html,css,js코드 작성 가능
             + 정적 페이지(미리 만들어진 형태 그대로)

    - jsp  : html, css, js, java, el, jstl 작성 가능
             + 동적 페이지(요청에 따라 응답 화면 변형 가능)
  </pre>

<hr>

<h1>EL (Expression Language, 표현언어)</h1>

<pre>
   (간단히 정의)
   - JSP에서 Java 코드값을 쉽게 출력하는 언어표기법
    \${key} 형태로 작성
</pre>

<%-- form태그 method 기본값은 GET --%>
<form action="/el/test1" method="get">
  <table>
    <tr>
      <td>문자열 입력 :</td>
      <td><input type="text" name="str"></td>
    </tr>
    <tr>
      <td>정수  입력 :</td>
      <td><input type="number" name="intNum"></td>
    </tr>
    <tr>
      <td>실수  입력 :</td>
      <td><input type="number" name="doubleNum"></td>
    </tr>
  </table>

  <div>
  A <input type="checkBox" name="check" value="A"> 
  B <input type="checkBox" name="check" value="B"> 
  C <input type="checkBox" name="check" value="C"> 
  </div>

    <button>제출하기</button>
</form>



</body>
</html>