package entidades;

import entidades.Prenda;

public class Camisa extends Prenda{
	private boolean mangaCorta;
	private boolean tieneCuelloMao;
	
	public Camisa() {}

	public Camisa(boolean mangaCorta, boolean tieneCuelloMao) {
		super();
		this.mangaCorta = mangaCorta;
		this.tieneCuelloMao = tieneCuelloMao;
	}

	public boolean isMangaCorta() {
		return mangaCorta;
	}

	public void setMangaCorta(boolean mangaCorta) {
		this.mangaCorta = mangaCorta;
	}

	public boolean isTieneCuelloMao() {
		return tieneCuelloMao;
	}

	public void setTieneCuelloMao(boolean tieneCuelloMao) {
		this.tieneCuelloMao = tieneCuelloMao;
	}

	
}
