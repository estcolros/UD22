package Backend.PatronMVC.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Backend.PatronMVC.model.dto.Video;
import Backend.PatronMVC.model.service.VideoServ;
import Backend.PatronMVC.controller.VideoController;
import java.awt.Font;

public class VentanaBuscarVideo extends JFrame implements ActionListener {


	private static final long serialVersionUID = 1L;
	private VideoController VideoController; 
	private JTextField textId,textTitle,textDirector,textCli_id;
	private JButton botonGuardar,botonCancelar,botonBuscar,botonModificar,botonEliminar;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaBuscarVideo frame = new VentanaBuscarVideo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VentanaBuscarVideo() {
		
		JLabel lblNewLabel = new JLabel("Código Video");
		lblNewLabel.setBounds(34, 73, 149, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Título");
		lblNewLabel_1.setBounds(78, 99, 46, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Director");
		lblNewLabel_2.setBounds(64, 131, 119, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Código Cliente");
		lblNewLabel_3.setBounds(23, 157, 149, 14);
		getContentPane().add(lblNewLabel_3);
		
		textId = new JTextField();
		textId.setBounds(120, 70, 101, 20);
		getContentPane().add(textId);
		textId.setColumns(10);
		
		textTitle = new JTextField();
		textTitle.setBounds(120, 98, 259, 20);
		getContentPane().add(textTitle);
		textTitle.setColumns(10);
		
		textDirector = new JTextField();
		textDirector.setBounds(121, 126, 258, 20);
		getContentPane().add(textDirector);
		textDirector.setColumns(10);
		
		textCli_id = new JTextField();
		textCli_id.setBounds(120, 154, 259, 20);
		getContentPane().add(textCli_id);
		textCli_id.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("BUSCAR VÍDEO");
		lblNewLabel_4.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_4.setBounds(34, 39, 288, 14);
		getContentPane().add(lblNewLabel_4);
		
		botonBuscar = new JButton("OK");
		botonBuscar.setBounds(233, 70, 54, 23);
		getContentPane().add(botonBuscar);
		
		botonCancelar = new JButton("Cancelar");
		botonCancelar.setBounds(290, 195, 89, 23);
		getContentPane().add(botonCancelar);
		
		botonModificar = new JButton("Modificar");
		botonModificar.setBounds(64, 195, 89, 23);
		getContentPane().add(botonModificar);
		
		botonGuardar = new JButton("Guardar");
		botonGuardar.setBounds(290, 70, 89, 23);
		getContentPane().add(botonGuardar);
		
		botonEliminar = new JButton("Eliminar");
		botonEliminar.setBounds(176, 195, 89, 23);
		getContentPane().add(botonEliminar);
		
		botonModificar.addActionListener(this);
		botonEliminar.addActionListener(this);
		botonBuscar.addActionListener(this);
		botonGuardar.addActionListener(this);
		botonCancelar.addActionListener(this);
		
		limpiar();

		setBounds(100, 100, 411, 284);
		setTitle("Patron de Diseño/MVC");
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);

		
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

				VideoController.modificarVideo(miVideo);
				
				if (VideoServ.modificaVideo==true) {
					habilita(true, false, false, false, true, false, true, true);	
				}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null,"Error en el Ingreso de Datos","Error",JOptionPane.ERROR_MESSAGE);
			}
			
		}
		
		if (e.getSource()==botonBuscar)
		{
			Video miVideo=VideoController.buscarVideo(textId.getText());
			if (miVideo!=null)
			{
				muestraVideo(miVideo);
			}
			else if(VideoServ.consultaVideo==true){
				JOptionPane.showMessageDialog(null, "El Video no Existe","Advertencia",JOptionPane.WARNING_MESSAGE);
			}
		}
		
		if (e.getSource()==botonModificar)
		{
			habilita(false, true, true, true, false, true, false, false);
			
		}
		
		if (e.getSource()==botonEliminar)
		{
			if (!textId.getText().equals(""))
			{
				int respuesta = JOptionPane.showConfirmDialog(this,
						"Esta seguro de eliminar el Video?", "Confirmación",
						JOptionPane.YES_NO_OPTION);
				if (respuesta == JOptionPane.YES_NO_OPTION)
				{
					VideoController.eliminarVideo(textId.getText());
					limpiar();
				}
			}
			else{
				JOptionPane.showMessageDialog(null, "Ingrese un numero", "Información",JOptionPane.WARNING_MESSAGE);
			}
			
		}
		if (e.getSource()==botonCancelar)
		{
			this.dispose();
		}

	}



	/**
	 * permite cargar los datos de la codigo consultada
	 * @param micodigo
	 */
	private void muestraVideo(Video miVideo) {
		textTitle.setText(miVideo.getTitle());
		textDirector.setText(miVideo.getDirector()+"");
		textCli_id.setText(miVideo.getCli_id()+"");
		habilita(true, false, false, false, true, false, true, true);
	}


	/**
	 * Permite limpiar los componentes
	 */
	public void limpiar()
	{
		textId.setText("");
		textTitle.setText("");
		textDirector.setText("");
		textCli_id.setText("");
		habilita(true, false, false, false, true, false, true, true);
	}


	/**
	 * Permite habilitar los componentes para establecer una modificacion
	 * @param codigo
	 * @param title
	 * @param director
	 * @param cli_id
	 * @param bBuscar
	 * @param bGuardar
	 * @param bModificar
	 * @param bEliminar
	 */
	public void habilita(boolean codigo, boolean title, boolean director, boolean cli_id, boolean bBuscar, boolean bGuardar, boolean bModificar, boolean bEliminar)
	{
		textId.setEditable(codigo);
		textTitle.setEditable(title);
		textDirector.setEditable(director);
		textCli_id.setEditable(cli_id);
		botonBuscar.setEnabled(bBuscar);
		botonGuardar.setEnabled(bGuardar);
		botonModificar.setEnabled(bModificar);
		botonEliminar.setEnabled(bEliminar);
	}
}