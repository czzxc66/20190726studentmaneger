<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>学员管理</title>
<link rel="stylesheet" type="text/css" href="./css/all.css" />
<style type="text/css">
</style>
 <link rel="stylesheet" type="text/css" href="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/css/jquery.dataTables.css">
  <!-- jQuery -->
  <!-- DataTables -->
</head>
<body>
	<img src="./images/header.jpg" /> ${msg}
	<h1 align="center">先生信息管理</h1>

	<div id="all_comm" class="all">
		<h2 align="center">先生信息一览</h2>
		<table id="table_id" border="8">
			<tr>
				<td>id</td>
				<td>name</td>
				<td>birthday</td>
				<td>age</td>
				<td>score</td>
				<td>classid</td>


			</tr>

			<c:forEach items="${students}" var="student">
				<tr>
					<td id="${student.id }">${student.id}</td>
					<td id="${student.id }">${student.name}</td>
					<td id="${student.id}">${student.birthday}</td>
					<td id="${student.id}">${student.age}</td>
					<td id="${student.id}">${student.score}</td>
					<td id="${student.id}">${student.classid}</td>

				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>