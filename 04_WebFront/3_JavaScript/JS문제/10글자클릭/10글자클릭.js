const reTry = document.getElementById('retry');
const result = document.getElementById('result');

function init(e) {
 if(result.innerText.length >= 10){
  alert("10자 까지만 입력할 수 있습니다");
  return;
 }
  
 insertValue = e.innerText;
 result.innerText += insertValue;
}

reTry.addEventListener('click', (e) => {
  result.innerText = '';
});




