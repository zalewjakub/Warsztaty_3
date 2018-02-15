<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create</title>
</head>
<body>
<form action="http://localhost:8080/Warsztaty_3/Update" method='post'>Wpisz dane:<br>
		<c:forEach var='name' items="${data.fields}">
			<input type="text" name="${name}" placeholder="${name}"}>
		</c:forEach>
		<br> <input type="submit" value="Dodaj"><br>
	</form>
	<br>
	<a href="http://localhost:8080/Warsztaty_3/Edit">Powrót do strony
		edycji</a>
</body>
</html>