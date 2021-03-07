package Backend.PatronMVC.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Backend.PatronMVC.controller.CientificoController;
import Backend.PatronMVC.model.dto.Cientifico;


public class VentanaRegistroCientifico extends JFrame implements ActionListener{

	
	private static final long serialVersionUID = 1L;
	private CientificoController CientificoController; //objeto CientificoController que permite la relacion entre esta clase y la clase CientificoController
	private JLabel labelTitulo;
	private JTextField textDniCient,textNombreCient;
	private JLabel DniCient,nomApels;
	private JButton botonGuardar,botonCancelar;
	
	/**
	 * constructor de la clase donde se inicializan todos los componentes
	 * de la ventana de registro
	 */
	public VentanaRegistroCientifico() {

		botonGuardar = new JButton();
		botonGuardar.setBounds(110, 220, 120, 25);
		botonGuardar.setText("Registrar");
		
		botonCancelar = new JButton();
		botonCancelar.setBounds(250, 220, 120, 25);
		botonCancelar.setText("Cancelar");

		labelTitulo = new JLabel();
		labelTitulo.setText("REGISTRO DE CIENTIFICOS");
		labelTitulo.setBounds(120, 20, 380, 30);
		labelTitulo.setFont(new java.awt.Font("Verdana", 1, 18));

		DniCient=new JLabel();
		DniCient.setText("DNI");
		DniCient.setBounds(20, 80, 80, 25);
		getContentPane().add(DniCient);
		
		nomApels=new JLabel();
		nomApels.setText("Nombre");
		nomApels.setBounds(20, 120, 80, 25);
		getContentPane().add(nomApels);
		
		textDniCient=new JTextField();
		textDniCient.setBounds(80, 80, 96, 25);
		getContentPane().add(textDniCient);
		
		textNombreCient=new JTextField();
		textNombreCient.setBounds(80, 120, 190, 25);
		getContentPane().add(textNombreCient);
		
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
		textDniCient.setText("");
		textNombreCient.setText("");
	}


	public void setCoordinador(CientificoController CientificoController) {
		this.CientificoController=CientificoController;
	}


	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource()==botonGuardar)
		{
			try {
				Cientifico miCientifico=new Cientifico();
				miCientifico.setDniCientifico(textDniCient.getText());
				miCientifico.setNomApelsCientifico(textNombreCient.getText());
				
				CientificoController.registrarCientifico(miCientifico);	
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
