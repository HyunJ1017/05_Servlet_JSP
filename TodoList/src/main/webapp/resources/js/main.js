/* 제목이 작성되지 않은경우 #addForm의 제출 막기*/

const addForm = document.querySelector("#addForm");
const title = document.querySelector("[name=title]");

// addForm이 제출될려고 할때
addForm.addEventListener("submit", e=>{
  // e: 이벤트객체

  // 제목 입력값 가져와서 양쪽 입력값 제외
  const input = title.value.trim();

  if(input.length === 0){ //제목이 입력되지 않았을때
    e.preventDefault(); // form 제출 이벤트 막기
    alert("제목을 입력 해 주세요");
    title.focus();
  }

})