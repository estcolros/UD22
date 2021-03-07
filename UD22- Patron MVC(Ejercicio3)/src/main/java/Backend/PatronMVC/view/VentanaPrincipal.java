package Backend.PatronMVC.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import Backend.PatronMVC.controller.AsignadoAController;
import Backend.PatronMVC.controller.CientificoController;
import Backend.PatronMVC.controller.ProyectoController;

public class VentanaPrincipal extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	public ProyectoController Controller;
	public AsignadoAController AsignadoAController;
	private CientificoController ClienteController; // objeto ClienteController que permite la relacion entre esta clase
	// y la clase ClienteController
	private JTextArea areaIntroduccion;
	private JLabel labelTitulo, labelVideo;
	private JButton botonRegistrarCient, botonRegistrarProyec, btnBuscarProyecto, btnBuscarAsignadoa,
			botonRegistrarAsigA, botonBuscarCient;
	/**
	 * Establece la informacion que se presentara como introduccion del sistema
	 */
	public String textoIntroduccion = "";

	private AsignadoAController asignadoAController;

	private CientificoController cientificoController;

	private ProyectoController proyectoController;

	/**
	 * constructor de la clase donde se inicializan todos los componentes de la
	 * ventana principal
	 */
	public VentanaPrincipal() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		botonRegistrarCient = new JButton();
		botonRegistrarCient.setBounds(100, 194, 128, 25);
		botonRegistrarCient.setText("Registrar Cientifico");

		botonBuscarCient = new JButton();
		botonBuscarCient.setBounds(240, 194, 120, 25);
		botonBuscarCient.setText("Buscar Cientifico");

		
		JButton botonRegistrarProyec = new JButton();
		botonRegistrarProyec.setText("Registrar Proyecto");
		botonRegistrarProyec.setBounds(100, 231, 141, 25);
		getContentPane().add(botonRegistrarProyec);
		
		
		JButton btnBuscarProyecto = new JButton();
		btnBuscarProyecto.setText("Buscar Proyecto");
		btnBuscarProyecto.setBounds(240, 229, 120, 25);
		getContentPane().add(btnBuscarProyecto);

		JButton botonRegistrarAsigA = new JButton();
		botonRegistrarAsigA.setText("Registrar AsignadoA");
		botonRegistrarAsigA.setBounds(100, 268, 163, 25);
		getContentPane().add(botonRegistrarAsigA);

		JButton btnBuscarAsignadoa = new JButton();
		btnBuscarAsignadoa.setText("Buscar AsignadoA");
		btnBuscarAsignadoa.setBounds(264, 266, 120, 25);
		getContentPane().add(btnBuscarAsignadoa);
		
		
		
		labelTitulo = new JLabel();
		labelTitulo.setText("PATRON MODELO VISTA CONTROLADOR");
		labelTitulo.setBounds(60, 26, 380, 30);
		labelTitulo.setFont(new java.awt.Font("Verdana", 1, 15));

		labelVideo = new JLabel();
		labelVideo.setText("Operación que desea realizar:");
		labelVideo.setBounds(100, 157, 300, 25);

		textoIntroduccion = "Esta aplicación presenta un ejemplo práctico del patron "
				+ "de diseño MVC.\nLa aplicación permite registrar, actualizar, buscar y eliminar registros de una tabla Cliente."
				+ "tambien son vinculados algunos conceptos de los Patrones Value Object y Data Access Objetc\n";

		areaIntroduccion = new JTextArea();
		areaIntroduccion.setBounds(49, 66, 380, 79);
		areaIntroduccion.setEditable(false);
		areaIntroduccion.setFont(new java.awt.Font("Verdana", 0, 14));
		areaIntroduccion.setLineWrap(true);
		areaIntroduccion.setText(textoIntroduccion);
		areaIntroduccion.setWrapStyleWord(true);
		areaIntroduccion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED,
				null, null, null, new java.awt.Color(0, 0, 0)));

		botonRegistrarCient.addActionListener(this);
		botonBuscarCient.addActionListener(this);

		botonRegistrarProyec.addActionListener(this);
		btnBuscarProyecto.addActionListener(this);
		
		botonRegistrarAsigA.addActionListener(this);
		btnBuscarAsignadoa.addActionListener(this);
		
		getContentPane().add(botonBuscarCient);
		getContentPane().add(botonRegistrarCient);

		getContentPane().add(labelVideo);
		getContentPane().add(labelTitulo);
		getContentPane().add(areaIntroduccion);

		setSize(480, 350);
		setTitle("Patron de Diseño/MVC");
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);

		

	}

	public void setCoordinadorCientifico(CientificoController cientificoController) {
		this.cientificoController = cientificoController;
	}

	public void setCoordinadorAsignadoA(AsignadoAController asignadoAController) {
		this.asignadoAController = asignadoAController;
	}

	public void setCoordinadorProyecto(ProyectoController proyectoController) {
		this.proyectoController = proyectoController;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == botonRegistrarCient) {
			cientificoController.mostrarVentanaRegistro();
		}
		if (e.getSource() == botonBuscarCient) {
			cientificoController.mostrarVentanaConsulta();
		}
		if (e.getSource() == botonRegistrarProyec) {
			proyectoController.mostrarVentanaRegistro();
		}

		if (e.getSource() == btnBuscarProyecto) {
			proyectoController.mostrarVentanaConsulta();
		}

		if (e.getSource() == botonRegistrarAsigA) {
			asignadoAController.mostrarVentanaRegistroAsignadoA();
		}

		if (e.getSource() == btnBuscarAsignadoa) {
			asignadoAController.mostrarVentanaConsultaAsignadoA();
		}

	}
}
