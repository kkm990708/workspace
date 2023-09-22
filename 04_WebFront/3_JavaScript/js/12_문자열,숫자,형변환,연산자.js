/* 문자열 관련 함수 */
document.getElementById("btn1").addEventListener("click", () => {

  /* 문자열.indexof(찾을문자열) */
  const str1 = "Heloo world 입니다.";
  console.log(str1.indexOf("9"));


  /* 문자열.substring(시작, 종료(미포함)) */
  const str2 = "Javascript 하는 중...";
  console.log(str2.substring(4, 10));

  // 문자열.length : 문자열 길이
  // console.log("script".length);
  const start = str2.indexOf("script"); // 시작 인덱스
  const end = start + "script".length;  // 종료 인덱스
  console.log(str2.substring(start, end));

  /* 문자열.split("구분자") */
  const str3 = "중고거래 / 쇼핑몰 / SNS / 블로그 / 게임"
  const arr = str3.split(" / ");

  for (let i = 0; i < arr.length; i++) {
    console.log(arr[i]);
  }
  
});


/* 숫자 관련 리터럴/함수 */
document.querySelector("#btn2").addEventListener("click", (e) => {
  // Infinity 확인
  console.log("5 / 0 = " + (5 / 0));

  // NaN(Not a Number) 
  console.log("aaa" * 100);

  // 연산 결과가 NaN인 경우 alert("계산 불가") 출력
  // -> isNaN() 사용
  //   --> 값이 NaN이면 true 반환
  if( isNaN("aaa" * 100) ) {
    // alert("계산 불가")
  }

  /* toFixed() 확인 */
  console.log( (3.45).toFixed(1) );

  /* Math.random() 확인 */
  // 버튼의 배경색을 랜덤하게 변경(rgb, 0~255)
  const red = Math.floor(Math.random() * 256);
  const green = Math.floor(Math.random() * 256);
  const blue = Math.floor(Math.random() * 256);

  /* 백틱(``) */
  e.target.style.backgroundColor = `rgb(${red}, ${green}, ${blue})`;
});


document.querySelector("#btn3").addEventListener("click", (e) => {
  const num = "1.234";
  
  // typeof : 값의 자료형을 반환

  console.log(`${num}의 자료형 : ${typeof num}`);
  console.log(`${Number(num)}의 자료형 : ${typeof Number(num)}`);
  console.log(`${parseFloat(num)}의 자료형 : ${typeof parseFloat(num)}`);
  console.log(`${parseInt(num)}의 자료형 : ${typeof parseInt(num)}`);
  
});




const btn4 = document.querySelector("#btn4");

btn4.addEventListener("click", (e) => {
  console.log(`1 == "1" -> ${1 == "1"}`);
  console.log(`1 == true -> ${1 == true}`);
  
  console.log(`1 === "1" -> ${1 === "1"}`);
  console.log(`1 === true -> ${1 === true}`);
  
});