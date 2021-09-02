package main;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.Controller;
import entidades.Camisa;
import entidades.Cotizacion;
import entidades.Pantalon;
import entidades.Prenda;
import entidades.TiendaDeRopa;
import entidades.Vendedor;
import excepciones.StockException;
import vista.Marco;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Camisa> camisasParaVender = new ArrayList<Camisa>();
		ArrayList<Pantalon> pantalonesParaVender = new ArrayList<Pantalon>();
		
		//200 manga corta, cuello mao, 100 standard, 100 premium
		for(int i = 0; i<200; i++) {
			camisasParaVender.add(new Camisa(true, true));
			}
		
		//300 manga corta, cuello normal, 150 standard, 150 premium
		for(int i = 0; i<300; i++) {
			camisasParaVender.add(new Camisa(true, false));
		}
		
		//150 manga larga, cuello mao, 75 standard, 75 premium
		for(int i = 0; i<150; i++) {
			camisasParaVender.add(new Camisa(false, true));
		}
		
		//350 manga larga, cuello normal, 175 standard, 175 premium
		for(int i = 0; i<350; i++) {
			camisasParaVender.add(new Camisa(false, false));
		}
		
		//1500 pantalones chupines, 750 standard, 750 premium
		for(int i = 0; i<1500; i++) {
			pantalonesParaVender.add(new Pantalon(false));
		}
		
		//500 pantalones comunes, 250 standard, 250 premium
		for(int i = 0; i<500; i++) {
			pantalonesParaVender.add(new Pantalon(true));
		}
		
		Cotizacion c = new Cotizacion();
		
		Controller controller = new Controller();
		
		Prenda prenda = new Prenda();
		
		Camisa camisa = new Camisa();
		
		Pantalon pantalon = new Pantalon();
		
		Vendedor vendedor = new Vendedor(1, "Pepe", "Fernandez", new TiendaDeRopa("Lo de Pepe", "Calle falsa 123", camisasParaVender, pantalonesParaVender));
		
		ArrayList<String[]> sublistaCamisas = new ArrayList<String[]>();
		
		ArrayList<String[]> sublistaPantalones = new ArrayList<String[]>();
		
		Marco miMarco = new Marco();
		
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		miMarco.setVisible(true);
		
		miMarco.recibeMain(c, controller, prenda, camisa, pantalon, vendedor, sublistaCamisas, sublistaPantalones);				
	}
}
