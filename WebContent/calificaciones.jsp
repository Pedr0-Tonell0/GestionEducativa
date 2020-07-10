<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="entidad.Alumno"%>
<%@page import="entidad.Curso"%>
<%@page import="java.util.ArrayList"%>
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

		String user = (String) misession.getAttribute("user");

		if (user == null) {
			RequestDispatcher view = request.getRequestDispatcher("/index.jsp");
			view.forward(request, response);
		}
		ArrayList<Alumno> lista = null;
		if (request.getAttribute("listaAlumnos") != null) {
			lista = (ArrayList<Alumno>) request.getAttribute("listaAlumnos");
		}
	%>
	<%
		int cursoActivo = 0;
		if (request.getAttribute("curso") != null) {
			cursoActivo = (Integer) request.getAttribute("curso");
		}
	%>
	<form action="servletNotas" method="post">

		<div class="wrapper">
			<div class="container">
				<div class="row">
					<div class="description">
						<label style="font-size: 22px;">CALIFICAR CURSO</label>
					</div>

					<div class="fresh-table full-color-red" style="width: 100%;">
						<div class="toolbar">
							<button id="alertBtn" class="btn btn-default">Refrescar</button>
						</div>
						<table id="fresh-table" class="table">
							<thead>
								<th data-field="Legajo" data-sortable="true">Legajo</th>
								<th data-field="Apellido" data-sortable="true">Apellido</th>
								<th data-field="Nombre" data-sortable="true">Nombre</th>
								<th data-field="Parcial 1" data-sortable="true">Parcial 1</th>
								<th data-field="Parcial 2" data-sortable="true">Parcial 2</th>
								<th data-field="Recuperatorio 1" data-sortable="true">Recuperatorio
									1</th>
								<th data-field="Recuperatorio 2" data-sortable="true">Recuperatorio
									2</th>
								<th data-field="Estado" data-sortable="true">Estado</th>
								<th data-field="Calificar" data-sortable="true">Calificar</th>
							</thead>
							<tbody>

								<%
									if (lista != null) {
										for (Alumno alumnos : lista) {
								%>
								<tr>
									<td><%=alumnos.getLegajo()%></td>
									<td><%=alumnos.getApellido()%></td>
									<td><%=alumnos.getNombre()%></td>

									<td><input style="color: black; width: 100px;"
										type="number" name="notas"
										value="<%=alumnos.getCalificaciones().getParcial1()%>"
										max="10" min="0" required></td>
									<td><input style="color: black; width: 100px;"
										type="number" name="notas"
										value="<%=alumnos.getCalificaciones().getParcial2()%>"
										max="10" min="0" required></td>
									<td><input style="color: black; width: 100px;"
										type="number" name="notas"
										value="<%=alumnos.getCalificaciones().getRecuperatorio1()%>"
										max="10" min="0" required></td>
									<td><input style="color: black; width: 100px;"
										type="number" name="notas"
										value="<%=alumnos.getCalificaciones().getRecuperatorio2()%>"
										max="10" min="0" required></td>
									<td><select style="color: black;" class="cboxEstado"
										name="cboxEstado" id="cboxEstado" required>
											<%if(alumnos.getID_Estado() == 1 )
											{%>
												<option selected value="<%=alumnos.getID_Estado()%>"><%= alumnos.getCondicion() %></option>
												<option style="color: black;" value="2">Libre</option>
											<%}
											else
											{%>
												<option selected value="<%=alumnos.getID_Estado()%>"><%= alumnos.getCondicion() %></option>
												<option style="color: black;" value="1">Regular</option>
											<%}%>
											
									</select></td>
									<td><input type="checkbox"
										value='<%=alumnos.getLegajo()%>' name="legajos" required>
									</td>
								</tr>
								<%}} %>
							</tbody>
						</table>
						<input type="hidden" value='<%=cursoActivo%>' class="myButton"
							name="btnCalificar" id="btnCalificar">
						<center>
							<input type="submit" id="btnAgregarCalificacion"
								name="btnAgregarCalificacion" class="btn btn-primary btn-xs"
								value="Cargar calificaciones" style="margin-top: 1px;">
							<a style="margin-left: 10px;" type="submit"
								class="btn btn-primary btn-xs" href="servletProfesor">Volver</a>
						</center>


						<br></br>
						<%
							if (request.getAttribute("mensaje") != null) {
						%>
						<center>
							<label
								style="color: white; font-size: 16px; font-family: 'Cairo', sans-serif; margin-left: 50px;">
								Calificaciones cargadas correctamente</label>
						</center>
						<br></br>
						<%
							}
						%>

					</div>

				</div>
			</div>
		</div>
	</form>


</body>
<script type="text/javascript">
	var $table = $('#fresh-table')
	var $alertBtn2 = $('#alertBtn2')

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
		})
		$refresh.click(function() {
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