<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="member">
	<div id="header">회원 정보 상세보기</div>
	<form id="frm_mm" name="frm_mm" method="post">
	
		<label>아이디</label>
		<input type="text" name="mId" value="${vo.mId}" readonly/><br/>
		<label>성 명</label>
		<input type="text" name="mName" value="${vo.mName}" readonly/><br/>
		<label>등록일</label>
		<input type="date" name="rDate" value="${vo.rDate}" readonly/><br/>
		<label>학년</label>
		<input type="text" name="grade" value="${vo.grade}" readonly/>
		<br/>
		<label>증명사진</label>
		<span class="in_photo"><img id="photo" src="./photo/${vo.photos[0].sysFile}"></span>
		<div id="button">
			<input type="button" id="btnModify" value="회원수정"/>
			<input type="button" id="btnDelete" value="회원탈퇴"/>
			<input type="button" id="btnFind" value="취소"/>
			<input type="hidden" name="nowPage" value="${p.nowPage}"/>
			<input type="hidden" name="findStr" value="${p.findStr}"/>
		</div>
	</form>
</div>
<script>mm.func()</script>