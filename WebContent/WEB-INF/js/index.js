$(document).ready(function(){

	$('table tr:even').css('background-color', 'pink');
	$('table tr:odd').css('background-color', 'white')

	$("#submitname").click(function(){
		var form =$("#queryname");
	    var input_name=$("#selectname").val();
		if (input_name == "" || input_name == null) {
		    	alert("请输入学員姓名！！！");
		    	return false;
		    }
		form.submit();
		return true;
	})

	$("#addCheckForm").click(function(){
		var form =$("#addForm");
		var input_name=$("#addname").val();
	    var input_birthday=$("#addbirthday").val();
	    var input_age=$("#addage").val();
	    var input_score=$("#addscore").val();
	    var input_classid=$("#addclassid").val();
	    var input_address=$("#addaddress").val();

	    if (input_name == "" || input_name == null) {
	    	alert("请输入学員姓名！！！");
	    	return false;
	    }

	    if (input_birthday == "" || input_birthday == null) {
	    	alert("请输入学員出生年月！！！");
	    	return false;
	    }

	    if (input_age == "" || input_age == null) {
	    	alert("请输入学員年龄！！！");
	    	return false;
	    }

	    if (input_classid == "" || input_classid == null) {
	    	alert("请输入クラスID！！！");
	    	return false;
	    }

	    if (input_address == "" || input_address == null) {
	    	alert("请输入住所！！！");
	    	return false;
	    }

		form.submit();
		return true;
	})

	$("#delCheckForm").click(function(){
		var form =$("#delForm");

		var input_id=$("#delid").val() ;
		if (input_id == "" || input_id == null) {
			alert("请输入削除学員id！！！");
			return false;
		}


		form.submit();
		return true;
	})

				$('#zip').jpostal({
			postcode : [
				'#zip'
			],
			address : {
				'#addaddress' : '%3%4%5'
			}
		});

	$("#editCheckForm").click(function(){
		var form =$("#editForm");

    	var input_id=$("#editid").val();
    	var input_name=$("#editname").val();
    	var input_birthday=$("#editbirthday").val();
    	var input_age=$("#editage").val();
    	var input_score=$("#editscore").val();
	    var input_classid=$("#editclassid").val();
	    var input_address=$("#editaddress").val();

    	if (input_id == "" || input_id == null) {
    		alert("请输入学員id！！！");
    		return false;
    	}

    	if (input_name == "" || input_name == null) {
    		alert("请输入学員姓名！！！");
    		return false;
    	}

    	if (input_birthday == "" || input_birthday == null) {
    		alert("请输入学員出生年月！！！");
	   		return false;
    	}

    	if (input_age == "" || input_age == null) {
    		alert("请输入学員年龄！！！");
    		return false;
    	}

    	if (input_score == "" || input_score == null) {
    		alert("请输入学員成绩！！！");
    		return false;
    	}

	    if (input_classid == "" || input_classid == null) {
	    	alert("请输入クラスID！！！");
	    	return false;
	    }

	    if (input_address == "" || input_address == null) {
	    	alert("请输入住所！！！");
	    	return false;
	    }

		form.submit();
		return true;
		})

	$('#zipone').jpostal({
		postcode : [
			'#zipone'
		],
		address : {
			'#editaddress' : '%3%4%5'
		}
	});

		$("#hyouJi").click(function(){
			var input_nyuuRyoku=$("#nyuuRyoku").val();
			alert(input_nyuuRyoku);
		})

	})







