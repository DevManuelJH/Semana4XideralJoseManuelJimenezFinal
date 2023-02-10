<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
	<title>Alta Desarrollador</title>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/css/style.css">

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/css/add-customer-style.css">
</head>

<body>
	
	<div id="wrapper">
		<div id="header">
			<h2>Desarrollador</h2>
		</div>
	</div>

	<div id="container">
		<h3>Alta de usuario</h3>
	
		<form:form action="guardarDesarrollador" modelAttribute="desarrolladores" method="POST">

			<!-- need to associate this data with customer id -->
			<form:hidden path="id" />
					
			<table>
				<tbody>
					<tr>
						<td><label>Nombre:</label></td>
						<td><form:input path="nombre" /></td>
					</tr>
				
					<tr>
						<td><label>Apellido:</label></td>
						<td><form:input path="apellido" /></td>
					</tr>

					<tr>
						<td><label>Email:</label></td>
						<td><form:input path="email" /></td>
					</tr>
					
					<tr>
						<td><label>Proyecto:</label></td>
						<td><form:input path="proyecto" /></td>
					</tr>
					
					<tr>
						<td><label>Puesto:</label></td>
						<td><form:input path="puesto" /></td>
					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Guardar" class="save" /></td>
					</tr>

				
				</tbody>
			</table>
		
		
		</form:form>
	
		<div style="clear; both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/Accenture/devs">Atras</a>
		</p>
	
	</div>

</body>

</html>










