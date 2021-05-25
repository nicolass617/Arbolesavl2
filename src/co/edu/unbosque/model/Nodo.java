package co.edu.unbosque.model;

public class Nodo {
	
	private int valor;
	private int fe;
	private Nodo hijoIzq;
	private Nodo hijoDer;
	
	public Nodo(int v) {
		this.valor = v;
		this.fe = 0;
		this.hijoIzq = null;
		this.hijoDer = null;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public int getFe() {
		return fe;
	}

	public void setFe(int fe) {
		this.fe = fe;
	}

	public Nodo getHijoIzq() {
		return hijoIzq;
	}

	public void setHijoIzq(Nodo hijoIzq) {
		this.hijoIzq = hijoIzq;
	}

	public Nodo getHijoDer() {
		return hijoDer;
	}

	public void setHijoDer(Nodo hijoDer) {
		this.hijoDer = hijoDer;
	}

}
