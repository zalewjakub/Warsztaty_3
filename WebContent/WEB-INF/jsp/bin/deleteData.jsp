<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="" method='post'>
		Podaj Id do usuniecia rekordu: <br> <input type="text" name="id"
			placeholder="Podaj Id"}><br> <input type="submit"
			placeholder="Wyślij"><br>
	${param.message}
	</form>
	<a href="http://localhost:8080/Warsztaty_3/Menu">Powrót do Strony
		głównej</a>
</body>
</html>