<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

JSP import 구문(EL 쓰면 필요없음)
<%@ page import="java.util.List" %>


<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>el_result</title>
</head>
<body>
  <h1>EL을 이용해서 파라미터 출력하기</h1>
  <h4>${param.inputDate}</h4>

  <hr>

  <h1>EL을 이용해서 세팅된 속성(Attribute) 값 출력하기</h1>

  <ul>
    <li> 기본 작성법 : \${ key }</li>

    <li> 
    List(객체) : ${ strList }
      <ul>
        <li><%= ((List)request.getAttribute("strList") ).get(0) %></li>

        <%-- eEL은 get 이라는 단어를 사용하지 않음 --%>
        <li>${strList[0]}</li>
      </ul>
    
    </li>
    <li>
     DTO(객체) : ${ b1 }
      <ul>
        <li>title : ${b1.getTitle()}</li>
        <li>writer : ${b1.getWrite()}</li>
        <li>price : ${b1.getPrice()}</li>
      </ul> 
    </li>
  </ul>

  <hr><hr><hr>
  <h1>empty 연산자 </h1>
  <pre>
   - \${empty 객체 | 배열 | 리스트}
   - null 또는 빈칸 또는 비어있으면 true
     아니면 false

    (EL은 null을 빈칸으로 표현)
      -> null == ""(빈칸) + 비어있음
  </pre>

  <li> test1 = null; ->   ${empty test1}</li>
  <li> test2 = ""; ->     ${empty test2}</li>
  <li> test3 = null; ->   ${empty test3}</li>
  <li> test4 = new ArrayList<String>(); -> ${empty test4}</li>
  <li> test6 = new ArrayList<String>(); + add -> ${empty test5}</li>


</body>
</html>