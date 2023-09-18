const inBox = document.querySelectorAll(".in-box");

document.addEventListener("keydown", function(e) {

  for (let index = 0; index < inBox.length; index++) {

    if (e.key.toUpperCase() == inBox[index].textContent) {

      inBox[index].style.backgroundColor = "skyblue";

    } 
  }
});

document.addEventListener("keyup", function(e) {

  for (let index = 0; index < inBox.length; index++) {

    if (e.key.toUpperCase() == inBox[index].textContent) {

      inBox[index].style.backgroundColor = "white";
      
    } 
  }
});