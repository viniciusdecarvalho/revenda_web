<%@ include file="/WEB-INF/partial/_header.jsp" %>		

	<div class="row">
	    <div class="col-lg-12">
	        <h1 class="page-header">${t['aquisicao.detalhe']}</h1>
	    </div>
	    <!-- /.col-lg-12 -->
	</div>

	<!-- /.row -->
	<div class="row">
	    <div class="col-lg-12">
            <form role="form">
	        <div class="panel panel-default">
	            <div class="panel-heading">
		            <a href="${linkTo[AquisicoesController].lista}" class="btn btn-default">${t['botao.volta']}</a>
	            </div>	
	            <!-- /.panel-heading -->
	            <div class="panel-body">
	                <!-- Nav tabs -->
	                <ul class="nav nav-tabs">
	                    <li class="active"><a href="#aquisicao_veiculo" data-toggle="tab">${t['aquisicao.veiculo']}</a>
	                    </li>
	                    <li><a href="#aquisicao_cliente" data-toggle="tab">${t['aquisicao.cliente']}</a>
	                    </li>
	                    <li><a href="#aquisicao_financeiro" data-toggle="tab">${t['aquisicao.financeiro']}</a>
	                    </li>	                    
	                </ul>
	
	                <!-- Tab panes -->
	                <div class="tab-content">
	                    <div class="tab-pane fade in active" id="aquisicao_veiculo">
	                        <h4>${t['aquisicao.veiculo']}</h4>
	                        <input type="hidden" name="aquisicao.id" value="${aquisicao.id }"/>
	                        	
                        	<c:set value="${aquisicao.cliente}" var="cliente" />
                        	<c:set value="${aquisicao.veiculo}" var="veiculo" />
	                        	
                            <div class="form-group">
		                         <label>${t['veiculo.placa'] }</label>
		                         <input type="text" class="form-control" name="veiculo.placa" value="${veiculo.placa}" disabled />
		                   	</div>
		                   	<div class="form-group">
								<label>${t['veiculo.marca'] }</label>
								<input type="text" class="form-control" name="veiculo.marca" value="${veiculo.marca}" disabled />
							</div>
							<div class="form-group">
								<label>${t['veiculo.modelo'] }</label>
								<input type="text" class="form-control" name="veiculo.modelo" value="${veiculo.modelo}" disabled />
							</div>
							<div class="form-group">
								<label>${t['veiculo.ano'] }</label>
								<input type="text" class="form-control" name="veiculo.ano" placeholder="XXXX/XXXX" value="${veiculo.ano}" disabled />
							</div>
							<div class="form-group">
								<label>${t['veiculo.especie'] }</label>
								<input type="text" class="form-control" name="veiculo.especie" value="${veiculo.especie}" disabled />								
							</div>
							<div class="form-group">
								<label>${t['veiculo.chassi'] }</label>
								<input type="text" class="form-control" name="veiculo.chassi" value="${veiculo.chassi}" disabled />
							</div>
							<div class="form-group">
								<label>${t['veiculo.renavan'] }</label>
								<input type="text" class="form-control" name="veiculo.renavan" value="${veiculo.renavan}" disabled />
							</div>
	                    </div>
	                    <div class="tab-pane fade" id="aquisicao_cliente">
	                        <h4>${t['aquisicao.cliente']}</h4>
                            <div class="form-group">
                                <label>${t['cliente.razaoSocial']}</label>
                                <input type="text" class="form-control" name="cliente.razaoSocial" placeholder="${t['cliente.razaoSocial'] }" value="${cliente.razaoSocial}" disabled>
                            </div>
                            <div class="form-group">	                            
                                <label>${t['cliente.cpfCnpj'] }</label>                                
                                <input type="text" class="form-control input-cpfcnpj" name="cliente.cpfCnpj" placeholder="${t['cliente.cpfCnpj']}" value="${cliente.cpfCnpj}" disabled>
                            </div>
                            <h4>${t['cliente.contato']}</h4>
	                        <label>${t['cliente.contato.fone']}</label>
	                        <div class="form-inline">
		                        <div class="form-group">
	                                <label class="sr-only">${t['cliente.contato.fone']}</label>
	                                <input type="tel" class="form-control" name="cliente.contato.fone" placeholder="${t['cliente.contato.fone']}" value="${cliente.contato.fone}" disabled/>
	                            </div>
	                            <div class="form-group">
	                                <label class="sr-only">${t['cliente.contato.celular']}</label>
	                                <input type="tel" class="form-control" name="cliente.contato.celular" placeholder="${t['cliente.contato.celular']}" value="${cliente.contato.celular}" disabled />
	                            </div>
	                        </div>
                            <div class="form-group">
                                <label>${t['cliente.contato.email']}</label>
                                <input type="email" class="form-control" name="cliente.contato.email" placeholder="${t['cliente.contato.email']}" value="${cliente.contato.email}" disabled />
                            </div>
	                    </div>
	                    <div class="tab-pane fade" id="aquisicao_financeiro">
	                        <h4>${t['aquisicao.financeiro']}</h4>
	                        <!-- Nav tabs -->
			                <ul class="nav nav-tabs">
			                    <li class="active"><a href="#financeiro_valores" data-toggle="tab">${t['aquisicao.financeiro.valores']}</a>
			                    </li>
			                    <li><a href="#financeiro_pagamentos" data-toggle="tab">${t['aquisicao.financeiro.pagamentos']}</a>
			                    </li>
			                    <li><a href="#financeiro_gastos" data-toggle="tab">${t['aquisicao.financeiro.gastos']}</a>
			                    </li>	                    
			                </ul>
			                
			                <!-- Tab panes -->
			                <div class="tab-content">
			                    <div class="tab-pane fade in active" id="financeiro_valores">
			                    	<div class="form-group">
				                         <label>${t['aquisicao.data']}</label>
				                         <input type="date" class="form-control" name="aquisicao.data" value="${l[aquisicao.data].pattern('yyyy-MM-dd')}" autofocus />
				               	 	</div>						
									<div class="form-group">
										<label>${t['aquisicao.valor.compra']}</label>
										<input type="text" class="form-control input-decimal" name="aquisicao.valor" value="${aquisicao.valor}" />
									</div>
									<div class="form-group">
										<label>${t['aquisicao.valor.pedido']}</label>
										<input type="text" class="form-control input-decimal" name="aquisicao.valorPedido" value="${aquisicao.valorPedido}" />
									</div>
									<div class="form-group">
										<label>${t['aquisicao.obs']}</label>
										<textarea rows="3" class="form-control" name="aquisicao.obs">${aquisicao.obs}</textarea>
									</div>
			                    </div>
			                    <div class="tab-pane fade in active" id="financeiro_pagamentos">
			                    	<strong>${t['pagamento.cadastro'].count(aquisicao.pagamentos.size())}</strong>
					
									<table class="table table-striped table-bordered table-hover">
										<thead>
										  	<tr>										  		
											    <th class="descricao">${t['pagamento.coluna.descricao']}</th>
											    <th class="formaPagamento">${t['pagamento.coluna.formaPagamento']}</th>
											    <th class="valor">${t['pagamento.coluna.valor']}</th>
										  	</tr>
									  	</thead>
									  	<tbody>
											<c:forEach items="${aquisicao.pagamentos}" var="pagamento">																						
												<tr>					
													<td class="descricao">${pagamento.descricao}</td>
													<td class="formaPagamento">${pagamento.formaPagamento.nome}</td>
											    	<td class="valor">${l[pagamento.valor].pattern("#,##0.00")}</td>	
											  	</tr>
											</c:forEach>
									  	</tbody>							  							  
									</table>
			                    </div>
			                    <div class="tab-pane fade in active" id="financeiro_gastos">
			                    </div>
		                   	</div>
	                    </div>
	                </div>
	            </div>
	            <!-- /.panel-body -->
	            <div class="panel-heading">
		            <a href="${linkTo[AquisicoesController].lista}" class="btn btn-default">${t['botao.volta']}</a>
	            </div>
	        </div>
	        <!-- /.panel -->
            </form>
	    </div>	    
	</div>
	<!-- /.row -->
<%@ include file="/WEB-INF/partial/_footer.jsp" %>