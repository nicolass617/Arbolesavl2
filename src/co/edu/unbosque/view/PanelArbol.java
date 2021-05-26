
package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import co.edu.unbosque.model.Nodo;


/**
 *
 * @author daniel
 */
public class PanelArbol extends JPanel {
    private Nodo nodoRaiz;
    public static final int DIAMETRO = 30;
    public static final int RADIO = DIAMETRO / 2;
    public static final int ANCHO = 50;
    
    public PanelArbol() {
    	
    }

    public void setObjArbol(Nodo nodo) {
    	this.nodoRaiz = nodo;
    	repaint();
    	
    }
    

    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
       pintar(g, getWidth() / 2, 50, nodoRaiz);
    }
    
      private void pintar(Graphics g, int x, int y, Nodo n) {
        if (n == null)
        {
        	
        }
        else {
        	
            int extra = n.nodosCompletos(n) * (ANCHO/2);
            g.setColor(Color.black);
            
            g.fillOval(x, y, DIAMETRO, DIAMETRO);
            g.setColor(Color.white);
            g.drawString(String.valueOf(n.getValor()), x + 12, y + 18);
            g.setColor(Color.BLACK);
            if(n.getHijoIzq()!= null) {
            	g.drawLine(x+RADIO-4, y+RADIO+4, x-ANCHO - extra + RADIO, y+ANCHO+RADIO);
            }
            if(n.getHijoDer()!=null) {
            	g.drawLine(x+RADIO+4, y+RADIO+4, x+ANCHO+extra+RADIO, y+ANCHO+RADIO);
            }
            pintar(g,x-ANCHO-extra,y+ANCHO,n.getHijoIzq());
            pintar(g,x+ANCHO+extra,y+ANCHO,n.getHijoDer());
        }
    }
}
