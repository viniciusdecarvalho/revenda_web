<%@ include file="/WEB-INF/partial/_header.jsp" %>

	<style type="text/css">
		th.razaoSocial {
				
		}
		th.cpfCnpj {
			width: 20%;			
		}
		th.fone {
			width: 20%;		
		}
		th.actions {
			width: 12%;			
		}
		td.razaoSocial {
			text-align: left;
		}
		td.cpfCnpj,
		td.fone,
		td.actions {
			text-align: center;			
		}
   	</style>

	<!-- /.row -->
	<div class="row">
		
		<div class="col-lg-12">
			<div class="row">
				<div class="col-lg-12">
                    <h1 class="page-header"><i class="fa fa-users"><b>${t['cliente.lista']}</b></i></h1>
                </div>
            </div>
			<div class="panel panel-default">
				<div class="panel-body">
					
					<div class="dataTable_wrapper">						
						<div class="col-lg-12 tooltip-demo">
					    	<a 	href="${linkTo[ClientesController].form()}" class="btn btn-success" data-toggle="tooltip" title="${t['cliente.adiciona']}"><i class="fa fa-plus"></i></a>
					    	<strong>${t['cliente.cadastro'].count(clientes.size())}</strong>
						</div>
						<%--
						<div class="col-lg-4">
				           	<form role="form" action="${linkTo[ClientesController].lista}" >
				            	<div class="row panel-body">
				            		<div class="input-group custom-search-form col-lg-12">
					                    <input class="form-control" type="text" name="search.cpfCnpj" value="${search.cpfCnpj}" placeholder="Cpj/Cnpj" />
					                    <span class="input-group-btn">
						                    <button class="btn btn-default" type="button"><i class="fa fa-search"></i></button>
					                	</span>
					                </div>
				            	</div>
				            </form>
				        </div>
						 --%>
						
						<table class="table table-striped table-bordered table-hover" id="dataTablesClientes">
							<thead>
							  	<tr>
								    <th class="razaoSocial">${t['cliente.coluna.razaoSocial']}</th>
								    <th class="cpfCnpj">${t['cliente.coluna.cpfCnpj']}</th>
								    <th class="fone">${t['cliente.coluna.fones']}</th>
								    <th class="actions"></th>
							  	</tr>
						  	</thead>
						  	<tbody>
								<c:forEach items="${clientes}" var="cliente">
									<tr class="${cliente.ativo ? '' : 'danger'}">
								    	<td class="razaoSocial">
								    		<a href="${linkTo[ClientesController].detalhes(cliente.id)}">${cliente.razaoSocial}</a>								    		
							    		</td>
								    	<td class="cpfCnpj">${cliente.cpfCnpj}</td>
								    	<td class="fone">${cliente.contato.fone}  ${cliente.contato.celular}</td>
								    	<td class="actions">
											<div class="tooltip-demo">
								    			<a href="${linkTo[ClientesController].form(cliente.id)}" class="btn btn-default btn-xs" data-toggle="tooltip" data-placement="bottom" title="${t['cliente.edita'] }"><i class="fa fa-edit"></i></a>
								    			<a href="${linkTo[ClientesController].deleta(cliente.id)}" class="btn btn-danger btn-xs" data-toggle="tooltip" data-placement="bottom" title="${t['cliente.deleta'] }"><i class="fa fa-ban"></i></a>
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