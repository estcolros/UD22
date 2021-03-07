
/*
 * Esta parte del patrón es la que define la lógica de administración del sistema, 
 * establece la conexión entre la vista y el modelo.
 */

package Backend.PatronMVC.controller;

import Backend.PatronMVC.model.dto.Cientifico;
import Backend.PatronMVC.model.service.CientificoServ;
import Backend.PatronMVC.view.VentanaBuscarCientifico;
import Backend.PatronMVC.view.VentanaPrincipal;
import Backend.PatronMVC.view.VentanaRegistroCientifico;

public class CientificoController {

	private CientificoServ CientificoServ;
	private VentanaPrincipal miVentanaPrincipal;
	private VentanaRegistroCientifico miVentanaRegistro;
	private VentanaBuscarCientifico miVentanaBuscar;
	
	//Metodos getter Setters de vistas
	public VentanaPrincipal getMiVentanaPrincipal() {
		return miVentanaPrincipal;
	}
	public void setMiVentanaPrincipal(VentanaPrincipal miVentanaPrincipal) {
		this.miVentanaPrincipal = miVentanaPrincipal;
	}
	public VentanaRegistroCientifico getMiVentanaRegistro() {
		return miVentanaRegistro;
	}
	public void setMiVentanaRegistro(VentanaRegistroCientifico miVentanaRegistro) {
		this.miVentanaRegistro = miVentanaRegistro;
	}
	public VentanaBuscarCientifico getMiVentanaBuscar() {
		return miVentanaBuscar;
	}
	public void setMiVentanaBuscar(VentanaBuscarCientifico miVentanaBuscar) {
		this.miVentanaBuscar = miVentanaBuscar;
	}
	public CientificoServ getCientificoServ() {
		return CientificoServ;
	}
	public void setCientificoServ(CientificoServ CientificoServ) {
		this.CientificoServ = CientificoServ;
	}
	
	//Hace visible las vistas de Registro y Consulta
	public void mostrarVentanaRegistro() {
		miVentanaRegistro.setVisible(true);
	}
	public void mostrarVentanaConsulta() {
		miVentanaBuscar.setVisible(true);
	}
	
	//Llamadas a los metodos CRUD de la capa service para validar los datos de las vistas
	public void registrarCientifico(Cientifico miCientifico) {
		CientificoServ.validarRegistro(miCientifico);
	}
	
	public Cientifico buscarCientifico(String codigoCientifico) {
		return CientificoServ.validarConsulta(codigoCientifico);
	}
	
	public void modificarCientifico(Cientifico miCientifico) {
		CientificoServ.validarModificacion(miCientifico);
	}
	
	public void eliminarCientifico(String codigo) {
		CientificoServ.validarEliminacion(codigo);
	}


}