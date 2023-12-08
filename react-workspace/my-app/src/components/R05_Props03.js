import React from 'react'

// 컴포넌트 부모/자식 관계 순서
// App -> Prorps3 -> ChildComponent

const ChildComponent = (props) => {
  // PropsEx3 로 부터 전달 받은 props : {name : "이름", age : 나이}

  return(
    <>
      <h3>App에서 부터 전달된 name : {props.name}</h3>
      <h3>PropsEx3에서 부터 전달된 age : {props.age}</h3>
      <br/>
    </>
  )
}

const Props3 = (props) => {
  // 전달 받은 prorps : {name : "이름"}


  // 동등 비교연산자 (==) : 값이 같으면 true
  // 동일 비교연산자 (===) : 자료형, 값이 모두 같으면 true

  const obj = {};
  obj.name = props.name;
  obj.age = props.name === '김민규' ? 28 : 30

  // 전개, 나열 연산자 (...) : 배열, 객체를 나열하는 연산자
  // 양쪽, 괄호가 사라진다고 생각
  // [1,2,3] => 1,2,3
  // {a:10, b:20} => a:10, b:20
  return(
    // <ChildComponent name={props.name} age={props.name === '김민규' ? 28 : 30 }/>
    <ChildComponent {...obj}/>
  );
}

export default Props3