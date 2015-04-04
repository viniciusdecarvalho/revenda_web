<%@ include file="/partial/header.jsp" %>
	<div class="row">
	    <div class="col-lg-12">
	        <h1 class="page-header">
	        	<c:if test="${empty cliente.razaoSocial }">
	        		Novo Cliente
	        	</c:if>
	        	<c:if test="${not empty cliente.razaoSocial }">
	        		Editar Cliente
	        	</c:if>
	        </h1>
	    </div>
	    <!-- /.col-lg-12 -->
	</div>
	
	
	<!-- /.row -->
	<div class="row">
	    <div class="col-lg-12">
            <form role="form" method="post" action="${linkTo[ClientesController].salva}" >
	        <div class="panel panel-default">
	            <div class="panel-heading">
		            <c:import url="form_toolbar.jsp" />
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
                                <input type="text" class="form-control" name="cliente.razaoSocial" placeholder="Nome ou Razao Social" value="${cliente.razaoSocial}">
                            </div>
                            <div class="form-group">
                                <label>Cpf ou Cnpj</label>
                                <input type="text" class="form-control" name="cliente.cpfCnpj" placeholder="Cpf ou Cnpj" value="${cliente.cpfCnpj}">
                            </div>
                            <div class="form-group">
                                  <label>Ativo</label>
                                  <select class="form-control" name="cliente.ativo" >
                                      <option value="true" ${cliente.ativo ? 'selected' : ''}>Sim</option>
                                      <option value="false" ${not cliente.ativo ? 'selected' : ''}>Não</option>
                                  </select>
                              </div>
	                    </div>
	                    <div class="tab-pane fade" id="cliente_endereco">
	                        <h4>Endereço</h4>
                            <div class="form-group">
                                <label>Cep</label>
                                <input type="text" class="form-control" name="cliente.cep" placeholder="Cep" value="${cliente.cep}">
                            </div>
	                        <div class="form-group">
                                <label>UF</label>
                                <input type="text" class="form-control" name="cliente.estado" placeholder="UF" value="${cliente.estado}" >
                            </div>
                            <div class="form-group">
                                <label>Cidade</label>
                                <input type="text" class="form-control" name="cliente.cidade" placeholder="Cidade" value="${cliente.cidade}">
                            </div>
                            <div class="form-group">
                                <label>Logradouro</label>
                                <input type="text" class="form-control" name="cliente.logradouro" placeholder="Logradouro" value="${cliente.logradouro}" >
                            </div>
                            <div class="form-group">
                                <label>Complemento</label>
                                <input type="text" class="form-control" name="cliente.complemento" placeholder="Complemento" value="${cliente.complemento}">
                            </div>
	                    </div>
	                    <div class="tab-pane fade" id="cliente_contato">
	                        <h4>Contato</h4>
	                        <label>Telefones</label>
	                        <div class="form-inline">
		                        <div class="form-group">
	                                <label class="sr-only">Residencial</label>
	                                <input type="tel" class="form-control" name="cliente.fone" placeholder="Residencial" value="${cliente.fone}" />
	                            </div>
	                            <div class="form-group">
	                                <label class="sr-only">Celular</label>
	                                <input type="tel" class="form-control" name="cliente.celular" placeholder="Celular" value="${cliente.celular}" />
	                            </div>
	                        </div>
                            <div class="form-group">
                                <label>E-Mail</label>
                                <input type="email" class="form-control" name="cliente.email" placeholder="E-Mail" value="${cliente.email}" />
                            </div>	                        
	                    </div>
	                </div>
	            </div>
	            <!-- /.panel-body -->
	            <div class="panel-heading">
		            <c:import url="form_toolbar.jsp" />
	            </div>
	        </div>
	        <!-- /.panel -->
            </form>
	    </div>	    
	</div>
	<!-- /.row -->
	
<%@ include file="/partial/footer.jsp" %>