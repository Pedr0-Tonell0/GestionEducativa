<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.ArrayList"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js">
	
	
	</script>
<link href="css/stylehome.css" rel="stylesheet" type="text/css">
</head>
<body>
          <form action="servletHome" method="get">
          
          <% 
	HttpSession misession= (HttpSession) request.getSession();
	 
	String user = (String) misession.getAttribute("Usuario");
	 
	if(user == null)
	{
		RequestDispatcher view = request.getRequestDispatcher("/index.jsp");
		view.forward(request, response);
	}
	 %>
		
          
	<div class="container">

		<div class="navbar-header">
			<button data-target=".navbar-collapse" data-toggle="collapse"
				class="navbar-toggle" type="button">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
		</div>
		<div class="collapse navbar-collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<li class=""><a style="color: white;"><span
						class="glyphicon glyphicon-home" style="color: white;"></span>
						Principal</a></li>
					
						<li class="dropdown"><a href="" data-toggle="dropdown"
					style="color: white;"><span
						class="glyphicon glyphicon-list-alt" style="color: white;"></span>
						Cursos</a><b class="caret"></b>
					<ul class="dropdown-menu">
						<li><a href="servletAltaCursos"><i  style="color: white;" class="glyphicon glyphicon-list-alt"></i>
								Alta de cursos</a></li>
								<li><a href="servletBMcursos" ><i  style="color: white;" class="glyphicon glyphicon-list-alt"></i>
								Baja y Modificar cursos</a></li>
					</ul></li>
						
				<li class="nav-item"><a href="servletPersonas" style="color: white;"><span
						class="glyphicon glyphicon-user" style="color: white;"></span>
						Personas</a></li>
				<li class="nav-item"><a href="AdministradorReporte.jsp" style="color: white;"><span
						class="glyphicon glyphicon-book" style="color: white;"></span>
						Reportes</a></li>
						<li class="nav-item"><a href="servletUsuarios" style="color: white;"><span
						class="glyphicon glyphicon-refresh" style="color: white;"></span>
						Cambiar usuarios/contraseñas</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a href="" data-toggle="dropdown"
					class="dropdown-toggle" style="color: white;"> <span></span> <small>Bienvenido,</small>
					<%=user%>	 <b class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a href="index.jsp"><i class="glyphicon glyphicon-off"></i>
								Cerrar sesion</a></li>
					</ul></li>
			</ul>
		</div>
	</div>
	
	<div class="container" style="margin-top: 50px">
		<div class="row">
			<div class="col-md-4">
				<div class="card-base">
					<div class="card-icon">
						<a title="Cursos" id="widgetCardIcon" class="imagecard"><span
							class="glyphicon glyphicon-list-alt"></span></a>
						<div class="card-data widgetCardData">
							<h2 class="box-title" style="color: #bb7824;">Cursos</h2>
							<p class="card-block text-center" style="color: white;">Podrá
								dar de alta cursos</p>
							<a href="servletAltaCursos" title="Cursos" class="anchor btn btn-default"
								style="background: #bb7824; border: #bb7824;"> <i
								class="fa fa-paper-plane" aria-hidden="true"></i>  Ingresar
							</a>
						</div>
					</div>
					<div class="space"></div>
				</div>
			</div>
			<div class="col-md-4">
				<div class="card-base">
					<div class="card-icon">
						<a title="Cursos" id="widgetCardIcon" class="imagecard"><span
							class="glyphicon glyphicon-pencil"></span></a>
						<div class="card-data widgetCardData">
							<h2 class="box-title" style="color: #bb7824;">Cursos</h2>
							<p class="card-block text-center" style="color: white;">Podrá
								Modificar y borrar cursos.</p>
							<a href="servletBMcursos" title="Cursos" class="anchor btn btn-default"
								style="background: #bb7824; border: #bb7824;"> <i
								class="fa fa-paper-plane" aria-hidden="true"></i>  Ingresar
							</a>
						</div>
					</div>
					<div class="space"></div>
				</div>
			</div>
			<div class="col-md-4">
				<div class="card-base">
					<div class="card-icon">
						<a  title="Personas" id="widgetCardIcon" class="imagecard"><span
							class="glyphicon glyphicon-user"></span></a>
						<div class="card-data widgetCardData">
							<h2 class="box-title" style="color: #bb7824;">Personas</h2>
							<p class="card-block text-center" style="color: white;">Podrá
								dar de alta, modificar, borrar y listar.</p>
							<a href="servletPersonas" title="Personas" class="anchor btn btn-default"
								style="background: #bb7824; border: #bb7824;"> <i
								class="fa fa-paper-plane" aria-hidden="true"></i>  Ingresar
							</a>
						</div>
					</div>
					<div class="space"></div>
				</div>
			</div>
			<div class="col-md-4" style="margin-top: 20px">
				<div class="card-base">
					<div class="card-icon">
						<a title="Reportes" id="widgetCardIcon" class="imagecard"><span
							class="glyphicon glyphicon-book"></span></a>
						<div class="card-data widgetCardData">
							<h2 class="box-title" style="color: #bb7824;">Reportes</h2>
							<p class="card-block text-center" style="color: white;">Podrá
								ver reportes estadísticos.</p>
							<a href="AdministradorReporte.jsp" title="Reportes" class="anchor btn btn-default"
								style="background: #bb7824; border: #bb7824;"> <i
								class="fa fa-paper-plane" aria-hidden="true" ></i>  Ingresar
							</a>
						</div>
					</div>
					<div class="space"></div>
				</div>
			</div>
			
			<div class="col-md-4"  style="margin-top: 20px">
				<div class="card-base">
					<div class="card-icon">
						<a title="Profesores" id="widgetCardIcon" class="imagecard"><span
							class="glyphicon glyphicon-refresh"></span></a>
						<div class="card-data widgetCardData">
							<h2 class="box-title" style="color: #bb7824;">Cambiar contraseñas</h2>
							<p class="card-block text-center" style="color: white;">Podrá
								cambiar el usuario y/o la contraseña de los profesores.</p>
							<a href="servletUsuarios" title="Profesores" class="anchor btn btn-default"
								style="background: #bb7824; border: #bb7824;"> <i
								class="fa fa-paper-plane" aria-hidden="true" ></i>  Ingresar
							</a>
						</div>
					</div>
					<div class="space"></div>
				</div>
			</div>
			<div class="col-md-4"  style="margin-top: 20px">
				<div class="card-base">
					<div class="card-icon">
						<a title="Profesores" id="widgetCardIcon" class="imagecard"><span
							class="glyphicon glyphicon-cloud"></span></a>
						<div class="card-data widgetCardData">
							<h2 class="box-title" style="color: #bb7824;">Profesores</h2>
							<p class="card-block text-center" style="color: white;">Podrá
								ver los datos de todos los profesores.</p>
							<a href="servletListarDatosProfesores" title="Profesores" class="anchor btn btn-default"
								style="background: #bb7824; border: #bb7824;"> <i
								class="fa fa-paper-plane" aria-hidden="true" ></i>  Ingresar
							</a>
						</div>
					</div>
					<div class="space"></div>
				</div>
			</div>
		
		</div>

	</div>
	</form>
</body>
</html>