<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@page import="java.util.ArrayList"%>
<%@page import="entidad.Datos"%>


<html lang="en">
<head>
<meta charset="utf-8" />
<link rel="icon" type="image/png" href="assets/img/favicon.ico">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
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
</head>

<body>
	<%
		HttpSession misession = (HttpSession) request.getSession();

		String user = (String) misession.getAttribute("Usuario");

		if (user == null) {
			RequestDispatcher view = request.getRequestDispatcher("/index.jsp");
			view.forward(request, response);
		}

		ArrayList<Datos> lista = null;
		if (request.getAttribute("lista") != null) {
			lista = (ArrayList<Datos>) request.getAttribute("lista");
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

				<li class="nav-item"><a href="servletPersonas"
					style="color: white;"><span class="glyphicon glyphicon-user"
						style="color: white;"></span> Personas</a></li>
				<li class="nav-item"><a href="AdministradorReporte.jsp" style="color: white;"><span
						class="glyphicon glyphicon-book" style="color: white;"></span>
						Reportes</a></li>
				<li class="nav-item"><a href="servletUsuarios"
					style="color: white;"><span class="glyphicon glyphicon-refresh"
						style="color: white;"></span> Cambiar usuarios/contrasenias</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a data-toggle="dropdown"
					class="dropdown-toggle" style="color: white;"> <span></span> <small>Bienvenido,</small>
						<%=user%> <b class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a href="index.jsp"><i
								class="glyphicon glyphicon-off"></i> Cerrar sesion</a></li>
					</ul></li>
			</ul>
		</div>
	</div>

			<div class="row">
				<div class="col-md-12 col-md-offset-2" style="margin-left: 1%;">
					<div class="description">
						<label style="font-size: 22px;">DATOS DE LOS PROFESORES</label>
					</div>

					<div class="fresh-table full-color-green" style="width: 100%;">

						<table id="fresh-table" class="table">
							<thead>
								<th data-field="Legajo" data-sortable="true">Legajo</th>
								<th data-field="DNI" data-sortable="true">DNI</th>
								<th data-field="Nombre" data-sortable="true">Nombre</th>
								<th data-field="Apellido" data-sortable="true">Apellido</th>
								<th data-field="Edad" data-sortable="true">Edad</th>
								<th data-field="Mail" data-sortable="true">Mail</th>
								<th data-field="Telefono" data-sortable="true">Telefono</th>
								<th data-field="Cantidad" data-sortable="true">Cantidad de
									cursos</th>
								<th data-field="Direccion" data-sortable="true">Direccion</th>
								<th data-field="Localidad" data-sortable="true">Localidad</th>
								<th data-field="Provincia" data-sortable="true">Provincia</th>
								<th data-field="Usuario" data-sortable="true">Usuario</th>
								<th data-field="Contrasenia" data-sortable="true">Contrasenia</th>


							</thead>
							<tbody>
								<%
									if (lista != null) {
										for (Datos datos : lista) {
								%>
								<tr>
									<td><%=datos.getLegajo()%></td>
									<td><%=datos.getDni()%></td>
									<td><%=datos.getNombre()%></td>
									<td><%=datos.getApellido()%></td>
									<td><%=datos.getEdad()%></td>
									<td><%=datos.getEmail()%></td>
									<td><%=datos.getTelefono()%></td>
									<td><%=datos.getCantidadCursos()%></td>
									<td><%=datos.getDireccion()%></td>
									<td><%=datos.getLocalidad().getDescripcion()%></td>
									<td><%=datos.getProvincia().getDescripcion()%></td>
									<td><%=datos.getUsuario().getUsuario()%></td>
									<td><%=datos.getUsuario().getContrasenia()%></td>

								</tr>

								<%
									}
									}
								%>


							</tbody>
						</table>
					</div>

				</div>
			</div>
		</div>
	</div>



</body>
<script type="text/javascript">
	var $table = $('#fresh-table')

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
			showToggle : true,
			showColumns : true,
			pagination : true,
			striped : true,
			sortable : true,
			pageSize : 5,
			pageList : [ 5, 10, 15, 20, 25 ],

			formatShowingRows : function(pageFrom, pageTo, totalRows) {
				return ''
			},
			formatRecordsPerPage : function(pageNumber) {
				return pageNumber + ' rows visible'
			}
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