<!-- Navigation -->
<nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
	<div class="navbar-header">
	    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
	        <span class="sr-only"></span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	    </button>
	    <a class="navbar-brand" href="${linkTo[HomeController].home }"><span class=""></span>${t['app.name']}</a>
	</div>
	<!-- /.navbar-header -->

	<ul class="nav navbar-top-links navbar-right">
	    <!-- /.dropdown -->
	    <li class="dropdown">
	        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
	            <i class="fa fa-user fa-fw"></i>  <i class="fa fa-caret-down"></i>
	        </a>
	        <ul class="dropdown-menu dropdown-user">
	            <li><a href="#"><i class="fa fa-user fa-fw"></i>${t['app.perfil']}</a>
	            </li>
	            <li><a href="#"><i class="fa fa-gear fa-fw"></i>${t['app.configuracao']}</a>
	            </li>
	            <li class="divider"></li>
	            <li><a href="${linkTo[HomeController].logout }"><i class="fa fa-sign-out fa-fw"></i>${t['app.sair']}</a>
	            </li>
	        </ul>
	        <!-- /.dropdown-user -->
	    </li>
	    <!-- /.dropdown -->
	</ul>
	<!-- /.navbar-top-links -->
	
	<%@ include file="/WEB-INF/partial/_sidebar.jsp" %>
           	
     <!-- /.navbar-static-side -->
</nav>