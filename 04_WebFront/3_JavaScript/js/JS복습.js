const bingoLength = document.querySelector('#bingo-length');
const createBtn = document.querySelector('#create-btn');
const fontColor = document.querySelector('#font-color');
const bingoBoard = document.querySelector('#bingo-board');

// 생성 버튼 클릭 시
createBtn.addEventListener('click', (e) => {


  // 생성 버튼의 이전 형제 요소(input)의 값 얻어오기
  const bingoLength = e.target.previousElementSibling.value;

  // bingoLength * bingoLength 한 수 만큼 중복되지 안흔 난수 생성
  // - Java 컬렉션 중 Set(중복X)과 똑같은 객체 존재

  const set = new Set();

  /* set.size 에 저장된 요소의 수 */
  while (set.size < bingoLength * bingoLength) {
    const r = Math.floor(Math.random() * bingoLength * bingoLength + 1);
    set.add(r);
  }

  // set을 array(배열) 변경
  // Array.from(set)는 set을 배열로 변환하여 반환
  const arr = Array.from(set);

  // ------------------------------------------

  /* 빙고판 생성 */
  // 재사용 용도의 변수 생성

  let row;
  let col;


  bingoBoard.innerHTML = '';

  for (let i = 0; i < arr.length; i++) {

    // 각 행의 첫 번째 값이 들어갈 index 차례일 때
    if (i % bingoLength == 0) {
      row = document.createElement('div');
      row.classList.add("bingo-row");

      // 만들어진 행을 #bingo-board에 추가
      bingoBoard.append(row);
    }

    // 열 (div.bingo-col) 생성
    col = document.createElement('div');
    col.classList.add("bingo-col");
    col.innerText = arr[i]; // 생성된 열에 난수를 순서대로 대입


    
    
    /***********************************************/
    // 생성된 열(col)이 클릭 되었을 때
    // .check 가 없으면 추가 없으면 제거
    col.addEventListener('click', e => {
      // 이벤트가 발생한 요소
      // 이벤트가 발생한 요소가 check 클래스를 포함하고 있는지 확인
      // console.log(e.target.classList.contains("check"));
      if (e.target.classList.contains("check")) {
        e.target.classList.remove("check");
      } else {
        e.target.classList.add("check");
      }

      // 빙고 여부 검사
      checkBingo();
    });


    /***********************************************/
    row.append(col);
  }
  
});


function checkBingo() {
  let board = []; // 비어있는 배열 생성
  // (참고 : JS의 배열은 Java의 List와 비슷)

  // 현재 빙고의 행들을 모두 얻어와 배열로 저장
  const rows = document.querySelectorAll(".bingo-row")
  for (let i = 0; i < rows.length; i++) {
    // rows[i].children : 각 행의 모든 열을 배열로 반환
    // 배열.push( 값/객체 ) : 배열 마지막 요소로 추가
    //  --------                   (java : List.add)
    board.push(rows[i].children);
  }


  // 모든 col에 있는 bingo 클래스 제거
  for (let i = 0; i < board.length; i++) {
    for (let j = 0; j < board[0].length; j++) {
      board[i][j].classList.remove("bingo");
    }
  }

  // 1. 행 빙고 검사
  rowCheck(board);

  // 2. 열 빙고 검사
  colCheck(board);

  diaCheck(board);
};

function rowCheck(board) {
  // board : 빙고판을 나타내는 2차원 배열
  // board[i] : i번째 행
  // board[i][j] : i번째 행 j번째 열
  for (let i = 0; i < board.length; i++) {
    // 한 행씩 접근해서 모든 열에 check 클래스가 있는지 검사
    let count = 0; // 현재 행에 check 개수 count

    // 모든 열 접근용 for문
    for (let j = 0; j < board[i].length; j++) {
      // 열에chehck 클래스가 있다면 count 장가
      if(board[i][j].classList.contains("check")) {
        count++;
    }
  }
    if (board[i].length == count) {
      for (let j = 0; j < board[i].length; j++) {
        board[i][j].classList.add("bingo");
        
      }
    }
  }
}

function colCheck(board) {
  // i는 열의 인덱스
  //board.length L 행의 길이 
  // 빙고판은 정사각형 : 행과 열의 길이
  const bingoLength = board.length
  for(let i = 0 ; i < bingoLength; i++) {
    let count = 0; // check 개수 count
    for(let j = 0 ; j < bingoLength; j++) {
      if(board[j][i].classList.contains("check")){
        count++;
      }
    }
    if(bingoLength == count){
      for(let j = 0 ; j < bingoLength; j++) {
        if(board[j][i].classList.add("bingo")){
        }
      }
    }
  }
}

function diaCheck(board) {
  let count1 = 0; // 왼쪽 위 -> 오른쪽 아래
  let count2 = 0; // 오른쪽위 -> 왼쪽 아래

  const bingoLength = board.length; // 빙고판 길이

  for(let i = 0 ; i < bingoLength; i++) {
    if(board[i][i].classList.contains("check")){
      count1++;
    }
    if(board[i][bingoLength - i - 1].classList.contains("check")){
      count2++;
    }
  } // for 문 끝

  if(bingoLength ==  count1){
    for(let i = 0 ; i < bingoLength; i++) {
      board[i][i].classList.add("bingo");
    }
  }

  if(bingoLength ==  count2){
    for(let i = 0 ; i < bingoLength; i++) {
      board[i][bingoLength - i - 1].classList.add("bingo");
    }
  }
}

fontColor.addEventListener('keyup', (e) => {
  if(e.key == 'Enter'){
    bingoBoard.style.color = fontColor.value;
  }
});