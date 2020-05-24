<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="board">
	<div id="header">댓글 등록</div>
	<form id="frm_brd" name="frm_brd" method="post">
		<label>작성자</label>
		<input type="text" name="id" value="나는댓글" readonly/><br/>
		
		<label>제 목</label>
		<input type="text" name="subject" size="90" /><br/>
		<textarea name="content" class="content"></textarea><br/>


		<label>암호</label>
		<input type="password" name="pwd" /><br/>
	
		<fieldset><legend>[ 파일 첨부 ]</legend>
			<input type="file" multiple="multiple" name="attFile"><hr/>
			<div id="attList"></div>
		</fieldset>
		
		<input type="button" id="btnReplR" value="답변저장"/>
		<input type="button" id="btnFind" value="취소"/>
		<input type="hidden" name="nowPage" value="${param.nowPage}"/>
		<input type="hidden" name="findStr" value="${param.findStr}"/>
		<input type="hidden" name="pSerial" value="${param.serial}"/>
	</form>
</div>
<script>brd.func()</script>