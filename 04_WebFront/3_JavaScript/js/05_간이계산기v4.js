const num1 = document.getElementById('num1');
const num2 = document.getElementById('num2');
const result = document.getElementById('result');

/* 연산자 버튼 클릭 시 동작
  매개 변수 btn : 클린된 버튼 자체 */
function calc(btn){
  const op = btn.innerText; // 버튼에 작성된 연산자

  v1 = Number(num1.value);
  v2 = Number(num2.value);

  // 1.eval("코드 형식의 문자열")
  // -> 매개변수의 문자열을 JS코드로 변환해서 해석하는 함수
  // -> 속도 + 보안 문제로 사용을 지양

  // result.innerText = "계산결과 : " + eval(v1 + op + v2);

  // 2. new Function("코드 형식의 문자열")();
  // -> 새 함수를 만들어서 바로 실행
  // -> 실행되는 함수의 내용은 첫번째()에 작성된
  //    코드형식의 문자열
  result.innerText = new Function("return " + v1 + op + v2)();
}