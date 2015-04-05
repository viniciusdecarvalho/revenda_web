<%@ include file="/WEB-INF/partial/_header.jsp" %>

    <div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
               	<h1>${t['app.name']}</h1>
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                        <h2 class="panel-title">${t['app.login.titulo']}</h2>
                    </div>
                    <div class="panel-body">
                        <form role="form" action="${linkTo[HomeController].login}" method="post">
                            <fieldset>
                                <div class="form-group input-group">
                                    <span class="input-group-addon"><i class="fa fa-user"></i></span>
                                    <input class="form-control" placeholder="Login" name="usuario.login" type="text" value="${ usuario.login }" autofocus>
                                </div>
                                <div class="form-group input-group">
                                    <span class="input-group-addon"><i class="fa fa-lock"></i></span>
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
                                <button type="submit" class="btn btn-lg btn-primary btn-block">${t['app.entra']}</button>
                            </fieldset>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

<%@ include file="/WEB-INF/partial/_footer.jsp" %>
