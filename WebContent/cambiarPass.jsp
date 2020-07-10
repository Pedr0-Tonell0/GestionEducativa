
<%@page import="entidad.Usuario"%>
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

<title>Modificar usuario y/o contraseña</title>
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
    	HttpSession misession= (HttpSession) request.getSession();
        	 
        	Docente docente = (Docente) misession.getAttribute("Docente");
        	String user = (String) misession.getAttribute("user");
        	String pass = (String) misession.getAttribute("pass");
        	
        	
        	if(user == null)
        	{
        		RequestDispatcher view = request.getRequestDispatcher("/index.jsp");
        		view.forward(request, response);
        	} %>

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
					<li class=""><a href="homeProfesor.jsp" style="color: white;"><span
							class="glyphicon glyphicon-home" style="color: white;"></span>
							Principal</a></li>
					<li class="nav-item"><a href="servletProfesor" style="color: white;"><span
							class="glyphicon glyphicon-list-alt" style="color: white;"></span>
							Cursos</a></li>
						<li class="nav-item"><a style="color: white;"><span
						class="glyphicon glyphicon-refresh" style="color: white;"></span>
						Cambiar contraseña</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown"><a a href="" data-toggle="dropdown"
						class="dropdown-toggle" style="color: white;"> <span></span> <small>Bienvenido,</small>
							<%=docente.getApellido()%>  <%=docente.getNombre()%> <b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="index.jsp"><i class="glyphicon glyphicon-off"></i>
									Cerrar sesion</a></li>
						</ul></li>
				</ul>
			</div>
		</div>

		<div class="row">
			<div class="col-md-6">
				<div class="container">
					<div class="row">

						<div class="fresh-table full-color-red"
							style="margin-top: 20px; margin-bottom: 5px; width: 80%; display: block; margin-left: 30%">
							<!-- Material form register -->
                           <form action="servletCambiarPass" method="post">
							<div class="container"></div>

	<label style="font-size: 16px; font-family: Roboto, Helvetica Neue, Open Sans, Arial, sans-serif; margin-top: 20px; color: white; text-align: center; display: block;">Cambiar contraseña</label>
								<hr>
    <label style="font-size: 16px; font-family: Roboto, Helvetica Neue, Open Sans, Arial, sans-serif; margin-top: 40px; color: white; margin-left: 18%;">Usuario </label>
	<input type="text" class="btn btn-default" readonly="readonly" name="user" style="background-color: gray; width: 40%; margin-left: 15%; font-size: 15px;"value="<%=user%>"> 
	<label style="font-size: 16px; font-family: Roboto, Helvetica Neue, Open Sans, Arial, sans-serif; margin-top: 40px; color: white; margin-left: 18%;">Contraseña antigua</label>
	<input type="password" class="btn btn-default" style="background-color: gray; width: 40%; margin-left: 6%; font-size: 15px;"name="pass" value="" required> 
	<label style="font-size: 16px; font-family: Roboto, Helvetica Neue, Open Sans, Arial, sans-serif; margin-top: 40px; color: white; margin-left: 18%;">Contraseña nueva</label>
	<input type="password" class="btn btn-default" style="background-color: gray; width: 40%; margin-left: 7%; font-size: 15px;" name="passnew" value="" required>

                           <%
							if (request.getAttribute("mensaje1") != null) {
						%>
					<br><center> <label
							style="margin-top:30px;color: black; font-size: 16px; font-family: 'Cairo', sans-serif; margin-left: 100px;">
							La contraseña antigua no es correcta</label></center>
						<%
							}
						%>
						<%
							if (request.getAttribute("mensaje2") != null) {
						%>
						<br><center> <label
							style="margin-top:30px;color: black; font-size: 16px; font-family: 'Cairo', sans-serif; margin-left: 100px;">
							La contraseña nueva no puede ser igual a la antigua</label></center>
						<%
							}
						%>
						
							<%
							if (request.getAttribute("mensaje4") != null) {
						%>
						<br> <center> <label
							style="margin-top:30px;color: black; font-size: 16px; font-family: 'Cairo', sans-serif; margin-left: 100px;">
							La contraseña fue cambiada correctamente</label></center>
						<%
							}
						%>
								<hr style="margin-bottom: 5px;">
								|<input type=submit value="Modificar" class="btn btn-danger"
									name="btnCambiar"
									style="width: 30%; background-color: #ED362C; align-items: center; position: relative; left: 43%; margin-bottom: 20px; margin-right: 30px;">
    <input type="hidden" value="<%=docente.getLegajo()%>" class="myButton" name="legajo" id="legajo">
    <input type="hidden" value="<%=pass%>" class="myButton" name="passold" id="old">


							</form>

						</div>
						
					</div>
				
				</div>
			</div>
		</div>
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
			pageSize : 4,
			pageList : [ 4, 8, 12, 15 ],

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

	$('#twitter').sharrre({
		share : {
			twitter : true
		},
		enableHover : false,
		enableTracking : true,
		buttons : {
			twitter : {
				via : 'CreativeTim'
			}
		},
		click : function(api, options) {
			api.simulateClick()
			api.openPopup('twitter')
		},
		template : '<i class="fa fa-twitter"></i> {total}',
		url : location.href
	})

	$('#facebook').sharrre({
		share : {
			facebook : true
		},
		enableHover : false,
		enableTracking : true,
		click : function(api, options) {
			api.simulateClick()
			api.openPopup('facebook')
		},
		template : '<i class="fa fa-facebook-square"></i> {total}',
		url : location.href
	})
</script>

<script type="text/javascript">
	var $table2 = $('#fresh-table2')
	var $alertBtn2 = $('#alertBtn2')

	window.operateEvents2 = {
		'click .like' : function(e, value, row, index) {
			alert('You click like icon, row: ' + JSON.stringify(row))
			console.log(value, row, index)
		},
		'click .edit' : function(e, value, row, index) {
			alert('You click edit icon, row: ' + JSON.stringify(row))
			console.log(value, row, index)
		},
		'click .remove' : function(e, value, row, index) {
			$table2.bootstrapTable('remove', {
				field : 'id',
				values : [ row.id ]
			})
		}
	}

	$(function() {
		$table2.bootstrapTable2({
			classes : 'table table-hover table-striped',
			toolbar : '.toolbar',

			search : true,
			showRefresh : false,
			showToggle : true,
			showColumns : true,
			pagination : true,
			striped : true,
			sortable : true,
			pageSize : 4,
			pageList : [ 4, 8, 12, 15 ],

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