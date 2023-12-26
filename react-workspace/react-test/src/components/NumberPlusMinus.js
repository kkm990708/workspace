

import React, { useState } from 'react';

const NumberPlusMinus = () => {

  const [number, setNumber] = useState(0);

  return(
    <>
      <button className='minus-btn' onClick={() => {setNumber(number - 1) } }>-</button>
      <span> {number} </span>
      <button className='plus-btn' onClick={() => { setNumber(number + 1) } }>+</button>
    </>
  );

}


export default NumberPlusMinus;

