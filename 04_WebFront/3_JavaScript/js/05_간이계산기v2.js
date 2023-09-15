const num1 = document.getElementById('num1');
const num2 = document.getElementById('num2');
const result = document.getElementById('result');

/* 연산자 버튼 클릭 시 동작
  매개 변수 op : + - * / %   */
function calc(btn){

  const op = btn.value;
  v1 = Number(num1.value);
  v2 = Number(num2.value);
  let res;
  
  /* switch 문을 이용해 op 매개변수 값에 따라 결과 도출 */
  switch(op){
    case '+': res = v1 + v2; break;
    case '-': res = v1 - v2; break;
    case '*': res = v1 * v2; break;
    case '/': res = v1 / v2; break;
    case '%': res = v1 % v2; break;
  }

  result.innerText = "계산결과 : " + res;
}