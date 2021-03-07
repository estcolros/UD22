package Backend.PatronMVC.controller;

import Backend.PatronMVC.model.dto.Proyecto;
import Backend.PatronMVC.model.service.ProyectoServ;
import Backend.PatronMVC.view.VentanaBuscarProyecto;
import Backend.PatronMVC.view.VentanaPrincipal;
import Backend.PatronMVC.view.VentanaRegistroProyecto;

public class ProyectoController {

	private ProyectoServ ProyectoServ;
	private VentanaPrincipal miVentanaPrincipal;
	private VentanaRegistroProyecto miVentanaRegistroProyecto;
	private VentanaBuscarProyecto miVentanaBuscarProyecto;

	// Metodos getter Setters de vistas
	public ProyectoServ getProyectoServ() {
		return ProyectoServ;
	}

	public void setProyectoServ(ProyectoServ ProyectoServ) {
		this.ProyectoServ = ProyectoServ;
	}

	public VentanaPrincipal getMiVentanaPrincipal() {
		return miVentanaPrincipal;
	}

	public void setMiVentanaPrincipal(VentanaPrincipal miVentanaPrincipal) {
		this.miVentanaPrincipal = miVentanaPrincipal;
	}

	public VentanaRegistroProyecto getMiVentanaRegistroProyecto() {
		return miVentanaRegistroProyecto;
	}

	public void setMiVentanaRegistroProyecto(VentanaRegistroProyecto miVentanaRegistroProyecto) {
		this.miVentanaRegistroProyecto = miVentanaRegistroProyecto;
	}

	public VentanaBuscarProyecto getMiVentanaBuscarProyecto() {
		return miVentanaBuscarProyecto;
	}

	public void setMiVentanaBuscarProyecto(VentanaBuscarProyecto miVentanaBuscarProyecto) {
		this.miVentanaBuscarProyecto = miVentanaBuscarProyecto;
	}

	// Hace visible las vistas de Registro y Consulta
	public void mostrarVentanaRegistro() {
		miVentanaRegistroProyecto.setVisible(true);
	}

	public void mostrarVentanaConsulta() {
		miVentanaBuscarProyecto.setVisible(true);
	}

	// Llamadas a los metodos CRUD de la capa service para validar los datos de las
	// vistas
	public void registrarProyecto(Proyecto miProyecto) {
		ProyectoServ.validarRegistro(miProyecto);
	}

	public Proyecto buscarProyecto(String codigoProyecto) {
		return ProyectoServ.validarConsulta(codigoProyecto);
	}

	public void modificarProyecto(Proyecto miProyecto) {
		ProyectoServ.validarModificacion(miProyecto);
	}

	public void eliminarProyecto(String codigo) {
		ProyectoServ.validarEliminacion(codigo);
	}

}