const btn = document.querySelector("#signupBtn");
const pw = document.querySelector("#inputPw");
const pwCh = document.querySelector("#inputPwCheck");

pw.addEventListener("")

btn.disabled = false;


btn.addEventListener("click",()=>{
  if(document.getElementsByName("inputPw").values != document.getElementsByName("inputPwCheck").values){
    btn.disabled = true;
  }
  if(document.getElementsByName("inputPw").values == document.getElementsByName("inputPwCheck").values){
    btn.disabled = false;
  }

});