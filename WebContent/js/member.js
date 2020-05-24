let mm = {}

mm.func = function() {
	$("#btnLogin").click(function(){
		let param = $("#frm_login").serialize();
		$.post("login.mm", param, function(data, state) {
			$("#main").html(data);
		});
	});
	
	$("#btnLoginR").click(function(){
		let param = $("#frm_login").serialize();
		$.post("loginR.mm", param, function(data, state) {
			location.href = "../index.jsp";
		});
	});
	
	$("#btnLogout").click(function(){
		$.post("logout.mm");
		location.href = "index.jsp";
	});
	
	$("#btnFindId").click(function() {
		let param = $("#frm_mm").serialize();
		$.post("findId.mm", param, function(data, state) {
			$("#main").html(data);
		});
	});
	
	$("#btnId").click(function() {
		let param = $("#frm_mm").serialize();
		$.post("findIdR.mm", param, function(data, state) {
			$("#main").html(data);
		});
	});
	
	$("#btnFind").click(function() {
		let param = $("#frm_mm").serialize();
		$.post("select.mm", param, function(data, state) {
			$("#main").html(data);
		});
	});
	
	$("#btnPhoto").change(function(e) {
		let url = e.target.files[0];
		
		let reader = new FileReader();
		reader.readAsDataURL(url);
		
		reader.onload = function(ev) {
			let img = new Image();
			img.src = ev.target.result;
			$("#photo").attr("src", img.src);
		}
	});
	
	$("#btnRegister").click(function() {
		let fd = new FormData($("#frm_mm")[0]);
		$.ajax({
			url : "insertR.mm",
			type : "post",
			data : fd,
			contentType : false,//옵션
			processData : false,//옵션
			error : function(xhr, status, error) {//옵션
				console.log(error);
			},
			success : function(data, xhr, status) {
				$("#main").html(data);
			}
		})
	});
	
	$("#btnModify").click(function() { //수정 폼
		let param = $("#frm_mm").serialize(); 
		$.post("modify.mm", param, function(data, state) { 
			$("#main").html(data);
		});
	});
	
	$("#btnUpdate").click(function() { //수정내용 저장
		let pwd = prompt("수정하려면 암호입력!");
		if (pwd == null || pwd == "") {return;}
		$('[name = "pwd"]').val(pwd);
		
		let fd = new FormData($("#frm_mm")[0]);
		$.ajax({
			url : "modifyR.mm",
			type : "post",
			data : fd,
			contentType : false,//옵션
			processData : false,//옵션
			error : function(xhr, status, error) {//옵션
				console.log(error);
			},
			success : function(data, xhr, status){ //status : 어떤 오류가 났는 지.
				$("#main").html(data);
			}
		})
	});
	
	$("#btnDelete").click(function() {
		let param = $("#frm_mm").serialize(); 
		$.post("deleteR.mm", param, function(data, state) { 
			$("#main").html(data);
		});
	});
}

mm.init = function() {
	$("#main").load("select.mm");
}

mm.insert = function() {
	let param = $("#frm_mm").serialize(); 
	$.post("insert.mm", param, function(data, state) { 
		$("#main").html(data);
	});	
}

mm.view = function(mId) {
	$('[name = "mId"]').val(mId);
	let param = $("#frm_mm").serialize();
	$.post("view.mm", param, function(data, state) {
		$("#main").html(data);
	});
}

mm.go = function(nowPage) {
	$('[name = "nowPage"]').val(nowPage);
	let param = $("#frm_mm").serialize(); 
	$.post("select.mm", param, function(data, state) { 
		$("#main").html(data);
	});
}