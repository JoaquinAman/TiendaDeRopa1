package vista;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.Controller;
import entidades.*;
import excepciones.PrendaException;
import excepciones.PriceAmountException;
import excepciones.StockException;

public class Marco extends JFrame {
	
	private Lamina_BotonesRadio lamina_tipo_prenda, lamina_calidad_prenda, lamina_precio, lamina_cantidad, lamina_manga_corta, lamina_cuello_mao, lamina_pantalon_chupin;
	private Lamina_BotonesCheck lamina_historial_cotizacion;
	
	public Marco() {
		
		setTitle("Cotizador Express");
		
		setBounds(500, 100, 675, 450);
		
		JPanel lamina_cuadricula = new JPanel();
		
		lamina_cuadricula.setLayout(new GridLayout(2,3));
		
		lamina_tipo_prenda = new Lamina_BotonesRadio("Tipo de Prenda", new String [] {
			
				"",
				"Camisa",
				"Pantalon",
				
			
		});
		
		lamina_manga_corta = new Lamina_BotonesRadio("Manga de Camisa", new String [] {
			
				"",
				"Manga corta",
				"Manga larga"
			
		});
		
		lamina_cuello_mao = new Lamina_BotonesRadio("Cuello de Camisa", new String [] {
			
				"",
				"Cuello mao",
				"Cuello comun"
				
		});
		
		lamina_pantalon_chupin = new Lamina_BotonesRadio("Tipo de Pantalon", new String [] {
			
				"",
				"Pantalon chupin",
				"Pantalon comun"
				
		});
		
		lamina_calidad_prenda = new Lamina_BotonesRadio("Calidad de Prenda", new String [] {
			
				"",
				"Standard",
				"Premium"
		});
		
		
		lamina_precio = new Lamina_BotonesRadio("Precio unitario");
	
		lamina_cantidad = new  Lamina_BotonesRadio("Cantidad unidades" );
		
		lamina_historial_cotizacion = new Lamina_BotonesCheck("Historial de Cotizaciones");
		
		setLayout(new BorderLayout());
		
		lamina_cuadricula.add(lamina_tipo_prenda);
		
		lamina_cuadricula.add(lamina_manga_corta);
		
		lamina_cuadricula.add(lamina_cuello_mao);
		
		lamina_cuadricula.add(lamina_pantalon_chupin);
		
		lamina_cuadricula.add(lamina_calidad_prenda);
		
		lamina_cuadricula.add(lamina_precio);
		
		lamina_cuadricula.add(lamina_cantidad);
		
		lamina_cuadricula.add(lamina_historial_cotizacion);
		
		JPanel lamina_mostrar = new JPanel();
		
		JButton boton_cotizar = new JButton("Cotizar");
		
		boton_cotizar.addActionListener(new AccionMostrar());
		
		lamina_mostrar.add(boton_cotizar);
		
		add(lamina_mostrar, BorderLayout.SOUTH);
		
		add(lamina_cuadricula, BorderLayout.CENTER);
	}

	public Lamina_BotonesRadio getLamina_tipo_prenda() {
		return lamina_tipo_prenda;
	}

	public void setLamina_tipo_prenda(Lamina_BotonesRadio lamina_tipo_prenda) {
		this.lamina_tipo_prenda = lamina_tipo_prenda;
	}

	public Lamina_BotonesRadio getLamina_calidad_prenda() {
		return lamina_calidad_prenda;
	}

	public void setLamina_calidad_prenda(Lamina_BotonesRadio lamina_calidad_prenda) {
		this.lamina_calidad_prenda = lamina_calidad_prenda;
	}

	public Lamina_BotonesRadio getLamina_precio() {
		return lamina_precio;
	}

	public void setLamina_precio(Lamina_BotonesRadio lamina_precio) {
		this.lamina_precio = lamina_precio;
	}

	public Lamina_BotonesRadio getLamina_cantidad() {
		return lamina_cantidad;
	}

	public void setLamina_cantidad(Lamina_BotonesRadio lamina_cantidad) {
		this.lamina_cantidad = lamina_cantidad;
	}

	public Lamina_BotonesRadio getLamina_manga_corta() {
		return lamina_manga_corta;
	}

	public void setLamina_manga_corta(Lamina_BotonesRadio lamina_manga_corta) {
		this.lamina_manga_corta = lamina_manga_corta;
	}

	public Lamina_BotonesRadio getLamina_cuello_mao() {
		return lamina_cuello_mao;
	}

	public void setLamina_cuello_mao(Lamina_BotonesRadio lamina_cuello_mao) {
		this.lamina_cuello_mao = lamina_cuello_mao;
	}

	public Lamina_BotonesRadio getLamina_pantalon_chupin() {
		return lamina_pantalon_chupin;
	}

	public void setLamina_pantalon_chupin(Lamina_BotonesRadio lamina_pantalon_chupin) {
		this.lamina_pantalon_chupin = lamina_pantalon_chupin;
	}

	public Lamina_BotonesCheck getLamina_historial_cotizacion() {
		return lamina_historial_cotizacion;
	}

	public void setLamina_historial_cotizacion(Lamina_BotonesCheck lamina_historial_cotizacion) {
		this.lamina_historial_cotizacion = lamina_historial_cotizacion;
	}
	
	public void recibeMain(Cotizacion c, Controller controller, Prenda prenda, Camisa camisa, Pantalon pantalon,
			Vendedor vendedor, ArrayList<String[]> sublistaCamisas, ArrayList<String[]> sublistaPantalones) {
		this.c = c;
		this.controller = controller;
		this.prenda = prenda;
		this.camisa = camisa;
		this.pantalon = pantalon;
		this.vendedor = vendedor;
		
		this.sublistaCamisas = sublistaCamisas;
		this.sublistaPantalones = sublistaPantalones;
		
		
	}
	
	Cotizacion c ;
	Controller controller;
	
	Prenda prenda;
	Camisa camisa;
	Pantalon pantalon;
	Vendedor vendedor;
	
	Date date = new Date();
	Instant instant = date.toInstant();
	LocalDateTime ldt = instant.atOffset(ZoneOffset.UTC).toLocalDateTime();
	DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
	String Fecha = ldt.format(fmt);
	
	ArrayList<String[]> sublistaCamisas;
	ArrayList<String[]> sublistaPantalones;
	


	//-------------------------------------------------------
	private class AccionMostrar  implements ActionListener {
	
		@Override
		public void actionPerformed(ActionEvent e){
			// TODO Auto-generated method stub
			
			c.setPrenda(prenda);
			c.setCamisa(camisa);
			c.setPantalon(pantalon);
			c.setFecha(Fecha);
			vendedor.setFecha(Fecha);
			
			if(getLamina_tipo_prenda().dameSeleccion().equals("Camisa")) {
			
				if(getLamina_calidad_prenda().dameSeleccion().equals("Standard")) 
					c.getPrenda().setStantard(true); 
				else
					c.getPrenda().setStantard(false); 
				
				if(getLamina_manga_corta().dameSeleccion().equals("Manga corta"))
					c.getCamisa().setMangaCorta(true);
				else
					c.getCamisa().setMangaCorta(false);
				
				if(getLamina_cuello_mao().dameSeleccion().equals("Cuello mao"))
					c.getCamisa().setTieneCuelloMao(true);
				else
					c.getCamisa().setTieneCuelloMao(false);

				c.setFecha(Fecha);
				
				Controller controller = new Controller();
				
				try {
					try {
					
					int precio = Integer.parseInt(getLamina_precio().getText().getText());
					
					int cantidad = Integer.parseInt(getLamina_cantidad().getText().getText());

					c.getPrenda().setCantidadACotizar(cantidad);
					
					c.getPrenda().setPrecio(precio);
					
					}catch (NumberFormatException e3) {
						e3.getMessage();
					}
					
					controller.CotizaCamisa(c, vendedor, lamina_pantalon_chupin,/*lamina_cuello_mao, lamina_manga_corta,*/ lamina_precio, lamina_cantidad, sublistaCamisas);
					
				} catch (PrendaException | StockException | PriceAmountException e1) {
				
					System.out.println(e1.getMessage());
				}
						
				getLamina_tipo_prenda().getBotonVacio().setSelected(true);
				getLamina_manga_corta().getBotonVacio().setSelected(true);
				getLamina_cuello_mao().getBotonVacio().setSelected(true);
				getLamina_pantalon_chupin().getBotonVacio().setSelected(true);
				getLamina_calidad_prenda().getBotonVacio().setSelected(true);
				getLamina_cantidad().getText().setText("");
				getLamina_precio().getText().setText("");
			}
			
			if(getLamina_tipo_prenda().dameSeleccion().equals("Pantalon")) {
				
				if(getLamina_calidad_prenda().dameSeleccion().equals("Standard")) 
					c.getPrenda().setStantard(true); 
				else
					c.getPrenda().setStantard(false); 
				
				if(getLamina_pantalon_chupin().dameSeleccion().equals("Pantalon comun"))
					c.getPantalon().setEsComun(true);
				else
					c.getPantalon().setEsComun(false);

				vendedor.setFecha(Fecha);

				Controller controller = new Controller();
				
				try {
					try {
						
					int precio = Integer.parseInt(getLamina_precio().getText().getText());
					
					int cantidad = Integer.parseInt(getLamina_cantidad().getText().getText());
					
					c.getPrenda().setCantidadACotizar(cantidad);
					
					c.getPrenda().setPrecio(precio);
					
					}catch (NumberFormatException e4) {
						e4.getMessage();
					}
					
					controller.CotizaPantalon(c, vendedor, lamina_manga_corta, lamina_precio, lamina_cantidad, sublistaPantalones);
					
				} catch (PrendaException | StockException | PriceAmountException e2) {
					
					System.out.println(e2.getMessage());
				}
				
				getLamina_tipo_prenda().getBotonVacio().setSelected(true);
				getLamina_manga_corta().getBotonVacio().setSelected(true);
				getLamina_cuello_mao().getBotonVacio().setSelected(true);
				getLamina_pantalon_chupin().getBotonVacio().setSelected(true);
				getLamina_calidad_prenda().getBotonVacio().setSelected(true);
				getLamina_cantidad().getText().setText("");
				getLamina_precio().getText().setText("");
			}
			
			if(lamina_historial_cotizacion.getBot().isSelected()) {
				
				Controller controller = new Controller();
				
				controller.ImprimeHistorialTodo(vendedor, sublistaCamisas, sublistaPantalones);
				
				getLamina_historial_cotizacion().getBot().setSelected(false);
			}
		}
	}
}
