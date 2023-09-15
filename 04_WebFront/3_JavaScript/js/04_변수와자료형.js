// script 태그 또는 js 파일에
// 함수 내부가 아닌 위치에 코드를 작성하면
// HTML 랜더링 시 바로 수행

// 전역변수
var str = "html 랜더링 시 바로 실행" // 전역변수
num1 = 100; // 전역 변수
num2 = 200; // 전역 변수
console.log("num1(전) : " + num1);
console.log("num2(전) : " + num2);
function testFn() {
  var num3 = 300; // 지역변수
  num4 = 400; // 전역변수
  // console.log("num3(함) : " + num3);
  // console.log("num4(전) : " + num4);

  if( 1==1){  // 무조건수행
    var num5 = 500;
    num6 = 600;
  }
  // console.log("num5(if)" + num5);
  // console.log("num6(전)" + num6);
}
testFn(); // 함수는 호출해야 수행된다

// num3 is not defined (num3 변수가 정의되지 않았다)
// -> 함수 밖이라서 인식 안됨
// console.log("num3(함) : " + num3);
/* JS는 중간에 오류가 발생하면 다음코드 해석X */
// console.log("함수 밖 num4(전) : " + num4);

// console.log("if -> 함수밖" + num6);
//----------------------------------------------------------------

// let / const
let let11 = 100;
// let let11 = 200; //변수명 중복X     

left1 = 100;
let1 = 10; // 값 변경 가능
const con1 = 200;
// con1 =20; /* 상수형 변수에는 새로운값을 할당 할 수 없다 */

function testFn2() {
  let1 = 9999; // block 값이 다르면 변수명 중복가능
  const con3 = 3000;
}

function typeTest() {
  const box = document.getElementById("box");
  box.innerHTML = ""; // box 내부에 작성된 내용을 모두 삭제

  let undef;  // 선언 후 값 대입X (자료형이 정의되지 않음)
  box.innerHTML += "undef :" + typeof undef; 

  const name = "홍길동"; // String 변수
  const gender = 'M'  // String 변수
  const phone = '01012341234';f


print(name);
print(gender);
print(phone)

// number 
const age = 33;
const height =  188.3;

print(age);
print(height);

// boolean
const tt = ture;
const ff = false;

print(tt);
print(ff);

// object
const arr = [10,20,30,40,50];
print(arr);

/* JS객체{K:V,  K:V} */
const user = {
  id : "user01",
  pw : "pass01",
  age : "20"
}
print(user);
console.log(user);

// 객체에 존재하는 값 얻어오는 방법
/* 변수명.key */
print(user.id);
print(user.pw);
print(user.age);

// 객체에 존재하는 값얻어오는 방법2
/* 변수명["key"] */
print(user["id"]);
print(user["pw"]);
print(user["age"]);

// function
// 익명함수 (함수명 없음)
// 변수명 == 함수명
const sumFn = function(n1, n2) {
  return n1 + n2;
}
console.log(sumFn(10,40));

print(sumFn);
}

// sumFn : 함수 자체

function br() {
  const box = document.getElementById("box");
  box.innerHTML += "<br>";
}


function print(temp){

}