<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit</title>
</head>
<body>
	<form action="http://localhost:8080/Warsztaty_3/Edit" method='get'>
		Podaj limit wyświetleń: <br> <input type="number" name="limit"
			placeholder="Podaj Limit" step="1" min="0" max="1000000"> <input
			type="submit" value="Wyślij"><br> <input type="submit"
			value="Drukuj całość"
			formaction="http://localhost:8080/Warsztaty_3/Edit"> <br>

	</form>
	<table border=' 1px solid black'>
		<thead>
			<tr>
				<th></th>
				<c:forEach var='head' items="${data.fields}">
					<th>${head}</th>
				</c:forEach>
				<th></th><th></th>
			</tr>
		</thead>

		<c:forEach var="number" begin='1' end='${limit}'>
			<tr>
				<td>${number}</td>
				<c:forEach var="next" items="${allData}" begin="${(number-1)*size}"
					end="${(number*size)-1}">
					<td>${next}</td>
				</c:forEach>
				<c:forEach var="id" items="${allData}" begin="${(number-1)*size}"
					end="${(number-1)*size}">
					<td><form method="get"
							action="http://localhost:8080/Warsztaty_3/Update">
							<button type="submit" name="id" value="${id}">Edytuj</button>
							<input type="hidden" name="className" value="${className}">
						</form></td>
					<td><form method="post"
							action="http://localhost:8080/Warsztaty_3/Edit">
							<button type="submit" name="id" value="${id}">Usuń</button>

						</form></td>
				</c:forEach>
			</tr>
		</c:forEach>
	</table>
	<br>
	<form method="get"	action="http://localhost:8080/Warsztaty_3/Update">
							<button type="submit" name="id" value="0">Dodaj nowy rekord</button>
							<input type="hidden" name="className" value="${className}">
							
						</form>
	
	<a href="http://localhost:8080/Warsztaty_3/Admin">Powrót do strony
		admina</a>
</body>
</html>