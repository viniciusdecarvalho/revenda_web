
<div class="navbar-default sidebar" role="navigation">
    <div class="sidebar-nav navbar-collapse">
        <ul class="nav" id="side-menu">
            <li class="sidebar-search">
                <div class="input-group custom-search-form">
                    <input type="text" class="form-control" placeholder="Procurar..." id="search_input">
                    <span class="input-group-btn">
	                    <button class="btn btn-default" type="button" id="search_button">
	                        <i class="fa fa-search"></i>
	                    </button>
                	</span>
                </div>
                <!-- /input-group -->
            </li>
            <li>
                <a href="${linkTo[HomeController].home }"><i class="fa fa-home fa-fw"></i>Home</a>
            </li>
            <li>
                <a href="#"><i class="fa fa-gear fa-fw"></i> Cadastros<span class="fa-chevron-circle-right"></span></a>
                <ul class="nav nav-second-level">
                    <li>
                        <a href="${linkTo[ClientesController].lista}" ><i class="fa fa-users fa-fw"></i>Clientes</a>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-car fa-fw"></i>Veiculos</a>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-building fa-fw"></i>Fornecedores</a>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-money fa-fw"></i>Formas de Pagamentos</a>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-user fa-fw"></i>Funcionarios</a>
                    </li>
                </ul>
                <!-- /.nav-second-level -->
            </li>
            <li>
                <a href="#"><i class="fa fa-legal fa-fw"></i>Negociações<span class="fa-chevron-circle-right"></span></a>
                <ul class="nav nav-second-level">
                    <li>
                        <a href="#" ><i class="fa fa-arrow-down fa-fw"></i>Compra de Veiculos</a>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-arrow-up fa-fw"></i>Venda de Veiculos</a>
                    </li>                                
                </ul>
            </li>                        
        </ul>
    </div>
    <!-- /.sidebar-collapse -->
</div>