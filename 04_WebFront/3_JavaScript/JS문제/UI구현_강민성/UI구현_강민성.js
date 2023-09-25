const inputId = document.getElementById("input-id");
const inputPw = document.getElementById("input-pw");
const inputPwCh = document.getElementById("input-pw-ch");
const inputEm = document.getElementById("input-em");
const inputEm2 = document.getElementById("input-em2");
const inputAd = document.getElementById("input-ad");
const inputAd2 = document.getElementById("input-ad2");
const jsId = document.getElementById("js-id");
const jsPw = document.getElementById("js-pw");
const jsPwCh = document.getElementById("js-pw-ch");

// 비밀번호 포커스
inputPw.addEventListener("focus", () => {
  const regExp = /^[a-zA-Z\d\!\@\#\$\%\^\&\*]{8,32}$/
  const value = inputPw.value.trim();
  jsPw.innerHTML = "영문자 대/소문자 특수문자, 숫자 포함 8 ~ 32자";

  // 유효성 검사 실패
  if(!regExp.test(inputPw.value)){
    jsPw.classList.add("error");
    jsPw.classList.remove("check");
  }

  // 유효성 검사 성공
  else{
    jsPw.classList.remove("error");
    jsPw.classList.add("check");
  }

  if (inputId.value.trim().length == 0){
    jsId.innerHTML = "필수 입력 항목 입니다";
  }
});

// 비밀번호 입력시
inputPw.addEventListener("input", () => {
  const regExp = /^[a-zA-Z\d\!\@\#\$\%\^\&\*]{8,32}$/
  jsPw.innerHTML = "영문자 대/소문자 특수문자, 숫자 포함 8 ~ 32자";

  if(!regExp.test(inputPw.value)){
    jsPw.classList.add("error");
    jsPw.classList.remove("check");
  }
  else{
    jsPw.classList.remove("error");
    jsPw.classList.add("check");
  }

});

inputPw.addEventListener("blur", () => {
  idPwOff();
  jsPw.classList.remove("error");
  jsPw.classList.remove("check");
});

inputPwCh.addEventListener("focus", () => {
  idPwOn();
});

inputPwCh.addEventListener("blur", () => {
  idPwOff();
});

inputAd.addEventListener("focus", () => {
  idPwOn();
});

inputAd.addEventListener("blur", () => {
  idPwOff();
});

inputAd2.addEventListener("focus", () => {
  idPwOn();
});

inputAd2.addEventListener("blur", () => {
  idPwOff();
});

inputEm.addEventListener("focus", () => {
  idPwOn();
});

inputEm.addEventListener("blur", () => {
  idPwOff();
});

inputEm2.addEventListener("focus", () => {
  idPwOn();
});

inputEm2.addEventListener("blur", () => {
  idPwOff();
});

// 텍스트 출력
function idPwOn(){
  if (inputId.value.trim().length == 0){
    jsId.innerHTML = "필수 입력 항목 입니다";
  }

  if (inputPw.value.trim().length == 0){
    jsPw.innerHTML = "필수 입력 항목 입니다";
  }
}

// 텍스트 삭제
function idPwOff(){
  jsPw.innerHTML = "";  
  jsId.innerHTML = "";
}