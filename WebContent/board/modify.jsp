<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="board">
	<div id="header">게시글 수정</div>
	<form id="frm_brd" name="frm_brd" method="post" enctype="multipart/form-data">
		<label>작성자</label>
		<input type="text" name="id" value="${vo.id}" readonly/><br/>
		
		<label>제 목</label>
		<input type="text" name="subject" size="90" value="${vo.subject}"/><br/>
		<textarea name="content" class="content">${vo.content}</textarea><br/>

		<fieldset><legend>[ 파일 첨부 ]</legend>
			<input type="file" id="btnAtt" name="attFile" multiple="multiple" ><hr/>
			<div id="attList"></div>
		</fieldset>	
		
		<fieldset><legend>[ 첨부된 파일 ]</legend>
			<c:forEach var="i" items="${attList}">
				<div>
					<span id="tag">${i.oriFile}</span> 
						<input type="checkbox" name="delFile" value="${i.sysFile}" onclick="brd.delCheck(this)"/>
				</div>
			</c:forEach>		
		</fieldset>
	
		<div id="button">
			<input type="button" id="btnUpdate" value="수정"/>
			<input type="button" id="btnFind" value="취소"/>
			<input type="hidden" name="pwd"/>
			<input type="hidden" name="nowPage" value="${p.nowPage}"/>
			<input type="hidden" name="findStr" value="${p.findStr}"/>
			<input type="hidden" name="serial" value="${vo.serial}"/>
		</div>
	</form>
</div>
<script>brd.func()</script>