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
import Backend.PatronMVC.model.service.AsignadoAServ;

public class VentanaBuscarAsignadoA  extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private AsignadoAController AsignadoAController; //objeto AsignadoAController que permite la relacion entre esta clase y la clase AsignadoAController
	private JLabel labelTitulo;
	private JTextField textCientifico,textProyecto;
	private JLabel Cientifico,Proyecto;
	private JButton botonGuardar,botonCancelar,botonBuscar,botonModificar,botonEliminar;
	
	/**
	 * constructor de la clase donde se inicializan todos los componentes
	 * de la ventana de busqueda
	 */
	public VentanaBuscarAsignadoA() {

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
		labelTitulo.setText("ADMINISTRAR AsignadoA");
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
		textCientifico.setBounds(90, 80, 80, 25);
		getContentPane().add(textCientifico);
		
		textProyecto=new JTextField();
		textProyecto.setBounds(80, 120, 190, 25);
		getContentPane().add(textProyecto);
		
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
				miAsignadoA.setProyecto(textProyecto.getText()+"");
				AsignadoAController.modificarAsignadoA(miAsignadoA);
				
				if (AsignadoAServ.modificaAsignadoA==true) {
					habilita(true, false, false, false, true, true);	
				}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null,"Error en el Ingreso de Datos","Error",JOptionPane.ERROR_MESSAGE);
			}
			
		}
		
		if (e.getSource()==botonBuscar)
		{
			AsignadoA miAsignadoA=AsignadoAController.buscarAsignadoA(textCientifico.getText());
			if (miAsignadoA!=null)
			{
				muestraAsignadoA(miAsignadoA);
			}
			else if(AsignadoAServ.consultaAsignadoA==true){
				JOptionPane.showMessageDialog(null, "El AsignadoA no Existe","Advertencia",JOptionPane.WARNING_MESSAGE);
			}
		}
		
		if (e.getSource()==botonModificar)
		{
			habilita(false, true, false, true, false, false);
			
		}
		
		if (e.getSource()==botonEliminar)
		{
			if (!textCientifico.getText().equals(""))
			{
				int respuesta = JOptionPane.showConfirmDialog(this,
						"Esta seguro de eliminar la AsignadoA?", "Confirmación",
						JOptionPane.YES_NO_OPTION);
				if (respuesta == JOptionPane.YES_NO_OPTION)
				{
					AsignadoAController.eliminarAsignadoA(textCientifico.getText());
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
	 * permite cargar los datos de la AsignadoA consultada
	 * @param miAsignadoA
	 */
	private void muestraAsignadoA(AsignadoA miAsignadoA) {
		textProyecto.setText(miAsignadoA.getProyecto()+"");
		textCientifico.setText(miAsignadoA.getCientifico()+"");
		
		habilita(true, false, false, false, true, true);
	}


	/**
	 * Permite limpiar los componentes
	 */
	public void limpiar()
	{
		textCientifico.setText("");
		textProyecto.setText("");
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
	public void habilita(boolean Cientifico, boolean Proyecto , boolean bBuscar, boolean bGuardar, boolean bModificar, boolean bEliminar)
	{
		textCientifico.setEditable(Cientifico);
		textProyecto.setEditable(Proyecto);
		botonGuardar.setEnabled(bGuardar);
		botonModificar.setEnabled(bModificar);
		botonEliminar.setEnabled(bEliminar);
	}
}


