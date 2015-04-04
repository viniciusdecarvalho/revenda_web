<%@ include file="/partial/header.jsp" %>

    <div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Login de Acesso</h3>
                    </div>
                    <div class="panel-body">
                        <form role="form" action="${linkTo[HomeController].login}" method="post">
                            <fieldset>
                                <div class="form-group">
                                    <input class="form-control" placeholder="Login" name="usuario.login" type="text" value="${ usuario.login }" autofocus>
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="Senha" name="usuario.senha" type="password" value="">
                                </div>
                                <!-- 
                                <div class="checkbox">
                                    <label>
                                        <input name="remember" type="checkbox" value="Lembrar-me">Remember Me
                                    </label>
                                </div>
                                 -->
                                <!-- Change this to a button or input when using this as a form -->                                
                                <button type="submit" class="btn btn-lg btn-primary btn-block">Entrar</button>
                            </fieldset>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

<%@ include file="/partial/footer.jsp" %>
