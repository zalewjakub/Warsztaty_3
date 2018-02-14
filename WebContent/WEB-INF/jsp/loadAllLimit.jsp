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
	<form action="http://localhost:8080/Warsztaty_3/TestGetAll" method='post'>
		Podaj limit wyświetleń: <br> <input type="number" name="limit"
			placeholder="Podaj Limit"}><br> <input
			type="submit" value="Wyślij"><br> <input type="submit"
			value="Drukuj całość" formaction="http://localhost:8080/Warsztaty_3/TestLoadAll"> <br>
	</form>
	<table border=' 1px solid black'>
		<thead>
			<tr>
				<th></th>
				<c:forEach var='name' items="${user.fields}">
					<th>${name}</th>
				</c:forEach>
			</tr>
		</thead>

		<c:forEach var="number" begin='1' end='${limit}'>
			<tr>
				<td>${number}</td>
				<c:forEach var="data" items="${allData}" begin="${(number-1)*size}"
					end="${(number*size)-1}">
					<td>${data}</td>
				</c:forEach>
			</tr>
		</c:forEach>
	</table>
	<a href="http://localhost:8080/Warsztaty_3/Menu">Powrót do Strony
		głównej</a>
</body>
</html>