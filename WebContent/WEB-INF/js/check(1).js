function notNullCheck(){

	var errorFlag = checkFirstName();

	if (!errorFlag) {
		errorFlag = checkLastName();
	}

	if (!errorFlag) {
		errorFlag = checkStudentNo(false);
	}

	if (!errorFlag) {
		errorFlag = checkMail();
	}

	if (!errorFlag) {
		alert("正常：　大成功。");
	}
}

function checkFirstName() {

	var errorFlag = false;
	var firstName = getTrimedStr(document.getElementById("firstName").value);

	if (firstName == null || firstName.trim().length == 0) {

		errorFlag = true;
		alert("エラー：　姓が必要です。");
	}

	return errorFlag;
}

function checkLastName() {

	var errorFlag = false;
	var lastName = getTrimedStr(document.getElementById("lastName").value);

	if (lastName == null || lastName.trim().length == 0) {

		errorFlag = true;
		alert("エラー：　名が必要です。");
	}

	return errorFlag;
}

function checkStudentNo(nullAbled){

	var errorFlag = false;

	var studentNo = getTrimedStr(document.getElementById("studentNo").value);
	var re = new RegExp(/^[0-9a-zA-Z]*$/);
	if (nullAbled) {
		if (studentNo != null && studentNo.length > 0) {
			if (studentNo.length > 10) {

				errorFlag = true;
				alert("エラー：　10 文字以内で入力して下さい。");
			} else if (!studentNo.match(re)) {

				errorFlag = true;
				alert("エラー：　学号が入力ミス。");
			}
		}
	} else {
		if (studentNo == null || studentNo.length == 0) {

			errorFlag = true;
			alert("エラー：　学号が必要です。");
		} else if (studentNo.length > 10) {

			errorFlag = true;
			alert("エラー：　10 文字以内で入力して下さい。");
		} else if (!studentNo.match(re)) {

			errorFlag = true;
			alert("エラー：　学号が入力ミス。");
		}
	}

	return errorFlag;
}

function checkMail() {

	var errorFlag = false;

	var mailAdress = getTrimedStr(document.getElementById("mailAdress").value);
	var re = new RegExp(/^[A-Za-z0-9]+[\w-]+@[\w\.-]+\.\w{2,}$/);

	if (mailAdress != null && mailAdress.length > 0) {
		if (!mailAdress.match(re)) {

			errorFlag = true;
			alert("エラー：　メイルが入力ミス。");
		}
	}

	return errorFlag;
}

function getTrimedStr(str) {

	if (str != null) {
		return str.trim();
	} else {
		return str;
	}
}

function displayDiv() {

	var displayDiv1 = document.getElementById("displayDiv1");
	displayDiv1.style.width = "300px";
	displayDiv1.style.background = "red";
	displayDiv1.style.display = "inline";
}

function hiddenDiv() {

	var displayDiv1 = document.getElementById("displayDiv1");
	displayDiv1.style.display = "none";
}