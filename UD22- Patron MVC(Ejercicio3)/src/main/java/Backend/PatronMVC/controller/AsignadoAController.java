package Backend.PatronMVC.controller;

import Backend.PatronMVC.model.dto.AsignadoA;
import Backend.PatronMVC.model.service.AsignadoAServ;
import Backend.PatronMVC.view.VentanaBuscarAsignadoA;
import Backend.PatronMVC.view.VentanaPrincipal;
import Backend.PatronMVC.view.VentanaRegistroAsignadoA;


public class AsignadoAController {
	
	private AsignadoAServ AsignadoAServ;
	private VentanaPrincipal miVentanaPrincipal;
	private VentanaRegistroAsignadoA miVentanaRegistroAsignadoA;
	private VentanaBuscarAsignadoA miVentanaBuscarAsignadoA;
	
	
	//Metodos getter Setters de vistas
	public VentanaPrincipal getMiVentanaPrincipal() {
		return miVentanaPrincipal;
	}
	public void setMiVentanaPrincipal(VentanaPrincipal miVentanaPrincipal) {
		this.miVentanaPrincipal = miVentanaPrincipal;
	}
	public VentanaRegistroAsignadoA getMiVentanaRegistroAsignadoA() {
		return miVentanaRegistroAsignadoA;
	}
	public void setMiVentanaRegistroAsignadoA(VentanaRegistroAsignadoA miVentanaRegistroAsignadoA) {
		this.miVentanaRegistroAsignadoA = miVentanaRegistroAsignadoA;
	}
	public VentanaBuscarAsignadoA getMiVentanaBuscarAsignadoA() {
		return miVentanaBuscarAsignadoA;
	}
	public void setMiVentanaBuscarAsignadoA(VentanaBuscarAsignadoA miVentanaBuscarAsignadoA) {
		this.miVentanaBuscarAsignadoA = miVentanaBuscarAsignadoA;
	}
	public AsignadoAServ getAsignadoAServ() {
		return AsignadoAServ;
	}
	public void setAsignadoAServ(AsignadoAServ AsignadoAServ) {
		this.AsignadoAServ = AsignadoAServ;
	}

	//Hace visible las vistas de Registro y Consulta
	public void mostrarVentanaRegistroAsignadoA() {
		miVentanaRegistroAsignadoA.setVisible(true);
	}
	public void mostrarVentanaConsultaAsignadoA() {
		miVentanaBuscarAsignadoA.setVisible(true);
	}
	
	
	//Llamadas a los metodos CRUD de la capa service para validar los datos de las vistas
	public void registrarAsignadoA(AsignadoA miAsignadoA) {
		AsignadoAServ.validarRegistro(miAsignadoA);
	}
	
	public AsignadoA buscarAsignadoA(String codigoAsignadoA) {
		return AsignadoAServ.validarConsulta(codigoAsignadoA);
	}
	
	public void modificarAsignadoA(AsignadoA miAsignadoA) {
		AsignadoAServ.validarModificacion(miAsignadoA);
	}
	
	public void eliminarAsignadoA(String codigo) {
		AsignadoAServ.validarEliminacion(codigo);
	}

}
