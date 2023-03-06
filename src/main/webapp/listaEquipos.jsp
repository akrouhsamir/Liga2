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
	<h2>Listado de equipos de la liga</h2>
	<TABLE border='1'>
		<TR>
			<TH>Codigo</TH>
			<TH>Nombre</TH>
			<TH>Estadio</TH>
			<TH>Aforo</TH>
			<TH>Fundacion</TH>
			<TH>Ciudad</TH>
			<TH>Presidente</TH>
		</TR>
		<%ArrayList<Equipo> equipos = (ArrayList<Equipo>)request.getAttribute("equipos");
		for (Equipo e : equipos){%>
		<TR>
			<TD><A href="/Liga2/principal?comando=equipoGoles&?&codigo=<%=e.getCodigo()%>&nombre=<%=e.getNombre()%>" target="equipoGolesMarco"><%=e.getCodigo()%></A></TD>
			<TD><%=e.getNombre()%></TD>
			<TD><%=e.getEstadio()%></TD>
			<TD><%=e.getAforo()%></TD>
			<TD><%=e.getFundacion()%></TD>
			<TD><%=e.getCiudad()%></TD>
			<TD><%=e.getPresidente()%></TD>
		</TR>
		<%
		}
		%>
	</TABLE>
	<BR/>
	<iframe name="equipoGolesMarco" src="" width="80%" height="200">
	</iframe>
	<BR/><BR/>
	<A href="index.html">Volver al inicio</A>
</body>
</html>