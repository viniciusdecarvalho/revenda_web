<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>

<!DOCTYPE html>
<html lang="pt_BR">

	<head>
	
	    <meta charset="utf-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <meta name="description" content="Revenda de Veiculos OnLine">
	    <meta name="author" content="Vinicius de Carvalho">
	    <meta name="reply-to" content="viniciusdecarvalho.tec@gmail.com"/>
		<meta name="keywords" content="carros, motos, veiculos, java, bootstrap, opensource"/>
	
	    <title>${t['app.name']}</title>
	    <link href='<c:url value="/images/favicon.png" />' rel="shortcut icon" type="image/x-icon" />
	
	    <!-- Bootstrap Core CSS -->
	    <link href='<c:url value="/bower_components/bootstrap/dist/css/bootstrap.min.css" />' rel="stylesheet">    
	
	    <!-- MetisMenu CSS -->
	    <link href='<c:url value="/bower_components/metisMenu/dist/metisMenu.min.css" />' rel="stylesheet">
	
		<!-- ++++++++++++++ INDEX ++++++++++++++ -->
		<!-- Timeline CSS -->
	    <link href='<c:url value="/dist/css/timeline.css" />' rel="stylesheet">
	
	    <!-- Morris Charts CSS -->
	    <link href='<c:url value="/bower_components/morrisjs/morris.css" />' rel="stylesheet">
		<!-- ++++++++++++++ INDEX ++++++++++++++ -->
	
		<!-- DataTables CSS -->
	    <link href='<c:url value="/bower_components/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.css" />' rel="stylesheet">
	
	    <!-- DataTables Responsive CSS -->
	    <link href='<c:url value="/bower_components/datatables-responsive/css/dataTables.responsive.css" />' rel="stylesheet">	    	   	   
	
	    <!-- Custom Fonts -->
	    <link href='<c:url value="/bower_components/font-awesome/css/font-awesome.min.css" />' rel="stylesheet" type="text/css">
	
	    <!-- Custom CSS -->
	    <link href='<c:url value="/dist/css/sb-admin-2.css" />' rel="stylesheet">
	    <link href='<c:url value="/dist/css/revenda.css" />' rel="stylesheet">
	    
	    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
	    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
	    <!--[if lt IE 9]>
	        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
	        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
	    <![endif]-->
	</head>
	<body>
	
	<c:set var="path">
		<c:url value="/"/>
	</c:set>
	
	<script type="text/javascript">path = '${path}';</script>
	
	<div id="wrapper">

		<c:if test="${ userInfo.logged }">
	   		
	   		<%@ include file="/WEB-INF/partial/_navigation.jsp" %>
	        
			<div id="page-wrapper">    
           	
        </c:if>
        <%@ include file="/WEB-INF/partial/_notification.jsp" %>
       	