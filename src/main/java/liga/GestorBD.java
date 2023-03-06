package liga;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class GestorBD {
	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String CONECTOR = "jdbc:mysql://localhost/Liga";

	public Connection getConnection() {
		Connection conexion = null;
		try {
			Class.forName(DRIVER);
			conexion = DriverManager.getConnection(CONECTOR, "usuario", "usuario");
		} catch (ClassNotFoundException cnfE) {
			cnfE.printStackTrace();
		} catch (SQLException sqlE) {
			System.err.println("\nHubo problemas con la base de datos:");
			System.err.println("Mensaje:\t" + sqlE.getMessage());
			System.err.println("Estado SQL:\t" + sqlE.getSQLState());
			System.err.println("Codigo Error:\t" + sqlE.getErrorCode());
		}
		return conexion;
	}
	
	public static ArrayList<Equipo> equipos() {
		ArrayList<Equipo> equipos = new ArrayList<>();
		Equipo equipo;
		try {
			Class.forName(DRIVER);
			Connection conexion = DriverManager.getConnection(CONECTOR, "usuario", "usuario");

			Statement sentencia = conexion.createStatement();
			ResultSet respuesta = sentencia.executeQuery("SELECT * FROM Equipos;");

			while (respuesta.next()) {
				String codigo = respuesta.getString("Codigo");
				String nombre = respuesta.getString("Nombre");
				String estadio = respuesta.getString("Estadio");
				int aforo = respuesta.getInt("Aforo");
				String fundacion = respuesta.getString("fundacion");
				String ciudad = respuesta.getString("ciudad");
				String presidente = respuesta.getString("presidente");
				equipo = new Equipo(codigo, nombre, estadio, aforo, fundacion, ciudad, presidente);
				equipos.add(equipo);
			}

			respuesta.close();
			sentencia.close();
			conexion.close();

		} catch (ClassNotFoundException cnfE) {
			cnfE.printStackTrace();
		} catch (SQLException sqlE) {
			System.err.println("\nHubo problemas con la base de datos:");
			System.err.println("Mensaje:\t"+sqlE.getMessage());
			System.err.println("Estado SQL:\t"+sqlE.getSQLState());
			System.err.println("Codigo Error:\t"+sqlE.getErrorCode());
		}
		return equipos;
	}
	
	public static ArrayList<Jugador> jugadores() {
		ArrayList<Jugador> jugadores = new ArrayList<>();
		Jugador jugador;
		try {
	        Class.forName(DRIVER);
	        Connection conexion = DriverManager.getConnection(CONECTOR, "usuario", "usuario");

	        Statement sentencia = conexion.createStatement();
	        ResultSet respuesta = sentencia.executeQuery("SELECT * FROM Jugadores;");
	        while (respuesta.next()) {
	            String codigo = respuesta.getString("Codigo");
	            String nombre = respuesta.getString("Nombre");
	            String fecha = respuesta.getString("Fecha");
	            String posicion = respuesta.getString("Posicion");
	            String codEquipo=  respuesta.getString("Cod_equipo");
	            jugador = new Jugador(codigo, nombre, fecha, posicion, codEquipo);
	            jugadores.add(jugador);
	        }

	        respuesta.close();
	        sentencia.close();
	        conexion.close();

	    } catch (ClassNotFoundException cnfE) {
	        cnfE.printStackTrace();
	    } catch (SQLException sqlE) {
	        System.err.println("\nHubo problemas con la base de datos:");
	        System.err.println("Mensaje:\t"+sqlE.getMessage());
	        System.err.println("Estado SQL:\t"+sqlE.getSQLState());
	        System.err.println("Codigo Error:\t"+sqlE.getErrorCode());
	    }
		return jugadores;
	}
	
	public static ArrayList<JugadorGol> jugadorGoles(String jugador) {
		ArrayList<JugadorGol> jugadorGoles = new ArrayList<>();
		JugadorGol jugadorGol;
		try {
			Class.forName(DRIVER);
			Connection conexion = DriverManager.getConnection(CONECTOR, "usuario", "usuario");

			Statement sentencia = conexion.createStatement();
			ResultSet respuesta = sentencia
					.executeQuery("SELECT e1.Nombre as Local, e2.Nombre as Visitante, Minuto, Descripcion\r\n"
							+ "FROM Goles AS g\r\n" + "JOIN Partidos AS p ON g.Cod_partido = p.Codigo\r\n"
							+ "JOIN Equipos as e1 ON e1.Codigo = p.Equipo_local\r\n"
							+ "JOIN Equipos as e2 ON e2.Codigo = p.Equipo_visitante\r\n" + "WHERE Cod_jugador = '"
							+ jugador + "';");
			while (respuesta.next()) {
				String local = respuesta.getString("Local");
				String visitante = respuesta.getString("Visitante");
				int minuto = respuesta.getInt("Minuto");
				String descripcion = respuesta.getString("Descripcion");
				jugadorGol = new JugadorGol(local, visitante, minuto, descripcion);
				jugadorGoles.add(jugadorGol);
			}

			respuesta.close();
			sentencia.close();
			conexion.close();

		} catch (ClassNotFoundException cnfE) {
	        cnfE.printStackTrace();
	    } catch (SQLException sqlE) {
	        System.err.println("\nHubo problemas con la base de datos:");
	        System.err.println("Mensaje:\t"+sqlE.getMessage());
	        System.err.println("Estado SQL:\t"+sqlE.getSQLState());
	        System.err.println("Codigo Error:\t"+sqlE.getErrorCode());
	    }
		return jugadorGoles;
	}
	
	public static ArrayList<EquipoGol> golesEquipo(String equipo) {
		ArrayList<EquipoGol> equipoGoles = new ArrayList<>();
		EquipoGol equipoGol;
		try {
	        Class.forName(DRIVER);
	        Connection conexion = DriverManager.getConnection(CONECTOR, "usuario", "usuario");

	        Statement sentencia = conexion.createStatement();
			ResultSet respuesta = sentencia.executeQuery("SELECT j.Nombre, j.Posicion, COUNT(*) as num_goles\r\n"
					+ "FROM Goles AS g JOIN Jugadores AS j ON g.Cod_jugador = j.Codigo \r\n" + "WHERE j.Cod_equipo = '"
					+ equipo + "'\r\n" + "GROUP BY j.Codigo;");
			
			while (respuesta.next()) {
				String nombre = respuesta.getString("Nombre");
				String posicion = respuesta.getString("Posicion");
				int nGoles = respuesta.getInt("num_goles");
				equipoGol = new EquipoGol(nombre, posicion, nGoles);
				equipoGoles.add(equipoGol);
			}

			respuesta.close();
			sentencia.close();
			conexion.close();

		} catch (ClassNotFoundException cnfE) {
	        cnfE.printStackTrace();
	    } catch (SQLException sqlE) {
	        System.err.println("\nHubo problemas con la base de datos:");
	        System.err.println("Mensaje:\t"+sqlE.getMessage());
	        System.err.println("Estado SQL:\t"+sqlE.getSQLState());
	        System.err.println("Codigo Error:\t"+sqlE.getErrorCode());
	    }
		return equipoGoles;
	}
	
	public static void main(String[] args) {
		golesEquipo("EQ001");
	}
}
