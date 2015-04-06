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
            <form role="form" method="post" action="${linkTo[AquisicoesController].veiculo}?cid=${compra.cid}" >
	        <div class="panel panel-default">
	            <div class="panel-heading">
		            <button type="submit" class="btn btn-primary"><i class="fa fa-hand-o-right"></i>${t['botao.proximo']}</button>
					<a href="${linkTo[AquisicoesController].lista}" class="btn btn-danger"><i class="fa fa-times-circle"></i>${t['botao.cancela']}</a>
	            </div>
	            <!-- /.panel-heading -->
	            <div class="panel-body">
	                <div class="form-group">
                       	<label>${t['aquisicao.veiculo']}</label>
                       	<select class="form-control" name="veiculo.veiculo.id" autofocus>
                       		<option>${t['option.notselected']}</option>
                       		<c:forEach items="${veiculos}" var="veiculo">
                           		<option value="${veiculo.id}" ${compra.veiculo.veiculo eq veiculo ? 'selected' : ''}>${veiculo}</option>                            
                       		</c:forEach>
                       	</select>
					</div>
							
					<div class="form-group">
						<label>${t['aquisicao.uf'] }</label>
						<input type="text" class="form-control" name="veiculo.uf" value="${compra.veiculo.uf}" />
					</div>
					<div class="form-group">
						<label>${t['aquisicao.cidade'] }</label>
						<input type="text" class="form-control" name="veiculo.cidade" value="${compra.veiculo.cidade}" />
					</div>
					<div class="form-group">
						<label>${t['aquisicao.cor'] }</label>
						<input type="text" class="form-control" name="veiculo.cor" value="${compra.veiculo.cor}" />
					</div>
					<div class="form-group">
                       	<label>${t['aquisicao.combustivel']}</label>
                       	<select class="form-control" name="veiculo.combustivel" >
                       		<option>${t['option.notselected']}</option>
                       		<c:forEach items="${combustiveis}" var="combustivel">
                           		<option value="${combustivel}" ${compra.veiculo.combustivel eq combustivel ? 'selected' : ''}>${combustivel}</option>                            
                       		</c:forEach>
                       	</select>
					</div>
					<div class="form-group">
						<label>${t['aquisicao.km'] }</label>
						<input type="text" class="form-control" name="veiculo.km" value="${compra.veiculo.km}" />
					</div>
	            </div>
	            <!-- /.panel-body -->
	            <div class="panel-heading">
		            <button type="submit" class="btn btn-primary"><i class="fa fa-hand-o-right"></i>${t['botao.proximo']}</button>
					<a href="${linkTo[AquisicoesController].lista}" class="btn btn-danger"><i class="fa fa-times-circle"></i>${t['botao.cancela']}</a>
	            </div>
	        </div>
	        <!-- /.panel -->
            </form>
	    </div>	    
	</div>
	<!-- /.row -->
	
<%@ include file="/WEB-INF/partial/_footer.jsp" %>