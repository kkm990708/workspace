import React from 'react'
const Props2 = (props) => {

  /* props 라는 객체서 */
  // {} 내부에 작성된 변수명과 같은 key 가 존재하면
  // 변수에 value를 대입
  let {name, age, address, gender} = props;

  return(
    /* className(React) == class(HTML) */
    <ul className='info'>
      <li>이름 : {name}</li>
      <li>나이 : {age}</li>
      <li>주소 : {address}</li>
      <li>성별 : {gender}</li>
    </ul>
  )

}

export default Props2;