<%@page import="java.time.LocalDate"%>
<%@page import="entidad.Persona"%>
<%@page import="com.sun.xml.internal.bind.v2.schemagen.xmlschema.Import"%>
<%@page import="entidad.Roll"%>
<%@page import="entidad.Provincia"%>
<%@page import="entidad.Localidad"%>
<%@page import="java.util.ArrayList"%>
<%@page import="javax.swing.JTextField"%>
<%@page import="javax.swing.DefaultListModel"%>
<%@page import="javax.swing.JList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="negocioImpl.PersonaNegocioImpl"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/jquery.min.js"></script>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<link href="css/stylepersonas.css" rel="stylesheet" type="text/css">
<link href="css/botonEliminar.css" rel="stylesheet" type="text/css">
<link href="css/botonModificar.css" rel="stylesheet" type="text/css">
<link href="css/botonBuscar.css" rel="stylesheet" type="text/css">
<link href="css/botonAgregar.css" rel="stylesheet" type="text/css">
<link href="css/botonRefresh.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/validaciones.js"></script>
<%@include file="css-js.jsp"%>
</head>
<body>

	<form method="post" action="">
		<%
			HttpSession misession = (HttpSession) request.getSession();

		String user = (String) misession.getAttribute("Usuario");

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
					<li class=""><a href="homeadm.jsp" style="color: white;"><span
							class="glyphicon glyphicon-home" style="color: white;"></span>
							Principal</a></li>

					<li class="dropdown"><a href="" data-toggle="dropdown"
						style="color: white;"><span
							class="glyphicon glyphicon-list-alt" style="color: white;"></span>
							Cursos</a><b class="caret"></b>
						<ul class="dropdown-menu">
							<li><a href="servletAltaCursos"><i style="color: white;"
									class="glyphicon glyphicon-list-alt"></i> Alta de cursos</a></li>
							<li><a href="servletBMcursos"><i style="color: white;"
									class="glyphicon glyphicon-list-alt"></i> Baja y Modificar
									cursos</a></li>
						</ul></li>

					<li class="nav-item"><a style="color: white;"><span
							class="glyphicon glyphicon-user" style="color: white;"></span>
							Personas</a></li>
					<li class="nav-item"><a href="AdministradorReporte.jsp"
						style="color: white;"><span class="glyphicon glyphicon-book"
							style="color: white;"></span> Reportes</a></li>
					<li class="nav-item"><a href="servletUsuarios"
						style="color: white;"><span
							class="glyphicon glyphicon-refresh" style="color: white;"></span>
							Cambiar usuarios/contraseñas</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown"><a href="" data-toggle="dropdown"
						class="dropdown-toggle" style="color: white;"> <span></span> <small>Bienvenido,</small>
							<%=user%> <b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="index.jsp"><i
									class="glyphicon glyphicon-off"></i> Cerrar sesion</a></li>
						</ul></li>
				</ul>
			</div>
		</div>
	</form>

	<div class="div_caja" style="height: 600px; margin-top: 0px !important">
		<header class="heading"> Ingresá los datos</header>
		<hr></hr>
		<div class="row">
			<form action="servletPersonas" method="post">
				<div class="col-sm-12">
					<div class="row">
						<div class="col-xs-4">
							<label class="roll" style="padding-left: 59px;">Roll</label>
						</div>
						<div class="col-sm-4">
							<select class="btn btn-default select_roll" name="selectRoll"
								id="selectRoll">
								<%
									String roll = (String) request.getAttribute("roll");
								if (roll != null) {
								%>
								<option selected><%=roll%></option>
								<%
									} else {
									ArrayList<Roll> listaRoll = (ArrayList<Roll>) request.getAttribute("listaRoll");
									if (listaRoll.size() > 0) {
										for (Roll unRoll : listaRoll) {
								%>
								<option><%=unRoll.getRoll()%></option>
								<%
									}
								}
								}
								%>
							</select>
						</div>
					</div>
				</div>
				<div class="col-sm-12">
					<div class="row">
						<div class="col-xs-4">
							<label class="nombre" style="padding-left: 4px;">Nombre</label>
						</div>
						<div class="col-xs-6">
							<input id="email" type="text" name="txtNombre"
								class="form-control" value="${persona.getNombre()}"
								required="true">

						</div>
					</div>
				</div>

				<div class="col-sm-12">
					<div class="row">
						<div class="col-xs-4">
							<label class="apellido" style="padding-left: 4px;">Apellido</label>
						</div>
						<div class="col-xs-6">
							<input type="text" name="txtApellido" id="apellido"
								class="form-control last" value="${persona.getApellido()}"
								required="true">
						</div>
					</div>
				</div>
				<div class="col-sm-12">
					<div class="row">
						<div class="col-xs-4">
							<label class="dni" style="padding-left: 70px;">Dni</label>
						</div>
						<div class="col-xs-6" style="padding-top: 5px;">
							<%
								if (request.getAttribute("dni") != null) {
							%>
							<input type="text" name="txtDni" id="dni" class="form-control"
								value="${persona.getDni()}" readonly="true">
							<%
								} else {
							%><input type="text" name="txtDni" id="dni" class="form-control"
								onkeypress="if ( isNaN( String.fromCharCode(event.keyCode) )) return false;"
								value="${persona.getDni()}" required="true">
							<%
								}
							%>
						</div>
					</div>
				</div>

				<div class="col-sm-12">
					<div class="row">
						<div class="col-xs-4">
							<label class="dni">Fec. Nacimiento</label>
						</div>
						<div class="col-xs-6" style="margin-top: 5px;">
							<ul class="nav nav-stacked">

								<%
									LocalDate fecha = (LocalDate) request.getAttribute("fechaNacimiento");

								if (fecha != null) {
								%>
								<fmt:formatDate value=<%=fecha%> pattern="yyyy/MM/dd"
									var="myDate" />
								<input name="dateFrom" class="form-control" type="date"
									min="1940-01-01" max="3000-01-01" path="foo" id="bar"
									value=<%=fecha%> />
								<%
									} else {
								%>
								<li><input type="date" class="form-control" name="dateFrom"
									min="1940-01-01" max="3000-01-01" name="date" /></li>
								<%
									}
								%>
							</ul>
						</div>
					</div>
				</div>

				<div class="col-sm-12">
					<div class="row">
						<div class="col-xs-4">
							<label class="roll" style="padding-left: 23px;">Provincia</label>
						</div>
						<div class="col-sm-4">
							<select id="idProvincia" class="btn btn-default select_roll"
								style="margin-top: 5px;" name="selectProvincia"
								id="selectProvincia" required="true">
								<option selected>Selecciona una provincia</option>
								<%
									Provincia provincia = (Provincia) request.getAttribute("provincia");
								if (provincia != null) {
								%>
								<option selected><%=provincia.getDescripcion()%></option>
								<%
									}
								ArrayList<Provincia> listaProvincias = (ArrayList<Provincia>) request.getAttribute("listaProvincias");
								if (listaProvincias.size() > 0) {
									for (Provincia unaProvincia : listaProvincias) {
								%>
								<option><%=unaProvincia.getDescripcion()%></option>
								<%
									}
								}
								%>
							</select>
						</div>
					</div>
				</div>

				<div class="col-sm-12">
					<div class="row">
						<div class="col-xs-4">
							<label class="roll" style="padding-left: 23px;">Localidad</label>
						</div>
						<div class="col-sm-4">
							<select id="idLocalidad" class="btn btn-default select_roll"
								style="margin-top: 5px;" name="selectLocalidad"
								id="selectLocalidad" required="true">
								<option selected>Selecciona una localidad</option>
								<%
									Localidad localidad = (Localidad) request.getAttribute("localidad");
								if (localidad != null) {
								%>
								<option selected><%=localidad.getDescripcion()%></option>
								<%
									}
								ArrayList<Localidad> listaLocalidades = (ArrayList<Localidad>) request.getAttribute("listaLocalidades");
								if (listaLocalidades.size() > 0) {
									for (Localidad unaLocalidad : listaLocalidades) {
								%>
								<option><%=unaLocalidad.getDescripcion()%></option>
								<%
									}
								}
								%>
							</select>
						</div>
					</div>
				</div>

				<div class="col-sm-12">
					<div class="row">
						<div class="col-xs-4">
							<label class="mail" style="padding-left: 15px;">Direccion</label>
						</div>
						<div class="col-xs-6">
							<input type="text" name="txtDireccion" id="idDireccion"
								class="form-control" style="margin-top: 5px;"
								value="${persona.getDireccion()}" required="true">
						</div>
					</div>
				</div>

				<div class="col-sm-12">
					<div class="row">
						<div class="col-xs-4">
							<label class="mail" style="padding-left: 40px;">Email</label>
						</div>
						<div class="col-xs-6">
							<input type="text" name="txtEmail" id="email"
								class="form-control" value="${persona.getEmail()}"
								required="true">
						</div>
					</div>
				</div>
				<div class="col-sm-12">
					<div class="row">
						<div class="col-xs-4">
							<label class="telefono">Telefono</label>
						</div>
						<div class="col-xs-6">
							<input type="text" name="txtTelefono" id="telefono"
								class="form-control"
								onkeypress="if ( isNaN( String.fromCharCode(event.keyCode) )) return false;"
								value="${persona.getTelefono()}" required="true">
						</div>
					</div>
				</div>

				<div class="col-sm-12">
					<div class="col-sm-18" style="padding-top: 20px;">
						<a><input name="btnAgregar" type="submit" value="Agregar"
							class="btn btn-warning" onclick="validar()"> <input
							type="hidden" class="myButton" name="btnActualizar"
							id="btnActualizar"></a><a class=buttonAgregar href="#"> </a>
					</div>
				</div>
				<div id="error"></div>
				<%
					if (request.getAttribute("mensaje") != null) {
				%>
				<br> <label
					style="color: red; font-size: 16px; font-family: 'Cairo', sans-serif; margin-left: auto; margin-top: 5px;">
					<%
						out.print(request.getAttribute("mensaje"));
					%>
				</label>
				<%
					}
				%>
			</form>
		</div>
	</div>

	<div class="div_caja2" id="tabListCategory"
		style="max-height: 240px !important; height: 240px; overflow-y: scroll;">
		<div class="mdl-grid">
			<div class="mdl-textfield mdl-js-textfield mdl-textfield--expandable">



				<label class="mdl-button mdl-js-button mdl-button--icon"
					for="buscar"> <i class="zmdi zmdi-search"></i>
				</label>
				<div class="mdl-textfield__expandable-holder"
					style="margin-bottom: 10px;">
					<a title="Refrescar tabla">
						<button type="submit" class="buttonRefresh" name="btnRefrescar"
							id="btnRefresh" style="margin-right: 15px;"
							onclick="javascript:window.location.reload();"></button>
					</a> <a><input type="text" onkeyup="doSearch()"
						class="mdl-textfield__input" id="buscar"> <label
						class="mdl-textfield__label"></label></a><a class="buttonBuscar"
						href="#"> </a>
				</div>
			</div>

			<table id="datos" number-per-page="3" current-page=""
				class="table table-bordered table-condensed"
				style="margin-bottom: 0px;">
				<thead>
					<tr>
						<th style="text-align: center;">Legajo</th>
						<th style="text-align: center;">DNI</th>
						<th style="text-align: center;">Nombre</th>
						<th style="text-align: center;">Apellido</th>
						<th style="text-align: center;">Telefono</th>
						<th style="text-align: center;">Email</th>
						<th style="text-align: center;">Acciones</th>
					</tr>
				</thead>
				<%
					ArrayList<Persona> listaPersonas = (ArrayList<Persona>) request.getAttribute("listaPersonas");
				%>
				<%
					for (Persona unaPersona : listaPersonas) {
				%>
				<tbody>
					<tr>
						<td><%=unaPersona.getLegajo()%></td>
						<td><%=unaPersona.getDni()%></td>
						<td><%=unaPersona.getNombre()%></td>
						<td><%=unaPersona.getApellido()%></td>
						<td><%=unaPersona.getTelefono()%></td>
						<td><%=unaPersona.getEmail()%></td>
						<td><form action="servletPersonas" method="post">

								<a title="Eliminar usuario">
									<button type="submit" class="button" name="btnBorrarPersona"
										id="btnBorrarPersona" style="margin-right: 15px;"></button> <input
									type="hidden" value="<%=unaPersona.getLegajo()%>"
									name="btnBorrar" id="btnBorrar">
								</a> 

							</form></td>
					</tr>
				</tbody>
				<%
					}
				%>
			</table>
		</div>
	</div>
</body>

<script type="text/javascript">
	function reFresh()
	location.reload(true)
	}
</script>

</html>