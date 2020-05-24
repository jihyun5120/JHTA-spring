<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="menu">
	<div class="dropdown">
		<button class="dropbtn">자유게시판</button>
		<div class="dropdown-content">
			<a href="#" onclick="brd.init()">게시물 조회</a><!-- getType -->
			<a href="#" onclick="brd.insert()">게시물 작성</a>
		</div>
	</div>
	<div class="dropdown">
		<button class="dropbtn">회원 정보</button>
		<div class="dropdown-content">
			<a href="#" onclick="mm.init()">회원 정보 조회</a>
			<a href="#" onclick="mm.insert()">회원 등록</a>
		</div>
	</div>
	<div id='login'>
		<c:if test="${empty session_id}">
			<input type="button" class="dropbtn" id="btnLogin" value="로그인"/>
		</c:if>
		<c:if test="${session_id != null}">
			[${session_id} 씨 안뇽!]
			<input type="button" class="dropbtn" id="btnLogout" value="로그아웃"/>
		</c:if>
	</div>
</div>

<header id='mainHeader'>SPRING 이야기</header>
<script>mm.func()</script>