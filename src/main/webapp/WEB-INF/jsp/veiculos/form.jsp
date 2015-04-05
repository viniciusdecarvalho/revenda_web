<%@ include file="/WEB-INF/partial/_header.jsp" %>

	<div class="row">
	    <div class="col-lg-12">
	        <h1 class="page-header">${empty veiculo.id ? t['veiculo.adiciona'] : t['veiculo.edita']}</h1>
	    </div>
	    <!-- /.col-lg-12 -->
	</div>
	
	<!-- /.row -->
	<div class="row">
	    <div class="col-lg-12">
            <form role="form" method="post" action="${linkTo[VeiculosController].salva}" >
	        <div class="panel panel-default">
	            <div class="panel-heading">
		            <button type="submit" class="btn btn-primary"><i class="fa fa-check"></i>${t['botao.confirma']}</button>
					<a href="${linkTo[VeiculosController].lista }" class="btn btn-danger"><i class="fa fa-times-circle"></i>${t['botao.cancela']}</a>
	            </div>
	            <!-- /.panel-heading -->
	            <div class="panel-body">
	                <input type="hidden" name="veiculo.id" value="${veiculo.id }"/>
	                        	
                     <div class="form-group">
                         <label>${t['veiculo.placa'] }</label>
                         <input type="text" class="form-control" name="veiculo.placa" value="${veiculo.placa}" autofocus />
                   	</div>
                   	<div class="form-group">
						<label>${t['veiculo.marca'] }</label>
						<input type="text" class="form-control" name="veiculo.marca" value="${veiculo.marca}" />
					</div>
					<div class="form-group">
						<label>${t['veiculo.modelo'] }</label>
						<input type="text" class="form-control" name="veiculo.modelo" value="${veiculo.modelo}" />
					</div>
					<div class="form-group">
						<label>${t['veiculo.ano'] }</label>
						<input type="text" class="form-control" name="veiculo.ano" placeholder="XXXX/XXXX" value="${veiculo.ano}" />
					</div>
					<div class="form-group">
						<label>${t['veiculo.especie'] }</label>
						<input type="text" class="form-control" name="veiculo.especie" value="${veiculo.especie}" />
						<datalist>
							<option>Automovel</option>
							<option>Motocicleta</option>
							<option>Caminhoneta</option>							
						</datalist>
					</div>
					<div class="form-group">
						<label>${t['veiculo.chassi'] }</label>
						<input type="text" class="form-control" name="veiculo.chassi" value="${veiculo.chassi}" />
					</div>
					<div class="form-group">
						<label>${t['veiculo.renavan'] }</label>
						<input type="text" class="form-control" name="veiculo.renavan" value="${veiculo.renavan}" />
					</div>
	            </div>
	            <!-- /.panel-body -->
	            <div class="panel-heading">
		            <button type="submit" class="btn btn-primary"><i class="fa fa-check"></i>${t['botao.confirma']}</button>
					<a href="${linkTo[VeiculosController].lista }" class="btn btn-danger"><i class="fa fa-times-circle"></i>${t['botao.cancela']}</a>
	            </div>
	        </div>
	        <!-- /.panel -->
            </form>
	    </div>	    
	</div>
	<!-- /.row -->
	
<%@ include file="/WEB-INF/partial/_footer.jsp" %>