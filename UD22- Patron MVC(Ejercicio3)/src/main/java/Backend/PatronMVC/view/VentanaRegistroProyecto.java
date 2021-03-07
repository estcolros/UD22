package Backend.PatronMVC.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Backend.PatronMVC.controller.AsignadoAController;
import Backend.PatronMVC.controller.ProyectoController;
import Backend.PatronMVC.model.dto.Cientifico;
import Backend.PatronMVC.model.dto.Proyecto;

public class VentanaRegistroProyecto extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private ProyectoController proyectoController; //objeto personaController que permite la relacion entre esta clase y la clase proyectoController
	private JLabel labelTitulo;
	private JTextField textNombre, textId, textHoras;
	private JLabel nombre,id, horas;
	private JButton botonGuardar,botonCancelar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRegistroProyecto frame = new VentanaRegistroProyecto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaRegistroProyecto() {
		botonGuardar = new JButton();
		botonGuardar.setBounds(101, 167, 120, 25);
		botonGuardar.setText("Registrar");
		
		botonCancelar = new JButton();
		botonCancelar.setBounds(247, 167, 120, 25);
		botonCancelar.setText("Cancelar");

		labelTitulo = new JLabel();
		labelTitulo.setText("REGISTRO DE PROYECTO");
		labelTitulo.setBounds(99, 10, 380, 30);
		labelTitulo.setFont(new java.awt.Font("Verdana", 1, 18));

		id=new JLabel();
		id.setText("Código:");
		id.setBounds(101, 52, 67, 25);
		getContentPane().add(id);
		
		nombre=new JLabel();
		nombre.setText("Nombre Proyecto:");
		nombre.setBounds(39, 87, 144, 25);
		getContentPane().add(nombre);
		
		horas=new JLabel();
		horas.setText("Horas:");
		horas.setBounds(111, 124, 91, 25);
		getContentPane().add(horas);
		
		textId=new JTextField();
		textId.setBounds(157, 51, 222, 25);
		getContentPane().add(textId);
		
		textNombre=new JTextField();
		textNombre.setBounds(157, 87, 222, 25);
		getContentPane().add(textNombre);
		
		textHoras=new JTextField();
		textHoras.setBounds(157, 124, 222, 25);
		getContentPane().add(textHoras);

		botonGuardar.addActionListener(this);
		botonCancelar.addActionListener(this);
		getContentPane().add(botonCancelar);
		getContentPane().add(botonGuardar);
		getContentPane().add(labelTitulo);
		limpiar();
		setSize(451, 243);
		setTitle("Patron de Diseño/MVC");
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);

	}


	private void limpiar() 
	{
		textNombre.setText("");
		textId.setText("");
		textHoras.setText("");

	}


	public void setCoordinador(ProyectoController proyectoController) {
		this.proyectoController=proyectoController;
	}


	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource()==botonGuardar)
		{
			try {
				Proyecto miProyecto=new Proyecto();
				miProyecto.setIdProyecto(textId.getText());
				miProyecto.setNombre(textNombre.getText());
				miProyecto.setHoras(Integer.parseInt(textHoras.getText()));


				proyectoController.registrarProyecto(miProyecto);	
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