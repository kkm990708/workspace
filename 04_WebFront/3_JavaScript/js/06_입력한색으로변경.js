const colorInput = document.querySelectorAll(".color-input")
const inBox = document.querySelectorAll(".in-box")
function changeColor(){

  for (let index = 0; index < colorInput.length; index++) {
    inBox[index].style.backgroundColor = colorInput[index].value;
  }
}

function changeRandomColor(){
  for (let index = 0; index < colorInput.length; index++) {
    let random1 = Math.floor(Math.random() * 255);
    let random2 = Math.floor(Math.random() * 255);
    let random3 = Math.floor(Math.random() * 255);
    inBox[index].style.backgroundColor = "rgb("+random1+","+random2+","+random3+")";
  }
}
