<%@ include file="/WEB-INF/partial/_header.jsp" %>

	<div class="row">
	    <div class="col-lg-12">
	        <h1 class="page-header">${t['venda.tab.cliente']}</h1>
	    </div>
	    <!-- /.col-lg-12 -->
	</div>

	<!-- /.row -->
	<div class="row">
	    <div class="col-lg-12">
            <form role="form" method="post" action="${linkTo[VendasController].cliente}" >
            <input type="hidden" name="cid" value="${venda.cid}"/>
	        <div class="panel panel-default">
	            <div class="panel-heading">
		            <a href="${linkTo[VendasController].veiculo}?cid=${venda.cid}" class="btn"><i class="fa fa-hand-o-left"></i>${t['botao.anterior']}</a>
		            <button type="submit" class="btn btn-primary"><i class="fa fa-hand-o-right"></i>${t['botao.proximo']}</button>
	            </div>
	            <!-- /.panel-heading -->
	            <div class="panel-body">
					<div class="form-group">
                       	<label>${t['venda.cliente']}</label>
                       	<select class="form-control" name="model.clienteId" autofocus>
                       		<option>${t['option.notselected']}</option>
                       		<c:forEach items="${clientes}" var="cliente">
                           		<option value="${cliente.id}" ${venda.cliente eq cliente ? 'selected' : ''}>${cliente}</option>                            
                       		</c:forEach>
                       	</select>
					</div>
					<div class="form-group">
                       	<label>${t['venda.vendedor']}</label>
                       	<select class="form-control" name="model.vendedorId" >
                       		<option>${t['option.notselected']}</option>
                       		<c:forEach items="${vendedores}" var="vendedor">
                           		<option value="${vendedor.id}" ${venda.vendedor eq vendedor ? 'selected' : ''}>${vendedor}</option>                            
                       		</c:forEach>
                       	</select>
					</div>
					<div class="form-group">
						<label>${t['venda.valor.comissao']}</label>
						<input type="text" class="form-control input-decimal" name="model.valorComissao" value="${venda.comissao}" />
					</div>
	            </div>
	            <!-- /.panel-body -->
	            <div class="panel-heading">
	            	<a href="${linkTo[VendasController].veiculo}?cid=${venda.cid}" class="btn"><i class="fa fa-hand-o-left"></i>${t['botao.anterior']}</a>
		            <button type="submit" class="btn btn-primary"><i class="fa fa-hand-o-right"></i>${t['botao.proximo']}</button>
	            </div>
	        </div>
	        <!-- /.panel -->
            </form>
	    </div>	    
	</div>
	<!-- /.row -->
	
<%@ include file="/WEB-INF/partial/_footer.jsp" %>