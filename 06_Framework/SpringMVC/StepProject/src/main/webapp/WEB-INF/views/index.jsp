<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>main</title>

</head>
<body>
	<form action="order" method="get">
    <table border="1" style="text-align: center;">
      <tr>
        <th colspan="3">주문자 명</th>
      </tr>
  
      <tr> 
        <td colspan="3"><input type="text" name="name"></td>
      </tr>
  
      <tr>
        <th>품목</th>
        <th>가격</th>
        <th>수량</th>
      </tr>
  
      <tr>
      </tr>
      <tr>
        <td>검정 펜</td>
        <td>500원</td>
        <td><input type="number" value="0" min="0" max="100" name="blackPen"></td>
      </tr>
      <tr>
        <td>빨간 펜</td>
        <td>700원</td>
        <td><input type="number" value="0" min="0" max="100" name="redPen"></td>
      </tr>
      <tr>
        <td>파란 펜</td>
        <td>700원</td>
        <td><input type="number" value="0" min="0" max="100" name="bluePen"></td>
      </tr>
      <tr>
        <td>화이트</td>
        <td>1000원</td>
        <td><input type="number" value="0" min="0" max="100" name="white"></td>
      </tr>
      <tr>
  			<td colspan="3">
  				<button>구매</button>
  				<button onclick="reset()" type="button">초기화</button>	
  			</td>
  		</tr>
    </table>
	</form>


  <script>
    const inputs = document.querySelectorAll("input")
    function reset(){
      
      inputs[0].value = '';
      inputs[1].value = 0;
      inputs[2].value = 0;
      inputs[3].value = 0;
      inputs[4].value = 0;
    }
	</script>


</body>
</html>
