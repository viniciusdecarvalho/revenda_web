<%@ include file="/partial/header.jsp" %>		

	<div class="row">
	    <div class="col-lg-12">
	        <h1 class="page-header">
	        	Detalhes do Cliente
	        </h1>
	    </div>
	    <!-- /.col-lg-12 -->
	</div>

	<!-- /.row -->
	<div class="row">
	    <div class="col-lg-12">
            <form role="form" action="${linkTo[ClientesController].deleta(cliente.id) }" method="post">
	        <div class="panel panel-default">
	            <div class="panel-heading">
		            <button type="submit" class="btn btn-danger"><i class="fa fa-check"></i>Deletar</button>
		            <a href="${linkTo[ClientesController].lista }" class="btn btn-default"><i class="fa fa-times-circle"></i>Voltar</a>
	            </div>	
	            <!-- /.panel-heading -->
	            <div class="panel-body">
	                <!-- Nav tabs -->
	                <ul class="nav nav-tabs">
	                    <li class="active"><a href="#cliente_id" data-toggle="tab">Dados</a>
	                    </li>
	                    <li><a href="#cliente_endereco" data-toggle="tab">Endereço</a>
	                    </li>
	                    <li><a href="#cliente_contato" data-toggle="tab">Contatos</a>
	                    </li>	                    
	                </ul>
	
	                <!-- Tab panes -->
	                <div class="tab-content">
	                    <div class="tab-pane fade in active" id="cliente_id">
	                        <h4>Dados</h4>
	                        <input type="hidden" name="cliente.id" value="${cliente.id }"/>
	                        	
                            <div class="form-group">
                                <label>Nome ou Razao Social</label>
                                <input type="text" class="form-control" name="cliente.razaoSocial" value="${cliente.razaoSocial}" disabled />
                            </div>
                            <div class="form-group">
                                <label>Cpf ou Cnpj</label>
                                <input type="text" class="form-control" name="cliente.cpfCnpj" value="${cliente.cpfCnpj}" disabled />
                            </div>
                            <div class="form-group">
                                 <label>Ativo</label>
                                 <select class="form-control" name="cliente.ativo" disabled>
                                     <option value="true" ${cliente.ativo ? 'selected' : ''}>Sim</option>
                                     <option value="false" ${not cliente.ativo ? 'selected' : ''}>Não</option>
                                 </select>
                            </div>
	                    </div>
	                    <div class="tab-pane fade" id="cliente_endereco">
	                        <h4>Endereço</h4>
                            <div class="form-group">
                                <label>Cep</label>
                                <input type="text" class="form-control" name="cliente.cep" value="${cliente.cep}" disabled />
                            </div>
	                        <div class="form-group">
                                <label>UF</label>
                                <input type="text" class="form-control" name="cliente.estado" value="${cliente.estado}" disabled />
                            </div>
                            <div class="form-group">
                                <label>Cidade</label>
                                <input type="text" class="form-control" name="cliente.cidade" value="${cliente.cidade}" disabled />
                            </div>
                            <div class="form-group">
                                <label>Logradouro</label>
                                <input type="text" class="form-control" name="cliente.logradouro" value="${cliente.logradouro}" disabled/>
                            </div>
                            <div class="form-group">
                                <label>Complemento</label>
                                <input type="text" class="form-control" name="cliente.complemento" value="${cliente.complemento}" disabled/>
                            </div>
	                    </div>
	                    <div class="tab-pane fade" id="cliente_contato">
	                        <h4>Contato</h4>
	                        <label>Telefones</label>
	                        <div class="form-inline">
		                        <div class="form-group">
	                                <label class="sr-only">Residencial</label>
	                                <input type="tel" class="form-control" name="cliente.fone" value="${cliente.fone}" disabled/>
	                            </div>
	                            <div class="form-group">
	                                <label class="sr-only">Celular</label>
	                                <input type="tel" class="form-control" name="cliente.celular" value="${cliente.celular}" disabled />
	                            </div>
	                        </div>
                            <div class="form-group">
                                <label>E-Mail</label>
                                <input type="email" class="form-control" name="cliente.email" value="${cliente.email}" disabled />
                            </div>	                        
	                    </div>
	                </div>
	            </div>
	            <!-- /.panel-body -->
	            <div class="panel-heading">
		            <button type="submit" class="btn btn-danger"><i class="fa fa-check"></i>Deletar</button>
		            <a href="${linkTo[ClientesController].lista }" class="btn btn-default"><i class="fa fa-times-circle"></i>Voltar</a>
	            </div>
	        </div>
	        <!-- /.panel -->
            </form>
	    </div>	    
	</div>
	<!-- /.row -->
<%@ include file="/partial/footer.jsp" %>