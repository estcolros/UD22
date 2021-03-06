package Backend.PatronMVC.view;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import Backend.PatronMVC.controller.VideoController;
import Backend.PatronMVC.controller.ClienteController;

public class VentanaPrincipal extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	public VideoController VideoController;
	private ClienteController ClienteController; //objeto ClienteController que permite la relacion entre esta clase y la clase ClienteController
	private JTextArea areaIntroduccion;
	private JLabel labelTitulo, labelSeleccion, labelVideo;
	private JButton botonRegistrar,botonBuscar,botonRegistrarVideo,botonBuscarVideo;
	

	/**
	 * Establece la informacion que se presentara como introduccion del sistema
	 */
	public String textoIntroduccion = "";

	/**
	 * constructor de la clase donde se inicializan todos los componentes
	 * de la ventana principal
	 */
	public VentanaPrincipal() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		botonRegistrar = new JButton();
		botonRegistrar.setBounds(100, 194, 128, 25);
		botonRegistrar.setText("Registrar Cliente");
		
		botonBuscar = new JButton();
		botonBuscar.setBounds(240, 194, 120, 25);
		botonBuscar.setText("Buscar Cliente");

		
		botonRegistrarVideo = new JButton();
		botonRegistrarVideo.setBounds(100, 268, 120, 25);
		botonRegistrarVideo.setText("Registrar Video");
		
		botonBuscarVideo = new JButton();
		botonBuscarVideo.setBounds(240, 268, 120, 25);
		botonBuscarVideo.setText("Buscar Video");
		
		
		
		labelTitulo = new JLabel();
		labelTitulo.setText("PATRON MODELO VISTA CONTROLADOR");
		labelTitulo.setBounds(60, 26, 380, 30);
		labelTitulo.setFont(new java.awt.Font("Verdana", 1, 15));

		labelSeleccion = new JLabel();
		labelSeleccion.setText("Operación que desea realizar con Cliente:");
		labelSeleccion.setBounds(100, 157, 324, 25);

		labelVideo = new JLabel();
		labelVideo.setText("Operación que desea realizar con Vídeo:");
		labelVideo.setBounds(110, 231, 300, 25);
		
		textoIntroduccion = "Esta aplicación presenta un ejemplo práctico del patron "
				+ "de diseño MVC.\nLa aplicación permite registrar, actualizar, buscar y eliminar registros de una tabla Cliente." +
				"tambien son vinculados algunos conceptos de los Patrones Value Object y Data Access Objetc\n";

		areaIntroduccion = new JTextArea();
		areaIntroduccion.setBounds(49, 66, 380, 79);
		areaIntroduccion.setEditable(false);
		areaIntroduccion.setFont(new java.awt.Font("Verdana", 0, 14));
		areaIntroduccion.setLineWrap(true);
		areaIntroduccion.setText(textoIntroduccion);
		areaIntroduccion.setWrapStyleWord(true);
		areaIntroduccion.setBorder(javax.swing.BorderFactory.createBevelBorder(
				javax.swing.border.BevelBorder.LOWERED, null, null, null,
				new java.awt.Color(0, 0, 0)));

		botonRegistrar.addActionListener(this);
		botonBuscar.addActionListener(this);
		botonRegistrarVideo.addActionListener(this);
		botonBuscarVideo.addActionListener(this);
		getContentPane().add(botonBuscar);
		getContentPane().add(botonRegistrar);
		getContentPane().add(botonBuscarVideo);
		getContentPane().add(botonRegistrarVideo);
		getContentPane().add(labelSeleccion);
		getContentPane().add(labelVideo);
		getContentPane().add(labelTitulo);
		getContentPane().add(areaIntroduccion);
	
		setSize(480, 350);
		setTitle("Patron de Diseño/MVC");
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);

	}


	public void setCoordinador(ClienteController ClienteController) {
		this.ClienteController=ClienteController;
	}

	public void setCoordinadorVideo(VideoController VideoController) {
		this.VideoController=VideoController;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==botonRegistrar) {
			ClienteController.mostrarVentanaRegistro();			
		}
		if (e.getSource()==botonBuscar) {
			ClienteController.mostrarVentanaConsulta();			
		}
		if (e.getSource()==botonRegistrarVideo) {
			VideoController.mostrarVentanaRegistroVideo();			
		}
		if (e.getSource()==botonBuscarVideo) {
			VideoController.mostrarVentanaConsultaVideo();			
		}
	}
}
