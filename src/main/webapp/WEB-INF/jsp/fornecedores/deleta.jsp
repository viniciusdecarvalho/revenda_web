<%@ include file="/WEB-INF/partial/_header.jsp" %>		

	<div class="row">
	    <div class="col-lg-12">
	        <h1 class="page-header">${t['fornecedor.detalhe']}</h1>
	    </div>
	    <!-- /.col-lg-12 -->
	</div>

	<!-- /.row -->
	<div class="row">
	    <div class="col-lg-12">
	    	<form role="form" method="post" action="${linkTo[FornecedoresController].deleta(fornecedor.id)}" >
	        <div class="panel panel-default">
	            <div class="panel-heading">
		            <button type="submit" class="btn btn-danger"><i class="fa fa-check"></i>${t['botao.deleta']}</button>
		            <a href="${linkTo[FornecedoresController].lista }" class="btn btn-default"><i class="fa fa-times-circle"></i>${t['botao.volta']}</a>
	            </div>
	            <!-- /.panel-heading -->
	            <div class="panel-body">
	                <input type="hidden" name="fornecedor.id" value="${fornecedor.id }"/>
	                        	
                     <div class="form-group">
                         <label>${t['fornecedor.razaoSocial'] }</label>
                         <input type="text" class="form-control" name="fornecedor.nome" placeholder="${t['fornecedor.razaoSocial'] }" value="${fornecedor.razaoSocial}" autofocus />
                   	</div>
                   	<div class="form-group">	                            
                        <label>${t['fornecedor.cpfCnpj'] }</label>
                        <input type="text" class="form-control input-cpfcnpj" name="fornecedor.cpfCnpj" placeholder="${t['fornecedor.cpfCnpj']}" value="${fornecedor.cpfCnpj}">
                    </div>                   	
                    <div class="form-group">
                      	<label>${t['fornecedor.ativo'] }</label>
                      	<select class="form-control" name="fornecedor.ativo" >
                          	<option value="true" ${fornecedor.ativo ? 'selected' : ''}>${t['sim'] }</option>
                          	<option value="false" ${not fornecedor.ativo ? 'selected' : ''}>${t['nao'] }</option>
                      	</select>
                	</div>
	            </div>
	            <!-- /.panel-body -->
	            <div class="panel-heading">
	            	<button type="submit" class="btn btn-danger"><i class="fa fa-check"></i>${t['botao.deleta']}</button>
		            <a href="${linkTo[FornecedoresController].lista }" class="btn btn-default"><i class="fa fa-times-circle"></i>${t['botao.volta']}</a>
	            </div>
	        </div>
	        <!-- /.panel -->
            </form>
	    </div>	    
	</div>
	<!-- /.row -->

<%@ include file="/WEB-INF/partial/_footer.jsp" %>