<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>멤버쉽관리</title>
</head>
<body>
  
  <h1>멤버들관리프로그램</h1>

  <div>
  <h3>한눈에보기</h3>
  <pre>
  총 회원수 : ${count}명
  금 : ${gold}명, 은 : ${silver}명, 동 : ${bronz}명, 일반 : ${nomal}명
  누적 판매금 : ${amount} 원
  </pre>
  </div>

  <hr><hr>

  <h3>회원관리 목록</h3>

  <ol>
  <li><a href="#">전체회원보기</a></li>
  <li><a href="#">회원 검색하기</a></li><%-- 이름으로 검색 후 삭제, 수정 --%>
  <li><a href="#">회원정보 수정하기</a></li><%-- 한 페이지에서 이름 검색,목록 띄워주면 선택하고 등등... --%>
  <li><a href="/membership/addAmount">사용금액입력하기</a></li><%-- 전화번호 뒷자리로 검색하고? 금액추가하기 --%>
  </ol>





  <h3>회원가입</h3>

  <form action="/membership/addMember" method="post">
    이름 : <input type="text" name="name">
    <br>
    P/H  : <input type="number" name="phone" value="010">

  <button>추가</button>
  </form>

  <c:if test="${not empty sessionScope.message}" >
    <script>
      alert("${message}");
    </script>

    <c:remove var="message" scope="session" />
  </c:if>

</body>
</html>