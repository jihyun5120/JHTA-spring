<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" type="text/css" href="./css/board.css"/>
<div id="member">
	<div id="header">회원 등록</div>
	<form id="frm_mm" name="frm_mm" method="post" enctype="multipart/form-data">
		<label>아이디</label>
		<input type="text" name="mId"><br/>
		<label>성 명</label>
		<input type="text" name="mName"><br/>
			
		<label>등록일</label>
		<input type="date" name="rDate"><br/>
		
		<label>학년</label>
		<select name="grade">
			<option value="1">1 학년</option>
			<option value="2">2학년</option>
			<option value="3">3학년</option>
			<option value="4">4학년</option>
			<option value="5">5학년</option>
			<option value="6">6학년</option>
			<option value="7">7학년</option>
			<option value="8">8학년</option>
			<option value="9">9학년</option>
			<option value="10">10학년</option>
		</select><br/>

		<label>암호</label>
		<input type="password" name="pwd"><br/>
		
		<label>증명사진</label>
		<span class="in_photo"><img id="photo" src="./images/profile.PNG"></span>
		<input type="file" id="btnPhoto" name="photo">
		<div id="button">
			<input type="button" id="btnRegister" value="저장"/>
			<input type="button" id="btnFind" value="취소"/>
			<input type="hidden" name="nowPage" value="${param.nowPage}"/>
			<input type="hidden" name="findStr" value="${param.findStr}"/>
		</div>
	</form>
</div>
<script>mm.func()</script>