package Backend.PatronMVC.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Backend.PatronMVC.model.dto.Cientifico;
import Backend.PatronMVC.model.dto.Proyecto;
import Backend.PatronMVC.model.service.CientificoServ;
import Backend.PatronMVC.model.service.ProyectoServ;
import Backend.PatronMVC.controller.AsignadoAController;
import Backend.PatronMVC.controller.ProyectoController;

import java.awt.Font;

public class VentanaBuscarProyecto extends JFrame implements ActionListener {


	private ProyectoController proyectoController; //objeto personaController que permite la relacion entre esta clase y la clase personaController
	private JLabel labelTitulo;
	private JTextField textNombre, textId, textHoras;
	private JLabel id, nombre, horas;
	private JButton botonGuardar,botonCancelar,botonBuscar,botonModificar,botonEliminar;
	
	/**
	 * constructor de la clase donde se inicializan todos los componentes
	 * de la ventana de busqueda
	 */
	public VentanaBuscarProyecto() {

		botonGuardar = new JButton();
		botonGuardar.setBounds(266, 72, 120, 25);
		botonGuardar.setText("Guardar");
		
		botonCancelar = new JButton();
		botonCancelar.setBounds(170, 187, 120, 25);
		botonCancelar.setText("Cancelar");
		
		botonBuscar = new JButton();
		botonBuscar.setBounds(204, 72, 50, 25);
		botonBuscar.setText("OK");
		
		botonEliminar = new JButton();
		botonEliminar.setBounds(302, 187, 120, 25);
		botonEliminar.setText("Eliminar");
		
		botonModificar = new JButton();
		botonModificar.setBounds(30, 187, 120, 25);
		botonModificar.setText("Modificar");

		labelTitulo = new JLabel();
		labelTitulo.setText("ADMINISTRAR PROYECTO");
		labelTitulo.setBounds(92, 17, 380, 30);
		labelTitulo.setFont(new java.awt.Font("Verdana", 1, 18));

		id=new JLabel();
		id.setText("ID");
		id.setBounds(92, 73, 80, 25);
		getContentPane().add(id);
		
		nombre=new JLabel();
		nombre.setText("Nombre");
		nombre.setBounds(59, 110, 80, 25);
		getContentPane().add(nombre);

		horas=new JLabel();
		horas.setText("Horas");
		horas.setBounds(69, 140, 80, 25);
		getContentPane().add(horas);

		
		textId=new JTextField();
		textId.setBounds(112, 70, 80, 25);
		getContentPane().add(textId);
		
		textNombre=new JTextField();
		textNombre.setBounds(112, 109, 274, 25);
		getContentPane().add(textNombre);
		
		textHoras=new JTextField();
		textHoras.setBounds(112, 139, 274, 25);
		getContentPane().add(textHoras);

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
				
		setSize(459, 271);
		setTitle("Patron de Diseño/MVC");
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);

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

				proyectoController.modificarProyecto(miProyecto);
				
				if (ProyectoServ.modificaProyecto==true) {
					habilita(true, false, false, true, false, true, true);	
				}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null,"Error en el Ingreso de Datos","Error",JOptionPane.ERROR_MESSAGE);
			}
			
		}
		
		if (e.getSource()==botonBuscar)
		{
			Proyecto miProyecto=proyectoController.buscarProyecto(textId.getText());
			if (miProyecto!=null)
			{
				muestraProyecto(miProyecto);
			}
			else if(ProyectoServ.consultaProyecto==true){
				JOptionPane.showMessageDialog(null, "La persona no Existe","Advertencia",JOptionPane.WARNING_MESSAGE);
			}
		}
		
		if (e.getSource()==botonModificar)
		{
			habilita(false, true,true, false, true, false, false);
			
		}
		
		if (e.getSource()==botonEliminar)
		{
			if (!textId.getText().equals(""))
			{
				int respuesta = JOptionPane.showConfirmDialog(this,
						"Esta seguro de eliminar el Proyecto?", "Confirmación",
						JOptionPane.YES_NO_OPTION);
				if (respuesta == JOptionPane.YES_NO_OPTION)
				{
					proyectoController.eliminarProyecto(textId.getText());
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
	 * permite cargar los datos de la persona consultada
	 * @param miPersona
	 */
	private void muestraProyecto(Proyecto miProyecto) {
		textNombre.setText(miProyecto.getNombre());
		textHoras.setText(Integer.toString(miProyecto.getHoras()));
		habilita(true, false, false, true, false, true, true);
	}


	/**
	 * Permite limpiar los componentes
	 */
	public void limpiar()
	{
		textHoras.setText("");
		textNombre.setText("");
		textId.setText("");
		habilita(true, false, false, true, false, true, true);
	}


	/**
	 * Permite habilitar los componentes para establecer una modificacion
	 * @param dni
	 * @param nombre
	 * @param horas
	 * @param bBuscar
	 * @param bGuardar
	 * @param bModificar
	 * @param bEliminar
	 */
	public void habilita(boolean id, boolean nombre, boolean horas, boolean bBuscar, boolean bGuardar, boolean bModificar, boolean bEliminar)
	{
		textId.setEditable(id);
		textNombre.setEditable(nombre);
		textHoras.setEditable(horas);
		botonBuscar.setEnabled(bBuscar);
		botonGuardar.setEnabled(bGuardar);
		botonModificar.setEnabled(bModificar);
		botonEliminar.setEnabled(bEliminar);
	}
}