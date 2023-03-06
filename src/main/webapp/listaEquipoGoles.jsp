<%@page import="liga.EquipoGol"%>
<%@page import="java.util.ArrayList"%>
<%@page import="liga.JugadorGol"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<h2>Listado de goleadores del equipo <%String nombre = (String)request.getAttribute("nombre");%><%=nombre%></h2>
		<%
		ArrayList<EquipoGol> equipoGoles = (ArrayList<EquipoGol>) request.getAttribute("equipoGoles");
		int goles = equipoGoles.size();
		if(goles>0){%>
			<TABLE border='1'>
		<TR>
			<TH>Nombre</TH>
			<TH>Posicion</TH>
			<TH>Número de goles</TH>
		</TR>
		<%
		for (EquipoGol eg : equipoGoles) {
		%>
		<TR>
			<TD><%=eg.getNombre()%></TD>
			<TD><%=eg.getPosicion()%></TD>
			<TD><%=eg.getNumGoles()%></TD>
		</TR>
		<%
		}}else{
		%>
		<P>Este equipo no ha marcado ningún gol.</P>
		<%} %>
	</TABLE>
</body>
</html>