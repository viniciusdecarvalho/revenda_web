<%@ include file="/WEB-INF/partial/_header.jsp" %>

	<style type="text/css">
		th.data {
			width: 10%;			
		}
		th.veiculo {
			width: 25%;			
		}
		th.cliente {
			width: 25%;			
		}
		th.valor-compra {
			width: 10%;			
		}
		th.valor-pedido {
			width: 10%;			
		}
		th.valor-custo {
			width: 10%;			
		}
		th.actions {
			width: 10%;			
		}
		td.veiculo, td.cliente {
			text-align: left;
		}
		td.data,
		td.valor-compra,
		td.valor-custo,
		td.valor-pedido,
		td.actions {
			text-align: center;			
		}
   	</style>

	<!-- /.row -->
	<div class="row">
		
		<div class="col-lg-12">
			<div class="row">
				<div class="col-lg-12">
                    <h1 class="page-header"><i class="fa fa-car"><b>${t['venda.lista']}</b></i></h1>
                </div>
            </div>
			<div class="panel panel-default">
				<div class="panel-body">
					
					<div class="dataTable_wrapper">						
						<div class="col-lg-12 tooltip-demo">
					    	<a href="${linkTo[VendasController].veiculo}" class="btn btn-success" data-toggle="tooltip" title="${t['venda.adiciona']}"><i class="fa fa-plus"></i></a>
					    	<strong>${t['venda.cadastro'].count(aquisicoes.size())}</strong>
						</div>
						
						<table class="table table-striped table-bordered table-hover">
							<thead>
							  	<tr>
								    <th class="data">${t['venda.coluna.data']}</th>
								    <th class="veiculo">${t['venda.coluna.veiculo']}</th>
								    <th class="cliente">${t['venda.coluna.cliente']}</th>
								    <th class="valorcompra">${t['venda.coluna.valor.venda']}</th>
								    <th class="valorpedido">${t['venda.coluna.valor.lucro']}</th>								    									
								    <th class="actions"></th>
							  	</tr>
						  	</thead>
						  	<tbody>
								<c:forEach items="${vendas}" var="venda">
									<tr>										
										<td class="data">${l[venda.data].format('short')}</td>
										<td class="veiculo">${venda.veiculo.placa}</td>
										<td class="cliente">${venda.cliente.razaoSocial}</td>
								    	<td class="valor-compra">${l[venda.valor].pattern("#,##0.00")}</td>										
										<td class="valor-lucro">${l[venda.lucro].pattern("#,##0.00")}</td>
								    	<td class="actions">
											<div class="tooltip-demo">
<%-- 								    			<a href="${linkTo[VendasController].detalhes(venda.id)}" class="btn btn-default btn-xs" data-toggle="tooltip" data-placement="bottom" title="${t['venda.detalhe']}"><i class="fa fa-edit"></i></a> --%>
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