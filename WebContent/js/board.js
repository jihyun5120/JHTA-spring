let brd = {}

brd.func = function() {
	$("#btnFind").click(function() {
		$("#frm_brd").remove("enctype");
		let param = $("#frm_brd").serialize(); //직렬화
		$.post("select.brd", param, function(data, state) { //url : spring의 url pattern으로 넘어옴.
			$("#main").html(data);
		});
	});
	
	$("#btnRegister").click(function() {
		let fd = new FormData($("#frm_brd")[0]);
		$.ajax({ //encType은 $.post, $.get 등을 사용할 수 없으므로 $.ajax를 사용해야 함.
			url : "insertR.brd",
			type : "post",
			data : fd,
			contentType : false,//옵션
			processData : false,//옵션
			error : function(xhr, status, error) {//옵션
				console.log(error);
			},
			success : function(data, xhr, status) { //status : 어떤 오류가 났는 지.
				$("#main").html(data);
			}
		})
	});
	
	$("#btnModify").click(function() { //수정 폼
		let param = $("#frm_brd").serialize(); 
		$.post("modify.brd", param, function(data, state) { 
			$("#main").html(data);
		});
	});
	
	$("#btnUpdate").click(function() { //수정내용 저장
		let pwd = prompt("수정하려면 암호입력!");
		if (pwd == null || pwd == "") {return;}
		$('[name = "pwd"]').val(pwd);
		
		let fd = new FormData($("#frm_brd")[0]);
		$.ajax({ //encType은 $.post, $.get 등을 사용할 수 없으므로 $.ajax를 사용해야 함.
			url : "modifyR.brd",
			type : "post",
			data : fd,
			contentType : false,//옵션
			processData : false,//옵션
			error : function(xhr, status, error){//옵션
				console.log(error);
			},
			success : function(data, xhr, status){ //status : 어떤 오류가 났는 지.
				$("#main").html(data);
			}
		})
	});
	
	$("#btnDelete").click(function() {
		let pwd = prompt("삭제하려면 암호입력!");
		if (pwd == null || pwd == "") {return;}
		$('[name = "pwd"]').val(pwd);
		let param = $("#frm_brd").serialize(); 
		$.post("deleteR.brd", param, function(data, state) { 
			$("#main").html(data);
		});
	});
	
	$("#btnRepl").click(function() { //답변 폼
		let param = $("#frm_brd").serialize(); 
		$.post("repl.brd", param, function(data, state) { 
			$("#main").html(data);
		});
	});
	
	$("#btnReplR").click(function() { //답변내용 저장
		let fd = new FormData($("#frm_brd")[0]);
		$.ajax({ //encType은 $.post, $.get 등을 사용할 수 없으므로 $.ajax를 사용해야 함.
			url : "replR.brd",
			type :"post",
			data : fd,
			contentType : false,//옵션
			processData : false,//옵션
			error : function(xhr, status, error){//옵션
				console.log(error);
			},
			success : function(data, xhr, status){ //status : 어떤 오류가 났는 지.
				$("#main").html(data);
			}
		})
	});
	
	$("#btnAtt").click(function() {
		let str = "<ol>";
		let files = $("#btnAtt")[0].files; //let files = frm_brd.attFile.files <js type>
		for (f of files) {
			str += "<li>" + f.name + " [ " + parseInt(f.size / 1000) + "kb ]</li>";
		}
		str += "</ol>";
		$("#attList").html(str);
	});
	
}

brd.insert = function() {
	let param = $("#frm_brd").serialize(); 
	$.post("insert.brd", param, function(data, state) { 
		$("#main").html(data);
	});
}

brd.init = function() {
	$("#main").load("select.brd");
}

brd.view = function(serial) {
	$('[name = "serial"]').val(serial);
	let param = $("#frm_brd").serialize(); 
	$.post("view.brd", param, function(data, state) { 
		$("#main").html(data);
	});
}

brd.go = function(nowPage) {
	$('[name = "nowPage"]').val(nowPage);
	let param = $("#frm_brd").serialize(); 
	$.post("select.brd", param, function(data, state) { 
		$("#main").html(data);
	});
}

brd.delCheck = function(box) {
	//let tag = box.parentElement.childNodes[1];
	if (box.checked) {
		$("#tag").css("text-decoration", "line-through"); 
		//tag.style.textDecoration = "line-through";
		$("#tag").css("color", "#f00"); 
		//tag.style.color = "#f00";
	} else {
		tag.style.textDecoration = "";
		tag.style.color = "";
	}
}