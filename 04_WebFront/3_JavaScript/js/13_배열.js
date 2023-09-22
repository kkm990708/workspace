/* 배열 생성 및 기초 사용방법 */
const btn1 = document.querySelector("#btn1");

btn1.addEventListener("click", () => {
  const arr1 = new Array();
  const arr2 = new Array(10);
  const arr3 = [];
  const arr4 = ["사과", "바나나", "복숭아"]

  /* JS 배열 기초사용법 */
  // 배열에 요소를 추가하는 방법
  // * 요소를 지정된 인덱스에 추가할 수 있다
  //  -> 중간에 인덱스를 건너 뛰면
  //     건너 뛴 인덱스 부분에 비어있는 요소를 자동 추가

  arr1[0] = "가나다";
  arr1[3] = "사나다";

  console.log(arr1);
  console.log(arr2);
  console.log(arr3);
  console.log(arr4);


});


const btn2 = document.querySelector("#btn2");

btn2.addEventListener("click", () => {
  const arr = [];

  // push() : 마지막 요소로 추가
  console.log(arr);
  arr.push("라면");
  arr.push("국밥");
  arr.push("비빔밥");
  arr.push("카레");

  // unshift() :  첫번째 요소로 추가
  arr.unshift("스팸볶음밥")
  arr.unshift("햄버거 ")

  // pop() : 마디막요소 꺼내기
  let temp = arr.pop();
  console.log(temp);
  console.log(`꺼내진 요소 : ${temp}`);
  

  // shift() : 첫번째 요소 꺼내기
  temp = arr.shift();
  console.log(temp);

  // sort() : 정렬(오름차순)
  console.log(arr);
  arr.sort();
  console.log(arr);
  
  /* sort 사용 시 주의 사항 
      -> 문자열 순서대로 오름차순 정렬 (숫자 크기 X)

      해결방법 : 정렬 기준 함수를 매개변수로 추가
      (a,b) => a-b (오름차순)
      (a,b) => b-a (내림차순)
  */
    
  const arr2 = [5, 3, 2, 10 ,11];
  console.log(arr2.sort());
  
  console.log(arr2.sort( (a,b) => a-b )); // 오름
  console.log(arr2.sort( (b,a) => b-a )); // 내림


  
  /* toString() : 배열 -> 문자열 */ 
  console.log(arr.toString());

  /* join("구분자") : 배열 -> 문자열(지정된 구분자) */
  console.log(arr.join(" 또는 "));
});


/* 배열명.foreach */
const foreach= document.getElementById("forEach-btn");
foreach.addEventListener("click", () => {
  const arr = [10, 20, 30, 40, 50]
  // arrr의 모든 요소의 값을 *2 한결과를 출력
  arr.forEach( (item, index) => {
    console.log(`${index} * ${item} * 2 = ${item * 2}`);});

});


const mapBtn= document.getElementById("map-btn");

mapBtn.addEventListener("click", () => {
  const arr = [10, 20, 30, 40, 50];
  const resultArr = arr.map( (item) => {return item * 2} );

  console.log(arr);
  console.log(resultArr);
  
});

/* For of  */
const forOfBtn = document.querySelector("#for-of-btn");
forOfBtn.addEventListener("click", () => {

  //.test 모두 얻어오기
  const arr = document.querySelectorAll(".test")
  console.log(arr);

  for(let li of arr){
    console.log(li);
    li.innerText = "ㄹㄹㄹ";
  }
});