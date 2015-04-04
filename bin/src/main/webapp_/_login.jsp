<form action="${linkTo[HomeController].login}" method="post" class="form-inline">
	<fieldset>
		<legend>Login</legend>
		<input type="text" class="form-control" name="usuario.login" placeholder="Login" />
		<input type="password" class="form-control" name="usuario.senha" placeholder="Senha" />
		<input type="submit" value="Entrar" class="btn btn-primary" >
	</fieldset>
</form>