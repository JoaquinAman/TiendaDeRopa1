package entidades;

import entidades.Camisa;
import entidades.Pantalon;
import entidades.Prenda;
import entidades.Vendedor;

public class Cotizacion {

	private String fecha;
	private Camisa camisa;
	private Pantalon pantalon;
	private Prenda prenda;
	private Vendedor vendedor;
	private float RtoCalculoDeCotizacionCamisa;
	private float RtoCalculoDeCotizacionPantalon;
	
	public Cotizacion() {}
	
	public void CotizacionCamisa (Camisa camisa, Prenda prenda, String fecha, int CodigoVendedor, float RtoCalculoDeCotizacionCamisa) {
		
		this.camisa = camisa;
		this.prenda = prenda;
		this.fecha = fecha;
		this.RtoCalculoDeCotizacionCamisa = RtoCalculoDeCotizacionCamisa;
	}
	
	public void CotizacionPantalon (Pantalon pantalon, Prenda prenda, String fecha, int CodigoVendedor, float RtoCalculoDeCotizacionPantalon) {
		
		this.pantalon = pantalon;
		this.prenda = prenda;
		this.fecha = fecha;
		this.RtoCalculoDeCotizacionPantalon = RtoCalculoDeCotizacionPantalon;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Camisa getCamisa() {
		return camisa;
	}

	public void setCamisa(Camisa camisa) {
		this.camisa = camisa;
	}

	public Pantalon getPantalon() {
		return pantalon;
	}

	public void setPantalon(Pantalon pantalon) {
		this.pantalon = pantalon;
	}

	public Prenda getPrenda() {
		return prenda;
	}

	public void setPrenda(Prenda prenda) {
		this.prenda = prenda;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public float getRtoCalculoDeCotizacionCamisa() {
		return RtoCalculoDeCotizacionCamisa;
	}

	public void setRtoCalculoDeCotizacionCamisa(float rtoCalculoDeCotizacionCamisa) {
		RtoCalculoDeCotizacionCamisa = rtoCalculoDeCotizacionCamisa;
	}

	public float getRtoCalculoDeCotizacionPantalon() {
		return RtoCalculoDeCotizacionPantalon;
	}

	public void setRtoCalculoDeCotizacionPantalon(float rtoCalculoDeCotizacionPantalon) {
		RtoCalculoDeCotizacionPantalon = rtoCalculoDeCotizacionPantalon;
	}
}
