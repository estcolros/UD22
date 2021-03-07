package Backend.PatronMVC.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Backend.PatronMVC.controller.AsignadoAController;
import Backend.PatronMVC.model.dto.AsignadoA;


public class VentanaRegistroAsignadoA extends JFrame implements ActionListener{
	

	
	private static final long serialVersionUID = 1L;
	private AsignadoAController AsignadoAController; //objeto AsignadoAontroller que permite la relacion entre esta clase y la clase AsignadoAController
	private JLabel labelTitulo;
	private JTextField textCientifico,textProyecto;
	private JLabel Cientifico,Proyecto;
	private JButton botonGuardar,botonCancelar;
	
	/**
	 * constructor de la clase donde se inicializan todos los componentes
	 * de la ventana de registro
	 */
	public VentanaRegistroAsignadoA() {

		botonGuardar = new JButton();
		botonGuardar.setBounds(110, 220, 120, 25);
		botonGuardar.setText("Registrar");
		
		botonCancelar = new JButton();
		botonCancelar.setBounds(250, 220, 120, 25);
		botonCancelar.setText("Cancelar");

		labelTitulo = new JLabel();
		labelTitulo.setText("REGISTRO DE AsignadoAS");
		labelTitulo.setBounds(120, 20, 380, 30);
		labelTitulo.setFont(new java.awt.Font("Verdana", 1, 18));

		Cientifico=new JLabel();
		Cientifico.setText("Cientifico");
		Cientifico.setBounds(20, 80, 80, 25);
		getContentPane().add(Cientifico);
		
		Proyecto=new JLabel();
		Proyecto.setText("Proyecto");
		Proyecto.setBounds(20, 120, 80, 25);
		getContentPane().add(Proyecto);
		
		textCientifico=new JTextField();
		textCientifico.setBounds(80, 80, 80, 25);
		getContentPane().add(textCientifico);
		
		textProyecto=new JTextField();
		textProyecto.setBounds(80, 120, 190, 25);
		getContentPane().add(textProyecto);
		
		botonGuardar.addActionListener(this);
		botonCancelar.addActionListener(this);
		getContentPane().add(botonCancelar);
		getContentPane().add(botonGuardar);
		getContentPane().add(labelTitulo);
		limpiar();
		setSize(480, 300);
		setTitle("Patron de Diseño/MVC");
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);

	}


	private void limpiar() 
	{
		textCientifico.setText("");
		textProyecto.setText("");
	}


	public void setCoordinador(AsignadoAController AsignadoAController) {
		this.AsignadoAController=AsignadoAController;
	}


	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource()==botonGuardar)
		{
			try {
				AsignadoA miAsignadoA=new AsignadoA();
				miAsignadoA.setCientifico(textCientifico.getText()+"");
				miAsignadoA.setProyecto(textProyecto.getText());
				
				AsignadoAController.registrarAsignadoA(miAsignadoA);	
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null,"Error en el Ingreso de Datos","Error",JOptionPane.ERROR_MESSAGE);
				System.out.println(ex);
			}
		}
		if (e.getSource()==botonCancelar)
		{
			this.dispose();
		}
	}
	
	
}

