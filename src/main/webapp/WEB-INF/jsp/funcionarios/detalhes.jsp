<%@ include file="/WEB-INF/partial/_header.jsp" %>		

	<div class="row">
	    <div class="col-lg-12">
	        <h1 class="page-header">${t['funcionario.detalhe']}</h1>
	    </div>
	    <!-- /.col-lg-12 -->
	</div>

	<!-- /.row -->
	<div class="row">
	    <div class="col-lg-12">
            <form role="form" method="post" action="${linkTo[FuncionariosController].salva}" >
	        <div class="panel panel-default">
	            <div class="panel-heading">
					<a href="${linkTo[FuncionariosController].lista }" class="btn btn-danger"><i class="fa fa-times-circle"></i>${t['botao.volta']}</a>
	            </div>
	            <!-- /.panel-heading -->
	            <div class="panel-body">
	                <input type="hidden" name="funcionario.id" value="${funcionario.id }"/>
	                        	
                     <div class="form-group">
                         <label>${t['funcionario.nome'] }</label>
                         <input type="text" class="form-control" name="funcionario.nome" placeholder="${t['funcionario.nome'] }" value="${funcionario.nome}" autofocus disabled />
                   	 </div>
                    <div class="form-group">
                         <label>${t['funcionario.cpf'] }</label>
                         <input type="text" class="form-control" name="funcionario.cpf" placeholder="${t['funcionario.cpf'] }" value="${funcionario.cpf}" disabled />
                    </div>
                    <div class="form-group">
                      	<label>${t['funcionario.ativo'] }</label>
                      	<select class="form-control" name="funcionario.ativo" disabled>
                          	<option value="true" ${funcionario.ativo ? 'selected' : ''}>${t['sim'] }</option>
                          	<option value="false" ${not funcionario.ativo ? 'selected' : ''}>${t['nao'] }</option>
                      	</select>
                	</div>
                	<div class="form-group">
                        <label>${t['funcionario.tipo']}</label>
                        <label class="checkbox-inline">
                            <input type="checkbox" name="funcionario.usuario" ${funcionario.vendedor ? 'checked': ''} disabled/>${t['funcionario.tipo.usuario']} 
                        </label>
                        <label class="checkbox-inline">
                            <input type="checkbox" name="funcionario.vendedor" ${funcionario.vendedor ? 'checked': ''} disabled />${t['funcionario.tipo.vendedor']}
                        </label>
                        <label class="checkbox-inline">
                            <input type="checkbox" name="funcionario.gerente" ${funcionario.vendedor ? 'checked': ''} disabled/>${t['funcionario.tipo.gerente']}
                        </label>
                    </div>                    
	            </div>
	            <!-- /.panel-body -->
	            <div class="panel-heading">
					<a href="${linkTo[FuncionariosController].lista }" class="btn btn-danger"><i class="fa fa-times-circle"></i>${t['botao.volta']}</a>
	            </div>
	        </div>
	        <!-- /.panel -->
            </form>
	    </div>	    
	</div>
	<!-- /.row -->
	
<%@ include file="/WEB-INF/partial/_footer.jsp" %>