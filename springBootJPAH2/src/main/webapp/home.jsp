<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="addAlien">
		<input type="text" name="aid">
		<input type="text" name="aname"> 
		<input type="text" name="tech">
		<input type="submit">
	</form>
	
	<form action="getAlien">
		<input type="text" name="aid">
		<input type="submit">
	</form>
	
	<form action="updateAlien">
		<input type="text" name="aid">
		<input type="text" name="aname"> 
		<input type="text" name="tech">
		<input type="submit">
	</form>

</body>
</html>