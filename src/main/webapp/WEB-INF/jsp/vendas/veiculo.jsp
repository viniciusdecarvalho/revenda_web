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
	    	
    		<c:set value="${linkTo[VendasController].veiculo}?cid=${venda.cid}" var="url" />
    		<c:set value="get" var="method" />
    		<c:if test="${not empty aquisicaoId}">	    		
	   			<c:set value="${linkTo[VendasController].veiculoSelecionado(aquisicaoId)}?cid=${venda.cid}" var="url" />
	   			<c:set value="post" var="method" />
	    	</c:if>
	    		    
            <form role="form" method="${method}" action="${url}" >
	        <div class="panel panel-default">
	            <div class="panel-heading">
		            <button type="submit" class="btn btn-primary"><i class="fa fa-search"></i>${t['botao.proximo']}</button>
					<a href="${linkTo[VendasController].lista}" class="btn btn-danger"><i class="fa fa-times-circle"></i>${t['botao.cancela']}</a>
	            </div>
	            <!-- /.panel-heading -->
	            <div class="panel-body">
	                <div class="form-group col-lg-9">
                       	<label>${t['venda.veiculo']}</label>
                       	<select class="form-control" name="aquisicaoId" autofocus>
                       		<option>${t['option.notselected']}</option>
                       		<c:forEach items="${aquisicoes}" var="aquisicao">
                           		<option value="${aquisicao.id}" ${venda.aquisicao eq aquisicao ? 'selected' : ''}>${aquisicao.veiculo}</option>                            
                       		</c:forEach>
                       	</select>
                     	<button type="submit" class="btn btn-default"><i class="fa fa-hand-o-right"></i>${t['botao.seleciona']}</button>
					</div>
							
					<c:set value="${venda.aquisicao}" var="aquisicao" />
							
					<div class="form-group col-lg-6">
						<label>${t['aquisicao.uf'] }</label>
						<input type="text" class="form-control" value="${aquisicao.uf}" />
					</div>
					<div class="form-group col-lg-6">
						<label>${t['aquisicao.cidade'] }</label>
						<input type="text" class="form-control" value="${aquisicao.cidade}" />
					</div>
					<div class="form-group col-lg-4">
						<label>${t['aquisicao.cor'] }</label>
						<input type="text" class="form-control" value="${aquisicao.cor}" />
					</div>
					<div class="form-group col-lg-4">
                       	<label>${t['aquisicao.combustivel']}</label>
                       	<select class="form-control" >
                       		<option>${aquisicao.combustivel}</option>
                       	</select>
					</div>
					<div class="form-group col-lg-4">
						<label>${t['aquisicao.km'] }</label>
						<input type="text" class="form-control" value="${aquisicao.km}" />
					</div>
	            </div>
	            <!-- /.panel-body -->
	            <div class="panel-heading">
		            <button type="submit" class="btn btn-primary"><i class="fa fa-hand-o-right"></i>${t['botao.proximo']}</button>
					<a href="${linkTo[VendasController].lista}" class="btn btn-danger"><i class="fa fa-times-circle"></i>${t['botao.cancela']}</a>
	            </div>
	        </div>
	        <!-- /.panel -->
            </form>
	    </div>	    
	</div>
	<!-- /.row -->
	
<%@ include file="/WEB-INF/partial/_footer.jsp" %>