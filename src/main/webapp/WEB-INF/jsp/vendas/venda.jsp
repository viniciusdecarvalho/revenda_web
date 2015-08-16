<%@ include file="/WEB-INF/partial/_header.jsp" %>

	<div class="row">
	    <div class="col-lg-12">
	        <h1 class="page-header">${t['venda.tab.veiculo']}</h1>
	    </div>
	    <!-- /.col-lg-12 -->
	</div>

	<!-- /.row -->
	<div class="row">
	    <div class="col-lg-12">
            <form role="form" method="post" action="${linkTo[VendasController].pagamentos}?cid=${venda.cid}" >
	        <div class="panel panel-default">
	            <div class="panel-heading">
		            <a href="${linkTo[VendasController].cliente}?cid=${venda.cid}" class="btn"><i class="fa fa-hand-o-left"></i>${t['botao.anterior']}</a>
		            <button type="submit" class="btn btn-primary"><i class="fa fa-hand-o-right"></i>${t['botao.proximo']}</button>
	            </div>
	            <!-- /.panel-heading -->
	            <div class="panel-body">
         			<div class="form-group">
                         <label>${t['venda.data']}</label>
                         <input type="date" class="form-control" name="model.data" value="${l[venda.data].pattern('yyyy-MM-dd')}" autofocus />
               	 	</div>						
					<div class="form-group">
						<label>${t['venda.valor']}</label>
						<input type="text" class="form-control input-decimal" name="model.valor" value="${venda.valor}" />
					</div>
	            </div>
	            <!-- /.panel-body -->
	            <div class="panel-heading">
		           	<a href="${linkTo[VendasController].cliente}?cid=${venda.cid}" class="btn"><i class="fa fa-hand-o-left"></i>${t['botao.anterior']}</a>
		            <button type="submit" class="btn btn-primary"><i class="fa fa-hand-o-right"></i>${t['botao.proximo']}</button>
	            </div>
	        </div>
	        <!-- /.panel -->
            </form>
	    </div>	    
	</div>
	<!-- /.row -->
	
<%@ include file="/WEB-INF/partial/_footer.jsp" %>