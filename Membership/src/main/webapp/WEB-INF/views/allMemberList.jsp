<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>회원 리스트</title>
  <link rel="stylesheet" href="/resources/css/base.css">
  <link rel="stylesheet" href="/resources/css/allMemberList.css">
</head>
<body>
  
  <h1>회원 전체 리스트</h1>
  <hr>

  <div id="btnDiv">
    <form action="/">
      <button>돌아가기</button>
    </form>
    <button>새로고침</button>
    <button>기분좋아지는버튼</button>
  </div>

  <div id="tableDiv">
    <table border="1" id="listTable">
      <thead>
        <th>번호</th>
        <th>회원이름</th>
        <th>회원전화번호</th>
        <th>회원등급</th>
        <th>누적포인트</th>
        <th></th>
      </thead>

      <tbody>
        <c:forEach items="${requestScope.memberList}" var="member" varStatus="vs">
          <tr>
            <th>${vs.count}</th>

            <th>${member.name}</th>

            <th>${member.phone}</th>

            <th>${gradeArray[member.grade]}</th>  <%-- 여기 if문으로 고치기 --%>

            <th>${member.amount}원</th>

            <th class="tableBtn">

            <form action="/membership/addAmount/downOne" method="post">
            <button name="phone" value="${member.phone}">포인트입력</button></form>

            <form action="/membership/updateMember" method="post">
            <button name="phone" value="${member.phone}">정보수정</button></form>

            <form action="/membership/deleteMember">
            <button name="phone" value="${member.phone}">회원탈퇴</button></form>
            </th>

          </tr>
        </c:forEach>
      </tbody>

    </table>
  </div>


</body>
</html>