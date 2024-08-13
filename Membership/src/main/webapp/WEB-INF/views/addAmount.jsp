<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>포인트누적</title>
  <link rel="stylesheet" href="/resources/css/base.css">
</head>
<body>
  <%-- 
  돌아가기 누를 때 session에 누른거 다 지워주기
  vs
  홈페이지 로드할때 이전꺼있으면 다지우기 - X
  vs
  받을때마다 지울까? - X
   --%>
  <h1>포인트 누적하기</h1>

  <form action="/membership/searchPhoneNum"> <%-- 번호 입력해서 검색리스트 + 등급배열 받기 --%>
    전화번호 뒷 4자리 입력
    <br>
    PH : <input type="number" name="searchPH">
    <button>검색</button>
  </form>

  <form action="/membership/addAmount/downOne" method="post"> <%-- 여기로 보낼때마다 받은 멤버검색리스트 다시 받아야함 + 선택한맴버 정보받기 --%>
    <div id="tableDiv">
      <h3>검색 결과</h3>
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
          <c:forEach items="${sessionScope.searchMembership}" var="member" varStatus="vs">
            <tr>
              <th>${vs.count}</th>

              <th>${member.name}</th>

              <th>${member.phone}</th>

              <th>${gradeArray[member.grade]}</th>  <%-- 여기 if문으로 고치기 --%>

              <th>${member.amount}원</th>

              <th><button name="phone" value="${member.phone}">선택</button></th>
            </tr>
          </c:forEach>
        </tbody>

      </table>
    </div>

  </form>


  <h1>금액 입력</h1>

  <div>
    선택된 회원 : ${selectMember.name}
    <br>
    핸재 등급 : ${gradeArray[selectMember.grade]}
    현재 포인트 : ${selectMember.amount}
  </div>

  <form action="/membership/addAmount/addOne" method = "post">
    입력금액 : <input type="number" name="addMoney">
    <button name="phone" value="${selectMember.phone}">입력</button>
  </form>

  <div id="btnDiv">
    <form action="/">
      <button name="returnBtn">돌아가기</button>
    </form>
    <button>새로고침</button>
  </div>


<c:if test="${not empty sessionScope.message}" >
  <script>
    alert("${message}");
  </script>
  <c:remove var="message" scope="session" />
</c:if>


  <%-- <c:forEach items="${todoList}" var="todo" varStatus="vs">
        <tr>
          <th>${vs.count}</th>

          <th>
             '제목' 클릭 시 인덱스 번호를 이용하여 
                todoList의 인덱스번째 요소 내용을 조회하기
                (쿼리스트링 이용 : 주소?K=V&K=V&K=V&...)
             
            <a href="/todo/detail?index=${vs.index}">${todo.title}</a>
          </th>

          <th>
            <c:if test="${todo.complete}" > O </c:if>
            <c:if test="${not todo.complete}" > X </c:if>
          </th>

          <td>${todo.regDate}</td>
        </tr>
      </c:forEach> --%>
  <script>
    document.querySelector("#returnBtn").addEventListener("click", () => {
      <c:remove var="selectMember" scope="session" />
      <c:remove var="gradeArray" scope="session" />
      <c:remove var="searchMembership" scope="session" />
    });
  </script>

</body>
</html>