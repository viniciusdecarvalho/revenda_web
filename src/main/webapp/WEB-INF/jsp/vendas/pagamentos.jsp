<%@ include file="/WEB-INF/partial/_header.jsp" %>

	<div class="row">
	    <div class="col-lg-12">
	        <h1 class="page-header">${t['venda.tab.pagamento']}</h1>
	    </div>
	    <!-- /.col-lg-12 -->
	</div>
	
	<style>
		th.actions, td.actions {
			width: 5%;
		}
	</style>

	<!-- /.row -->
	<div class="row">
	
	    <div class="col-lg-12">
	        <form id="pagamento" role="form" method="post" action="${linkTo[VendasController].salvaPagamento}" >
	        	<input type="hidden" name="cid" value="${venda.cid}"/>
		        <div class="panel panel-default">
		            <!-- /.panel-heading -->
		            <div class="panel-body">
	                    <div class="form-group inline col-lg-12">	                            
	                        <label>${t['pagamento.descricao']}</label>
	                        <input type="text" class="form-control" name="pagamento.descricao" value="${pagamento.descricao}">
	                    </div>
	                    <div class="form-group inline col-lg-8">
	                      	<label>${t['pagamento.formaPagamento']}</label>
	                      	<select class="form-control" name="pagamento.formaPagamento.id" >
	                      		<c:forEach items="${formasPagamentos}" var="formaPagamento">
	                      			<option value="${formaPagamento.id}">${formaPagamento.nome}</option>
	                      		</c:forEach>                          	                          
	                      	</select>
	                	</div>
	                	<div class="form-group inline col-lg-4">	                            
	                        <label>${t['pagamento.valor']}</label>
	                        <input type="text" class="form-control input-decimal" name="pagamento.valor" value="${pagamento.valor}">
	                    </div>
		            </div>
		            <!-- /.panel-body -->
		            <div class="panel-heading">
			            <button type="submit" form="pagamento" class="btn btn-success" data-toggle="tooltip" title="${t['pagamento.adiciona']}"><i class="fa fa-plus"></i></button>
		            </div>
		        </div>
		        <!-- /.panel -->
	        </form>
            <form role="form" method="post" action="${linkTo[VendasController].salva}" >
            	<input type="hidden" name="cid" value="${venda.cid}"/>
	        <div class="panel panel-default">
	            <div class="panel-heading">
		            <a href="${linkTo[VendasController].venda}?cid=${venda.cid}" class="btn"><i class="fa fa-hand-o-left"></i>${t['botao.anterior']}</a>
		            <button type="submit" class="btn btn-primary"><i class="fa fa-check"></i>${t['botao.conclui']}</button>
	            </div>
	            <!-- /.panel-heading -->
	            <div class="panel-body">
	            
					<strong>${t['pagamento.cadastro'].count(venda.pagamentos.size())}</strong>
					
					<table class="table table-striped table-bordered table-hover">
						<thead>
						  	<tr>
						  		<th class="actions"></th>
							    <th class="descricao">${t['pagamento.coluna.descricao']}</th>
							    <th class="formaPagamento">${t['pagamento.coluna.formaPagamento']}</th>
							    <th class="valor">${t['pagamento.coluna.valor']}</th>
						  	</tr>
					  	</thead>
					  	<tbody>
							<c:forEach items="${venda.venda.pagamentos}" var="pagamento" varStatus="it">
								<tr>		
									<td class="actions">
										<div class="tooltip-demo">
							    			<a href="${linkTo[VendasController].removePagamento(i)}?cid=${venda.cid}" class="btn btn-danger btn-xs" data-toggle="tooltip" data-placement="bottom" title="${t['pagamento.deleta']}"><i class="fa fa-ban"></i></a>
										</div>								    		
							    	</td>							
									<td class="descricao">${pagamento.descricao}</td>
									<td class="formaPagamento">${pagamento.formaPagamento.nome}</td>
							    	<td class="valor">${l[pagamento.valor].pattern("#,##0.00")}</td>	
							  	</tr>
							</c:forEach>
					  	</tbody>							  							  
					</table>
	            </div>
	            <!-- /.panel-body -->
	            <div class="panel-heading">
		            <a href="${linkTo[VendasController].venda}?cid=${venda.cid}" class="btn"><i class="fa fa-hand-o-left"></i>${t['botao.anterior']}</a>
		            <button type="submit" class="btn btn-primary"><i class="fa fa-check"></i>${t['botao.conclui']}</button>
	            </div>
	        </div>
	        <!-- /.panel -->
            </form>
	    </div>	    
	</div>
	<!-- /.row -->
	
<%@ include file="/WEB-INF/partial/_footer.jsp" %>