<%@ include file="/WEB-INF/partial/_header.jsp" %>
	<div class="row">
	    <div class="col-lg-12">
	        <h1 class="page-header">${empty funcionario.senha ? t['funcionario.senha.define'] : t['funcionario.senha.redefine']}</h1>
	    </div>
	    <!-- /.col-lg-12 -->
	</div>
	
	<!-- /.row -->
	<div class="row">
	    <div class="col-lg-12">
            <form role="form" method="post" action="${linkTo[FuncionariosController].salvaUsuario(funcionario.id, usuario)}" data-toggle="validator" >
	        <div class="panel panel-default">
	            <div class="panel-heading">
		            <button type="submit" class="btn btn-primary"><i class="fa fa-check"></i>${t['botao.confirma']}</button>
					<a href="${linkTo[FuncionariosController].lista }" class="btn btn-danger"><i class="fa fa-times-circle"></i>${t['botao.cancela']}</a>
	            </div>
	            <!-- /.panel-heading -->
	            <div class="panel-body">
	                        	
                     <div class="form-group">
                         <label>${t['funcionario.nome'] }</label>
                         <input type="text" class="form-control" placeholder="${t['funcionario.nome'] }" value="${funcionario.nome}" disabled />
                   	 </div>
                    <div class="form-group">
                         <label>${t['funcionario.cpf'] }</label>
                         <input type="text" class="form-control" placeholder="${t['funcionario.cpf'] }" value="${funcionario.cpf}" disabled />
                    </div>
                    <div class="form-group">
                      	<label>${t['funcionario.ativo'] }</label>
                      	<select class="form-control" disabled>
                          	<option value="true" ${funcionario.ativo ? 'selected' : ''}>${t['sim'] }</option>
                          	<option value="false" ${not funcionario.ativo ? 'selected' : ''}>${t['nao'] }</option>
                      	</select>
                	</div>
                	<div class="form-group">
                        <label>${t['funcionario.tipo']}</label>
                        <label class="checkbox-inline">
                            <input type="checkbox" ${funcionario.vendedor ? 'checked': ''} disabled/>${t['funcionario.tipo.usuario']} 
                        </label>
                        <label class="checkbox-inline">
                            <input type="checkbox" ${funcionario.vendedor ? 'checked': ''} disabled/>${t['funcionario.tipo.vendedor']}
                        </label>
                        <label class="checkbox-inline">
                            <input type="checkbox" ${funcionario.vendedor ? 'checked': ''} disabled/>${t['funcionario.tipo.gerente']}
                        </label>
                    </div>     
                    <div class="form-inline">
                    	<h4>${t['funcionario.acesso']}</h4>
                     	<div class="form-group">
                            <label class="sr-only">${t['funcionario.login']}</label>
                            <input type="text" class="form-control" name="usuario.login" placeholder="${t['funcionario.login']}" value="${funcionario.login}" />
                        </div>
                        <div class="form-group">
                            <label class="sr-only">${t['funcionario.senha']}</label>
                            <input type="password" class="form-control" name="usuario.senha" id="usuario_password" placeholder="${t['funcionario.senha']}" />
                        </div>
                        <div class="form-group">
                            <label class="sr-only">${t['funcionario.confirma.senha']}</label>
                            <input type="password" class="form-control" name="usuario.confirmaSenha" id="usuario_password_confirm" data-match="#usuario_password" placeholder="${t['funcionario.senha.confirma']}" />                            
                        </div>
                   	</div>               
	            </div>
	            <!-- /.panel-body -->
	            <div class="panel-heading">
		            <button type="submit" class="btn btn-primary"><i class="fa fa-check"></i>${t['botao.confirma']}</button>
					<a href="${linkTo[FuncionariosController].lista }" class="btn btn-danger"><i class="fa fa-times-circle"></i>${t['botao.cancela']}</a>
	            </div>
	        </div>
	        <!-- /.panel -->
            </form>
	    </div>	    
	</div>
	<!-- /.row -->
	
<%@ include file="/WEB-INF/partial/_footer.jsp" %>