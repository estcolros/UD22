package Backend.PatronMVC;

import java.awt.EventQueue;
import javax.swing.JFrame;
import Backend.PatronMVC.controller.CientificoController;
import Backend.PatronMVC.controller.ProyectoController;
import Backend.PatronMVC.controller.AsignadoAController;
import Backend.PatronMVC.model.service.AsignadoAServ;
import Backend.PatronMVC.model.service.CientificoServ;
import Backend.PatronMVC.model.service.ProyectoServ;
import Backend.PatronMVC.view.VentanaBuscarAsignadoA;
import Backend.PatronMVC.view.VentanaBuscarCientifico;
import Backend.PatronMVC.view.VentanaBuscarProyecto;
import Backend.PatronMVC.view.VentanaPrincipal;
import Backend.PatronMVC.view.VentanaRegistroAsignadoA;
import Backend.PatronMVC.view.VentanaRegistroCientifico;
import Backend.PatronMVC.view.VentanaRegistroProyecto;

public class mainApp extends JFrame {

	private static final long serialVersionUID = 1L;
	AsignadoAServ miAsignadoAServ;
	CientificoServ miCientificoServ;
	ProyectoServ miProyectoServ;
	
	VentanaPrincipal miVentanaPrincipal;
	
	VentanaBuscarAsignadoA miAsignadoABuscar;
	VentanaBuscarProyecto miProyectoBuscar;
	VentanaBuscarCientifico miCientificoBuscar;
	
	
	VentanaRegistroAsignadoA miVentanaRegistroAsignadoA;
	VentanaRegistroProyecto miVentanaRegistroProyecto;
	VentanaRegistroCientifico miVentanaRegistroCientifico;
	
	
	CientificoController CientificoController;
	AsignadoAController AsignadoAController;
	ProyectoController  ProyectoController;

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
		
		miVentanaRegistroAsignadoA = new VentanaRegistroAsignadoA();
		miAsignadoABuscar = new VentanaBuscarAsignadoA();
		miAsignadoAServ = new AsignadoAServ();
		AsignadoAController = new AsignadoAController();
		
		miVentanaRegistroProyecto = new VentanaRegistroProyecto();
		miProyectoBuscar = new VentanaBuscarProyecto();
		miProyectoServ = new ProyectoServ();
		ProyectoController = new ProyectoController();

		miVentanaRegistroCientifico = new VentanaRegistroCientifico();
		miCientificoBuscar = new VentanaBuscarCientifico();
		miCientificoServ = new CientificoServ();
		CientificoController = new CientificoController();

		/* Se establecen las relaciones entre clases */

		miVentanaPrincipal.setCoordinadorCientifico(CientificoController);
		miVentanaRegistroCientifico.setCoordinador(CientificoController);
		miCientificoBuscar.setCoordinador(CientificoController);
		miCientificoServ.setController(CientificoController);
		
		miVentanaPrincipal.setCoordinadorProyecto(ProyectoController);
		miVentanaRegistroProyecto.setCoordinador(ProyectoController);
		miProyectoBuscar.setCoordinador(ProyectoController);
		miProyectoServ.setController(ProyectoController);
		

		miVentanaPrincipal.setCoordinadorAsignadoA(AsignadoAController);
		miVentanaRegistroAsignadoA.setCoordinador(AsignadoAController);
		miAsignadoABuscar.setCoordinador(AsignadoAController);
		miAsignadoAServ.setController(AsignadoAController);
		

		/* Se establecen relaciones con la clase coordinador */
		CientificoController.setMiVentanaPrincipal(miVentanaPrincipal);
		CientificoController.setMiVentanaRegistro(miVentanaRegistroCientifico);
		CientificoController.setMiVentanaBuscar(miCientificoBuscar);
		CientificoController.setCientificoServ(miCientificoServ);

		ProyectoController.setMiVentanaPrincipal(miVentanaPrincipal);
		ProyectoController.setMiVentanaRegistroProyecto(miVentanaRegistroProyecto);
		ProyectoController.setMiVentanaBuscarProyecto(miProyectoBuscar);
		ProyectoController.setProyectoServ(miProyectoServ);

		
		AsignadoAController.setMiVentanaPrincipal(miVentanaPrincipal);
		AsignadoAController.setMiVentanaRegistroAsignadoA(miVentanaRegistroAsignadoA);
		AsignadoAController.setMiVentanaBuscarAsignadoA(miAsignadoABuscar);
		AsignadoAController.setAsignadoAServ(miAsignadoAServ);
		
		miVentanaPrincipal.setVisible(true);
	}


}
