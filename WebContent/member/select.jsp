<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div id="member">
	<div id="header">회원 정보 조회</div>
	<form id="frm_mm" name="frm_mm" method="post">
		<div id="button">
			<input type="text" id="findStr" name="findStr" value="${p.findStr}" size="50"/>
			<input type="button" id="btnFind" value="검색"/>
			<input type="hidden" name="nowPage" value="${p.nowPage}"/>
			<input type="hidden" name="mId" />
		</div>
	</form>
	<div class="list">
		<c:forEach var="i" items="${list}">
			<div class="items" onclick="mm.view('${i.mId}')">
				<span class="mId">아이디 : ${i.mId}</span>
				<span class="mName">성명 : ${i.mName}</span>
				<span class="rDate">등록일 : ${i.rDate}</span>
				<span class="grade">학년 : ${i.grade}</span>
				<c:choose>
					<c:when test="${fn:length(i.photos) == 0}">
						<span class="photo"><img src="./images/profile.PNG"></span>
					</c:when>
					<c:otherwise>
						<c:forEach var="p" items="${i.photos}">
							<span class="photo"><img src="./photo/${p.sysFile}"></span>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</div>		
		</c:forEach>
	</div>
	
	<div id="paging">
		<c:if test="${p.startPage > p.blockSize}">
			<input type="button" value="이전 " onclick = "mm.go(${p.startPage - 1})" />
		</c:if>
		<c:forEach var="i" begin="${p.startPage}" end="${p.endPage}">
			<input type="button" value="${i}" class="${(i==p.nowPage)? 'here' : '' }" onclick="mm.go(${i})" />
		</c:forEach>
		<c:if test="${p.endPage < p.totPage}">
			<input type="button" value="다음 " onclick="mm.go(${p.endPage + 1})" />
		</c:if>
	</div>
</div>	
<script>mm.func()</script>