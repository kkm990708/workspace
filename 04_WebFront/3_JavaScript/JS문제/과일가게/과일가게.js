const countBtn = document.querySelector('#count-btn');

countBtn.addEventListener('click', () => {
  const result = document.querySelector('#result');
  result.innerHTML = '';
  const checkedList = document.querySelectorAll('input[type=checkbox]:checked');
  let sum = 0;
  
  for(let i = 0; i < checkedList.length; i++) {
    // 체크 박스의 부모의 형제의 마지막 자식 요소의 값 선택
    const inputValue = checkedList[i].parentElement.nextElementSibling.lastElementChild.value;

    result.innerHTML += checkedList[i].value + " " + inputValue + '개 ';

    const price = checkedList[i].parentElement.nextElementSibling.firstElementChild.innerText;
    sum += Number(inputValue) * Number(price);
  }
  result.innerHTML += '  총합 : '+ sum + '원';
  
});