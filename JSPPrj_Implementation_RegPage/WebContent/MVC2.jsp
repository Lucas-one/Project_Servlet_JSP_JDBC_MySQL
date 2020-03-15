<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- -------------------------------------------------- -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<% 
pageContext.setAttribute("result","hello");
%>
<body>
	<%=request.getAttribute("result")%>입니다.
	${requestScope.result}<br>
	${names[1]}<br>
	${notice.id}<br>
	${result }<br>

	empty 테스트<br>
	이건 empty인지 : ${empty param.n}<br>
	이건 empty 아닌지 :${not empty param.n }<br>
	empty 테스트 끝<br>
	<br>
	3항 연산자 활용<br>
	${empty param.n?'값이 비어 있습니다.': param.n}<br><br>
	${header.accept }
</body>
</html>