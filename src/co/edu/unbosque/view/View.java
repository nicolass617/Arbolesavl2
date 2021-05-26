/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unbosque.view;


import javax.swing.JFrame;

import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import co.edu.unbosque.model.Nodo;

/**
 *
 * @author daniel
 */
public class View extends JFrame {

	private PanelArbol panelArbol;
	private PanelMenu panelMenu;
   
	public View() {
		
		setSize(830,700);
		setTitle("Árboles");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(null);
		
		panelArbol = new PanelArbol();
		Border borde = new TitledBorder(new EtchedBorder(),"Árbol");
		panelArbol.setBorder(borde);
		panelArbol.setBounds(10,230,800,400);
		panelArbol.setVisible(true);
		
		panelMenu = new PanelMenu();
		panelMenu.setBounds(10,10,800,400);
		panelMenu.setVisible(true);
		
		getContentPane().add(panelArbol);
		getContentPane().add(panelMenu);
		setVisible(true);
		
	}

	public PanelArbol getPanelArbol() {
		return panelArbol;
	}

	public PanelMenu getPanelMenu() {
		return panelMenu;
	}
	
//	public void insertarArbol(Nodo nodo) {
//		panelArbol.setObjArbol(nodo);
//	
//	}
	
	
	
}
