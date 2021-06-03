package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import co.edu.unbosque.model.ArbolAVL;
import co.edu.unbosque.model.Nodo;
import co.edu.unbosque.view.View;

public class Controller implements ActionListener {
   
	private View view;
	private ArbolAVL arbolAvl;
	
		
		public Controller() {
			view = new View();
			arbolAvl = new ArbolAVL();
			setActionListeners();
		}
		
		private void setActionListeners() {
			view.getPanelMenu().getBtnAgregar().addActionListener(this);
			view.getPanelMenu().getBtnBuscar().addActionListener(this);
			view.getPanelMenu().getBtnEliminar().addActionListener(this);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == view.getPanelMenu().getBtnAgregar()) {
				
				if(view.getPanelMenu().getTxtAgregar().getText().equals("") || !view.getPanelMenu().getTxtAgregar().getText().matches("^[+-]?[0-9]*")) {
					JOptionPane.showMessageDialog(null,"Datos Inválidos");
				}else {
					int valorNodo = Integer.parseInt(view.getPanelMenu().getTxtAgregar().getText()); 
					
					arbolAvl.setRaiz(arbolAvl.insertar(valorNodo)); 
				
					
					arbolAvl.setOrden("");
					arbolAvl.preOrder(arbolAvl.getRaiz());
					view.getPanelMenu().getPreOrden().setText("PreOrden: "+arbolAvl.getOrden());
					arbolAvl.setOrden("");
					arbolAvl.inOrder(arbolAvl.getRaiz());
					view.getPanelMenu().getInOrden().setText("InOrden: "+arbolAvl.getOrden());
					arbolAvl.setOrden("");
					arbolAvl.posOrder(arbolAvl.getRaiz());
					view.getPanelMenu().getPostOrden().setText("PostOrden "+arbolAvl.getOrden());
					
					
					view.getPanelArbol().setObjArbol(arbolAvl.getRaiz());
					view.getPanelMenu().getTxtAgregar().setText("");
				}
			}
			
			if(e.getSource() == view.getPanelMenu().getBtnEliminar()) {
				
				if(view.getPanelMenu().getTxtEliminar().getText().equals("") || !view.getPanelMenu().getTxtEliminar().getText().matches("^[+-]?[0-9]*")) {
					JOptionPane.showMessageDialog(null,"Datos inválidos");
				}else {
					int valorNodo = Integer.parseInt(view.getPanelMenu().getTxtEliminar().getText());
					Nodo eliminado = arbolAvl.eliminar(arbolAvl.getRaiz(), valorNodo);
					
					if(eliminado== null && arbolAvl.isExiste()==false) {
						JOptionPane.showMessageDialog(null,"No se puede eliminar, el nodo de valor "+valorNodo+" no existe");
					}else {
						arbolAvl.setRaiz(eliminado);
						view.getPanelArbol().setObjArbol(arbolAvl.getRaiz());
						
						arbolAvl.setOrden("");
						arbolAvl.preOrder(arbolAvl.getRaiz());
						view.getPanelMenu().getPreOrden().setText("PreOrden: "+arbolAvl.getOrden());
						arbolAvl.setOrden("");
						arbolAvl.inOrder(arbolAvl.getRaiz());
						view.getPanelMenu().getInOrden().setText("InOrden: "+arbolAvl.getOrden());
						arbolAvl.setOrden("");
						arbolAvl.posOrder(arbolAvl.getRaiz());
						view.getPanelMenu().getPostOrden().setText("PostOrden "+arbolAvl.getOrden());
				
					}
						
						
					
				}
			}
			
			if(e.getSource() == view.getPanelMenu().getBtnBuscar()) {
				if(view.getPanelMenu().getTxtBuscar().getText().equals("") || !view.getPanelMenu().getTxtBuscar().getText().matches("^[+-]?[0-9]*")) {
					JOptionPane.showMessageDialog(null,"Datos Inválidos");
				}else {
					int valorNodo = Integer.parseInt(view.getPanelMenu().getTxtBuscar().getText());
					Nodo nodoBuscado = arbolAvl.buscar(valorNodo,arbolAvl.getRaiz());
					
					if(nodoBuscado==null) {
						JOptionPane.showMessageDialog(null,"El nodo "+valorNodo+" no existe en el Árbol");
					}else
					{
						Nodo hijoIzq = nodoBuscado.getHijoIzq();
						Nodo hijoDer = nodoBuscado.getHijoDer();
						if(hijoIzq==null && hijoDer == null) {
							JOptionPane.showMessageDialog(null,"El nodo "+nodoBuscado.getValor()+"si existe en el árbol");
						}else if(hijoDer==null) {
							JOptionPane.showMessageDialog(null,"El nodo "+nodoBuscado.getValor()+"si existe en el árbol"
									+"\n"+"Hijo Izquierdo: "+nodoBuscado.getHijoIzq().getValor());
						}else if(hijoIzq==null) {
							JOptionPane.showMessageDialog(null,"El nodo "+nodoBuscado.getValor()+"si existe en el árbol"
									+"\n"+"Hijo Derecho: "+nodoBuscado.getHijoDer().getValor());
						}else {
							JOptionPane.showMessageDialog(null,"El nodo "+nodoBuscado.getValor()+"si existe en el árbol"
									+"\n"+"Hijo Izquierdo: "+nodoBuscado.getHijoIzq().getValor()+"\n"
									+"Hijo Derecho: "+nodoBuscado.getHijoDer().getValor());
						}
						
						
					}
					
				}
			}
			
		}
		
}