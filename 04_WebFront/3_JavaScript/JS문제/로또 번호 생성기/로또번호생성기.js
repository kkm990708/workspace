const createBtn = document.querySelector("#create-btn");
const back = document.querySelector("#back");
const outNumberBox = document.querySelector("#out-number-box");




createBtn.addEventListener("click", (e) => {
  let createNumber = document.querySelector("input[type=radio]:checked");
  if(createNumber.value == 0){
    createNumber = createNumber.nextElementSibling;
  }

  outNumberBox.innerHTML = "";

  for(let i = 0; i < createNumber.value; i++) {
    const div = document.createElement("div");
    div.classList.add("number-box");

    for(let j = 0; j < 6; j++) {
      const inDiv = document.createElement("div");
      /* 중복 제거 배열 */

      inDiv.innerText = crypto.getRandomValues(new Uint32Array(1))[0] % 45 + 1;

      while(true){
        let flag = true;
      for( let k = 0; k < div.children.length; k++) {

        if(div.children[k].innerText == inDiv.innerText) {
          inDiv.innerText = crypto.getRandomValues(new Uint32Array(1))[0] % 45 + 1;
          flag = false;
          }
        }

        if(flag){
          break;
        }
      }

      
      
    inDiv.classList.add("number");
    div.append(inDiv);

    const randomColor = crypto.getRandomValues(new Uint32Array(1))[0] % 5 + 1

    switch(randomColor){
      case 1:  inDiv.style.backgroundColor = '#fbc400'; break; 
      case 2:  inDiv.style.backgroundColor = '#69c8f2'; break; 
      case 3:  inDiv.style.backgroundColor = '#ff7272'; break; 
      case 4:  inDiv.style.backgroundColor = '#aaa'; break; 
      case 5:  inDiv.style.backgroundColor = '#b0d840'; break; 
    }
    
    outNumberBox.append(div);
  }
  
  
  
  
  
  
  
}});