<%@ include file="/WEB-INF/partial/_header.jsp" %>

	<div class="row">
	    <div class="col-lg-12">
	        <h1 class="page-header">${t['aquisicao.tab.cliente']}</h1>
	    </div>
	    <!-- /.col-lg-12 -->
	</div>

	<!-- /.row -->
	<div class="row">
	    <div class="col-lg-12">
            <form role="form" method="post" action="${linkTo[AquisicoesController].cliente}?cid=${compra.cid}" >
	        <div class="panel panel-default">
	            <div class="panel-heading">
		            <a href="${linkTo[AquisicoesController].veiculo}?cid=${compra.cid}" class="btn"><i class="fa fa-hand-o-left"></i>${t['botao.anterior']}</a>
		            <button type="submit" class="btn btn-primary"><i class="fa fa-hand-o-right"></i>${t['botao.proximo']}</button>
	            </div>
	            <!-- /.panel-heading -->
	            <div class="panel-body">
					<div class="form-group">
                       	<label>${t['aquisicao.cliente']}</label>
                       	<select class="form-control" name="cliente.cliente.id" autofocus>
                       		<option>${t['option.notselected']}</option>
                       		<c:forEach items="${clientes}" var="cliente">
                           		<option value="${cliente.id}" ${compra.cliente.cliente eq cliente ? 'selected' : ''}>${cliente}</option>                            
                       		</c:forEach>
                       	</select>
					</div>
					<div class="form-group">
                       	<label>${t['aquisicao.vendedor']}</label>
                       	<select class="form-control" name="cliente.vendedor.id" >
                       		<option>${t['option.notselected']}</option>
                       		<c:forEach items="${vendedores}" var="vendedor">
                           		<option value="${vendedor.id}" ${compra.cliente.vendedor eq vendedor ? 'selected' : ''}>${vendedor}</option>                            
                       		</c:forEach>
                       	</select>
					</div>
					<div class="form-group">
						<label>${t['aquisicao.valor.comissao']}</label>
						<input type="text" class="form-control input-decimal" name="cliente.valorComissao" value="${compra.cliente.valorComissao}" />
					</div>
	            </div>
	            <!-- /.panel-body -->
	            <div class="panel-heading">
	            	<a href="${linkTo[AquisicoesController].veiculo}?cid=${compra.cid}" class="btn"><i class="fa fa-hand-o-left"></i>${t['botao.anterior']}</a>
		            <button type="submit" class="btn btn-primary"><i class="fa fa-hand-o-right"></i>${t['botao.proximo']}</button>
	            </div>
	        </div>
	        <!-- /.panel -->
            </form>
	    </div>	    
	</div>
	<!-- /.row -->
	
<%@ include file="/WEB-INF/partial/_footer.jsp" %>