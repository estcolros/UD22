package Backend.PatronMVC.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Backend.PatronMVC.controller.ClienteController;
import Backend.PatronMVC.model.dto.Cliente;


public class VentanaRegistro extends JFrame implements ActionListener{

	
	private static final long serialVersionUID = 1L;
	private ClienteController ClienteController; //objeto ClienteController que permite la relacion entre esta clase y la clase ClienteController
	private JLabel labelTitulo;
	private JTextField textId,textNombre,textDni,textapellido,textDireccion;
	private JLabel id,nombre,Dni,apellido,direccion, Fecha;
	private JTextField textFecha;
	private JButton botonGuardar,botonCancelar;
	
	/**
	 * constructor de la clase donde se inicializan todos los componentes
	 * de la ventana de registro
	 */
	public VentanaRegistro() {

		botonGuardar = new JButton();
		botonGuardar.setBounds(110, 220, 120, 25);
		botonGuardar.setText("Registrar");
		
		botonCancelar = new JButton();
		botonCancelar.setBounds(250, 220, 120, 25);
		botonCancelar.setText("Cancelar");

		labelTitulo = new JLabel();
		labelTitulo.setText("REGISTRO DE CLIENTES");
		labelTitulo.setBounds(120, 20, 380, 30);
		labelTitulo.setFont(new java.awt.Font("Verdana", 1, 18));

		id=new JLabel();
		id.setText("Código");
		id.setBounds(20, 80, 80, 25);
		getContentPane().add(id);
		
		nombre=new JLabel();
		nombre.setText("Nombre");
		nombre.setBounds(20, 120, 80, 25);
		getContentPane().add(nombre);

		apellido=new JLabel();
		apellido.setText("Apellido");
		apellido.setBounds(282, 120, 80, 25);
		getContentPane().add(apellido);
		
		
		Dni=new JLabel();
		Dni.setText("DNI");
		Dni.setBounds(314, 160, 80, 25);
		getContentPane().add(Dni);
		
		direccion=new JLabel();
		direccion.setText("Dirección");
		direccion.setBounds(20, 160, 80, 25);
		getContentPane().add(direccion);
		
		textId=new JTextField();
		textId.setBounds(80, 80, 96, 25);
		getContentPane().add(textId);
		
		textNombre=new JTextField();
		textNombre.setBounds(80, 120, 190, 25);
		getContentPane().add(textNombre);

		textapellido=new JTextField();
		textapellido.setBounds(340, 119, 120, 25);
		getContentPane().add(textapellido);
		
		textDni=new JTextField();
		textDni.setBounds(340, 159, 120, 25);
		getContentPane().add(textDni);
		
		textDireccion=new JTextField();
		textDireccion.setBounds(80, 160, 190, 25);
		getContentPane().add(textDireccion);
		
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
		textId.setText("");
		textNombre.setText("");
		textDni.setText("");
		textapellido.setText("");
		textDireccion.setText("");
	}


	public void setCoordinador(ClienteController ClienteController) {
		this.ClienteController=ClienteController;
	}


	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource()==botonGuardar)
		{
			try {
				Cliente miCliente=new Cliente();
				miCliente.setIdCliente(Integer.parseInt(textId.getText()));
				miCliente.setNombreCliente(textNombre.getText());
				miCliente.setApellidoCliente(textapellido.getText());
				miCliente.setDniCliente(Integer.parseInt(textDni.getText()));
				miCliente.setDireccionCliente(textDireccion.getText());
				miCliente.setFechaCliente();
				
				ClienteController.registrarCliente(miCliente);	
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
