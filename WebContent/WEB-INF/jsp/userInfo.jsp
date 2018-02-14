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
<h1>Szczególy użytkownika o Id = ${id}</h1>
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
	<h2>Jego zadania</h2>
	<table border=' 1px solid black'>
		 <thead>
			<tr>
				<th></th>
				<c:forEach var='head' items="${solution.fields}">
					<th>${head}</th>
				</c:forEach>
			</tr>
		</thead> 


		<c:forEach var="number" begin='1' end='${limitSolution}'>
			<tr>
				<td>${number}</td>
				<c:forEach var="solution" items="${allSolution}" begin="${(number-1)*sizeSolution}"
					end="${(number*sizeSolution)-1}">
					<td>${solution}</td>
				</c:forEach>
				<c:forEach var="solution" items="${allSolution}" begin="${(number-1)*sizeSolution}"
					end="${(number-1)*sizeSolution}">				
					<td><form method="" action="http://localhost:8080/Warsztaty_3/SolutionInfo">
  <button type="submit" name="id" value="${solution}">Więcej</button>
</form></td>
				</c:forEach>
			</tr>
		</c:forEach>
	</table>
	
	
	<a href="http://localhost:8080/Warsztaty_3/Menu">Powrót do Strony
		głównej</a>
</body>
</html>