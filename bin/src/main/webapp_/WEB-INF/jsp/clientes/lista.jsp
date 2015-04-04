<%@ include file="/_header.jsp" %> 

<div>
	<a href="${linkTo[ClientesController].form(0)}">Novo</a>
</div>

<table class="table table-striped table-hover table-responsive">
	<thead>
	  <tr>
	    <th>Nome/Razão Social</th>
	    <th>Cpf/Cnpj</th>
	    <th>Telefone/Celular</th>
	    <th>Editar</th>
	  </tr>
  	</thead>
  	<tbody>
		<c:forEach items="${clientes}" var="cliente">
			<tr>
		    	<td>${cliente.razaoSocial}</td>
		    	<td>${cliente.cpfCnpj}</td>
		    	<td>${cliente.fone}  ${cliente.celular }</td>
		    	<td>
		    		<a href="${linkTo[ClientesController].form(cliente.id)}">Editar</a>
		    	</td>
		  	</tr>
		</c:forEach>
  	</tbody>
</table>


<%@ include file="/_footer.jsp" %> 