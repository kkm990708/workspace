// getElementById(아이디) : 아이디가 일치하는 요소를 얻어와라
const test1 = document.getElementById("test1");

// innerText로 읽어오기
function getBoxText(){
  // console.log(내용) : 내용을 개발자 도구 console에 출력해라
  // test1.innerText : test1 요소에 작성된 내용을 출력
  console.log(test1.innerText)
}

// innerText로 변경하기
function setBoxText(){
  test1.innerText = "innerText로 <br> 변경된 <b>내용입니다 &copy; </b>"
}

const test2 = document.getElementById("test2");

/* innerHTML로 얻어오기 */
function getBoxHTML(){
  console.log(test2.innerHTML);
}

/* innerHTML로 변경하기 */
function setBoxHTML(){
  test2.innerHTML += "<ul> <li>적용!</li> <li>됨</li> </ul>"
}

/* confirm 확인 */
function confirmFn(){
  const confirmBox = document.getElementById("confirm-box")
  if(confirm("배경색을 변경할까요?")){  // 확인 버튼 클릭 시
    confirmBox.style.backgroundColor = "skyBlue";
  } else{ // 취소 버튼 클릭 시
    confirmBox.style.backgroundColor = "white";
  }
}

/* prompt 확인 */
function promptFn(){
  const result = document.getElementById("prompt-result");

  const name = prompt("이름을 입력해주세요")
  // 확인 버튼을 클릭한 경우
  if(name != null){
    result.innerHTML = name;
  }else{
    result.innerHTML = "이름이 입력되지 않았습니다";
  }
}

/* innerHTML 응용 */
function addBox(){
  const con2 = document.getElementById("con2")
  con2.innerHTML += "<div class = 'box2'></div>";
}