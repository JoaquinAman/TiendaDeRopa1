package controller;

import java.util.ArrayList;

import entidades.Cotizacion;
import entidades.Vendedor;
import excepciones.PrendaException;
import excepciones.PriceAmountException;
import excepciones.StockException;
import vista.Lamina_BotonesRadio;

public class Controller {
	
	private float resultado;
	
	public float CotizaCamisa (Cotizacion c, Vendedor vendedor, Lamina_BotonesRadio lamina_pantalon_chupin, Lamina_BotonesRadio lamina_precio, Lamina_BotonesRadio lamina_cantidad, ArrayList<String[]> sublistaCamisas) throws PrendaException, StockException, PriceAmountException {

		vendedor.CotizarCamisa(c.getCamisa(), c.getPrenda(), c.getFecha(), vendedor.getCodigoVendedor(), lamina_pantalon_chupin, lamina_precio, lamina_cantidad, sublistaCamisas);
		
		setResultado(vendedor.getRtoCalculoDeCotizacionCamisa()) ;
		
		return resultado;
	}
	
	public float CotizaPantalon (Cotizacion c, Vendedor vendedor, Lamina_BotonesRadio lamina_manga_corta, Lamina_BotonesRadio lamina_precio, Lamina_BotonesRadio lamina_cantidad,  ArrayList<String[]> sublistaPantalones) throws PrendaException, StockException, PriceAmountException{

		vendedor.CotizarPantalon(c.getPantalon(), c.getPrenda(), c.getFecha(), vendedor.getCodigoVendedor(), lamina_manga_corta, lamina_precio, lamina_cantidad, sublistaPantalones);
		
		setResultado(vendedor.getRtoCalculoDeCotizacionPantalon());
		
		return resultado;
	}
	
	public void ImprimeHistorialTodo(Vendedor vendedor, ArrayList<String[]> sublistaCamisas, ArrayList<String[]> sublistaPantalones) {
		
		vendedor.ImprimeHistorialTodo( sublistaCamisas, sublistaPantalones);
	}

	public void setResultado(float resultado) {
		
		this.resultado = resultado;
	}
}
