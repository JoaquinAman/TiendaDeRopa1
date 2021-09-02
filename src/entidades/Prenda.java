package entidades;

public class Prenda {
	private boolean stantard = true;
	private float precio;
	private int cantidadEnStock;
	private int cantidadACotizar;
	
	public Prenda() {}

	public Prenda(boolean stantard, int precio, int cantidadEnStock, int cantidadACotizar) {
		this.stantard = stantard;
		this.precio = precio;
		this.cantidadEnStock = cantidadEnStock;
		this.cantidadACotizar = cantidadACotizar;
	}

	public Prenda(boolean stantard, int precio) {
		this.stantard = stantard;
		this.precio = precio;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public int getCantidadEnStock() {
		return cantidadEnStock;
	}

	public void setCantidadEnStock(int cantidadEnStock) {
		this.cantidadEnStock = cantidadEnStock;
	}

	public boolean isStantard() {
		return stantard;
	}

	public void setStantard(boolean stantard) {
		this.stantard = stantard;
	}

	public int getCantidadACotizar() {
		return cantidadACotizar;
	}

	public void setCantidadACotizar(int cantidadACotizar) {
		this.cantidadACotizar = cantidadACotizar;
	}
	
}
