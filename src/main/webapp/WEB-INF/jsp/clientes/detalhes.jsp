<%@ include file="/WEB-INF/partial/_header.jsp" %>		

	<div class="row">
	    <div class="col-lg-12">
	        <h1 class="page-header">${t['cliente.detalhe']}</h1>
	    </div>
	    <!-- /.col-lg-12 -->
	</div>

	<!-- /.row -->
	<div class="row">
	    <div class="col-lg-12">
            <form role="form">
	        <div class="panel panel-default">
	            <div class="panel-heading">
		            <a href="${linkTo[ClientesController].lista}" class="btn btn-default">${t['botao.volta']}</a>
	            </div>	
	            <!-- /.panel-heading -->
	            <div class="panel-body">
	                <!-- Nav tabs -->
	                <ul class="nav nav-tabs">
	                    <li class="active"><a href="#cliente_id" data-toggle="tab">${t['cliente.dados']}</a>
	                    </li>
	                    <li><a href="#cliente_endereco" data-toggle="tab">${t['cliente.endereco']}</a>
	                    </li>
	                    <li><a href="#cliente_contato" data-toggle="tab">${t['cliente.contato']}</a>
	                    </li>	                    
	                </ul>
	
	                <!-- Tab panes -->
	                <div class="tab-content">
	                    <div class="tab-pane fade in active" id="cliente_id">
	                        <h4>${t['cliente.dados']}</h4>
	                        <input type="hidden" name="cliente.id" value="${cliente.id }"/>
	                        	
                            <div class="form-group">
                                <label>${t['cliente.razaoSocial']}</label>
                                <input type="text" class="form-control" name="cliente.razaoSocial" placeholder="${t['cliente.razaoSocial']}" value="${cliente.razaoSocial}" disabled />
                            </div>
                            <div class="form-group">
                                <label>${t['cliente.cpfCnpj']}</label>
                                <input type="text" class="form-control" name="cliente.cpfCnpj" placeholder="${t['cliente.contato.fone']}" value="${cliente.cpfCnpj}" disabled />
                            </div>
                            <div class="form-group">
                                 <label>${t['cliente.ativo']}</label>
                                 <select class="form-control" name="cliente.ativo" disabled>
                                     <option value="true" ${cliente.ativo ? 'selected' : ''}>${t['sim']}</option>
                                     <option value="false" ${not cliente.ativo ? 'selected' : ''}>${t['nao']}</option>
                                 </select>
                            </div>
	                    </div>
	                    <div class="tab-pane fade" id="cliente_endereco">
	                        <h4>${t['cliente.endereco']}</h4>
                            <div class="form-group">
                                <label>${t['cliente.endereco.cep']}</label>
                                <input type="text" class="form-control" name="cliente.endereco.cep" placeholder="${t['cliente.endereco.cep']}" value="${cliente.endereco.cep}" disabled />
                            </div>
	                        <div class="form-group">
                                <label>${t['cliente.endereco.uf']}</label>
                                <input type="text" class="form-control" name="cliente.endereco.estado" placeholder="${t['cliente.endereco.uf']}" value="${cliente.endereco.estado}" disabled />
                            </div>
                            <div class="form-group">
                                <label>${t['cliente.endereco.cidade']}</label>
                                <input type="text" class="form-control" name="cliente.endereco.cidade" placeholder="${t['cliente.endereco.cidade']}" value="${cliente.endereco.cidade}" disabled />
                            </div>
                            <div class="form-group">
                                <label>${t['cliente.endereco.logradouro']}</label>
                                <input type="text" class="form-control" name="cliente.endereco.logradouro" placeholder="${t['cliente.endereco.logradouro']}" value="${cliente.endereco.logradouro}" disabled/>
                            </div>
                            <div class="form-group">
                                <label>${t['cliente.endereco.complemento']}</label>
                                <input type="text" class="form-control" name="cliente.endereco.complemento" placeholder="${t['cliente.endereco.complemento']}" value="${cliente.endereco.complemento}" disabled/>
                            </div>
	                    </div>
	                    <div class="tab-pane fade" id="cliente_contato">
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
	                </div>
	            </div>
	            <!-- /.panel-body -->
	            <div class="panel-heading">
		            <a href="${linkTo[ClientesController].lista}" class="btn btn-default">${t['botao.volta']}</a>
	            </div>
	        </div>
	        <!-- /.panel -->
            </form>
	    </div>	    
	</div>
	<!-- /.row -->
<%@ include file="/WEB-INF/partial/_footer.jsp" %>