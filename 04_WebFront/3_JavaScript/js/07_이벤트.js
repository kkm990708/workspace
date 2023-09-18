function inlineEventModel(btn){
  console.log(btn); // 클릭이벤트가 발생한 요소(버튼)
  console.log(btn.style.backgroundColor); // 클릭한 요소의 배경색 얻어오기
  if(btn.style.backgroundColor != "skyblue"){
  btn.style.backgroundColor = "skyblue";
  }else{
    btn.removeAttribute("style");
  }
}

/* 고전 이벤트 모델 */
// 아이다가 test2-1인 요소를 선택해변수에 저장
const a = document.getElementById("test2-1");
// 요소.이벤트리스너 = 이벤트 핸들러
a.onclick = function(){
  // function(){} : 익명 함수(이벤트 핸들러로 많이 사용)
  alert("test2-1클릭")
  
}

// 이벤트 제거
// #test2-2 클릭 시 #test2-1의 클릭 이벤트 제거
const b = document.querySelector("#test2-2");
b.onclick = function(){
 // a == #test2-1

 // #test2-1의 onclick 속성에 null을 대입해서 덮어쓰기
 a.onclick = null;  
  
 alert("#test2-1 이벤트 제거")
}

// 고전 이벤트 모델 단점
// -> 한 요소의 같은 이벤트 리스너에
//    여러 이벤트 핸들러를 대입할 수 없다

const c = document.querySelector("#test2-3");
// #test2-3 클릭 시 버튼의 배경색을 yellow로 변경
c.onclick = function(){
  c.style.backgroundColor = "yellow";
  // alert("test2-3 클릭")
}

// #test2-3 클릭 시 버튼의 글자 크기를 30px로 변경
c.onclick = function(){
  c.style.fontSize = "30px";
}


// ----------------------------------------------------------------

/* ***** 표준 이벤트 모델 ***** */
/* [작성법] 
  요소.addEventListener("click", function(){});
                        이벤트명 이벤트 핸들러
*/

// 아이디가 test3 인 요소에 click 했을 때 동작을 추가
document.getElementById("test3").addEventListener("click", function(){
  // 클릭된 요소의 너비가 10px 증가

  // 고전/표준 이벤트 핸들러 내부에서 this : 이벤트가 발생한 요소
  console.log(this);

  // 요소.clientWidth : 요소의 너비(테두리 제외)
  // -> css/style 속성으로 지정된 너브를 얻어올 때 사용
  console.log(this.clientWidth);

  // 요소.style.width : 요소의 style 속성 중 width의 값을 얻어옴
  // -> 요소 자체에 작성된 style 속성의 값을 얻어올 때 사용
  console.log(this.style.width);

  this.style.width = this.clientWidth + 10 + "px";
});

// #test3 요소에 click 이벤트 리스너를 추가
document.getElementById("test3").addEventListener("click", function(e){
  // 이벤트 핸들러 매개 변수 e 또는 event
  // -> 이벤트 객체(이벤트 관련 정보가 담긴 객체)가 전달됨

  // e.target : 이벤트가 발생한 요소

  console.log(e);
  console.log(e.target);

  // 현재 요소의 높이를 변경
  e.target.style.height = e.target.clientHeight + 10 + "px";
});

const btn4 = document.getElementById("btn4");
const input4 = document.getElementById("input4");
const box4 = document.getElementById("box4");

btn4.addEventListener("click", function(e) {
  box4.style.backgroundColor = input4.value;
});

// input 태그에서 엔터 입력 시 배경색 변경
input4.addEventListener('keyup', function(e) {
  // e : 이벤트 객체
  
  if(e.key == "Enter"){
    box4.style.backgroundColor = e.target.value;
  }
});


document.getElementById('move').addEventListener("click", function(e){

  // e : 이벤트 객체
  // prevent : 하지 못하게 막다
  // defualt : 기본

  e.preventDefault(); // HTML의 기본 이벤트 요소 막음

})

/* form 태그 기본 이벤트 제거 */
// 방법 1. e.preventDefault()
// document.getElementById("login").addEventListener("submit", function(e){

//   alert("제출");

//   e.preventDefault();
// });

// 방법 2. 인라인 이벤트 모델 onsubmit
function testFn(){
  const id = document.getElementById("input-id");
  const pw = document.getElementById("input-pw");

  // 아이디 또는 비밀번호를 입력하지 않았을 때
  if(id.value.trim().length == 0 || pw.value.trim().length == 0){
  
    return false;
  };
  return true;
}

// 방법3 : 일반 버튼 클릭으로 제출 막음

const loginBtn2 = document.querySelector("#login-btn2");

// #login-btn2 버튼이 클릭되었을 때
loginBtn2.addEventListener("click", function(){
  const id = document.getElementById("input-id");
  const pw = document.getElementById("input-pw");

  // 아이디, 비밀번호 둘다 입력했을 때
  if(id.value.trim().length != 0 && pw.value.trim().length != 0){


    // document.form 태그 name 속성 == 해당 form 요소 선택
    // form요소.submit() :form 제출
    // 문서 내에서 name 속성 값이 loginForm인 form 태그를 제출 시킴
    document.loginForm.submit();
  };
})


const createBtn = document.getElementById("create-btn");
const list = document.getElementById("list");
const inputValue = document.getElementById("count-input");

// 입력칸 생성 함수
function createList(){
  if(inputValue.value >= 1 && inputValue.value <= 10){

    let htmlTemp = ""; // html 코드 저장용 임시변수
    for (let index = 0; index < inputValue.value; index++) {
      htmlTemp += "<li><input type=number class=list-input></li>";
    }
    list.innerHTML = htmlTemp;
    
  }else{
    alert("1~10 사이의 숫자를 입력해주세요")
  }
  document.body.scrollIntoView(false);
}


// 입력칸 생성하기
createBtn.addEventListener("click", function(e){
  createList();
});


// 엔터 입력시 빈칸 생성
const countInput = document.getElementById("count-input");
countInput.addEventListener("keyup", function(e){
  if(e.key == "Enter"){
    createList();
  }
});



const calc = document.getElementById("calc");
const calcResult = document.getElementById("calc-result");

// 계산하기 클릭시 다 더하기
calc.addEventListener("click", function(){
  const listNumber = document.querySelectorAll(".list-input");
   let result = 0;

   for (let index = 0; index < listNumber.length; index++) {
    // 아무것도 입력되지 않은 input이 있으면
    if(listNumber[index].value == ""){
      alert("빈칸을 다 채워주세요")
      listNumber[index].focus();
      return;
    }
    result += Number(listNumber[index].value);
   }
   let avg = result / listNumber.length;
   calcResult.innerHTML = "합계 : " + result + " / 평균 : " + avg; 
});


// 숫자 입력할 때 마다 숫자 더하기
list.addEventListener("keyup",function(e){
  const listNumber = document.querySelectorAll(".list-input");

  let result = 0;
  for (let index = 0; index < listNumber.length; index++) {
    result += Number(listNumber[index].value);
   }
   let avg = result / listNumber.length;
   calcResult.innerHTML = "합계 : " + result + " / 평균 : " + avg; ; 
});