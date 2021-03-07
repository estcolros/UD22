package Backend.PatronMVC.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Backend.PatronMVC.model.dto.Cliente;
import Backend.PatronMVC.model.service.ClienteServ;
import Backend.PatronMVC.controller.ClienteController;

public class VentanaBuscar  extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private ClienteController ClienteController; //objeto ClienteController que permite la relacion entre esta clase y la clase ClienteController
	private JLabel labelTitulo;
	private JTextField textId,textNombre,textDni,textapellido,textDireccion;
	private JLabel id,nombre,Dni,Apellido,direccion, fecha;
	private JButton botonGuardar,botonCancelar,botonBuscar,botonModificar,botonEliminar;
	private JTextField textFecha;
	
	/**
	 * constructor de la clase donde se inicializan todos los componentes
	 * de la ventana de busqueda
	 */
	public VentanaBuscar() {

		botonGuardar = new JButton();
		botonGuardar.setBounds(50, 220, 120, 25);
		botonGuardar.setText("Guardar");
		
		botonCancelar = new JButton();
		botonCancelar.setBounds(190, 250, 120, 25);
		botonCancelar.setText("Cancelar");
		
		botonBuscar = new JButton();
		botonBuscar.setBounds(170, 80, 62, 25);
		botonBuscar.setText("Ok");
		
		botonEliminar = new JButton();
		botonEliminar.setBounds(330, 220, 120, 25);
		botonEliminar.setText("Eliminar");
		
		botonModificar = new JButton();
		botonModificar.setBounds(190, 220, 120, 25);
		botonModificar.setText("Modificar");

		labelTitulo = new JLabel();
		labelTitulo.setText("ADMINISTRAR CLIENTES");
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

		Apellido=new JLabel();
		Apellido.setText("Apellido");
		Apellido.setBounds(278, 160, 80, 25);
		getContentPane().add(Apellido);
		
		direccion=new JLabel();
		direccion.setText("Dirección");
		direccion.setBounds(20, 160, 80, 25);
		getContentPane().add(direccion);
		
		Dni=new JLabel();
		Dni.setText("DNI");
		Dni.setBounds(290, 120, 80, 25);
		getContentPane().add(Dni);
		
		textId=new JTextField();
		textId.setBounds(80, 80, 80, 25);
		getContentPane().add(textId);
		
		textNombre=new JTextField();
		textNombre.setBounds(80, 120, 190, 25);
		getContentPane().add(textNombre);

		textapellido=new JTextField();
		textapellido.setBounds(340, 160, 80, 25);
		getContentPane().add(textapellido);
		
		textDireccion=new JTextField();
		textDireccion.setBounds(80, 160, 190, 25);
		getContentPane().add(textDireccion);
		
		textDni=new JTextField();
		textDni.setBounds(340, 120, 80, 25);
		getContentPane().add(textDni);
		
		textFecha = new JTextField();
		textFecha.setBounds(336, 83, 114, 19);
		getContentPane().add(textFecha);
		textFecha.setColumns(10);
		
		botonModificar.addActionListener(this);
		botonEliminar.addActionListener(this);
		botonBuscar.addActionListener(this);
		botonGuardar.addActionListener(this);
		botonCancelar.addActionListener(this);

		getContentPane().add(botonCancelar);
		getContentPane().add(botonBuscar);
		getContentPane().add(botonModificar);
		getContentPane().add(botonEliminar);
		getContentPane().add(botonGuardar);
		getContentPane().add(labelTitulo);
		limpiar();
				
		setSize(480, 320);
		setTitle("Patron de Diseño/MVC");
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);
		
		JLabel fecha = new JLabel("Fecha");
		fecha.setBounds(278, 85, 70, 15);
		getContentPane().add(fecha);
		
		

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
				miCliente.setDireccionCliente(textDireccion.getText());
				miCliente.setDniCliente(Integer.parseInt(textDni.getText()));
				miCliente.setFechaCliente();

				ClienteController.modificarCliente(miCliente);
				
				if (ClienteServ.modificaCliente==true) {
					habilita(true, false, false, false, false, true, false, false, true, true);	
				}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null,"Error en el Ingreso de Datos","Error",JOptionPane.ERROR_MESSAGE);
			}
			
		}
		
		if (e.getSource()==botonBuscar)
		{
			Cliente miCliente=ClienteController.buscarCliente(textId.getText());
			if (miCliente!=null)
			{
				muestraCliente(miCliente);
			}
			else if(ClienteServ.consultaCliente==true){
				JOptionPane.showMessageDialog(null, "El Cliente no Existe","Advertencia",JOptionPane.WARNING_MESSAGE);
			}
		}
		
		if (e.getSource()==botonModificar)
		{
			habilita(false, true, true, true, true, false, false, true, false, false);
			
		}
		
		if (e.getSource()==botonEliminar)
		{
			if (!textId.getText().equals(""))
			{
				int respuesta = JOptionPane.showConfirmDialog(this,
						"Esta seguro de eliminar la Cliente?", "Confirmación",
						JOptionPane.YES_NO_OPTION);
				if (respuesta == JOptionPane.YES_NO_OPTION)
				{
					ClienteController.eliminarCliente(textId.getText());
					limpiar();
				}
			}
			else{
				JOptionPane.showMessageDialog(null, "Ingrese un numero de Documento", "Información",JOptionPane.WARNING_MESSAGE);
			}
			
		}
		if (e.getSource()==botonCancelar)
		{
			this.dispose();
		}

	}



	/**
	 * permite cargar los datos de la Cliente consultada
	 * @param miCliente
	 */
	private void muestraCliente(Cliente miCliente) {
		textNombre.setText(miCliente.getNombreCliente());
		textapellido.setText(miCliente.getApellidoCliente()+"");
		textDireccion.setText(miCliente.getDireccionCliente()+"");
		textFecha.setText(miCliente.getFechaCliente()+"");
		textDni.setText(miCliente.getDniCliente()+"");
		habilita(true, false, false, false, false, true, false, false, true, true);
	}


	/**
	 * Permite limpiar los componentes
	 */
	public void limpiar()
	{
		textId.setText("");
		textNombre.setText("");
		textDni.setText("");
		textapellido.setText("");
		textDireccion.setText("");
		habilita(true, false, false, false, false, true, false, false, true, true);
	}


	/**
	 * Permite habilitar los componentes para establecer una modificacion
	 * @param codigo
	 * @param nombre
	 * @param Dni
	 * @param tel
	 * @param direccion
	 * @param cargo
	 * @param bBuscar
	 * @param bGuardar
	 * @param bModificar
	 * @param bEliminar
	 */
	public void habilita(boolean codigo, boolean nombre, boolean Dni, boolean tel, boolean direccion, boolean fecha,	 boolean bBuscar, boolean bGuardar, boolean bModificar, boolean bEliminar)
	{
		textId.setEditable(codigo);
		textNombre.setEditable(nombre);
		textDni.setEditable(Dni);
		textapellido.setEditable(tel);
		textDireccion.setEditable(direccion);
		textFecha.setEditable(false);
		botonGuardar.setEnabled(bGuardar);
		botonModificar.setEnabled(bModificar);
		botonEliminar.setEnabled(bEliminar);
	}
}
