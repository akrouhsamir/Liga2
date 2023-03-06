package liga;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class Principal extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest peticion, HttpServletResponse respuesta)throws ServletException, IOException {

		switch (peticion.getParameter("comando")) {
		case "listaEquipos":
			ArrayList<Equipo> equipos = GestorBD.equipos();
			peticion.setAttribute("equipos", equipos);
			RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/listaEquipos.jsp");
			rd.forward(peticion, respuesta);
			break;
		case "listaJugadores":
			ArrayList<Jugador> jugadores = GestorBD.jugadores();
			peticion.setAttribute("jugadores", jugadores);
			RequestDispatcher rd2 = this.getServletContext().getRequestDispatcher("/listaJugadores.jsp");
			rd2.forward(peticion, respuesta);
			break;
		case "jugadorGoles":
			String codigo = peticion.getParameter("codigo");
			String nombre = peticion.getParameter("nombre");
			ArrayList<JugadorGol> jugadorGoles = GestorBD.jugadorGoles(codigo);
			peticion.setAttribute("jugadorGoles", jugadorGoles);
			peticion.setAttribute("nombre", nombre);
			RequestDispatcher rd3 = this.getServletContext().getRequestDispatcher("/listaJugadorGoles.jsp");
			rd3.forward(peticion, respuesta);
			break;
			
		case "equipoGoles":
			String codigo2 = peticion.getParameter("codigo");
			String nombre2 = peticion.getParameter("nombre");
			ArrayList<EquipoGol> equipoGoles = GestorBD.golesEquipo(codigo2);
			peticion.setAttribute("equipoGoles", equipoGoles);
			peticion.setAttribute("nombre", nombre2);
			RequestDispatcher rd4 = this.getServletContext().getRequestDispatcher("/listaEquipoGoles.jsp");
			rd4.forward(peticion, respuesta);
			break;
		default:
			System.err.println("Llamada a Principal con parámetro erróneo.");
			break;
		}
	}
}
