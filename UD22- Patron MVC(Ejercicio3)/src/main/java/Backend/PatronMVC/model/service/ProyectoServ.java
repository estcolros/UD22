package Backend.PatronMVC.model.service;

import javax.swing.JOptionPane;
import Backend.PatronMVC.model.dto.Proyecto;
import Backend.PatronMVC.controller.ProyectoController;
import Backend.PatronMVC.model.dao.ProyectoDao;


public class ProyectoServ {

	private ProyectoController proyectoController;
	public static boolean consultaProyecto = false;
	public static boolean modificaProyecto = false;

	// Metodo de vinculación con el controller principal
	public void setproyectoController(ProyectoController proyectoController) {
		this.setController(proyectoController);
	}

	// Metodo que valida los datos de Registro antes de pasar estos al DAO
	public void validarRegistro(Proyecto miProyecto) {
		ProyectoDao miProyectoDao;
		if (miProyecto.getNombre().length() > 3 && miProyecto.getIdProyecto().length() == 4) { //comprueba la longitud del nombre y del id 
			miProyectoDao = new ProyectoDao();
			miProyectoDao.registrarProyecto(miProyecto);
		} else {
			if (miProyecto.getNombre().length() <= 3) { //si es menos o igual a 3, indicará mensaje de error
				JOptionPane.showMessageDialog(null, "El nombre del proyecto debe ser mayor a 3 digitos", "Advertencia",
						JOptionPane.WARNING_MESSAGE);
			}
			if (miProyecto.getIdProyecto().length() != 4) { //si es diferente de 4 indicará mensaje de error
				JOptionPane.showMessageDialog(null, "El codigo del proyecto de ser de 4 digitos", "Advertencia",
						JOptionPane.WARNING_MESSAGE);
			}
		}

	}

	// Metodo que valida los datos de consulta antes de pasar estos al DAO
	public Proyecto validarConsulta(String codigoProyecto) {
		ProyectoDao miProyectoDao;

		try {
			if (codigoProyecto.length() == 4) { 
				miProyectoDao = new ProyectoDao();
				consultaProyecto = true;
				return miProyectoDao.buscarProyecto(codigoProyecto);
			} else {
				JOptionPane.showMessageDialog(null, "El codigo del proyecto debe ser de 4 digitos", "Advertencia",
						JOptionPane.WARNING_MESSAGE);
				consultaProyecto = false;
			}

		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Debe ingresar un dato numerico", "Error", JOptionPane.ERROR_MESSAGE);
			consultaProyecto = false;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Se ha presentado un Error", "Error", JOptionPane.ERROR_MESSAGE);
			consultaProyecto = false;
		}

		return null;
	}

	// Metodo que valida los datos de Modificación antes de pasar estos al DAO
	public void validarModificacion(Proyecto miProyecto) {
		ProyectoDao miProyectoDao;
		if (miProyecto.getNombre().length() > 3 && miProyecto.getIdProyecto().length() == 4) {
			miProyectoDao = new ProyectoDao();
			miProyectoDao.modificarProyecto(miProyecto);
			modificaProyecto = true;
		} else {
			if (miProyecto.getNombre().length() <= 3) {
				JOptionPane.showMessageDialog(null, "El nombre del proyecto debe ser mayor a 3 digitos", "Advertencia",
						JOptionPane.WARNING_MESSAGE);
				modificaProyecto = false;
			}
			if (miProyecto.getIdProyecto().length() != 4) {
				JOptionPane.showMessageDialog(null, "El id del proyecto debe ser de 4 digitos", "Advertencia",
						JOptionPane.WARNING_MESSAGE);
				modificaProyecto = false;
			}
		}
	}

	// Metodo que valida los datos de Eliminación antes de pasar estos al DAO
	public void validarEliminacion(String codigo) {
		ProyectoDao miProyectoDao = new ProyectoDao();
		miProyectoDao.eliminarProyecto(codigo);
	}

	public ProyectoController getProyectoController() {
		return proyectoController;
	}

	public void setController(ProyectoController proyectoController) {
		this.proyectoController = proyectoController;
	}

}