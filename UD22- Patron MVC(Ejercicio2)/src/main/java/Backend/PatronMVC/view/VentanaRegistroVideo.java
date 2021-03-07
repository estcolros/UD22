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

import Backend.PatronMVC.controller.VideoController;
import Backend.PatronMVC.model.dto.Video;

public class VentanaRegistroVideo extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private VideoController VideoController; //objeto clienteController que permite la relacion entre esta clase y la clase clienteController
	private JTextField textId,textTitle,textDirector,textCli_id;
	private JLabel labelTitulo, id, title,director,cli_id;
	private JButton botonGuardar,botonCancelar;
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRegistroVideo frame = new VentanaRegistroVideo();
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
	public VentanaRegistroVideo() {
	
		
		id = new JLabel("Código Video");
		id.setBounds(34, 73, 130, 14);
		getContentPane().add(id);
		
		title = new JLabel("Título");
		title.setBounds(77, 99, 46, 14);
		getContentPane().add(title);
		
		director = new JLabel("Director");
		director.setBounds(63, 131, 158, 14);
		getContentPane().add(director);
		
		cli_id = new JLabel("Código Cliente");
		cli_id.setBounds(23, 157, 149, 14);
		getContentPane().add(cli_id);
		
		textId = new JTextField();
		textId.setBounds(120, 70, 252, 20);
		getContentPane().add(textId);
		textId.setColumns(10);
		
		textTitle = new JTextField();
		textTitle.setBounds(120, 98, 252, 20);
		getContentPane().add(textTitle);
		textTitle.setColumns(10);
		
		textDirector = new JTextField();
		textDirector.setBounds(120, 128, 252, 20);
		getContentPane().add(textDirector);
		textDirector.setColumns(10);
		
		textCli_id = new JTextField();
		textCli_id.setBounds(120, 154, 252, 20);
		getContentPane().add(textCli_id);
		textCli_id.setColumns(10);
		
		labelTitulo = new JLabel("REGISTRAR VIDEO");
		labelTitulo.setFont(new Font("Verdana", Font.BOLD, 14));
		labelTitulo.setBounds(34, 34, 216, 14);
		getContentPane().add(labelTitulo);
		
		botonGuardar = new JButton("Registrar");
		botonGuardar.setBounds(107, 201, 89, 23);
		getContentPane().add(botonGuardar);
		
		botonCancelar = new JButton("Cancelar");
		botonCancelar.setBounds(208, 201, 89, 23);
		getContentPane().add(botonCancelar);
		
		botonGuardar.addActionListener(this);
		botonCancelar.addActionListener(this);
		
		limpiar();

		
		setSize(401, 281);
		setTitle("Patron de Diseño/MVC");
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);
	}

	

	private void limpiar() 
	{
		textId.setText("");
		textTitle.setText("");
		textDirector.setText("");
		textCli_id.setText("");

	}

	public void setCoordinador(VideoController VideoController) {
		this.VideoController=VideoController;
	}


	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource()==botonGuardar)
		{
			try {
				Video miVideo=new Video();
				miVideo.setIdVideo(Integer.parseInt(textId.getText()));
				miVideo.setTitle(textTitle.getText());
				miVideo.setDirector(textDirector.getText());
				miVideo.setCli_id(Integer.parseInt(textCli_id.getText()));

				VideoController.registrarVideo(miVideo);
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null,"Error en el Ingreso de Datos","Error",JOptionPane.ERROR_MESSAGE);
				System.out.println(e2);

			}
		}
		if (e.getSource()==botonCancelar)
		{
			this.dispose();
		}
	}
	
}