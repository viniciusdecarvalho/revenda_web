				</div>
				<!-- /#page-wrapper -->
			</div>
   			<!-- /#wrapper -->
    		
    	<c:if test="${ userInfo.logged }">	
	    	<nav class="navbar navbar-default navbar-static-bottom" role="navigation" style="margin-bottom: 0">
	    		<p>
	              	Analise e Desenvolvimento de Sistemas | Faculdade Lourenço Filho
	        	</p>
	    	</nav>
    	</c:if>
    	
	    <!-- jQuery -->
	    <script src='<c:url value="/bower_components/jquery/dist/jquery.min.js"/>' ></script>
	
	    <!-- Bootstrap Core JavaScript -->
	    <script src='<c:url value="/bower_components/bootstrap/dist/js/bootstrap.min.js"/>' ></script>
	
	    <!-- Metis Menu Plugin JavaScript -->
	    <script src='<c:url value="/bower_components/metisMenu/dist/metisMenu.min.js"/>' ></script>	   	   
	
	    <!-- Morris Charts JavaScript -->
	    <!-- 
	    <script src='<c:url value="/bower_components/raphael/raphael-min.js"/>' ></script>
	    <script src='<c:url value="/bower_components/morrisjs/morris.min.js"/>' ></script>
	    <script src='<c:url value="/js/morris-data.js"/>' ></script>
	     -->
	
		<!-- DataTables JavaScript -->
	    <script src='<c:url value="/bower_components/datatables/media/js/jquery.dataTables.min.js"/>'></script>
	    <script src='<c:url value="/bower_components/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.min.js"/>'></script>
	
		<script src='<c:url value="/bower_components/mask/jquery.mask.min.js"/>'></script>
	
	    <!-- Custom Theme JavaScript -->
	    <script src='<c:url value="/dist/js/sb-admin-2.js"/>' ></script>
	    
	    <!-- Custom Theme JavaScript -->
	    <script src='<c:url value="/dist/js/revenda.js"/>' ></script>
	
		<script>
		    // tooltip demo
		    $('.tooltip-demo').tooltip({
		        selector: "[data-toggle=tooltip]",
		        container: "body"
		    })
		
		    // popover demo
		    $("[data-toggle=popover]").popover()
	    </script>	
	    
	</body>

</html>
