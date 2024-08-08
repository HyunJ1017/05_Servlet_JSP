<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL 확인 1번</title>
</head>
<body>

  <h2>EL의 특징</h2>
  <pre>
    1. EL은 null을 빈칸("")으로 처리하고 읽어옴
      + NullpointerException을 발생시키지 않음!!

    2. get 이라는 단어를 거의 사용하지 않는다!
      + EL은 표현(출력) 언어
      -> 값을 대입하고, 조건/반복하는 구문을 작성 X
        오로지 출력!
        (출력하려면 값을 얻어와야 하는게 당연한거라 get 단어사용X)
  </pre>

  <hr>

  <h3>전달받은 파라미터 출력하기</h3>

  <pre>
    -\${param.str} : key(str) 일치하는 파라미터 얻어오기
    -\${paramValues.key} : key 일치하는 파라미터 모두 얻어오기
  </pre>
  <h4>존제하지 하는 파라미터 얻어오기</h4>
  <div>
    <table>
      <tr>
        <td>JSP 표현식으로 str 파라미터 얻어오기 : </td>
        <td> <%= request.getParameter("str") %> </td>
      </tr>
      <tr>
        <td>EL 구문으로 str 파라미터 얻어오기 : </td>
        <td>${param.str}</td>
      </tr>
    </table> 
  </div>

  <h4>존제하지 않는 파라미터 얻어오기</h4>
  <div>
    <table>
      <tr>
        <td>JSP 표현식으로 temp 파라미터 얻어오기 : </td>
        <td> <%= request.getParameter("temp") %> </td>
      </tr>
      <tr>
        <td>EL 구문으로 temp 파라미터 얻어오기 : </td>
        <td>${param.str}</td>
      </tr>
    </table> 
  </div>

  <hr>

  <h3>EL은 자료형 변환(parsing)을 자동으로 수행 해준다</h3>

  <ul>
    <%--  EL은 Java로 변환되지만
      문자열 비교는 == (비교연산자) 사용가능 --%>
    <li>\${param.str == "abc"} : ${param.str == "abc"}</li>

    <%-- HTML에서 넘어오는 데이터는 모두 String
      하지만 EL에서 연산되는 자료형이 다를 경우
      자동으로 자료형 변환(parsing) 진행해준다 --%>
    <li>\${param.intNum == 100} : ${param.intNum == 100}</li>
    <li>\${param.doubleNum == 3.14} : ${param.doubleNum == 3.14}</li>

  </ul>

  <h3>같은 key값을 지닌 parameter 얻어오기</h3>
  <ul>

  <%-- 체크가 여러개 전달된 경우 첫번째 값 출력 --%>

  <li>
    \${param.check} : ${param.check}
  </li>
  
  <%-- check라는 key를 가진 모든 값을 가져와 String[]로 반환 --%>

  <li>
    \${paramValues.check} : ${paramValues.check}
  </li>

  <li>
    \${paramValues.check[0]} : ${paramValues.check[0]}
  </li>

  <li>\${paramValues.check[0]} : ${paramValues.check[0]}</li>
  <li>\${paramValues.check[1]} : ${paramValues.check[1]}</li>
  <li>\${paramValues.check[2]} : ${paramValues.check[2]}</li>
  </ul>

  <hr>

  <h1><a href="/el/scope">Servlet/JSP 범위 별 내장 객체 + EL 사용법</a></h1>

</body>
</html>