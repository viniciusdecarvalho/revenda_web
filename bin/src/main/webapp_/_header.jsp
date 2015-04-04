<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
    	<meta name="viewport" content="width=device-width, initial-scale=1">
		
		<link href="<c:url value="/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet" type="text/css"/>
		<link href="<c:url value="/css/normalize.css"/>" rel="stylesheet" type="text/css"/>
		
		<!--[if lt IE 7]>
	    	<script src="http://ie7-js.googlecode.com/svn/version/2.0(beta3)/IE7.js" type="text/javascript"></script>
    	<![endif]-->
		
		<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
	    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
	    <!--[if lt IE 9]>
	      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
	      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	    <![endif]-->
		
		<script type="text/javascript" src="<c:url value='/js/jquery.min.js'/>"></script>
		
		<title>.:Revenda - ${title}:.</title>				
		
	</head>
<body>
    
    <c:set var="path">
    	<c:url value="/"/>
   	</c:set>
    
	<c:if test="${not empty errors}">
		<div>
			<c:forEach items="${errors}" var="error">
				<b>${error.category}</b> - ${error.message} <br/>
			</c:forEach>
		</div>
	</c:if>
	
	<c:if test="${not empty exception}">
		<div> 
			${exception} 
		</div>
	</c:if>
	
	<c:if test="${not empty notice}">
		<div> 
			${notice} 
		</div>
	</c:if>
	
	<c:if test="${ empty userInfo.usuario }">
		<%@ include file="/_login.jsp" %>
	</c:if>
	
	<c:if test="${ not empty userInfo.usuario }">
		<a href="${linkTo[HomeController].logout}" class="btn btn-warning" role="button">LogOut</a>
		<%@ include file="/_menu.jsp" %>
	</c:if>
	
	<div id="content_wrap" class="container">
