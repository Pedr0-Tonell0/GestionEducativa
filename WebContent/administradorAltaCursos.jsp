
<%@page import="entidad.Curso"%>
<%@page import="negocioImpl.AlumnoNegocioImpl"%>
<%@page import="negocioImpl.DocenteNegocioImpl"%>
<%@page import="entidad.Docente"%>
<%@page import="entidad.Alumno"%>
<%@page import="com.sun.xml.internal.bind.v2.schemagen.xmlschema.Import"%>
<%@page import="entidad.Materia"%>
<%@page import="java.util.ArrayList"%>
<%@page import="javax.swing.JTextField"%>
<%@page import="javax.swing.DefaultListModel"%>
<%@page import="javax.swing.JList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="negocioImpl.MateriaNegocioImpl"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" />
<link rel="icon" type="image/png" href="assets/img/favicon.ico">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

<title>Alta</title>
<meta
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0"
	name="viewport" />
<!-- Canonical SEO -->
<link rel="canonical"
	href="https://www.creative-tim.com/product/fresh-bootstrap-table" />
<!--  Social tags    -->
<meta name="keywords"
	content="creative tim, html table, html css table, web table, freebie, free bootstrap table, bootstrap, css3 table, bootstrap table, fresh bootstrap table, frontend, modern table, responsive bootstrap table, responsive bootstrap table">
<meta name="description"
	content="Probably the most beautiful and complex bootstrap table you've ever seen on the internet, this bootstrap table is one of the essential plugins you will need.">
<!-- Schema.org markup for Google+ -->
<meta itemprop="name" content="Fresh Bootstrap Table by Creative Tim">
<meta itemprop="description"
	content="Probably the most beautiful and complex bootstrap table you've ever seen on the internet, this bootstrap table is one of the essential plugins you will need.">
<meta itemprop="image"
	content="http://s3.amazonaws.com/creativetim_bucket/products/31/original/opt_fbt_thumbnail.jpg">
<!-- Twitter Card data -->
<meta name="twitter:card" content="product">
<meta name="twitter:site" content="@creativetim">
<meta name="twitter:title"
	content="Fresh Bootstrap Table by Creative Tim">
<meta name="twitter:description"
	content="Probably the most beautiful and complex bootstrap table you've ever seen on the internet, this bootstrap table is one of the essential plugins you will need.">
<meta name="twitter:creator" content="@creativetim">
<meta name="twitter:image"
	content="http://s3.amazonaws.com/creativetim_bucket/products/31/original/opt_fbt_thumbnail.jpg">
<meta name="twitter:data1"
	content="Fresh Bootstrap Table by Creative Tim">
<meta name="twitter:label1" content="Product Type">
<meta name="twitter:data2" content="Free">
<meta name="twitter:label2" content="Price">

<!-- Open Graph data -->
<meta property="og:title"
	content="Fresh Bootstrap Table by Creative Tim" />
<meta property="og:type" content="article" />
<meta property="og:url"
	content="https://wenzhixin.github.io/fresh-bootstrap-table/compact-table.html" />
<meta property="og:image"
	content="http://s3.amazonaws.com/creativetim_bucket/products/31/original/opt_fbt_thumbnail.jpg" />
<meta property="og:description"
	content="Probably the most beautiful and complex bootstrap table you've ever seen on the internet, this bootstrap table is one of the essential plugins you will need." />
<meta property="og:site_name" content="Creative Tim" />


<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.4.1/css/bootstrap.min.css">
<link href="css/fresh-bootstrap-table.css" rel="stylesheet" />
<link href="css/demo.css" rel="stylesheet" />
<link rel="stylesheet" href="css/StyleAdministradorGestionCursos.css">
<link rel="stylesheet" href="css/styleAdministradorReporte.css">
<link href="css/stylehome.css" rel="stylesheet" type="text/css">

<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.6.3/css/all.css"
	integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/"
	crossorigin="anonymous">
<link href="http://fonts.googleapis.com/css?family=Roboto:400,700,300"
	rel="stylesheet" type="text/css">

<script src="https://code.jquery.com/jquery-3.3.1.min.js"
	integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script
	src="https://unpkg.com/bootstrap-table/dist/bootstrap-table.min.js"></script>

<!--  Just for demo purpose, do not include in your project   -->
<script src="js/gsdk-switch.js"></script>
<script src="js/jquery.sharrre.js"></script>
<script src="js/demo.js"></script>
<script>function soloNumeros(e){
	  var key = window.event ? e.which : e.keyCode;
	  if (key < 48 || key > 57) {
	    e.preventDefault();
	  }
	}</script>
</head>
<body>

	<%
		HttpSession misession = (HttpSession) request.getSession();

	String user = (String) misession.getAttribute("Usuario");

	if (user == null) {
		RequestDispatcher view = request.getRequestDispatcher("/index.jsp");
		view.forward(request, response);
	}
	%>
	<form method="post" action="servletAltaCursos">
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
						<li><a ><i  style="color: white;" class="glyphicon glyphicon-list-alt"></i>
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
						Cambiar usuarios/contrasenias</a></li>
			</ul>
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown"><a data-toggle="dropdown"
						class="dropdown-toggle" style="color: white;"> <span></span> <small>Bienvenido,</small>
							<%=user%> <b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="index.jsp"><i class="glyphicon glyphicon-off"></i>
									Cerrar sesion</a></li>
						</ul></li>
				</ul>
			</div>
		</div>

			<h2
				style="color: white; align-items: center; display: block; margin-left: 800px;">
				<b>Alta de curso</b>
			</h2>


			<div class="container">
				<div class="row">

					<div class="fresh-table full-color-blue">


						<div class="container">

							<h4 style="color: white;">
								Seleccione las siguientes opciones
								</h3>
								<select
									class="form-control btn btn-default dropdown-toggle browser-default custom-select"
									name="selectMateria"
									style="background-color: gray; width: 50%; margin-top: 10px; margin-bottom: 10px;"
									id="selectMateria">
									<option value="0" selected>Selecciona una materia</option>
									<%
										ArrayList<Materia> listaMaterias = (ArrayList) request.getAttribute("listaMaterias");

									if (listaMaterias != null) {
										for (Materia materia : listaMaterias) {
									%>
									<option value="<%=materia.getIdMateria()%>"><%=materia.getNombre()%></option>

									<%
										}
									}
									%>

								</select><select
									class="form-control btn btn-default dropdown-toggle browser-default custom-select"
									name="selectDocente" id="selectDocente"
									style="background-color: gray; width: 50%; margin-top: 10px; margin-bottom: 10px;">
									<option value="0" selected>Selecciona un Docente</option>
									<%
										ArrayList<Docente> listaDocentes = (ArrayList) request.getAttribute("listaDocentes");

									if (listaDocentes != null) {
										for (Docente docente : listaDocentes) {
									%>
									<option value="<%=docente.getLegajo()%>"><%=docente.getNombre() + " " + docente.getApellido()%></option>
									<%
										}
									}
									%>
								</select> <select
									class="form-control btn btn-default dropdown-toggle browser-default custom-select "
									name="selectCuatrimestre" id="selectCuatrimestre"
									style="background-color: gray; width: 50%; margin-top: 10px; margin-bottom: 10px;">
									<option value="0" selected>Cuatrimestre</option>
									<option value="1">Cuatrimestre 1</option>
									<option value="2">Cuatrimestre 2</option>
								</select><select name="selectAnio" id="selectAnio"
									style="background-color: gray; width: 50%; margin-top: 10px; margin-bottom: 10px;"
									class="form-control btn btn-default dropdown-toggle browser-default custom-select">
									<option value="0" selected>Año</option>
									<option value="2018">2018</option>
									<option value="2019">2019</option>
									<option value="2020">2020</option>
									<option value="2021">2021</option>
									<option value="2022">2022</option>
								</select>
						</div>
					</div>
				</div>
			</div>

			<div class="container">
				<div class="row">

					<div class="col-md-12">

						<div class="fresh-table full-color-blue">
							<div class="col-md-4"></div>

							<table id="fresh-table" class="table">
								<thead>
									<th data-field="#" data-sortable="true">#</th>
									<th data-field="Legajo" data-sortable="true">Legajo</th>
									<th data-field="Dni" data-sortable="true">Dni</th>
									<th data-field="Nombre" data-sortable="true">Nombre</th>
									<th data-field="Email" data-sortable="true">Email</th>
									<th data-field="Telefono" data-sortable="true">Telefono</th>
									<th><input type="checkbox" value=""></th>
								</thead>
								<tbody>
									<%
										int contador = 0;
									ArrayList<Alumno> listaAlumnos = (ArrayList<Alumno>) request.getAttribute("listaAlumnos");

									if (listaAlumnos != null) {
										for (Alumno alumno : listaAlumnos) {
									%>
									<tr>
										<th scope="row"><%=++contador%></th>
										<td><%=alumno.getLegajo()%></td>
										<td><%=alumno.getDNI()%></td>
										<td><%=alumno.getApellido() + " " + alumno.getNombre()%></td>
										<td><%=alumno.getMail()%></td>
										<td><%=alumno.getTelefono()%></td>
										<td><input type="checkbox"
											value='<%=alumno.getLegajo()%>' name="fila"></td>
									</tr>
									<%
										}
									}
									%>


								</tbody>
							</table>
							<%
								if (request.getAttribute("Inserto") != null) {
								if (request.getAttribute("Inserto") == "SI") {
							%>
							<br> <label
								style="color: white; font-size: 20px; font-family: 'Cairo', sans-serif; margin-left: 100px;">
								Curso dado de alta correctamente</label>
							<%
								} else {
							%>
							<br> <label
								style="color: white; font-size: 20px; font-family: 'Cairo', sans-serif; margin-left: 100px;">
								Error al dar de alta el curso, verifique los datos</label>

							<%
								}
							} else {
							%>
							<br> <label
								style="color: white; font-size: 20px; font-family: 'Cairo', sans-serif; margin-left: 100px;">
								Debe seleccionar todos los campos</label>
							<%
								}
							%>
							<hr>

							<input type="submit" value="Agregar"
								class="btn btn-info btn-fille active" name="btnAgregarCurso"
								style="width: 60%; background-color: #ffb33b; align-items: center; position: relative; left: 20%; margin-bottom: 20px;"
								id="btnAgregarCurso"><br>

						</div>
					</div>
				</div>
			</div>
		</div>
	</form>
</body>

<script type="text/javascript">
	var $table = $('#fresh-table')
	var $alertBtn = $('#alertBtn')

	window.operateEvents = {
		'click .like' : function(e, value, row, index) {
			alert('You click like icon, row: ' + JSON.stringify(row))
			console.log(value, row, index)
		},
		'click .edit' : function(e, value, row, index) {
			alert('You click edit icon, row: ' + JSON.stringify(row))
			console.log(value, row, index)
		},
		'click .remove' : function(e, value, row, index) {
			$table.bootstrapTable('remove', {
				field : 'id',
				values : [ row.id ]
			})
		}
	}

	$(function() {
		$table.bootstrapTable({
			classes : 'table table-hover table-striped',
			toolbar : '.toolbar',

			search : true,
			showRefresh : false,
			showToggle : true,
			showColumns : true,
			pagination : true,
			striped : true,
			sortable : true,
			pageSize : 7,
			pageList : [ 7, 14, 21, 28 ],

			formatShowingRows : function(pageFrom, pageTo, totalRows) {
				return ''
			},
			formatRecordsPerPage : function(pageNumber) {
				return pageNumber + ' rows visible'
			}
		})

		$alertBtn.click(function() {
			alert('You pressed on Alert')
		})
	})

	$('#sharrreTitle').sharrre(
			{
				share : {
					twitter : true,
					facebook : true
				},
				template : '',
				enableHover : false,
				enableTracking : true,
				render : function(api, options) {
					$("#sharrreTitle").html(
							'Thank you for ' + options.total + ' shares!')
				},
				enableTracking : true,
				url : location.href
			})
</script>

<script>
	(function(i, s, o, g, r, a, m) {
		i['GoogleAnalyticsObject'] = r;
		i[r] = i[r] || function() {
			(i[r].q = i[r].q || []).push(arguments)
		}, i[r].l = 1 * new Date();
		a = s.createElement(o), m = s.getElementsByTagName(o)[0];
		a.async = 1;
		a.src = g;
		m.parentNode.insertBefore(a, m)
	})(window, document, 'script', '//www.google-analytics.com/analytics.js',
			'ga')

	ga('create', 'UA-46172202-1', 'auto')
	ga('send', 'pageview')
</script>
</html>