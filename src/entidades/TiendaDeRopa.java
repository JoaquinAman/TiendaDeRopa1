package entidades;

import java.util.ArrayList;

public class TiendaDeRopa {
	private String Nombre;
	private String Direccion;
	private ArrayList<Camisa> camisasParaVender;
	private ArrayList<Pantalon> pantalonesParaVender;
	
	public TiendaDeRopa() {}
	
	public TiendaDeRopa(String nombre, String direccion, ArrayList<Camisa> camisasParaVender, ArrayList<Pantalon> pantalonesParaVender) {
		this.Nombre = nombre;
		this.Direccion = direccion;
		this.camisasParaVender = camisasParaVender;
		this.pantalonesParaVender = pantalonesParaVender;
	}

	public TiendaDeRopa(String nombre, String direccion) {
		this.Nombre = nombre;
		this.Direccion = direccion;
	}
	
	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getDireccion() {
		return Direccion;
	}

	public void setDireccion(String direccion) {
		Direccion = direccion;
	}

	public ArrayList<Camisa> getCamisasParaVender() {
		return camisasParaVender;
	}

	public void setCamisasParaVender(ArrayList<Camisa> camisasParaVender) {
		this.camisasParaVender = camisasParaVender;
	}

	public ArrayList<Pantalon> getPantalonesParaVender() {
		return pantalonesParaVender;
	}

	public void setPantalonesParaVender(ArrayList<Pantalon> pantalonesParaVender) {
		this.pantalonesParaVender = pantalonesParaVender;
	}
	
}
