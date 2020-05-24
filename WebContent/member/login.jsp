<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="member">
	<div id="header">로그인</div>
	<form id="frm_login" name="frm_login" method="post">
		<fieldset>
			<legend> [LOGIN] </legend>
			<label>아이디</label>
			<input type="text" name="mId"/><br/>
			<label>비밀번호</label>
			<input type="password" name="pwd"/><br/>
			<input type="button" id="btnLoginR" value="로그인"/>
			<input type="button" id="btnBack" value="취소" onclick="history.back()"/>
			<br/>
			<a href="">아이디/비밀번호찾기</a>
		</fieldset>
	</form>
</div>
<script>mm.func()</script>