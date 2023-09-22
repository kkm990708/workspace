const btn = document.getElementById('btn');
const inputBox = document.querySelector('#input-box');
const createInput = document.getElementById('create-input');
const sumBox = document.querySelector('#sum');

btn.addEventListener('click', (e) => {
  inputBox.innerHTML = "";
  const inputValue = createInput.value;

  for(let i = 0; i < inputValue ; i++) {
    const newDiv = document.createElement('input');
    newDiv.type = 'number';

    newDiv.classList.add('num-input');

    const div = document.createElement('div');

    div.append(newDiv);

    inputBox.append(div);
  }
});

sumBox.addEventListener('click', (e) => {
  const inputList = document.querySelectorAll('.num-input');
  let result = 0; 
  
  for(let i = 0; i < inputList.length; i++) {
    result += Number(inputList[i].value);
  }
  const resultSpan = document.querySelector('#result');
  resultSpan.innerHTML = result;
});