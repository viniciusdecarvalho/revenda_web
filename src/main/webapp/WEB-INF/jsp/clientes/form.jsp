<%@ include file="/WEB-INF/partial/_header.jsp" %>
	<div class="row">
	    <div class="col-lg-12">
	        <h1 class="page-header">${empty cliente.id ? t['cliente.adiciona'] : t['cliente.edita']}</h1>
	    </div>
	    <!-- /.col-lg-12 -->
	</div>
	
	<!-- /.row -->
	<div class="row">
	    <div class="col-lg-12">
            <form role="form" method="post" action="${linkTo[ClientesController].salva}" >
	        <div class="panel panel-default">
	            <div class="panel-heading">
		            <button type="submit" class="btn btn-primary"><i class="fa fa-check"></i>${t['botao.confirma']}</button>
					<a href="${linkTo[ClientesController].lista }" class="btn btn-danger"><i class="fa fa-times-circle"></i>${t['botao.cancela']}</a>
	            </div>
	            <!-- /.panel-heading -->
	            <div class="panel-body">
	                <!-- Nav tabs -->
	                <ul class="nav nav-tabs">
	                    <li class="active"><a href="#cliente_id" data-toggle="tab">${t['cliente.dados'] }</a>
	                    </li>
	                    <li><a href="#cliente_endereco" data-toggle="tab">${t['cliente.endereco'] }</a>
	                    </li>
	                    <li><a href="#cliente_contato" data-toggle="tab">${t['cliente.contato'] }</a>
	                    </li>	                    
	                </ul>
	
	                <!-- Tab panes -->
	                <div class="tab-content">
	                    <div class="tab-pane fade in active" id="cliente_id">
	                        <h4>Dados</h4>
	                        <input type="hidden" name="cliente.id" value="${cliente.id}"/>
	                        	
                            <div class="form-group">
                                <label>${t['cliente.razaoSocial']}</label>
                                <input type="text" class="form-control" name="cliente.razaoSocial" placeholder="${t['cliente.razaoSocial'] }" value="${cliente.razaoSocial}" autofocus>
                            </div>
                            <div class="form-group">	                            
                                <label>${t['cliente.cpfCnpj'] }</label>
                                <%--
		                        <label class="radio-inline">
		                            <input type="radio" name="tipo" ${cliente.tipo eq 'FISICA' ? 'checked': ''}/>${t['cliente.tipo.cpf']} 
		                        </label>
		                        <label class="radio-inline">
		                            <input type="radio" name="tipo" ${cliente.tipo eq 'JURIDICA' ? 'checked': ''}/>${t['cliente.tipo.cnpj']}
		                        </label>
		                         --%>
                                <input type="text" class="form-control input-cpfcnpj" name="cliente.cpfCnpj" placeholder="${t['cliente.cpfCnpj']}" value="${cliente.cpfCnpj}">
                            </div>
                            <div class="form-group">
	                            <label>${t['cliente.ativo'] }</label>
	                            <select class="form-control" name="cliente.ativo" >
	                                <option value="true" ${cliente.ativo ? 'selected' : ''}>${t['sim']}</option>
	                                <option value="false" ${not cliente.ativo ? 'selected' : ''}>${t['nao']}</option>
	                            </select>
                             </div>
	                    </div>
	                    <div class="tab-pane fade" id="cliente_endereco">
	                        <h4>Endereço</h4>
                            <div class="form-group">
                                <label>${t['cliente.endereco.cep'] }</label>
                                <input type="text" class="form-control input-cep" name="cliente.endereco.cep" placeholder="${t['cliente.endereco.cep'] }" value="${cliente.endereco.cep}">
                            </div>
	                        <div class="form-group">
                                <label>${t['cliente.endereco.uf']}</label>
                                <input type="text" class="form-control" list="ufs" autocomplete="on" name="cliente.endereco.estado" placeholder="${t['cliente.endereco.uf']}" value="${cliente.endereco.estado}" >
                                <datalist id="ufs">
                                	<c:forEach items="${ufs}" var="uf">
                                		<option value="${uf}">
                                	</c:forEach>
								</datalist>
                            </div>
                            <div class="form-group">
                                <label>${t['cliente.endereco.cidade']}</label>
                                <input type="text" class="form-control" name="cliente.endereco.cidade" placeholder="${t['cliente.endereco.cidade']}" value="${cliente.endereco.cidade}">
                            </div>
                            <div class="form-group">
                                <label>${t['cliente.endereco.logradouro']}</label>
                                <input type="text" class="form-control" name="cliente.endereco.logradouro" placeholder="${t['cliente.endereco.logradouro']}" value="${cliente.endereco.logradouro}" >
                            </div>
                            <div class="form-group">
                                <label>${t['cliente.endereco.complemento']}</label>
                                <input type="text" class="form-control" name="cliente.endereco.complemento" placeholder="${t['cliente.endereco.complemento']}" value="${cliente.endereco.complemento}">
                            </div>
	                    </div>
	                    <div class="tab-pane fade" id="cliente_contato">
	                        <h4>${t['cliente.contato']}</h4>
	                        <label>${t['cliente.contato.fones']}</label>
	                        <div class="form-inline">
		                        <div class="form-group">
	                                <label class="sr-only">${t['cliente.contato.fone']}</label>
	                                <input type="tel" class="form-control" name="cliente.contato.fone" placeholder="${t['cliente.contato.fone']}" value="${cliente.contato.fone}" />
	                            </div>
	                            <div class="form-group">
	                                <label class="sr-only">${t['cliente.contato.celular']}</label>
	                                <input type="tel" class="form-control" name="cliente.contato.celular" placeholder="${t['cliente.contato.celular']}" value="${cliente.contato.celular}" />
	                            </div>
	                        </div>
                            <div class="form-group">
                                <label>${t['cliente.contato.email']}</label>
                                <input type="email" class="form-control" name="cliente.contato.email" placeholder="${t['cliente.contato.email']}" value="${cliente.contato.email}" />
                            </div>	                        
	                    </div>
	                </div>
	            </div>
	            <!-- /.panel-body -->
	            <div class="panel-heading">
		            <button type="submit" class="btn btn-primary"><i class="fa fa-check"></i>${t['botao.confirma']}</button>
					<a href="${linkTo[ClientesController].lista }" class="btn btn-danger"><i class="fa fa-times-circle"></i>${t['botao.cancela']}</a>
	            </div>
	        </div>
	        <!-- /.panel -->
            </form>
	    </div>	    
	</div>
	<!-- /.row -->
	
<%@ include file="/WEB-INF/partial/_footer.jsp" %>