<%@ include file="/partial/header.jsp" %>

	<div class="row">
	    <div class="col-lg-12">
	        <h1 class="page-header">${empty pagamento.id ? t['pagamento.adiciona'] : t['pagamento.edita']}</h1>
	    </div>
	    <!-- /.col-lg-12 -->
	</div>
	
	<!-- /.row -->
	<div class="row">
	    <div class="col-lg-12">
            <form role="form" method="post" action="${linkTo[AquisicoesController].salvaPagamento}" >
	        <div class="panel panel-default">
	            <div class="panel-heading">
		            <button type="submit" class="btn btn-primary"><i class="fa fa-check"></i>${t['botao.confirma']}</button>
					<a href="${linkTo[AquisicoesController].lista }" class="btn btn-danger"><i class="fa fa-times-circle"></i>${t['botao.cancela']}</a>
	            </div>
	            <!-- /.panel-heading -->
	            <div class="panel-body">
	                <input type="hidden" name="pagamento.id" value="${pagamento.id }"/>
	                        	
                    <div class="form-group">
                         <label>${t['pagamento.data'] }</label>
                         <input type="date" class="form-control" name="pagamento.data" value="${pagamento.data}" autofocus />
                   	</div>
                   	<div class="form-group">
                         <label>${t['pagamento.descricao'] }</label>
                         <input type="text" class="form-control" name="pagamento.descricao" value="${pagamento.descricao}" />
                   	</div>
                    <div class="form-group">
                      	<label>${t['pagamento.formaPagamento'] }</label>
                      	<select class="form-control" name="pagamento.formaPagamento" >
                      		<c:forEach items="${formasPagamentos}" var="formaPagamento">
                      			<option value="${formaPagamento.id}">${formaPagamento.nome}</option>
                      		</c:forEach>                          	                          
                      	</select>
                	</div>
                	<div class="form-group">	                            
                        <label>${t['pagamento.valor'] }</label>
                        <input type="text" class="form-control input-decimal" name="pagamento.valor" value="${pagamento.valor}">
                    </div>
	            </div>
	            <!-- /.panel-body -->
	            <div class="panel-heading">
		            <button type="submit" class="btn btn-primary"><i class="fa fa-check"></i>${t['botao.confirma']}</button>
					<a href="${linkTo[AquisicoesController].lista }" class="btn btn-danger"><i class="fa fa-times-circle"></i>${t['botao.cancela']}</a>
	            </div>
	        </div>
	        <!-- /.panel -->
            </form>
	    </div>	    
	</div>
	<!-- /.row -->
	
<%@ include file="/partial/footer.jsp" %>