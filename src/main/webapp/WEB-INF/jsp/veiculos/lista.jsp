<%@ include file="/WEB-INF/partial/_header.jsp" %>

	<style type="text/css">
		th.placa {
			width: 10%;			
		}
		th.marca {
			width: 10%;			
		}
		th.modelo {
			width: 25%;			
		}
		th.ano {
			width: 10%;			
		}
		th.especie {
			width: 15%;			
		}
		th.chassi {
			width: 10%;			
		}
		th.renavan {
			width: 8%;			
		}
		th.actions {
			width: 12%;			
		}
		td.marca, td.modelo, td.especie {
			text-align: left;
		}
		td.placa,
		td.ano,
		td.renavan,
		td.chassi,
		td.actions {
			text-align: center;			
		}
   	</style>

	<!-- /.row -->
	<div class="row">
		
		<div class="col-lg-12">
			<div class="row">
				<div class="col-lg-12">
                    <h1 class="page-header"><i class="fa fa-car"><b>${t['veiculo.lista']}</b></i></h1>
                </div>
            </div>
			<div class="panel panel-default">
				<div class="panel-body">
					
					<div class="dataTable_wrapper">						
						<div class="col-lg-12 tooltip-demo">
					    	<a 	href="${linkTo[VeiculosController].form()}" class="btn btn-success" data-toggle="tooltip" title="${t['veiculo.adiciona']}"><i class="fa fa-plus"></i></a>
					    	<strong>${t['veiculo.cadastro'].count(veiculos.size())}</strong>
						</div>
						
						<table class="table table-striped table-bordered table-hover">
							<thead>
							  	<tr>
								    <th class="marca">${t['veiculo.coluna.marca']}</th>
								    <th class="modelo">${t['veiculo.coluna.modelo']}</th>
								    <th class="ano">${t['veiculo.coluna.ano']}</th>
								    <th class="placa">${t['veiculo.coluna.placa']}</th>
								    <th class="especie">${t['veiculo.coluna.especie']}</th>
								    <th class="renavan">${t['veiculo.coluna.renavan']}</th>
								    <th class="chassi">${t['veiculo.coluna.chassi']}</th>
								    <th class="actions"></th>
							  	</tr>
						  	</thead>
						  	<tbody>
								<c:forEach items="${veiculos}" var="veiculo">
									<tr>
										<td class="marca">${veiculo.marca}</td>
										<td class="modelo">${veiculo.modelo}</td>
										<td class="ano">${veiculo.ano}</td>
								    	<td class="placa">${veiculo.placa}</td>
										<td class="especie">${veiculo.especie}</td>
										<td class="renavan">${veiculo.renavan}</td>
										<td class="chassi">${veiculo.chassi}</td>
								    	<td class="actions">
											<div class="tooltip-demo">
								    			<a href="${linkTo[VeiculosController].form(veiculo.id)}" class="btn btn-default btn-xs" data-toggle="tooltip" data-placement="bottom" title="${t['veiculo.edita'] }"><i class="fa fa-edit"></i></a>
								    			<a href="${linkTo[VeiculosController].deleta(veiculo.id)}" class="btn btn-danger btn-xs" data-toggle="tooltip" data-placement="bottom" title="${t['veiculo.deleta'] }"><i class="fa fa-ban"></i></a>
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