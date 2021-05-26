package co.edu.unbosque.view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelMenu extends JPanel {

	private JTextField txtAgregar;
	private JButton btnAgregar;
		
	private JTextField txtBuscar;
	private JButton btnBuscar;
	
	private JTextField txtEliminar;
	private JButton btnEliminar;
	
	private JLabel preOrden;
	private JLabel inOrden;
	private JLabel postOrden;
	
	public PanelMenu() {
		setSize(800,200);
		setLayout(null);
		init();
	}
	
	
	public void init() {
		
		txtAgregar = new JTextField();
		txtAgregar.setBounds(100,30,80,30);
		txtAgregar.setFont(new Font("helvetica",Font.BOLD,15));
		
		txtBuscar = new JTextField();
		txtBuscar.setBounds(350,30,80,30);
		txtBuscar.setFont(new Font("helvetica",Font.BOLD,15));
		
		txtEliminar = new JTextField();
		txtEliminar.setBounds(600,30,80,30);
		txtEliminar.setFont(new Font("helvetica",Font.BOLD,15));
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(100,70,80,30);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(350,70,80,30);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(600,70,80,30);
		
		preOrden = new JLabel("PreOrden:");
		preOrden.setBounds(100,120,700,30);
		preOrden.setFont(new Font("helvetica",Font.BOLD,15));
		
		inOrden = new JLabel("InOrden:");
		inOrden.setBounds(100,150,700,30);
		inOrden.setFont(new Font("helvetica",Font.BOLD,15));
		
		postOrden = new JLabel("PostOrden:");
		postOrden.setBounds(100,180,700,30);
		postOrden.setFont(new Font("helvetica",Font.BOLD,15));
		
		add(txtAgregar);
		add(txtBuscar);
		add(txtEliminar);
		add(btnAgregar);
		add(btnBuscar);
		add(btnEliminar);
		add(preOrden);
		add(inOrden);
		add(postOrden);
	}


	public JTextField getTxtAgregar() {
		return txtAgregar;
	}


	public JButton getBtnAgregar() {
		return btnAgregar;
	}


	public JTextField getTxtBuscar() {
		return txtBuscar;
	}


	public JButton getBtnBuscar() {
		return btnBuscar;
	}


	public JTextField getTxtEliminar() {
		return txtEliminar;
	}


	public JButton getBtnEliminar() {
		return btnEliminar;
	}


	public JLabel getPreOrden() {
		return preOrden;
	}


	public JLabel getInOrden() {
		return inOrden;
	}


	public JLabel getPostOrden() {
		return postOrden;
	}
	
	
	
}
