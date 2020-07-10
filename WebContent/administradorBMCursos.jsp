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

<title>BM</title>
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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>

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
<script>function soloNumeros(e){
	  var key = window.event ? e.which : e.keyCode;
	  if (key < 48 || key > 57) {
	    e.preventDefault();
	  }
	}
	
if(document.getElementById("IDCursoSelecc").value =="0") { alert("error")}
	
	</script>
</head>
<body>
<%
			HttpSession misession= (HttpSession) request.getSession();
			 
			String user = (String) misession.getAttribute("Usuario");
			
			if(user == null)
			{
				RequestDispatcher view = request.getRequestDispatcher("/index.jsp");
				view.forward(request, response);
			}
		%>
	<form method="post" action="servletBMcursos">

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
						<li><a href="servletAltaCursos" ><i  style="color: white;" class="glyphicon glyphicon-list-alt"></i>
								Alta de cursos</a></li>
								<li><a  ><i  style="color: white;" class="glyphicon glyphicon-list-alt"></i>
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
		<div class="container">
			<div class="row">

				<div class="col-md-12">
					<h2 style="color: white; align-items: center; position: relative;">
						<b>BM de curso</b>
					</h2>

					<div class="fresh-table full-color-orange"
						style="margin-top: 20px; margin-bottom: 20px;">

						<div class="toolbar">
							<button id="alertBtn" class="btn btn-default">Refrescar</button>
						</div>
						<table id="fresh-table" class="table">
							<thead>
								<th data-field="#" data-sortable="true"></th>
								<th data-field="ID" data-sortable="true">ID</th>
								<th data-field="Materia" data-sortable="true">Materia</th>
								<th data-field="Cuatrimestre" data-sortable="true">Cuatrimestre</th>
								<th data-field="Año" data-sortable="true">Anio</th>
								<th data-field="Docente" data-sortable="true">Docente</th>
								<th style="" data-field="actions"><div class="th-inner ">Borrar</div>
									<div class="fht-cell" style="width: 67px;"></div></th>
								<th style="" data-field="actionsMod"><div class="th-inner ">Modificar</div>
									<div class="fht-cell" style="width: 67px;"></div></th>
							</thead>
							<tbody>
								<%
									int contadorCursos = 0;
									ArrayList<Curso> listaCursos = (ArrayList<Curso>) request.getAttribute("listaCursos");

									if (listaCursos != null) {
										for (Curso curso : listaCursos) {
								%>

								<tr data-id="<%=curso.getIdCurso()%>">
									<th scope="row"></th>
									<td><%=curso.getIdCurso()%></td>
									<td><%=curso.getMateria().getNombre()%></td>
									<td><%=curso.getCuatrimestre()%></td>
									<td><%=curso.getAnio()%></td>
									<td><%=curso.getDocente().getNombre() + " " + curso.getDocente().getApellido()%></td>
									<td style="">
										<form action="servletBMcursos" method="post">
											<input type="submit" value="Borrar" class="btn btn-danger"
												name="btnBorrarCurso" id="btnBorrarCurso"
												style="background-color: #ED362C;"> <input
												type="hidden" value="<%=curso.getIdCurso()%>"
												class="myButton" name="btnBorrar" id="btnBorrar">

										</form>
									</td>
									<td style="">
										<form method="post" action="servletBMcursos">
											<input type=submit value="Modificar" class="btn btn-danger"
												name="btnModificarCurso" id="btnModificarCurso"
												style="background-color: #ED362C;"> <input
												type="hidden" value="<%=curso.getIdCurso()%>"
												class="myButton" name="btnModificar" id="btnModificar">
											<input type="hidden"
												value="<%=curso.getMateria().getIdMateria()%>"
												class="myButton" name="btnModificarMateria"
												id="btnModificarMateria"> <input type="hidden"
												value="<%=curso.getCuatrimestre()%>" class="myButton"
												name="btnModificarCuatri" id="btnModificarCuatri"> <input
												type="hidden" value="<%=curso.getAnio()%>" class="myButton"
												name="btnModificarAnio" id="btnModificarAnio"> <input
												type="hidden" value="<%=curso.getDocente().getLegajo()%>"
												class="myButton" name="btnModificarDocente"
												id="btnModificarDocente">
										</form>
									</td>
								</tr>
								<%
									}
									}
								%>

							</tbody>
						</table>

						<%
							if (request.getAttribute("mensajeBorrado") == "OK") {
						%>
						<br> <label
							style="color: white; font-size: 20px; font-family: 'Cairo', sans-serif; margin-left: 100px;">
							Curso Borrado correctamente</label>
						<%
							}
							if (request.getAttribute("mensajeBorrado") == "NOK") {
						%>
						<br> <label
							style="color: white; font-size: 20px; font-family: 'Cairo', sans-serif; margin-left: 100px;">
							Error al Borrar el curso</label>
						<%
							}
						%>

					</div>

				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-6">
				<div class="container">
					<div class="row">

						<div class="fresh-table full-color-orange"
							style="margin-top: 5px; margin-bottom: 5px; width: 80%; display: block; margin-left: 21%">
							<!-- Material form register -->
							<form action="servletBMcursos" method="post">
								<div class="container"></div>

								<label
									style="font-size: 16px; font-family: Roboto, Helvetica Neue, Open Sans, Arial, sans-serif; margin-top: 20px; color: white; text-align: center; display: block;">Modificar
									Curso</label>
								<hr>

								<%
									if (request.getAttribute("CursoSeleccionada") == null) {
										request.setAttribute("CursoSeleccionada", 0);

									}
								%>
								<label
									style="font-size: 16px; font-family: Roboto, Helvetica Neue, Open Sans, Arial, sans-serif; margin-top: 40px; color: white; margin-left: 18%;">ID
									del curso</label><input type="text" class="btn btn-default"
									readonly="readonly" name="IDCursoSelecc" id="IDCursoSelecc"
									style="background-color: gray; width: 40%; margin-left: 15%; font-size: 15px;"
									value="<%=request.getAttribute("CursoSeleccionada")%>">
								<br> <label
									style="font-size: 16px; font-family: Roboto, Helvetica Neue, Open Sans, Arial, sans-serif; margin-top: 40px; color: white; margin-left: 18%;">Materia</label>
								<select
									class="form-control btn btn-default dropdown-toggle browser-default custom-select"
									name="selectMateria"
									style="margin-left: 18%; background-color: gray; width: 40%; font-family: sans-serif; font-size: 15px;"
									id="selectMateria">
									<option
										style="font-size: 18px; font-family: Arial, Helvetica, sans-serif;"
										value="0" selected>Selecciona una materia</option>
									<%
										ArrayList<Materia> listaMaterias = (ArrayList) request.getAttribute("listaMaterias");

										if (listaMaterias != null) {
											for (Materia materia : listaMaterias) {
									%>
									<option
										style="font-size: 18px; font-family: Arial, Helvetica, sans-serif;"
										value="<%=materia.getIdMateria()%>"><%=materia.getNombre()%></option>

									<%
										}
										}
									%>

								</select> <br> <label
									style="font-size: 16px; font-family: Roboto, Helvetica Neue, Open Sans, Arial, sans-serif; margin-top: 40px; color: white; margin-left: 18%;">Docente</label><select
									class="form-control btn btn-default dropdown-toggle browser-default custom-select"
									name="selectDocente" id="selectDocente"
									style="margin-left: 18%; background-color: gray; width: 40%; font-family: sans-serif; font-size: 15px;">
									<option
										style="font-size: 18px; font-family: Arial, Helvetica, sans-serif;"
										value="0" selected>Selecciona un Docente</option>
									<%
										ArrayList<Docente> listaDocentes = (ArrayList) request.getAttribute("listaDocentes");

										if (listaDocentes != null) {
											for (Docente docente : listaDocentes) {
									%>
									<option style="font-size: 18px;"
										value="<%=docente.getLegajo()%>"><%=docente.getNombre() + " " + docente.getApellido()%></option>
									<%
										}
										}
									%>

								</select><br> <label
									style="font-size: 16px; font-family: Roboto, Helvetica Neue, Open Sans, Arial, sans-serif; margin-top: 40px; color: white; margin-left: 18%;">Cuatrimestre</label>
								<select
									class="form-control btn btn-default dropdown-toggle browser-default custom-select "
									name="selectCuatrimestre" id="selectCuatrimestre"
									style="margin-left: 14%; background-color: gray; width: 40%; font-family: sans-serif; font-size: 15px;">
									<option
										style="font-size: 18px; font-family: Arial, Helvetica, sans-serif;"
										value="0" selected>Cuatrimestre</option>
									<option
										style="font-size: 18px; font-family: Arial, Helvetica, sans-serif;"
										value="1">Cuatrimestre 1</option>
									<option
										style="font-size: 18px; font-family: Arial, Helvetica, sans-serif;"
										value="2">Cuatrimestre 2</option>
								</select><br> <label
									style="font-size: 16px; font-family: Roboto, Helvetica Neue, Open Sans, Arial, sans-serif; margin-top: 40px; color: white; margin-left: 18%;">Anio</label>
								<select name="selectAnio" id="selectAnio"
									style="margin-left: 21%; background-color: gray; width: 40%; font-family: sans-serif; font-size: 15px;"
									class="form-control btn btn-default dropdown-toggle browser-default custom-select">
									<option value="0" selected>Anio</option>
									<option value="2018">2018</option>
									<option value="2019">2019</option>
									<option value="2020">2020</option>
									<option value="2021">2021</option>
									<option value="2022">2022</option>
								</select>

								<hr style="margin-bottom: 5px;">
								<%
									if (request.getAttribute("mensajeActualizar") == "OK") {
								%>
								<br> <label style="color: white; font-size: 20px; font-family: 'Cairo', sans-serif; margin-left: 100px; display: block;">
									Curso actualizado correctamente</label>
								<%
									}
									if (request.getAttribute("mensajeActualizar") == "NOK") {
								%>
								<br> <label style="color: white; font-size: 20px; font-family: 'Cairo', sans-serif; margin-left: 100px; block;">
									Error al actualizar el curso</label>
								<%
									}
								%>


								<br>
								|<input type=submit value="Actualizar Datos"
									class="btn btn-danger" name="btnModificarCursoUpdate"
									id="btnModificarCursoUpdate"
									style="width: 30%; background-color: #ED362C; align-items: center; position: relative; left: 20%; margin-bottom: 20px; margin-right: 30px;">

								<%
									if (request.getAttribute("presionoModificar") != null) {
								%>
								<a href="servletModificaAlumnosCursos"
									title="IR a Modificar alumnos" class="btn btn-danger"
									style="width: 30%; background-color: #ED362C; align-items: center; position: relative; left: 20%; margin-bottom: 20px;"
									id="btnModificarCursoAlumnos" name="btnModificarCursoAlumnos">
									<i class="fa fa-paper-plane" aria-hidden="true"></i> IR a
									Modificar alumnos
								</a>

								<%
									}
								%>


							</form>
							<%
								if (request.getAttribute("MateriaSeleccionada") != null) {
							%>
							<script>
    								document.ready = document.getElementById("selectAnio").value = <%=request.getAttribute("AnioSeleccionado")%>;
    								document.ready = document.getElementById("selectCuatrimestre").value = <%=request.getAttribute("CuatriSeleccionado")%>;
    								document.ready = document.getElementById("IDCursoSelecc").value = <%=request.getAttribute("CursoSeleccionada")%>;
    								document.ready = document.getElementById("selectMateria").value = <%=request.getAttribute("MateriaSeleccionada")%>;
    								document.ready = document.getElementById("selectDocente").value = <%=request.getAttribute("DocenteSeleccionado")%>;
    								
    								$("#selectDocente").val("<%=request.getAttribute("DocenteSeleccionado")%>");
								</script>

							<%
								}
							%>

						</div>
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
      'click .like': function (e, value, row, index) {alert('You click like icon, row: ' + JSON.stringify(row))
        console.log(value, row, index)
      },
      'click .edit': function (e, value, row, index) {
        alert('You click edit icon, row: ' + JSON.stringify(row))
        console.log(value, row, index)
      },
      'click .remove': function (e, value, row, index) {
        $table.bootstrapTable('remove', {
          field: 'id',
          values: [row.id]
        })
      }
    }
 
    $(function () {
      $table.bootstrapTable({
        classes: 'table table-hover table-striped',
        toolbar: '.toolbar',

        search: true,
        showRefresh: false,
        showToggle: true,
        showColumns: true,
        pagination: true,
        striped: true,
        sortable: true,
        pageSize : 4,
		pageList : [ 4, 8, 12, 15 ],

        formatShowingRows: function (pageFrom, pageTo, totalRows) {
          return ''
        },
        formatRecordsPerPage: function (pageNumber) {
          return pageNumber + ' rows visible'
        }
      })

      $alertBtn.click(function () {
      })
      $refresh.click(function () {
        alert('You pressed on Alert')
      })
    })

    $('#sharrreTitle').sharrre({
      share: {
        twitter: true,
        facebook: true
      },
      template: '',
      enableHover: false,
      enableTracking: true,
      render: function (api, options) {
        $("#sharrreTitle").html('Thank you for ' + options.total + ' shares!')
      },
      enableTracking: true,
      url: location.href
    })

    $('#twitter').sharrre({
      share: {
        twitter: true
      },
      enableHover: false,
      enableTracking: true,
      buttons: { twitter: {via: 'CreativeTim'}},
      click: function (api, options) {
        api.simulateClick()
        api.openPopup('twitter')
      },
      template: '<i class="fa fa-twitter"></i> {total}',
      url: location.href
    })

    $('#facebook').sharrre({
      share: {
        facebook: true
      },
      enableHover: false,
      enableTracking: true,
      click: function (api, options) {
        api.simulateClick()
        api.openPopup('facebook')
      },
      template: '<i class="fa fa-facebook-square"></i> {total}',
      url: location.href
    })
    
    
  </script>

<script type="text/javascript">
    var $table2 = $('#fresh-table2')
    var $alertBtn2 = $('#alertBtn2')

    window.operateEvents2 = {
      'click .like': function (e, value, row, index) {
        alert('You click like icon, row: ' + JSON.stringify(row))
        console.log(value, row, index)
      },
      'click .edit': function (e, value, row, index) {
        alert('You click edit icon, row: ' + JSON.stringify(row))
        console.log(value, row, index)
      },
      'click .remove': function (e, value, row, index) {
        $table2.bootstrapTable('remove', {
          field: 'id',
          values: [row.id]
        })
      }
    }
 
    $(function () {
      $table2.bootstrapTable2({
        classes: 'table table-hover table-striped',
        toolbar: '.toolbar',

        search: true,
        showRefresh: false,
        showToggle: true,
        showColumns: true,
        pagination: true,
        striped: true,
        sortable: true,
        pageSize : 4,
		pageList : [ 4, 8, 12, 15 ],

        formatShowingRows: function (pageFrom, pageTo, totalRows) {
          return ''
        },
        formatRecordsPerPage: function (pageNumber) {
          return pageNumber + ' rows visible'
        }
      })

      $alertBtn.click(function () {
      })
      $refresh.click(function () {
        alert('You pressed on Alert')
      })
    })


  </script>
<script>
    (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
    (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
    m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
    })(window,document,'script','//www.google-analytics.com/analytics.js','ga')

    ga('create', 'UA-46172202-1', 'auto')
    ga('send', 'pageview')

  </script>

</html>