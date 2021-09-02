package entidades;

import java.util.ArrayList;
import java.util.Arrays;

import excepciones.PrendaException;
import excepciones.PriceAmountException;
import excepciones.StockException;
import vista.Lamina_BotonesRadio;


public class Vendedor {
	
	private String Nombre;
	private String Apellido;
	private String fecha;
	private TiendaDeRopa Tienda;
	private int CodigoVendedor;
	
	private float RtoCalculoDeCotizacionCamisa;
	private float RtoCalculoDeCotizacionPantalon;
	
	private ArrayList<Camisa> ListaCamisasCotizadas;
	private ArrayList<Pantalon> ListaPantalonesCotizadas;
	

	public Cotizacion CotizarCamisa(Camisa camisa, Prenda prenda, String fecha, int CodigoVendedor, Lamina_BotonesRadio lamina_pantalon_chupin, Lamina_BotonesRadio lamina_precio, Lamina_BotonesRadio lamina_cantidad, ArrayList<String[]> sublistaCamisas) throws PrendaException, StockException, PriceAmountException{

		if(lamina_pantalon_chupin.dameSeleccion().equals("Pantalon chupin") || lamina_pantalon_chupin.dameSeleccion().equals("Pantalon comun")) {
			throw new PrendaException();
		}
		
		if(prenda.getCantidadACotizar() > Tienda.getCamisasParaVender().size()) {
			throw new StockException();
		}
				
		if((lamina_precio.getText().getText().equals("")) || lamina_cantidad.getText().getText().equals("")) {
			throw new PriceAmountException();
		}
		
		String tipoMangaCamisa = null;
		String tipoCuelloCamisa = null;
		String tipoPrenda = null;

		//RN 3
		if(camisa.isMangaCorta() && camisa.isTieneCuelloMao()) {
			prenda.setPrecio(prenda.getPrecio() - prenda.getPrecio()/10);
		
			prenda.setPrecio(prenda.getPrecio() + (prenda.getPrecio()*3)/100);

			tipoMangaCamisa = "Manga corta";
		
			tipoCuelloCamisa = "Cuello mao";
		}	
		else {
			//RN 1
			if(camisa.isMangaCorta()) {
				
				prenda.setPrecio(prenda.getPrecio() - prenda.getPrecio()/10);
				
				tipoMangaCamisa = "Manga corta";
			}	
			
			//RN 2
			if(camisa.isTieneCuelloMao()) {
			
				prenda.setPrecio(prenda.getPrecio() + (prenda.getPrecio()*3)/100);
		
				tipoCuelloCamisa = "Cuello mao";
			}
			
			if(!camisa.isMangaCorta())
				tipoMangaCamisa = "Manga larga";
			
			if(!camisa.isTieneCuelloMao())
				tipoCuelloCamisa = "Cuello comun";
		}
		//RN 5	
		if(!(prenda.isStantard())) {		
			
			prenda.setPrecio(prenda.getPrecio() + (prenda.getPrecio()*30)/100);
			
			tipoPrenda = "Prenda premium";
		} else {
			
			tipoPrenda = "Prenda standard";
		}
		
		RtoCalculoDeCotizacionCamisa = prenda.getCantidadACotizar() * prenda.getPrecio();
		
		String arrayCamisa1[] = new String[6];
				
		arrayCamisa1[0] = fecha;
		arrayCamisa1[1] = tipoMangaCamisa;
		arrayCamisa1[2] = tipoCuelloCamisa;
		arrayCamisa1[3] = tipoPrenda;
		arrayCamisa1[4] = "Rto calculo cotizacion: " + Float.toString(RtoCalculoDeCotizacionCamisa);
		arrayCamisa1[5] = "Cantidad a cotizar: " + Integer.toString(prenda.getCantidadACotizar());

		sublistaCamisas.add(arrayCamisa1);

		Cotizacion c = new Cotizacion();
		
		c.CotizacionCamisa(camisa, prenda, fecha, CodigoVendedor, RtoCalculoDeCotizacionCamisa);
		
		return c;
	}
	
	public Cotizacion CotizarPantalon(Pantalon pantalon, Prenda prenda, String fecha, int CodigoVendedor, Lamina_BotonesRadio lamina_manga_corta, Lamina_BotonesRadio lamina_precio, Lamina_BotonesRadio lamina_cantidad, ArrayList<String[]> sublistaPantalones) throws PrendaException, StockException, PriceAmountException{                
		
		if(lamina_manga_corta.dameSeleccion().equals("Manga corta") || lamina_manga_corta.dameSeleccion().equals("Manga larga")) 
			throw new PrendaException();

		if(prenda.getCantidadACotizar() > Tienda.getPantalonesParaVender().size()) {
			throw new StockException();
		}

		if((lamina_precio.getText().getText().equals("")) || lamina_cantidad.getText().getText().equals("")) {
			throw new PriceAmountException();
		}	
		
		String tipoPantalon = null;
		
		String tipoPrenda = null;

		//RN 4
		if(!pantalon.isEsComun()) {
			
			prenda.setPrecio(prenda.getPrecio() - ((prenda.getPrecio()*12)/100));
			
			tipoPantalon = "Pantalon chupin";	
		}else {
			
			tipoPantalon = "Pantalon comun";
		}	
			
		//RN 5
		if(!prenda.isStantard()) {		
			
			prenda.setPrecio(prenda.getPrecio() + (prenda.getPrecio()*30)/100);
			
			tipoPrenda = "Prenda premium";
		} else {
			
			tipoPrenda = "Prenda standard";
		}
		RtoCalculoDeCotizacionPantalon = prenda.getCantidadACotizar() * prenda.getPrecio();
	
		String arrayPantalon1[] = new String[5];
		
		arrayPantalon1[0] = fecha;
		arrayPantalon1[1] = tipoPantalon;
		arrayPantalon1[2] = tipoPrenda;
		arrayPantalon1[3] = Float.toString(RtoCalculoDeCotizacionPantalon);
		arrayPantalon1[4] = Integer.toString(prenda.getCantidadACotizar());
		
		sublistaPantalones.add(arrayPantalon1);
		
		Cotizacion c = new Cotizacion();
		
		c.CotizacionPantalon(pantalon, prenda, fecha, CodigoVendedor, RtoCalculoDeCotizacionPantalon);
		
		return c;
	}
	
	public void ImprimeHistorialTodo(ArrayList<String[]> sublistaCamisas, ArrayList<String[]> sublistaPantalones) {
	
		System.out.println("Historial de CAMISAS");
		
		for(String[] str : sublistaCamisas) {
			System.out.println(Arrays.toString(str));
		}
			
		System.out.println("Historial de PANTALONES");
		
		for(String[] str1 : sublistaPantalones) {
			System.out.println(Arrays.toString(str1));
		}
	}
	
	public Vendedor() {}
	
	public Vendedor(int codigoVendedor, String nombre, String apellido, TiendaDeRopa tienda) {
		this.CodigoVendedor = codigoVendedor;
		this.Nombre = nombre;
		this.Apellido = apellido;
		this.Tienda = tienda;
	}

	public int getCodigoVendedor() {
		return CodigoVendedor;
	}

	public void setCodigoVendedor(int codigoVendedor) {
		CodigoVendedor = codigoVendedor;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellido() {
		return Apellido;
	}

	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	
	public TiendaDeRopa getTienda() {
		return Tienda;
	}
	
	public void setTienda(TiendaDeRopa tienda) {
		Tienda = tienda;
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

	public String getFecha() {
		//fecha.format(LocalDateTime.now());
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public ArrayList<Camisa> getListaCamisasCotizadas() {
		return ListaCamisasCotizadas;
	}

	public void setListaCamisasCotizadas(ArrayList<Camisa> listaCamisasCotizadas) {
		ListaCamisasCotizadas = listaCamisasCotizadas;
	}

	public ArrayList<Pantalon> getListaPantalonesCotizadas() {
		return ListaPantalonesCotizadas;
	}

	public void setListaPantalonesCotizadas(ArrayList<Pantalon> listaPantalonesCotizadas) {
		ListaPantalonesCotizadas = listaPantalonesCotizadas;
	}
}
