<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>회원 검색</title>
  <link rel="stylesheet" href="/resources/css/base.css">
  <link rel="stylesheet" href="/resources/css/searchName.css">
</head>
<body>
  
  <h1>회원 검색</h1>

  <form action="/membership/searchName/search" method="post"><%-- 이름이 포함되는 회원리스트 되돌려받기 --%>
    검색할 이름 : <input type="text" name="name">
  </form>

  <div id="tableDiv">
    <table border="1"id="listTable">
    <thead>
      <th>번호</th>
      <th>회원이름</th>
      <th>회원전화번호</th>
      <th>회원등급</th>
      <th>누적포인트</th>
      <th></th>
    </thead>

    <tbody>
        <c:forEach items="${sessionScope.searchList}" var="member" varStatus="vs">
          <tr>
            <th>${vs.count}</th>

            <th>${member.name}</th>

            <th>${member.phone}</th>

            <th>${gradeArray[member.grade]}</th>

            <th>${member.amount}원</th>
            
            <th>
            <form action="/membership/updateMember" method="post"><button name="phone" value="${member.phone}">정보수정</button></form>
            <form action="/membership/deleteMember"><button name="phone" value="${member.phone}">회원탈퇴</button></form>
            </th>

          </tr>
        </c:forEach>
      </tbody>
    </table>
  </div>

  <div id="btnDiv">
  <form action="/"><button name="returnBtn">되돌아가기</button></form>
  <button>새로고침</button>
  <button>기분좋아지는버튼</button>
  </div>




  <c:if test="${not empty session.message}" >
    <script>
      alert("${message}");
    </script>
    <c:remove var="message" scope="session" />
  </c:if>


  <script>
    document.querySelector("#returnBtn").addEventListener("click", () => {
      <c:remove var="searchList" scope="session" />
      <c:remove var="gradeArray" scope="session" />
    });
  </script>

</body>
</html>