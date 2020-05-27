<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
    Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Milk</title>
</head>
<body>
	<div align="center">
		<h2>Milk Manager</h2>
		<form method="get" action="search">
			<input type="text" name="keyword" /> &nbsp; <input type="submit"
				value="Search" />
		</form>
		<br> <br> <br>
		<table border="1" cellpadding="5">
			<tr>
				<th>ID</th>
				<th>IDAGE</th>
				<th>ID_COMPANY</th>
				<th>ID_COUNTRY</th>
				<th>NAME</th>
			</tr>
			<c:forEach items="${listMilk}" var="item">
				<tr>
					<td>${item.id}</td>
					<td>${item.age}</td>
					<td>${item.company}</td>
					<td>${item.country}</td>
					<td>${item.name}</td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<div align="left">
		<form method="get" action="filter">
			<h3>COUNTRY:</h3>
			<select name="country" id="country">
				<option value=0>ALL</option>
				<option value=1>JAPAN</option>
				<option value=2>USA</option>
				<option value=3>VIETNAM</option>
			</select>
			<h3>AGE:</h3>
			<select name="age" id="age">
				<option value=0>ALL</option>
				<option value=1>1-2</option>
				<option value=2>3-4</option>
				<option value=3>>5</option>
			</select>
			<h3>COMPANY	:</h3>
			<select name="company" id="company">
				<option value=0>ALL</option>
				<option value=1>JAPAN</option>
				<option value=2>USA</option>
				<option value=3>VIETNAM</option>
			</select>
		
			<input type="submit"
				value="SUBMIT" />
		</form>
	</div>
</body>
</html>