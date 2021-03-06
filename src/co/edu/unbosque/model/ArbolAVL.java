package co.edu.unbosque.model;

public class ArbolAVL {

	private Nodo raiz;
	private String orden;
	private boolean existe = true;

	public ArbolAVL() {
		raiz = null;
		orden = "";
	}

	public Nodo buscar(int v, Nodo n) {
		if (n == null) {
			return null;
		} else if (n.getValor() == v) {
			return n;
		} else if (n.getValor() < v) {
			return buscar(v, n.getHijoDer());
		} else {
			return buscar(v, n.getHijoIzq());
		}
	}

	public int obtenerFE(Nodo n) {
		if (n == null) {
			return -1;
		} else {
			return n.getFe();
		}
	}

	public Nodo rotacionIzq(Nodo x) {
		Nodo y = x.getHijoDer();
		Nodo t2 = y.getHijoIzq();

		y.setHijoIzq(x);
		x.setHijoDer(t2);

		x.setFe(max(obtenerFE(x.getHijoIzq()), obtenerFE(x.getHijoDer())) + 1);
		y.setFe(max(obtenerFE(y.getHijoIzq()), obtenerFE(y.getHijoDer())) + 1);

		return y;
	}

	public Nodo rotacionDer(Nodo y) {
		Nodo x = y.getHijoIzq();
		Nodo t2 = x.getHijoDer();

		x.setHijoDer(y);
		y.setHijoIzq(t2);

		y.setFe(max(obtenerFE(y.getHijoIzq()), obtenerFE(y.getHijoDer())) + 1);
		x.setFe(max(obtenerFE(x.getHijoIzq()), obtenerFE(x.getHijoDer())) + 1);

		return x;
	}

	public int obtenerBalance(Nodo n) {
		if (n == null)
			return 0;

		return obtenerFE(n.getHijoIzq()) - obtenerFE(n.getHijoDer());
	}

	private int max(int a, int b) {
		return (a > b) ? a : b;
	}

	public Nodo insertar(Nodo nodo, int v) {

		if (nodo == null)
			return new Nodo(v);
		
		if (v < nodo.getValor())
			nodo.setHijoIzq(insertar(nodo.getHijoIzq(), v));
		else if (v > nodo.getValor())
			nodo.setHijoDer(insertar(nodo.getHijoDer(), v));
		else
			return nodo;

		nodo.setFe(1 + max(obtenerFE(nodo.getHijoIzq()), obtenerFE(nodo.getHijoDer())));

		int balance = obtenerBalance(nodo);

		if (nodo.getHijoIzq() != null && balance > 1 && v < nodo.getHijoIzq().getValor())
			return rotacionDer(nodo);

		if (nodo.getHijoIzq() != null && balance < -1 && v > nodo.getHijoIzq().getValor())
			return rotacionIzq(nodo);

		if (nodo.getHijoIzq() != null && balance > 1 && v > nodo.getHijoIzq().getValor()) {
			nodo.setHijoIzq(rotacionIzq(nodo.getHijoIzq()));
			return rotacionDer(nodo);
		}

		if (nodo.getHijoDer() != null && balance < -1 && v < nodo.getHijoDer().getValor()) {
			nodo.setHijoDer(rotacionDer(nodo.getHijoDer()));
			return rotacionIzq(nodo);
		}

		return nodo;
	}

	public Nodo minValNodo(Nodo nodo) {
		Nodo actual = nodo;

		while (actual.getHijoIzq() != null)
			actual = actual.getHijoIzq();

		return actual;
	}

	public Nodo eliminar(Nodo r, int v) {
		if(buscar(v, r) == null) {
			existe = false;
			return null;
		}else {
			existe = true;
		}
		if (r == null)
			return r;

		if (v < r.getValor())
			r.setHijoIzq(eliminar(r.getHijoIzq(), v));

		else if (v > r.getValor())
			r.setHijoDer(eliminar(r.getHijoDer(), v));

		else {

			if ((r.getHijoIzq() == null) || (r.getHijoDer() == null)) {
				Nodo temp = null;
				if (temp == r.getHijoIzq())
					temp = r.getHijoDer();
				else
					temp = r.getHijoIzq();

				if (temp == null) {
					temp = r;
					r = null;
				} else
					r = temp;
			} else {

				Nodo temp = minValNodo(r.getHijoDer());

				r.setValor(temp.getValor());

				r.setHijoDer(eliminar(r.getHijoDer(), temp.getValor()));
			}
		}

		if (r == null)
			return r;

		r.setFe(max(obtenerFE(r.getHijoIzq()), obtenerFE(r.getHijoDer())) + 1);

		int balance = obtenerBalance(r);

		if (balance > 1 && obtenerBalance(r.getHijoIzq()) >= 0)
			return rotacionDer(r);

		if (balance > 1 && obtenerBalance(r.getHijoIzq()) < 0) {
			r.setHijoIzq(rotacionIzq(r.getHijoIzq()));
			return rotacionDer(r);
		}

		if (balance < -1 && obtenerBalance(r.getHijoDer()) <= 0)
			return rotacionIzq(r);

		if (balance < -1 && obtenerBalance(r.getHijoDer()) > 0) {
			r.setHijoDer(rotacionDer(r.getHijoDer()));
			return rotacionIzq(r);
		}

		return r;
	}

	public void preOrder(Nodo n) {
		if (n != null) {
			orden+= n.getValor() + " \t";
			preOrder(n.getHijoIzq());
			preOrder(n.getHijoDer());
		}
	}

	public void inOrder(Nodo n) {
		if (n != null) {
			inOrder(n.getHijoIzq());
			orden+= n.getValor() + " \t";
			inOrder(n.getHijoDer());
		}
	}

	public void posOrder(Nodo n) {
		if (n != null) {
			posOrder(n.getHijoIzq());
			posOrder(n.getHijoDer());
			orden+= n.getValor() + " \t";
		}
	}
	
	public Nodo insertar(int valor) {
		return insertar(raiz,valor);
	}
	
	

	public Nodo getRaiz() {
		return raiz;
	}

	public void setRaiz(Nodo raiz) {
		this.raiz = raiz;
	}
	
	

	public String getOrden() {
		return orden;
	}

	public void setOrden(String orden) {
		this.orden = orden;
	}

	public boolean isExiste() {
		return existe;
	}

	public void setExiste(boolean existe) {
		this.existe = existe;
	}
	
	
}
