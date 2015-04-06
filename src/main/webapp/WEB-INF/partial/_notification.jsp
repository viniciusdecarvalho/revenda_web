<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
	<c:if test="${not empty notice}">
	     <div class="row">
		 	<div class="col-md-6 col-md-offset-2">
            	<div class="panel-body">
            		<div class="alert alert-info alert-dismissable">
              			<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
              			<div class="alert alert-success alert-dismissable">
              				<i class="fa fa-info"></i>
             				${notice}
             			</div>
              		</div>
                </div>
        	</div>
    	</div> 
	</c:if> 
	
	<c:if test="${not empty errors}">
	     <div class="row">
		 	<div class="col-md-6 col-md-offset-2">
            	<div class="panel-body">
					<div class="alert alert-danger alert-dismissable">
						<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
	           			<c:forEach items="${errors}" var="error">
	           				<div class="alert-danger">
								<i class="fa fa-exclamation-triangle"></i><b>${error.category}</b> - ${error.message} <br/>
							</div>
						</c:forEach>                       
					</div>
                </div>
        	</div>
    	</div> 
	</c:if>   
	
	<c:if test="${not empty exception}">
	     <div class="row">
		 	<div class="col-md-4 col-md-offset-4">
            	<div class="panel-body">     
					<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
					<div class="alert alert-danger alert-dismissable">${exception}</div>					         
                </div>
        	</div>
    	</div> 
	</c:if>