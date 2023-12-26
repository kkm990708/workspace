import React, { useState } from 'react';

const StateEx2 = (props) => {
  // props : 부모로 부터 전달받은 값을 저장한 객체
  
  // 상태변수 count 선언 
  // 부모로 부터 전달받은 props.init 으로 count 초기화
  // setCount()를 이용해 상태변수 값을 수정하면 화면에 리렌더링 수행
  const [count, setCount] = useState(props.init);
  
  return(
    <div>
      <h3>{count}</h3>
      {/* {} 내부에는 js 코드 작성 가능 */}
      {/* 이벤트 리스너 {} 내부에 익명함수를 작성하면 이벤트 핸들러로 사용 */}
      <button onClick={()=>{ setCount(count + 1)} }>클릭하면 카운트 1 증가</button>
    </div>
  );

}

export default StateEx2;