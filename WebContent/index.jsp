<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link href="css/stylelogin.css" rel="stylesheet" type="text/css">
</head>

<body>

	<%
		HttpSession misession = request.getSession(true);
		misession.setAttribute("Usuario", null);
	%>
	<div id="login-container">
		<h3>Acceder al sistema</h3>
		<hr>
		<div class="container">
			<div class="row">
				<div class="col-12">
					<form action="servletLogin" method="post">


						<div class="input-group mb-3">
							<div class="input-group-prepend">
								<span class="input-group-text" id="email-label"> <i
									class="fa fa-user-circle" aria-hidden="true"></i>
								</span>
							</div>
							<input name="txtUsuario" required type="text"
								class="form-control" aria-label="Usuario"
								aria-describedby="email-label">
						</div>

						<div class="input-group mb-3">
							<div class="input-group-prepend">
								<span class="input-group-text" id="password-label"> <i
									class="fa fa-key" aria-hidden="true"></i>
								</span>
							</div>
							<input name="txtPass" required type="password"
								class="form-control" aria-label="Password"
								aria-describedby="password-label">
						</div>
						<%
							if (request.getAttribute("mensaje") != null) {
						%>
						<br> <label
							style="color: white; font-size: 16px; font-family: 'Cairo', sans-serif; margin-left: 100px;">
							Usuario o contraseña incorrecta</label>
						<%
							}
						%>


						<div class="text-center">
							<input name="btnIngresar" type="submit" value="Ingresar"
								class="btn btn-customized">
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>


</body>
</html>