package Backend.PatronMVC.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Backend.PatronMVC.model.dto.Cientifico;
import Backend.PatronMVC.model.service.CientificoServ;
import Backend.PatronMVC.controller.CientificoController;

public class VentanaBuscarCientifico  extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private CientificoController CientificoController; //objeto CientificoController que permite la relacion entre esta clase y la clase CientificoController
	private JLabel labelTitulo;
	private JTextField textDniCient,textNombreCint;
	private JLabel dni,nombre;
	private JButton botonGuardar,botonCancelar,botonBuscar,botonModificar,botonEliminar;
	
	/**
	 * constructor de la clase donde se inicializan todos los componentes
	 * de la ventana de busqueda
	 */
	public VentanaBuscarCientifico() {

		botonGuardar = new JButton();
		botonGuardar.setBounds(50, 220, 120, 25);
		botonGuardar.setText("Guardar");
		
		botonCancelar = new JButton();
		botonCancelar.setBounds(190, 250, 120, 25);
		botonCancelar.setText("Cancelar");
		
		botonBuscar = new JButton();
		botonBuscar.setBounds(170, 80, 62, 25);
		botonBuscar.setText("OK");
		
		botonEliminar = new JButton();
		botonEliminar.setBounds(330, 220, 120, 25);
		botonEliminar.setText("Eliminar");
		
		botonModificar = new JButton();
		botonModificar.setBounds(190, 220, 120, 25);
		botonModificar.setText("Modificar");

		labelTitulo = new JLabel();
		labelTitulo.setText("ADMINISTRAR CIENTIFICOS");
		labelTitulo.setBounds(120, 20, 380, 30);
		labelTitulo.setFont(new java.awt.Font("Verdana", 1, 18));

		dni=new JLabel();
		dni.setText("Dni");
		dni.setBounds(20, 80, 80, 25);
		getContentPane().add(dni);
		
		nombre=new JLabel();
		nombre.setText("Nombre");
		nombre.setBounds(20, 120, 80, 25);
		getContentPane().add(nombre);
		
		textDniCient=new JTextField();
		textDniCient.setBounds(80, 80, 80, 25);
		getContentPane().add(textDniCient);
		
		textNombreCint=new JTextField();
		textNombreCint.setBounds(80, 120, 190, 25);
		getContentPane().add(textNombreCint);
		
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
				miCientifico.setNomApelsCientifico(textNombreCint.getText());

				CientificoController.modificarCientifico(miCientifico);
				
				if (CientificoServ.modificaCientifico==true) {
					habilita(true, false, false, false, true, true);	
				}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null,"Error en el Ingreso de Datos","Error",JOptionPane.ERROR_MESSAGE);
			}
			
		}
		
		if (e.getSource()==botonBuscar)
		{
			Cientifico miCientifico=CientificoController.buscarCientifico(textDniCient.getText());
			if (miCientifico!=null)
			{
				muestraCientifico(miCientifico);
			}
			else if(CientificoServ.consultaCientifico==true){
				JOptionPane.showMessageDialog(null, "El Cientifico no Existe","Advertencia",JOptionPane.WARNING_MESSAGE);
			}
		}
		
		if (e.getSource()==botonModificar)
		{
			habilita(false, true, false, true, false, false);
			
		}
		
		if (e.getSource()==botonEliminar)
		{
			if (!textDniCient.getText().equals(""))
			{
				int respuesta = JOptionPane.showConfirmDialog(this,
						"Esta seguro de eliminar la Cientifico?", "Confirmación",
						JOptionPane.YES_NO_OPTION);
				if (respuesta == JOptionPane.YES_NO_OPTION)
				{
					CientificoController.eliminarCientifico(textDniCient.getText());
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
	 * permite cargar los datos de la Cientifico consultada
	 * @param miCientifico
	 */
	private void muestraCientifico(Cientifico miCientifico) {
		textNombreCint.setText(miCientifico.getNomApelsCientifico());
		habilita(true, false, false, false, true, true);
	}


	/**
	 * Permite limpiar los componentes
	 */
	public void limpiar()
	{
		textDniCient.setText("");
		textNombreCint.setText("");
		habilita(true, false, false, false, true, true);
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
	public void habilita(boolean dni, boolean nomApels, boolean bBuscar, boolean bGuardar, boolean bModificar, boolean bEliminar)
	{
		textDniCient.setEditable(dni);
		textNombreCint.setEditable(nomApels);
		
		botonGuardar.setEnabled(bGuardar);
		botonModificar.setEnabled(bModificar);
		botonEliminar.setEnabled(bEliminar);
	}
}
