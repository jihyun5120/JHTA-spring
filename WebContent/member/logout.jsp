<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="member">
	<div id="header">로그아웃</div>
	<form id="frm_mm" name="frm_mm" method="post">
		<input type="button" id="btnLogout" value="로그아웃"/>
		<input type="text" name="nowPage" value="${nowPage}"/>
		<input type="text" name="findStr" value="${findStr}"/>
	</form>
</div>