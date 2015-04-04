<%@ include file="/_header.jsp" %> 

<form method="post" action="${linkTo[ClientesController].salva}" class="form-inline">
	
	<input type="hidden" name="cliente.id" value="${cliente.id}" />

	<h2>Cadastro de Clientes</h2>
	
	<c:import url="_tbar.jsp" />
	
	<fieldset>
		<legend>Dados gerais</legend>
		
		<ul>
			<li>Nome/Razão Social<br />
				<input type="text" class="form-control" name="cliente.razaoSocial" placeholder="Nome ou Razao Social" value="${cliente.razaoSocial}">
			</li>
			
			<li>Cpf/Cnpj<br />
				<input type="text" class="form-control" name="cliente.cpfCnpj" placeholder="Cpf ou Cnpj" value="${cliente.cpfCnpj}">
			</li>
			
		</ul>	
	</fieldset>
	<fieldset>
		<legend>Endereço</legend>
		
		<ul>
			<li>UF<br />
				<input type="text" class="form-control" name="cliente.estado" placeholder="UF" value="${cliente.estado}" >
			</li>
			
			<li>Cidade<br />
				<input type="text" class="form-control" name="cliente.cidade" placeholder="Cidade" value="${cliente.cidade}">
			</li>
			
			<li>Cep<br />
				<input type="text" class="form-control" name="cliente.cep" placeholder="Cep" value="${cliente.cep}">
			</li>
			
			<li>Logradouro<br /> 
				<input type="text" class="form-control" name="cliente.logradouro" placeholder="Logradouro" value="${cliente.logradouro}" >
			</li>
			
			<li>Complemento<br />
				<input type="text" class="form-control" name="cliente.complemento" placeholder="Complemento" value="${cliente.complemento}">
			</li>
			
		</ul>	
	</fieldset>
	
	<fieldset>
		<legend>Contato</legend>		
		<ul>
			<li>Telefone<br/>
				<input type="tel" class="form-control" name="cliente.fone" placeholder="Telefone" value="${cliente.fone}" />
			</li>
			
			<li>Celular<br />
				<input type="tel" class="form-control" name="cliente.celular" placeholder="Celular" value="${cliente.celular}" />
			</li>
			
			<li>E-Mail<br />
				<input type="email" class="form-control" name="cliente.email" placeholder="E-Mail" value="${cliente.email}" />
			</li>
			
		</ul>	
	</fieldset>
	<c:import url="_tbar.jsp" />
</form>

<%@ include file="/_footer.jsp" %> 