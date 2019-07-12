<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>学员管理</title>
<link rel="stylesheet" type="text/css" href="./css/test.css"/>
<style type="text/css">
</style>

<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
<script type="text/javascript" src="./js/index.js"></script>
<script type="text/javascript" src="//code.jquery.com/jquery-2.1.0.min.js"></script>
<script type="text/javascript" src="//jpostal-1006.appspot.com/jquery.jpostal.js"></script>



<script type="text/javascript" language="javascript">
function goPage(page){
location.href="all?currentPage="+page;
}
</script>

</head>
<body>
<img src="./images/header.jpg" />
${msg}
<br>
<a href="http://localhost:8080/StudentManager/order">受注信息管理</a>
<h1 align="center">学员信息管理</h1>


<div id="all_comm" class="all"  >
  <h2 align="center">学员信息一览</h2>
  <table id="items"  align="center" cellspacing=0>
	<tr>
		<td>id</td>
		<td>姓名</td>
		<td>出生年月</td>
		<td>年龄</td>
		<td>分数</td>
		<td>クラスID</td>
		<td>住所</td>

	</tr>

    <c:forEach items="${students}" var="student" >
	    <tr>
			<td id="id${student.id }">${student.id}</td>
			<td id="name${student.id }">${student.name}</td>
			<td id="birthday${student.id}">${student.birthday}</td>
			<td id="age${student.id }">${student.age}</td>
			<td id="score${student.id}">${student.score}</td>
			<td id="classid${student.id}">${student.classid}</td>
			<td id="address${student.id}">${student.address}</td>
		 </tr>
	 </c:forEach>
  </table>
</div>


 <div style="text-align:center; margin-top:40px" id="venderfen">
        当前第${paging.currentPage }页/共${paging.totalPage }页
        <c:choose>
            <c:when test="${paging.currentPage==1&&paging.totalPage==0}">

            </c:when>
            <c:when test="${paging.currentPage==1&&paging.totalPage==1}">

            </c:when>
            <c:when test="${paging.currentPage==2&&paging.totalPage==2}">
                <input type="button" value="首页" onclick="goPage(1)" />
                <input type="button" value="上一页"
                    onclick="goPage(${paging.currentPage-1})" />
            </c:when>
            <c:when test="${paging.currentPage==1 }">
            <input type="button" value="上一页" >
                <input type="button" value="下一页"
                    onclick="goPage(${paging.currentPage+1})" />
                <input type="button" value="末页"
                    onclick="goPage(${paging.totalPage})" />
            </c:when>
            <c:when test="${paging.currentPage==paging.totalPage }">
                <input type="button" value="首页" onclick="goPage(1)" />
                <input type="button" value="上一页"
                    onclick="goPage(${paging.currentPage-1})" />
            </c:when>
            <c:otherwise>
                <input type="button" value="首页" onclick="goPage(1)" />
                <input type="button" value="上一页"
                    onclick="goPage(${paging.currentPage-1})" />
                <input type="button" value="下一页"
                    onclick="goPage(${paging.currentPage+1})" />
                <input type="button" value="末页"
                    onclick="goPage(${paging.totalPage})" />
            </c:otherwise>
        </c:choose>
    </div>



	<div id="add_comm" class="all" align="left">
	  <h2>查找学员</h2>
	    <form id="queryname" action="queryByName" method="post" >
		<input id="selectname" type="text" placeholder="姓名" name="name" >
		<button id="submitname">查找学员</button>
	  </form>

	  <h2 id="edit_title">添加学员</h2>
		<form  id="addForm" action="add" method="post" >
		<input id="addname" type="text" placeholder="姓名" name="name">
		<input id="addbirthday" type="text" placeholder="出生年月" name="birthday">
		<input id="addage" type="text" placeholder="年龄" name="age">
		<input id="addscore" type="text" placeholder="分数" name="score">
		<input id="addclassid" type="text" placeholder="クラスID" name="classid">
		<input id="zip" type="text" placeholder="7桁の郵便番号入力" name="zip">
		<input id="addaddress" type="text" placeholder="都道府県市区町村" name="address">
		<button id="addCheckForm">添加</button>
	  </form>
	</div>

	<div id="edit_comm" class="all">
	  <h2>删除学员</h2>
	  <form id="delForm" action="deleteById" method="post" >
		<input id="delid" type="text" placeholder="要删除的id" name="id" />
		<button id="delCheckForm">删除学员</button>
	  </form>

	  <h2 id="edit_title">编辑学员</h2>
	  <form id = "editForm"action="update" method="post">
		<input id="editid" type="text" placeholder="要修改的id" id="edit_id" name="id"/><br>
		<input id="editname" type="text" placeholder="姓名" name="name" />
		<input id="editbirthday" type="text" placeholder="出生年月" name="birthday" />
		<input id="editage" type="text" placeholder="年龄" name="age" />
		<input id="editscore" type="text" placeholder="分数" name="score" />
		<input id="editclassid" type="text" placeholder="クラスID" name="classid">
		<input id="zipone" type="text" placeholder="7桁の郵便番号入力" name="zipone">
		<input id="editaddress" type="text" placeholder="都道府県市区町村" name="address">
		<button id="editCheckForm">确定修改</button>
	  </form>
	</div>


<div id="averScoreByClassId" class="all"  >
  <h2 align="center">クラスよりリテ成績</h2>
  <table id="averScoreByClassIditems"  cellspacing=0 >
	<tr>
		<td margin:10px;>クラスid</td>
		<td>リテ成績</td>
	</tr>

    <c:forEach items="${classScoreFormList}" var="classScoreForm" >
	    <tr>
			<td>${classScoreForm.classId}</td>
			<td>${classScoreForm.averScore}</td>
		 </tr>
	 </c:forEach>
  </table>
</div>


<div id="displayGood" class="all" align="left">
	<h2>ランキング表示</h2>
	<form action="displayGoodController"method="post">
		<input type="submit" value="優秀者表示">
	</form>
</div>

<div id="displayGokaku" class="all" align="left">
	<form action="displayGokakuController"method="post">
		<input type="submit" value="合格者表示">
	</form>
</div>

<div id="displayAverScore" class="all" align="left">
	<form action="displayAverScoreController"method="post">
		<input type="submit" value="リテ成績表示">
	</form>
</div><br>

	<input id="nyuuRyoku" type="text" placeholder="自由に入力して下さい！" name="text" />
	<button id="hyouJi">表示</button>

</body>
</html>