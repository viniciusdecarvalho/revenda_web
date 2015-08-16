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
            <form role="form" method="post" action="${linkTo[FormasPagamentosController].deleta(formaPagamento.id)}" >
	        <div class="panel panel-default">
	            <div class="panel-heading">
		            <button type="submit" class="btn btn-danger"><i class="fa fa-check"></i>${t['botao.deleta']}</button>
		            <a href="${linkTo[FuncionariosController].lista }" class="btn btn-default"><i class="fa fa-times-circle"></i>${t['botao.volta']}</a>
	            </div>
	            <!-- /.panel-heading -->
	            <div class="panel-body">
	                <input type="hidden" name="formaPagamento.id" value="${formaPagamento.id }"/>
	                        	
                     <div class="form-group">
                         <label>${t['formaPagamento.nome'] }</label>
                         <input type="text" class="form-control" name="formaPagamento.nome" placeholder="${t['formaPagamento.nome'] }" value="${formaPagamento.nome}" autofocus />
                   	</div>
                   	<div class="form-group">
                        <label>${t['formaPagamento.tipo']}</label>
                        <label class="checkbox-inline">
                            <input type="checkbox" name="formaPagamento.usuario" ${formaPagamento.credito ? 'checked': ''}/>${t['formaPagamento.credito']} 
                        </label>
                        <label class="checkbox-inline">
                            <input type="checkbox" name="formaPagamento.vendedor" ${formaPagamento.debito ? 'checked': ''}/>${t['formaPagamento.debito']}
                        </label>
                    </div>  
                    <div class="form-group">
                      	<label>${t['formaPagamento.ativo'] }</label>
                      	<select class="form-control" name="formaPagamento.ativo" >
                          	<option value="true" ${formaPagamento.ativo ? 'selected' : ''}>${t['sim'] }</option>
                          	<option value="false" ${not formaPagamento.ativo ? 'selected' : ''}>${t['nao'] }</option>
                      	</select>
                	</div>
	            </div>
	            <!-- /.panel-body -->
	            <div class="panel-heading">
		            <button type="submit" class="btn btn-danger"><i class="fa fa-check"></i>${t['botao.deleta']}</button>
		            <a href="${linkTo[FuncionariosController].lista }" class="btn btn-default"><i class="fa fa-times-circle"></i>${t['botao.volta']}</a>
	            </div>
	        </div>
	        <!-- /.panel -->
            </form>
	    </div>	    
	</div>
	<!-- /.row -->

<%@ include file="/WEB-INF/partial/_footer.jsp" %>