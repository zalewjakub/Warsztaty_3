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
		Dodaj Użytkownika:
		<c:forEach var='name' items="${user.fields}">
			<input type="text" name="${name}" placeholder="${name}"}>
		</c:forEach>
		<br> <input type="submit" name="${getTableName}"
			placeholder="Wyślij"><br> <br> ${param.message}<br>
	</form>
	<a href="http://localhost:8080/Warsztaty_3/Menu">Powrót do Strony głównej</a>
</body>
</html>