<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>List Customers</title>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/css/style.css" />

</head>

<body>

	<div id="wrapper">
	    <div>
	    <br>
	    <img src="https://www.accenture.com/content/dam/accenture/final/images/icons/symbol/Acc_Logo_Black_Purple_RGB.png">
	    <br>
	    <br>
	    </div>
	    
		<div id="header">
			<h2>Lista de asignacion de proyectos Accenture</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
			<!-- put new button: Add Customer -->
		
			<input type="button" value="Agregar"
				   onclick="window.location.href='agregarDesarrollador'; return false;"
				   class="add-button"
			/>
		
			<!--  add our html table here -->
		
			<table>
				<tr>
					<th>Nombre</th>
					<th>Apellido</th>
					<th>Email</th>
					<th>Proyecto</th>
					<th>Puesto</th>
					<th>Opciones</th>
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="planDesarrollador" items="${desarrolladores}">
				
					<!-- construct an "update" link with customer id -->
					<c:url var="actualizarLink" value="/Accenture/formularioActualizar">
						<c:param name="desarrolladorId" value="${planDesarrollador.id}" />
					</c:url>					

					<!-- construct an "delete" link with customer id -->
					<c:url var="eliminarLink" value="/Accenture/eliminar">
						<c:param name="desarrolladorId" value="${planDesarrollador.id}" />
					</c:url>					
					
					<tr>
						<td> ${planDesarrollador.nombre} </td>
						<td> ${planDesarrollador.apellido} </td>
						<td> ${planDesarrollador.email} </td>
						<td> ${planDesarrollador.proyecto} </td>
						<td> ${planDesarrollador.puesto} </td>
						
						<td>
							<!-- display the update link -->
							<a href="${actualizarLink}">Actualizar</a>
							|
							<a href="${eliminarLink}"
							   onclick="if (!(confirm('¿Desea eliminar a ${planDesarrollador.nombre}  ${planDesarrollador.apellido} del Proyecto: ${planDesarrollador.proyecto}?'))) return false">Eliminar</a>
						</td>
						
					</tr>
				
				</c:forEach>
						
			</table>
				
		</div>
	
	</div>
	

</body>

</html>









