<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="member">
	<div id="header">결과</div>
	${msg}
	<form id="frm_mm" name="frm_mm" method="post">
		<input type="button" id="btnFind" value="회원조회 "/>
		<input type="text" name="nowPage" value="${param.nowPage}"/>
		<input type="text" name="findStr" value="${param.findStr}"/>
	</form>
</div>
<script>mm.func()</script>