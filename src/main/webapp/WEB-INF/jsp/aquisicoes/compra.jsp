<%@ include file="/WEB-INF/partial/_header.jsp" %>

	<div class="row">
	    <div class="col-lg-12">
	        <h1 class="page-header">${t['aquisicao.tab.veiculo']}</h1>
	    </div>
	    <!-- /.col-lg-12 -->
	</div>

	<!-- /.row -->
	<div class="row">
	    <div class="col-lg-12">
            <form role="form" method="post" action="${linkTo[AquisicoesController].compra}?cid=${compra.cid}" >
	        <div class="panel panel-default">
	            <div class="panel-heading">
		            <a href="${linkTo[AquisicoesController].cliente}?cid=${compra.cid}" class="btn"><i class="fa fa-hand-o-left"></i>${t['botao.anterior']}</a>
		            <button type="submit" class="btn btn-primary"><i class="fa fa-hand-o-right"></i>${t['botao.proximo']}</button>
	            </div>
	            <!-- /.panel-heading -->
	            <div class="panel-body">
         			<div class="form-group">
                         <label>${t['aquisicao.data']}</label>
                         <input type="date" class="form-control" name="compra.data" value="${l[compra.compra.data].pattern('yyyy-MM-dd')}" autofocus />
               	 	</div>						
					<div class="form-group">
						<label>${t['aquisicao.valor.compra']}</label>
						<input type="text" class="form-control input-decimal" name="compra.valor" value="${compra.compra.valor}" />
					</div>
					<div class="form-group">
						<label>${t['aquisicao.valor.pedido']}</label>
						<input type="text" class="form-control input-decimal" name="compra.valorPedido" value="${compra.compra.valorPedido}" />
					</div>
					<div class="form-group">
						<label>${t['aquisicao.obs']}</label>
						<textarea rows="3" class="form-control" name="compra.obs">${compra.compra.obs}</textarea>
					</div>
	            </div>
	            <!-- /.panel-body -->
	            <div class="panel-heading">
		           	<a href="${linkTo[AquisicoesController].cliente}?cid=${compra.cid}" class="btn"><i class="fa fa-hand-o-left"></i>${t['botao.anterior']}</a>
		            <button type="submit" class="btn btn-primary"><i class="fa fa-hand-o-right"></i>${t['botao.proximo']}</button>
	            </div>
	        </div>
	        <!-- /.panel -->
            </form>
	    </div>	    
	</div>
	<!-- /.row -->
	
<%@ include file="/WEB-INF/partial/_footer.jsp" %>