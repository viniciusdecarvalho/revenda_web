<%@ include file="/partial/header.jsp" %>

	<div class="row">
	    <div class="col-lg-12">
	        <h1 class="page-header">${t['aquisicao.adiciona']}</h1>
	    </div>
	    <!-- /.col-lg-12 -->
	</div>
	
	<!-- /.row -->
	<div class="row">
	    <div class="col-lg-12">
            <form role="form" method="post" action="${linkTo[AquisicoesController].salvaAquisicao}?cid=${cid}" >
	        <div class="panel panel-default">
	            <div class="panel-heading">
		            <button type="submit" class="btn btn-primary"><i class="fa fa-check"></i>${t['botao.confirma']}</button>
					<a href="${linkTo[AquisicoesController].lista }" class="btn btn-danger"><i class="fa fa-times-circle"></i>${t['botao.cancela']}</a>
	            </div>
	            <!-- /.panel-heading -->
	            <div class="panel-body">
	                <input type="hidden" name="aquisicao.id" value="${aquisicao.id }"/>
	                        	
                     <div class="form-group">
                         <label>${t['aquisicao.data'] }</label>
                         <input type="date" class="form-control" name="aquisicao.data" value="${aquisicao.data}" autofocus />
                   	</div>
                   	<div class="form-group">
                       	<label>${t['aquisicao.veiculo']}</label>
                       	<select class="form-control" name="aquisicao.veiculo.id" >
                       		<c:forEach items="${veiculos}" var="veiculo">
                           		<option value="${veiculo.id}" ${aquisicao.veiculo eq veiculo ? 'selected' : ''}>${veiculo}</option>                            
                       		</c:forEach>
                       	</select>
					</div>
					<div class="form-group">
                       	<label>${t['aquisicao.cliente']}</label>
                       	<select class="form-control" name="aquisicao.cliente.id" >
                       		<c:forEach items="${clientes}" var="cliente">
                           		<option value="${cliente.id}" ${aquisicao.cliente eq cliente ? 'selected' : ''}>${cliente}</option>                            
                       		</c:forEach>
                       	</select>
					</div>
					<div class="form-group">
						<label>${t['aquisicao.uf'] }</label>
						<input type="text" class="form-control" name="aquisicao.uf" value="${aquisicao.uf}" />
					</div>
					<div class="form-group">
						<label>${t['aquisicao.cidade'] }</label>
						<input type="text" class="form-control" name="aquisicao.cidade" value="${aquisicao.cidade}" />
					</div>
					<div class="form-group">
						<label>${t['aquisicao.cor'] }</label>
						<input type="text" class="form-control" name="aquisicao.cor" value="${aquisicao.cor}" />
					</div>
					<div class="form-group">
                       	<label>${t['aquisicao.combustivel']}</label>
                       	<select class="form-control" name="aquisicao.combustivel" >
                       		<c:forEach items="${combustiveis}" var="combustivel">
                           		<option value="${combustivel}" ${aquisicao.combustivel eq combustivel ? 'selected' : ''}>${combustivel}</option>                            
                       		</c:forEach>
                       	</select>
					</div>
					<div class="form-group">
						<label>${t['aquisicao.km'] }</label>
						<input type="text" class="form-control" name="aquisicao.km" value="${aquisicao.km}" />
					</div>
					<div class="form-group">
						<label>${t['aquisicao.obs'] }</label>
						<textarea rows="3" class="form-control" name="aquisicao.obs">${aquisicao.obs}</textarea>
					</div>
					
					<div class="form-group">
						<label>${t['aquisicao.valor.compra'] }</label>
						<input type="text" class="form-control input-decimal" name="aquisicao.valor" value="${aquisicao.valor}" />
					</div>
					
					<div class="form-group">
                       	<label>${t['aquisicao.vendedor']}</label>
                       	<select class="form-control" name="aquisicao.funcionario.id" >
                       		<c:forEach items="${vendedores}" var="vendedor">
                           		<option value="${vendedor.id}" ${aquisicao.funcionario eq vendedor ? 'selected' : ''}>${vendedor}</option>                            
                       		</c:forEach>
                       	</select>
					</div>
					<div class="form-group">
						<label>${t['aquisicao.valor.comissao'] }</label>
						<input type="text" class="form-control input-decimal" name="aquisicao.valorComissao" value="${aquisicao.valorComissao}" />
					</div>
					
					
					<div class="form-group">
						<label>${t['aquisicao.valor.pedido'] }</label>
						<input type="text" class="form-control input-decimal" name="aquisicao.valorPedido" value="${aquisicao.valorPedido}" />
					</div>
					
					<a 	href="${linkTo[AquisicoesController].formPagamento}?cid=${cid}" class="btn btn-success" data-toggle="tooltip" title="${t['pagamento.adiciona']}"><i class="fa fa-plus"></i></a>
					
					<table class="table table-striped table-bordered table-hover">
						<thead>
						  	<tr>
							    <th class="data">${t['pagamento.coluna.data']}</th>
							    <th class="descricao">${t['pagamento.coluna.descricao']}</th>
							    <th class="formaPagamento">${t['pagamento.coluna.formaPagamento']}</th>
							    <th class="valor">${t['pagamento.coluna.valor']}</th>
						  	</tr>
					  	</thead>
					  	<tbody>
							<c:forEach items="${gastos}" var="gasto">
								<tr>
									<td class="data">${l[pagamento.data].format('short')}</td>
									<td class="descricao">${pagamento.descricao}</td>
									<td class="formaPagamento">${pagamento.formaPagamento}</td>
							    	<td class="valor">${l[pagamento.valor].pattern("#,##0.00")}</td>									
							    	<td class="actions">
										<div class="tooltip-demo">
							    			<a href="${linkTo[AquisicoesController].formPagamento(pagamento.id, aquisicao.id)}" class="btn btn-default btn-xs" data-toggle="tooltip" data-placement="bottom" title="${t['pagamento.edita']}"><i class="fa fa-edit"></i></a>
							    			<a href="${linkTo[AquisicoesController].deletaPagamento(pagamento.id, aquisicao.id)}" class="btn btn-default btn-xs" data-toggle="tooltip" data-placement="bottom" title="${t['pagamento.deleta']}"><i class="fa fa-ban"></i></a>
										</div>								    		
							    	</td>
							  	</tr>
							</c:forEach>
					  	</tbody>
					  							  	
					</table>
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