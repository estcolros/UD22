
/*
 * Esta parte del patrón es la que define la lógica de administración del sistema, 
 * establece la conexión entre la vista y el modelo.
 */

package Backend.PatronMVC.controller;

import Backend.PatronMVC.model.dto.Cliente;
import Backend.PatronMVC.model.service.ClienteServ;
import Backend.PatronMVC.view.VentanaBuscar;
import Backend.PatronMVC.view.VentanaPrincipal;
import Backend.PatronMVC.view.VentanaRegistro;


public class ClienteController {
	
	private ClienteServ ClienteServ;
	private VentanaPrincipal miVentanaPrincipal;
	private VentanaRegistro miVentanaRegistro;
	private VentanaBuscar miVentanaBuscar;
	
	//Metodos getter Setters de vistas
	public VentanaPrincipal getMiVentanaPrincipal() {
		return miVentanaPrincipal;
	}
	public void setMiVentanaPrincipal(VentanaPrincipal miVentanaPrincipal) {
		this.miVentanaPrincipal = miVentanaPrincipal;
	}
	public VentanaRegistro getMiVentanaRegistro() {
		return miVentanaRegistro;
	}
	public void setMiVentanaRegistro(VentanaRegistro miVentanaRegistro) {
		this.miVentanaRegistro = miVentanaRegistro;
	}
	public VentanaBuscar getMiVentanaBuscar() {
		return miVentanaBuscar;
	}
	public void setMiVentanaBuscar(VentanaBuscar miVentanaBuscar) {
		this.miVentanaBuscar = miVentanaBuscar;
	}
	public ClienteServ getClienteServ() {
		return ClienteServ;
	}
	public void setClienteServ(ClienteServ ClienteServ) {
		this.ClienteServ = ClienteServ;
	}
	
	//Hace visible las vistas de Registro y Consulta
	public void mostrarVentanaRegistro() {
		miVentanaRegistro.setVisible(true);
	}
	public void mostrarVentanaConsulta() {
		miVentanaBuscar.setVisible(true);
	}
	
	//Llamadas a los metodos CRUD de la capa service para validar los datos de las vistas
	public void registrarCliente(Cliente miCliente) {
		ClienteServ.validarRegistro(miCliente);
	}
	
	public Cliente buscarCliente(String codigoCliente) {
		return ClienteServ.validarConsulta(codigoCliente);
	}
	
	public void modificarCliente(Cliente miCliente) {
		ClienteServ.validarModificacion(miCliente);
	}
	
	public void eliminarCliente(String codigo) {
		ClienteServ.validarEliminacion(codigo);
	}


}
