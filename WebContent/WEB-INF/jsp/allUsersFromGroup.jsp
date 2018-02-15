<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Users_from_Group</title>
</head>
<body>
<h1>Użytkownicy z grupy:</h1>

	<table border=' 1px solid black'>
		<thead>
			<tr>
				<th></th>
				<c:forEach var='name' items="${user.fields}">
					<th>${name}</th>
				</c:forEach>
				<th></th>
			</tr>
		</thead>

		<c:forEach var="number" begin='1' end='${limit}'>
			<tr>
				<td>${number}</td>
				<c:forEach var="data" items="${searchingUsers}" begin="${(number-1)*size}"
					end="${(number*size)-1}">
					<td>${data}</td>
				</c:forEach>
				<c:forEach var="data" items="${searchingUsers}" begin="${(number-1)*size}"
					end="${(number-1)*size}">				
					<td><form method="" action="http://localhost:8080/Warsztaty_3/UserInfo">
  <button type="submit" name="id" value="${data}">Więcej</button>
</form></td>
				</c:forEach>
			</tr>
		</c:forEach>
	</table>
	<a href="http://localhost:8080/Warsztaty_3/Groups">Powrót do
		strony wyboru grupy</a>
</body>
</html>