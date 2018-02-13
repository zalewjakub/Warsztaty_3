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
	<form action="" method='post'>
		Szukaj Użytkownika: <br> <input type="text" name="id"
			placeholder="Podaj Id"}><br> <input type="submit"
			placeholder="Wyślij"><br>
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


		<tr>
			<td>${size}</td>
			<c:forEach var="data" items="${finded}">
				<td>${data}</td>
			</c:forEach>
		</tr>
	</table>
	<a href="http://localhost:8080/Warsztaty_3/Menu">Powrót do Strony
		głównej</a>
</body>
</html>