<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="board">
	<div id="header">결과</div>
	${msg}
	<form id="frm_brd" name="frm_brd" method="post">
		<div id="button">
			<input type="button" id="btnFind" value="게시물 목록"/>
			<input type="hidden" name="nowPage" value="${p.nowPage}"/>
			<input type="hidden" name="btnFind" value="${p.findStr}"/>
		</div>
	</form>
</div>
<script>brd.func()</script>