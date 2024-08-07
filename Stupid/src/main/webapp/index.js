const btn = document.querySelector("#signupBtn");

btn.disabled = false;


btn.addEventListener("click",()=>{
  if(document.getElementsByName("inputPw").values != document.getElementsByName("inputPwCheck").values){
    btn.disabled = true;
  }
  if(document.getElementsByName("inputPw").values == document.getElementsByName("inputPwCheck").values){
    btn.disabled = false;
  }

});