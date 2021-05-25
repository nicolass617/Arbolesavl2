package co.edu.unbosque.model;

public class ArbolAVL {

	private Nodo raiz;

	public ArbolAVL() {
		raiz = null;
	}

	public Nodo buscar(int v, Nodo n) {
		if (raiz == null) {
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
		Nodo t2 = y.getHijoDer();

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
			return (new Nodo(v));
		if (v < nodo.getValor())
			nodo.setHijoIzq(insertar(nodo.getHijoIzq(), v));
		else if (v > nodo.getValor())
			nodo.setHijoDer(insertar(nodo.getHijoDer(), v));
		else
			return nodo;

		nodo.setFe(1 + max(obtenerFE(nodo.getHijoIzq()), obtenerFE(nodo.getHijoDer())));

		int balance = obtenerBalance(nodo);

		if (balance > 1 && v < nodo.getHijoIzq().getValor())
			return rotacionDer(nodo);

		if (balance < -1 && v > nodo.getHijoIzq().getValor())
			return rotacionIzq(nodo);

		if (balance > 1 && v > nodo.getHijoIzq().getValor()) {
			nodo.setHijoIzq(rotacionIzq(nodo.getHijoIzq()));
			return rotacionDer(nodo);
		}

		if (balance < -1 && v < nodo.getHijoDer().getValor()) {
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
		if (r == null)
			return r;

		if (v < r.getValor())
			r.setHijoIzq(eliminar(r.getHijoIzq(), v));

		else if (v > r.getValor())
			r.setHijoDer(eliminar(r.getHijoDer(), v));

		else {

			if ((r.getHijoIzq() == null) || (r.getHijoDer() == null)) {
				Nodo temp = null;
				if (temp == r.getHijoDer())
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

		if (balance > 1 && obtenerBalance(r.getHijoDer()) < 0) {
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
			System.out.print(n.getValor() + " ");
			preOrder(n.getHijoIzq());
			preOrder(n.getHijoDer());
		}
	}

	public void inOrder(Nodo n) {
		if (n != null) {
			inOrder(n.getHijoIzq());
			System.out.print(n.getValor() + " ");
			inOrder(n.getHijoDer());
		}
	}

	public void posOrder(Nodo n) {
		if (n != null) {
			posOrder(n.getHijoIzq());
			posOrder(n.getHijoDer());
			System.out.print(n.getValor() + " ");
		}
	}

	public static void main(String[] args) {

		ArbolAVL arbolito = new ArbolAVL();

		arbolito.raiz = arbolito.insertar(arbolito.raiz, 20);
		arbolito.raiz = arbolito.insertar(arbolito.raiz, 34);
		arbolito.raiz = arbolito.insertar(arbolito.raiz, 16);
		arbolito.raiz = arbolito.insertar(arbolito.raiz, 6);
		arbolito.raiz = arbolito.insertar(arbolito.raiz, 36);
		arbolito.raiz = arbolito.insertar(arbolito.raiz, 14);
		arbolito.raiz = arbolito.insertar(arbolito.raiz, 32);

		arbolito.preOrder(arbolito.raiz);

		arbolito.eliminar(arbolito.raiz, 16);

		System.out.println("");

		arbolito.preOrder(arbolito.raiz);

	}
}
