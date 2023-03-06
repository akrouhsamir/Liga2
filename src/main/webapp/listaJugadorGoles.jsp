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
	<h2>Listado de goles del jugador <%String nombre = (String)request.getAttribute("nombre");%><%=nombre%></h2>
		<%
		ArrayList<JugadorGol> jugadorGoles = (ArrayList<JugadorGol>) request.getAttribute("jugadorGoles");
		int goles = jugadorGoles.size();
		if(goles>0){%>
			<TABLE border='1'>
		<TR>
			<TH>Local</TH>
			<TH>Visitante</TH>
			<TH>Minuto</TH>
			<TH>Descripción</TH>
		</TR>
		<%
		for (JugadorGol jg : jugadorGoles) {
		%>
		<TR>
			<TD><%=jg.getLocal()%></TD>
			<TD><%=jg.getVisitante()%></TD>
			<TD><%=jg.getMinuto()%></TD>
			<TD><%=jg.getDescripcion()%></TD>
		</TR>
		<%
		}}else{
		%>
		<P>Este jugador no ha marcado ningún gol.</P>
		<%} %>
	</TABLE>
</body>
</html>