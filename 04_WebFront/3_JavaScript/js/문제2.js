

function apply(){
  const width = document.getElementById('width');
  const height = document.getElementById('height');
  const fontSize = document.getElementById('font-size');
  const fontWeight = document.querySelector("[name='font-weight']:checked");
  const color = document.getElementById('color');
  const backColor = document.getElementById('back-color');
  const horizontal = document.querySelector("[name='horizontal']:checked");
  const vertical = document.querySelector("[name='vertical']:checked");
  const inputText = document.getElementById('input-text');

  const resultBox = document.getElementById('result-box');

  // 너비를 입력하는 input에 값이 작성되어 있다면
  if(width.value.trim().length > 0){
    resultBox.style.width = `${width.value}px`;
  }
  // 높이를 입력하는 input에 값이 작성되어 있다면
  if(height.value.trim().length > 0){
    resultBox.style.height = `${height.value}px`;
  }

  if(backColor.value.trim().length > 0){
    resultBox.style.backgroundColor = backColor.value;
  }

  if(color.value.trim().length > 0){
    resultBox.style.color = color.value;
  }

  if(fontSize.value.trim().length > 0){
    resultBox.style.fontSize = `${fontSize.value}px`;
  }

  if(fontWeight != null){
    resultBox.style.fontWeight = fontWeight.value;
  }

  if(horizontal != null){
    resultBox.style.justifyContent = horizontal.value;
  }

  if(vertical != null){
    resultBox.style.alignItems = vertical.value;
  }

  if(inputText.value.trim().length > 0){
  resultBox.innerHTML = inputText.value;
  }
}