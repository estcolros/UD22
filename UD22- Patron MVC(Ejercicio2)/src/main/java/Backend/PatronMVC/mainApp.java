package Backend.PatronMVC;

import java.awt.EventQueue;

import javax.swing.JFrame;

import Backend.PatronMVC.controller.ClienteController;
import Backend.PatronMVC.controller.VideoController;
import Backend.PatronMVC.model.service.ClienteServ;
import Backend.PatronMVC.model.service.VideoServ;
import Backend.PatronMVC.view.VentanaBuscar;
import Backend.PatronMVC.view.VentanaBuscarVideo;
import Backend.PatronMVC.view.VentanaPrincipal;
import Backend.PatronMVC.view.VentanaRegistro;
import Backend.PatronMVC.view.VentanaRegistroVideo;

public class mainApp extends JFrame {

	private static final long serialVersionUID = 1L;
	ClienteServ miClienteServ;
	VideoServ miVideoServ;
	
	VentanaPrincipal miVentanaPrincipal;
	
	VentanaBuscar miVentanaBuscar;
	VentanaBuscarVideo miVentanaBuscarVideo;
	
	VentanaRegistro miVentanaRegistro;
	VentanaRegistroVideo miVentanaRegistroVideo;
	
	ClienteController ClienteController;
	VideoController VideoController;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				mainApp miPrincipal = new mainApp();
				miPrincipal.iniciar();
			}
		});
	}

	/**
	 * Permite instanciar todas las clases con las que trabaja el sistema
	 */
	private void iniciar() {
		/* Se instancian las clases */
		miVentanaPrincipal = new VentanaPrincipal();
		
		miVentanaRegistro = new VentanaRegistro();
		miVentanaBuscar = new VentanaBuscar();
		miClienteServ = new ClienteServ();
		ClienteController = new ClienteController();
		
		miVentanaRegistroVideo = new VentanaRegistroVideo();
		miVentanaBuscarVideo = new VentanaBuscarVideo();
		miVideoServ = new VideoServ();
		VideoController = new VideoController();


		/* Se establecen las relaciones entre clases */
		miVentanaPrincipal.setCoordinador(ClienteController);
		miVentanaRegistro.setCoordinador(ClienteController);
		miVentanaBuscar.setCoordinador(ClienteController);
		miClienteServ.setController(ClienteController);
		
		miVentanaPrincipal.setCoordinadorVideo(VideoController);
		miVentanaBuscarVideo.setCoordinador(VideoController);
		miVentanaRegistroVideo.setCoordinador(VideoController);
		miVideoServ.setVideoController(VideoController);


		/* Se establecen relaciones con la clase coordinador */
		ClienteController.setMiVentanaPrincipal(miVentanaPrincipal);
		ClienteController.setMiVentanaRegistro(miVentanaRegistro);
		ClienteController.setMiVentanaBuscar(miVentanaBuscar);
		ClienteController.setClienteServ(miClienteServ);
		
		VideoController.setMiVentanaBuscarVideo(miVentanaBuscarVideo);
		VideoController.setMiVentanaRegistroVideo(miVentanaRegistroVideo);
		VideoController.setVideoServ(miVideoServ);
		
		miVentanaPrincipal.setVisible(true);
	}


}
