package liga;

import java.io.Serializable;

public class EquipoGol implements Serializable{

	private static final long serialVersionUID = 1L;
	private String nombre;
	private String posicion;
	private int numGoles;
	
	
	
	public EquipoGol(String nombre, String posicion, int numGoles) {
		super();
		this.nombre = nombre;
		this.posicion = posicion;
		this.numGoles = numGoles;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPosicion() {
		return posicion;
	}
	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}
	public int getNumGoles() {
		return numGoles;
	}
	public void setNumGoles(int numGoles) {
		this.numGoles = numGoles;
	}
	
	
}
