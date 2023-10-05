document.querySelector("#btn1").addEventListener("click", () => {

  // location.href : 현재 주소 반환
  // location.href = 주소 : 대입된 주소로 이동(GET 방식)
  location.href = "/jstl/basic"
});

document.querySelector("#btn2").addEventListener("click", () => {

    location.href = "/jstl/condition"; // GET 방식
  
});

document.getElementById("btn3").addEventListener("click", () => {

  location.href = "/jstl/loop"; // GET 방식

});