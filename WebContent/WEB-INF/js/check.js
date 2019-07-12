function notNullCheck(){
		checkStudentNo(false);
}



function checkFirstName(){
	var flag=false;
	var firstName=document.getElementById("firstName").value;
	if(!isEmpty(firstName)){
		alert("エラー：姓が必要です。");
		flag=true;
	}
	return flag;
}
function checkLastName(){
	var flag=false;
	var lastName=document.getElementById("lastName").value;
	if(!isEmpty(lastName)){
		alert("エラー：名が必要です。");
		flag=true;
	}
	return flag;
}




function checkStudentNo(nullAbled){

	var studentNo = getTrimedStr(document.getElementById("studentNo").value);
	var re = new RegExp(/^[0-9a-zA-Z]*$/);
	if (nullAbled) {
		if (!isEmpty(studentNo)) {
			if (studentNo.length > 10) {
				alert("エラー：　10 文字以内で入力して下さい。");
			} else if (!studentNo.match(re)) {
				alert("エラー：　学号が入力ミス。");
			} else {
				//alert("正常：　[" + studentNo + "]");
				checkMail(true);
			}
		}else {
			//alert("正常：　[" + studentNo + "]");
			checkMail(true);
		}
	} else {
		if (isEmpty(studentNo)) {
			alert("エラー：　学号が必要です。");
		} else if (studentNo.length > 10) {
			alert("エラー：　10 文字以内で入力して下さい。");
		} else if (!studentNo.match(re)) {
			alert("エラー：　学号が入力ミス。");
		} else {
			//alert("正常：　[" + studentNo + "]");
			checkMail(false);
		}
	}
}

function isEmpty(str){
	if (str == null || str.length == 0){
		return true;
	}else{
		return false;
		}
}


function getTrimedStr(str) {

	if (str != null) {
		return str.trim();
	} else {
		return str;
	}
}
function displayDiv(){
	var displayDiv1 = document.getElementById("displayDiv1");
	displayDiv1.style.width="300px";
	displayDiv1.style.background="red";
	displayDiv1.style.display="inline";
}
function hiddenDiv(){
	var displayDiv1 = document.getElementById("displayDiv1");
	displayDiv1.style.display="none";
}
function checkMail(nullAbled){
	var checkMail = getTrimedStr(document.getElementById("mailAdress").value);
	var re = new RegExp(/^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/);

	if (nullAbled) {
		if (!isEmpty(checkMail)) {
			if (checkMail.length > 50) {
				alert("エラー：　50文字以内で入力して下さい。");
			} else if (!checkMail.match(re)) {
				alert("エラー：　メールアドレスが入力ミス。");
			} else {
				alert("正常：　[" + checkMail + "]");
			}
		}else {
			alert("正常：　[" + checkMail + "]");

		}
	} else {
		if (isEmpty(checkMail)) {
			alert("エラー：　メールアドレスが必要です。");
		} else if (checkMail.length > 50) {
			alert("エラー：　50 文字以内で入力して下さい。");
		} else if (!checkMail.match(re)) {
			alert("エラー：　メールアドレスが入力ミス。");
		} else {
			alert("正常：　[" + checkMail + "]");
		}
	}







}

