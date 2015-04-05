<%@ include file="/WEB-INF/partial/_header.jsp" %>

	<style type="text/css">
		th.credito,
		th.debito {
			width: 20%;			
		}
		th.actions {
			width: 12%;			
		}
		td.nome {
			text-align: left;
		}
		td.credito,
		td.debito,
		td.actions {
			text-align: center;			
		}
   	</style>

	<!-- /.row -->
	<div class="row">
		
		<div class="col-lg-12">
			<div class="row">
				<div class="col-lg-12">
                    <h1 class="page-header"><i class="fa fa-money"><b>${t['formaPagamento.lista']}</b></i></h1>
                </div>
            </div>
			<div class="panel panel-default">
				<div class="panel-body">
					
					<div class="dataTable_wrapper">						
						<div class="col-lg-12 tooltip-demo">
					    	<a 	href="${linkTo[FormasPagamentosController].form()}" class="btn btn-success" data-toggle="tooltip" title="${t['formaPagamento.adiciona']}"><i class="fa fa-plus"></i></a>
					    	<strong>${t['formaPagamento.cadastro'].count(formaPagamentos.size())}</strong>
						</div>
						
						<table class="table table-striped table-bordered table-hover">
							<thead>
							  	<tr>
								    <th class="nome">${t['formaPagamento.coluna.nome']}</th>
								    <th class="credito">${t['formaPagamento.coluna.credito']}</th>
								    <th class="debito">${t['formaPagamento.coluna.debito']}</th>
								    <th class="actions"></th>
							  	</tr>
						  	</thead>
						  	<tbody>
								<c:forEach items="${formaPagamentos}" var="formaPagamento">
									<tr class="${formaPagamento.ativo ? '' : 'danger'}">
								    	<td class="nome">${formaPagamento.nome}</td>
								    	<td class="tipo">${formaPagamento.credito ? 'SIM': 'NAO'}</td>
								    	<td class="tipo">${formaPagamento.debito ? 'SIM': 'NAO'}</td>
								    	<td class="actions">
											<div class="tooltip-demo">
								    			<a href="${linkTo[FormasPagamentosController].form(formaPagamento.id)}" class="btn btn-default btn-xs" data-toggle="tooltip" data-placement="bottom" title="${t['formaPagamento.edita'] }"><i class="fa fa-edit"></i></a>
								    			<a href="${linkTo[FormasPagamentosController].deleta(formaPagamento.id)}" class="btn btn-danger btn-xs" data-toggle="tooltip" data-placement="bottom" title="${t['formaPagamento.deleta'] }"><i class="fa fa-ban"></i></a>
											</div>								    		
								    	</td>
								  	</tr>
								</c:forEach>
						  	</tbody>
						  							  	
						</table>
						
					</div>
				</div>				
			</div>				
		</div>
	</div>
<%@ include file="/WEB-INF/partial/_footer.jsp" %>