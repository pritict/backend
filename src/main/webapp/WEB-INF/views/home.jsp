<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P> 테스 The time on the server is ${serverTime}. </P>
<c:forEach items="${testdata}" var="test">
	${test.no}<br/>
	${test.name}
</c:forEach><br/>
${text}
</body>
</html>
