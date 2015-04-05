<%@ include file="/WEB-INF/partial/_header.jsp" %>

	<style type="text/css">
		th.nome {
				
		}
		th.cpf {
			width: 20%;			
		}
		th.tipo {
			width: 20%;		
		}
		th.actions {
			width: 12%;			
		}
		td.nome {
			text-align: left;
		}
		td.cpf,
		td.tipo,
		td.actions {
			text-align: center;			
		}
   	</style>

	<!-- /.row -->
	<div class="row">
		
		<div class="col-lg-12">
			<div class="row">
				<div class="col-lg-12">
                    <h1 class="page-header"><i class="fa fa-user"><b>${t['funcionario.lista']}</b></i></h1>
                </div>
            </div>
			<div class="panel panel-default">
				
				<div class="panel-body">
					
					<div class="dataTable_wrapper">
						<div class="col-lg-12 page-header">
					    	<a 	href="${linkTo[FuncionariosController].form()}" class="btn btn-success" data-toggle="tooltip" title="${t['funcionario.adiciona'] }"><i class="fa fa-plus"></i></a>
						</div>
						<table class="table table-striped table-bordered table-hover">
							<thead>
							  	<tr>
								    <th class="nome">${t['funcionario.coluna.nome']}</th>
								    <th class="cpf">${t['funcionario.coluna.cpf']}</th>
								    <th class="tipo">${t['funcionario.coluna.tipo']}</th>
								    <th class="actions"></th>
							  	</tr>
						  	</thead>
						  	<tbody>
								<c:forEach items="${funcionarios}" var="funcionario">
									<tr class="${empty funcionario.senha ? 'warning' : ''} 
											   ${funcionario.ativo ? '' : 'danger'} ">
								    	<td class="nome">
								    		<a href="${linkTo[FuncionariosController].detalhes(funcionario.id)}" >${funcionario.nome}</a>
								    	</td>
								    	<td class="cpf">${funcionario.cpf}</td>
								    	<td class="tipo">${funcionario.tipo}</td>
								    	<td class="actions">
											<div class="tooltip-demo">								    			
								    			<a href="${linkTo[FuncionariosController].form(funcionario.id)}" class="btn btn-default btn-xs" data-toggle="tooltip" data-placement="bottom" title="${t['funcionario.edita'] }"><i class="fa fa-edit"></i></a>
								    			<a href="${linkTo[FuncionariosController].deleta(funcionario.id)}" class="btn btn-danger btn-xs" data-toggle="tooltip" data-placement="bottom" title="${t['funcionario.deleta'] }"><i class="fa fa-ban"></i></a>
								    			<a href="${linkTo[FuncionariosController].editaUsuario(funcionario.id)}" class="btn btn-primary btn-xs" data-toggle="tooltip" data-placement="bottom" title="${empty funcionario.senha ? t['funcionario.senha.define'] : t['funcionario.senha.redefine'] }"><i class="fa fa-retweet"></i></a>
											</div>								    		
								    	</td>
								  	</tr>
								</c:forEach>
						  	</tbody>
						  	
						</table>
					</div>
				</div>
			</div>				
		</div>
	</div>	
<%@ include file="/WEB-INF/partial/_footer.jsp" %>