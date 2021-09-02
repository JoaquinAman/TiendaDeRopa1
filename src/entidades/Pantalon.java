package entidades;

import entidades.Prenda;

public class Pantalon extends Prenda{
	
	private boolean esComun = true;
	
	public Pantalon() {}

	public Pantalon(boolean esComun) {
		
		super();
		this.esComun = esComun;	
	}

	public boolean isEsComun() {
		
		return esComun;
	}

	public void setEsComun(boolean esComun) {
		
		this.esComun = esComun;
	}
}
