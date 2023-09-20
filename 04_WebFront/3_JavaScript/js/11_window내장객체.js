// [window.setTimeout](함수, 지연시간)
const test1 =document.querySelector("#test1")

// setTimeout() 은 비동기로 동작
test1.addEventListener("click", () =>{


    // - 비동기 -
    // 현재 코드를 수행할 때 다음 코드가 기다리지 않고 동시 수행
    console.log("1초");

    setTimeout(() => {
      console.log("2초 후");
    }, 2000);

    setTimeout(() => {
      console.log("3초 후");
    }, 3000);

  
});

const target2 = document.querySelector("#target2");
const test2 = document.querySelector("#test2");

// test2 클릭시 test2의 내용을 1초미다 1씩증가
test2.addEventListener("click", () => {
  setInterval(() => {
    ++target2.innerHTML;
  }, 1000);

  // 버튼 비활성화
  // -> 추가 클릭으로 인한 무분별한 인터벌 생성 방지
  test2.disabled = true;
})


//[window.]clearInterval( setInterval() );

/* 스톰워치 만들기 */
const stopWatch = document.querySelector("#stopwatch");
const startBtn = document.querySelector("#start");
const stopBtn = document.querySelector("#stop");

let stopWatchInterval;  // start 버튼 클릭시 생성된 setInterval을 저장할 변수
startBtn.addEventListener("click", () => {
  
  // 이전 START 버튼 클릭으로 생성된 setInerval을 지움
  clearInterval(stopWatchInterval);

  let count = 0; // 클릭 후 지난 시간을 세기위한 변수
  // count == 1 == 0.01s
  // count == 199 == 1초

  stopWatchInterval = setInterval(() => {
    count++;
    let min = Math.floor(count / 100 / 60);
    let sec = Math.floor(count / 100 % 60);
    let ms = count % 100;

    if(min < 10) min = "0" + min; // 한 자리인 경우
    if(sec < 10) sec = "0" + sec; // 한 자리인 경우
    if(ms < 10) ms = "0" + ms; // 한 자리인 경우

    stopWatch.innerText = min + " : " + sec + " : " + ms;
  },10) // 0.01.초마다 동작
  
});

stopBtn.addEventListener("click", () => {
  clearInterval(stopWatchInterval);
});

const open1 = document.querySelector("#open1");
const open2 = document.querySelector("#open2");
const open3 = document.querySelector("#open3");

// 새탭으로 열기
open1.addEventListener("click", () => {
  window.open("https://www.kh-academy.co.kr");
});

open2.addEventListener("click", () => {
  window.open("https://www.kh-academy.co.kr"
  , "_blank"
  , "popup");
});

open3.addEventListener("click", () => {
  window.open("https://www.kh-academy.co.kr"
  , "_blank"
  ,  "width=400,height=600,top=100,left=100");
  /* 주의 사항 */
  // top, left는 여러 모니터를 사용하는 환경에선
  // 주모니터(main) 에서만 적용된다
});

const open4 = document.querySelector("#open4");
open4.addEventListener("click", () => {

  window.open("popup.html", "_blank", "width=500, height-300");
});
// 새창으로 열기
