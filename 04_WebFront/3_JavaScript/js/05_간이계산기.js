const num1 = Number(document.getElementById('num1').value);
const num2 = Number(document.getElementById('num2').value);
const result = document.getElementById('result');
function plus(){
  result.innerText = "계산 결과 : " + (num1 + num2);
}

function minus(){
  result.innerText = "계산 결과 : " + (num1 - num2);
}

function multi(){
  result.innerText = "계산 결과 : " + (num1 * num2);
}

function div(){
  result.innerText = "계산 결과 : " + (num1 / num2);
}

function mod(){
  result.innerText = "계산 결과 : " + (num1 % num2);
}

