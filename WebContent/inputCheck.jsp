<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>入力チェック</title>
<link rel="stylesheet" type="text/css" href="./css/check.css"/>

<script type="text/javascript" src="./js/check.js"></script>

</head>
<body>
	<div width="100px">
		<input id="firstName" width="80px" type="text">&nbsp;&nbsp;<label>姓</label>
	</div><br>
	<div width="100px">
		<input id="lastName" width="80px" type="text">&nbsp;&nbsp;<label>名</label>
	</div><br>
	<div width="100px">
		<input id="studentNo" width="80px" type="text">&nbsp;&nbsp;<label>学号</label>
	</div><br>
	<div>
		<input id="mailAdress" width="80px" type="text">&nbsp;&nbsp;<label>メールアドレス</label>
	</div><br>
	<div>
		<input class="aaa bbb" type="button" onClick="notNullCheck();" value="確定">
	</div><br>
	<div style="position:relative">
		<div>
			<button onmouseover="displayDiv();" onmouseout="hiddenDiv();">表示エリア</button>
		</div><br>
		<div id="displayDiv1"  style="display:none; position:absolute;top:-30px;">
			<input id="display1" type="text" value="私は表示される">
		</div>
	</div>

</body>
</html>