<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="entidad.Docente"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<link href="css/stylehome.css" rel="stylesheet" type="text/css">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</head>
<body>

	<%
		HttpSession misession = (HttpSession) request.getSession();

	Docente docente = (Docente) misession.getAttribute("Docente");

	String user = (String) misession.getAttribute("user");

	if (user == null) {
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

				<li class="nav-item"><a href="servletProfesor"
					style="color: white;"><span class="glyphicon glyphicon-book"
						style="color: white;"></span> Cursos</a></li>
				<li class="nav-item"><a href="cambiarPass.jsp"
					style="color: white;"><span class="glyphicon glyphicon-refresh"
						style="color: white;"></span> Cambiar contraseña</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a href="" data-toggle="dropdown"
					class="dropdown-toggle" style="color: white;"> <span></span> <small>Bienvenido,</small>
						<%=docente.getApellido()%> <%=docente.getNombre()%><b
						class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a href="index.jsp"><i class="glyphicon glyphicon-off"></i>
								Cerrar sesion</a></li>
					</ul></li>
			</ul>
		</div>
	</div>
	<div class="container" style="margin-top: 50px;">
		<div class="row">
			<div class="col-md-5">
				<div class="card-base">
					<div class="card-icon">
						<a href="#" title="Cursos" id="widgetCardIcon" class="imagecard"><span
							class="glyphicon glyphicon-book" style="text-align: center;"></span></a>
						<div class="card-data widgetCardData">
							<h2 class="box-title" style="color: #bb7824;">Cursos</h2>
							<p class="card-block text-center" style="color: white;">Podrá
								ver el listado de cursos.</p>
							<a href="servletProfesor" title="Reportes"
								class="anchor btn btn-default"
								style="background: #bb7824; border: #bb7824;"> <i
								class="fa fa-paper-plane" aria-hidden="true"></i>  Ingresar
							</a>
						</div>
					</div>
					<div class="space"></div>
				</div>
			</div>

			<div class="col-md-5">
				<div class="card-base">
					<div class="card-icon">
						<a href="#" title="Cambiar pass" id="widgetCardIcon"
							class="imagecard"><span class="glyphicon glyphicon-refresh"
							style="text-align: center;"></span></a>
						<div class="card-data widgetCardData">
							<h2 class="box-title" style="color: #bb7824;">Cambiar
								contraseña</h2>
							<p class="card-block text-center" style="color: white;">Podrá
								cambiar la contraseña de su usuario.</p>
							<a href="cambiarPass.jsp" title="Contraseña"
								class="anchor btn btn-default"
								style="background: #bb7824; border: #bb7824;"> <i
								class="fa fa-paper-plane" aria-hidden="true"></i>  Ingresar
							</a>
						</div>
					</div>
					<div class="space"></div>
				</div>
			</div>
		</div>

	</div>
</body>
</html>