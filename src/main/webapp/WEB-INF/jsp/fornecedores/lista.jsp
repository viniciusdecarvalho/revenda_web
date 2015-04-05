<%@ include file="/WEB-INF/partial/_header.jsp" %>

	<style type="text/css">
		th.cpfCnpj {
			width: 20%;			
		}
		th.actions {
			width: 12%;			
		}
		td.razaoSocial {
			text-align: left;
		}
		td.cpfCnpj,
		td.actions {
			text-align: center;			
		}
   	</style>

	<!-- /.row -->
	<div class="row">
		
		<div class="col-lg-12">
			<div class="row">
				<div class="col-lg-12">
                    <h1 class="page-header"><i class="fa fa-building"><b>${t['fornecedor.lista']}</b></i></h1>
                </div>
            </div>
			<div class="panel panel-default">
				<div class="panel-body">
					
					<div class="dataTable_wrapper">						
						<div class="col-lg-12 tooltip-demo">
					    	<a 	href="${linkTo[FornecedoresController].form()}" class="btn btn-success" data-toggle="tooltip" title="${t['fornecedor.adiciona']}"><i class="fa fa-plus"></i></a>
					    	<strong>${t['fornecedor.cadastro'].count(fornecedores.size())}</strong>
						</div>
						
						<table class="table table-striped table-bordered table-hover">
							<thead>
							  	<tr>
								    <th class="razaoSocial">${t['fornecedor.coluna.razaoSocial']}</th>
								    <th class="cpfCnpj">${t['fornecedor.coluna.cpfCnpj']}</th>
								    <th class="actions"></th>
							  	</tr>
						  	</thead>
						  	<tbody>
								<c:forEach items="${fornecedores}" var="fornecedor">
									<tr class="${fornecedor.ativo ? '' : 'danger'}">
								    	<td class="razaoSocial">${fornecedor.razaoSocial}</td>
								    	<td class="cpfCnpj">${fornecedor.cpfCnpj}</td>
								    	<td class="actions">
											<div class="tooltip-demo">
								    			<a href="${linkTo[FornecedoresController].form(fornecedor.id)}" class="btn btn-default btn-xs" data-toggle="tooltip" data-placement="bottom" title="${t['fornecedor.edita'] }"><i class="fa fa-edit"></i></a>
								    			<a href="${linkTo[FornecedoresController].deleta(fornecedor.id)}" class="btn btn-danger btn-xs" data-toggle="tooltip" data-placement="bottom" title="${t['fornecedor.deleta'] }"><i class="fa fa-ban"></i></a>
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