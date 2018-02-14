<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Rozwiązanie zadania o Id = ${id}</h1>
<table border=' 1px solid black'>
		<thead>
			<tr>
				<c:forEach var='exercise' items="${exercise.fields}">
					<th>${exercise}</th>
				</c:forEach>
			</tr>
		</thead>


		<tr>
			<c:forEach var="data" items="${finded}">
				<td>${data}</td>
			</c:forEach>
		</tr>
	</table>
	<a href="http://localhost:8080/Warsztaty_3/LoadUsers">Powrót do strony
		wyboru użytkownika</a>
</body>
</html>