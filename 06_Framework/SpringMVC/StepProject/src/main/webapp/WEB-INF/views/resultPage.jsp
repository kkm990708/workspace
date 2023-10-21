<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>resultPage</title>

</head>
<body>

  <h1>${name}님의 구매 목록</h1>
  <p>검은 펜 ${blackPen}개 : ${blackPenPrice}</p>
  <p>빨간 펜 ${redPen}개 : ${redPenPrice}</p>
  <p>파란 펜 ${bluePen}개 : ${bluePenPrice}</p>
  <p>화이트 ${white}개 : ${whitePrice}</p>
  <hr>
  <p>총합 ${total}원을 결제하셨습니다</p>

</body>
</html>