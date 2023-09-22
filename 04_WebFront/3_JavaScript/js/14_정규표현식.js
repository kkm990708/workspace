/* 정규표현식 객체 생성/패턴 일치 확인 */
const check1 = document.getElementById('check1');

check1.addEventListener('click', () => {
  //  정규 표현식 객체 생성
  // 1) new RegExp("정규표현식")
  let regEx = new RegExp("\d{3}");  // 연속적으로 작성된 숫자 3개
  
  // 2) 정규표현식
  regEx = /\d{3}/;

  /* 패턴 일치 여부 확인 */
  const str1 = "정규표현식123";
  const str2 = "정규표89현식";
  // 정규식객체.test(문자열) -> 패턴이 일치하면 true
  console.log( regEx.test(str1) );
  console.log( regEx.test(str2) );

  // 정규식객체.exec(문자열) -> 패턴이 일치하면 문자열을 반환
  console.log(regEx.exec(str1));
});

const check2 = document.querySelector('#check2');

/* 
     a (일반문자열) : 문자열 내에 a라는 문자열이 존재하는 검색 
     [abcd] : 문자열 내에 a,b,c,d 중 하나라도 일치하는 문자가 있는지 검색
     ^(캐럿) : 문자열의 시작을 의미
     $(달러) : 문자열의 끝을 의미
 */

check2.addEventListener('click', () => {
  let regEx = /java/;
  console.log(`javascript : ${regEx.test("javascript")}`);
  console.log(`jajajaja : ${regEx.test("jajajaja")}`);

  
  // [abcd] : 문자열 내에 a,b,c,d 중 하나라도 일치하는 문자가 있는지 검색

  regEx = /[a-z][0-9][A-Z]/;
  // 영어 소문자, 숫자, 영어 대문자
  let str = "a3T";
  console.log(`${str} : ${regEx.test(str)}`);

  str = "@@@@@a3T@@@@@";
  console.log(`${str} : ${regEx.test(str)}`);

  // ^(캐럿) : 문자열의 시작을 의미
  // $(달러) : 문자열의 끝을 의미

  regEx = /^Hello[0-9]/
  
  str = "Hello4world3";
  console.log(`${str} : ${regEx.test(str)}`);

  str = "Hello world";
  console.log(`${str} : ${regEx.test(str)}`);

  str = "        Hello3 world";
  console.log(`${str} : ${regEx.test(str)}`);
  



  // $(달러) : 문자열의 끝을 의미
  regEx = /\d\d\d/; // 문자열의 끝에 숫자가 3칸 있는가
  str = "";
  console.log(`${str} : ${regEx.test(str)}`);


  str = "12121212_99";
  console.log(`${str} : ${regEx.test(str)}`);
  
  regEx = /^[a-z]TEST\d/;
  str = "wTEST4"
  console.log(`${str} : ${regEx.test(str)}`);
});

/* *, $ 를 같이 사용하는 경우
  문자열의 시작과끝이 장해져있다 */

  const inputName = document.querySelector('#input-name');
  
  const nameResult = document.querySelector('#name-result');
  

  inputName.addEventListener('input', () => {

    // 1) 2~15글자 사이        -> {2,15}
    // 2) 처음부터 끝까지 한글 -> ^한글$
    // 3) 단자음, 단모음 제외  -> [가-힣]

    const regEx = /^[가-힣]{2,15]$/

    // 입력받은 값
    const value = inputName.value.trim();

    inputName.value = value;  // 좌우 공백이 제거된 값을 대입

    if(value.length == 0){
      nameResult.innerText = "한글 2~15자 사이 입력";
      nameResult.classList.remove('check');
      nameResult.classList.remove('error');
      return
    }

    if(regEx.test(value)){
      nameResult.innerText = "유효한 이름입니다"

      nameResult.classList.add('check');
      nameResult.classList.remove('error');
    }else{
      nameResult.innerText = "유효하지 않은 이름입니다"
      nameResult.classList.add('error');
      nameResult.classList.remove('check');
    }
    
    
  });


  const callInput = document.querySelector('#call-input');
  const callResult = document.querySelector('#call-result');

  callInput.addEventListener('input', () => {
    
    const regEx = /^01[0,1,6,7,9]-\d{3,4}-\d{4}$/
    
    const value = callInput.value.trim();

    callInput.value = value;  // 좌우 공백이 제거된 값을 대입

    if(value.length == 0){
      callResult.innerText = "휴대폰 번호를 입력(- 포함)";
      callResult.classList.remove('check');
      callResult.classList.remove('error');
      return;
    }

    if(regEx.test(value)){
      callResult.innerText = "유효한 번호입니다"
      callResult.classList.add('check');
      callResult.classList.remove('error');
    }
    else{
      callResult.innerText = "유효하지 않은 번호입니다"
      callResult.classList.add('error');
      callResult.classList.remove('check');
    }


  });