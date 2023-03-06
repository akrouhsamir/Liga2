<%@page import="liga.Jugador"%>
<%@page import="liga.GestorBD"%>
<%@page import="liga.Equipo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Equipos</title>
</head>
<body>
	<h2>Listado de jugadores de la liga</h2>
	<TABLE border='1'>
		<TR>
			<TH>Codigo</TH>
			<TH>Nombre</TH>
			<TH>Fecha</TH>
			<TH>Posicion</TH>
			<TH>Cod_equipo</TH>
		</TR>
		<%
		ArrayList<Jugador> jugadores = (ArrayList<Jugador>) request.getAttribute("jugadores");
		for (Jugador j : jugadores) {
		%>
		<TR>
			<TD><a href="/Liga2/principal?comando=jugadorGoles&?&codigo=<%=j.getCodigo()%>&nombre=<%=j.getNombre()%>" target="jugadorGolesMarco"><%=j.getCodigo()%></a></TD>
			<TD><%=j.getNombre()%></TD>
			<TD><%=j.getFecha()%></TD>
			<TD><%=j.getPosicion()%></TD>
			<TD><%=j.getCodEquipo()%></TD>
		</TR>
		<%
		}
		%>
	</TABLE>
	<BR/>
	<iframe name="jugadorGolesMarco" src="" width="80%" height="200">
	</iframe>
	<BR/><BR/>
	<A href="index.html">Volver al inicio</A>
</body>
</html>