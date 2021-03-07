package Backend.PatronMVC.model.service;

import javax.swing.JOptionPane;

import Backend.PatronMVC.controller.AsignadoAController;
import Backend.PatronMVC.model.dao.AsignadoADao;
import Backend.PatronMVC.model.dto.AsignadoA;

public class AsignadoAServ {

	private AsignadoAController AsignadoAController; 
	public static boolean consultaAsignadoA=false;
	public static boolean modificaAsignadoA=false;
	
	//Metodo de vinculación con el controller principal
	public void setAsignadoAController(AsignadoAController AsignadoAController) {
		this.setController(AsignadoAController);		
	}

	//Metodo que valida los datos de Registro antes de pasar estos al DAO
	public void validarRegistro(AsignadoA miAsignadoA) {
		AsignadoADao miAsignadoADao;
		if (miAsignadoA.getCientifico().length()>2) {
			miAsignadoADao = new AsignadoADao();
			miAsignadoADao.registrarAsignadoA(miAsignadoA);						
		}else {
			JOptionPane.showMessageDialog(null,"El documento del AsignadoA debe ser mas de 3 digitos","Advertencia",JOptionPane.WARNING_MESSAGE);
			
		}
		
	}
	
	//Metodo que valida los datos de consulta antes de pasar estos al DAO
	public AsignadoA validarConsulta(String codigoAsignadoA) {
		AsignadoADao miAsignadoADao;
		
		try {
			String codigo=codigoAsignadoA;	
			if (codigo.length()> 2) {
				miAsignadoADao = new AsignadoADao();
				consultaAsignadoA=true;
				return miAsignadoADao.buscarAsignadoA(codigo);
								
			}else{
				JOptionPane.showMessageDialog(null,"El documento del AsignadoA debe ser mas de 3 digitos","Advertencia",JOptionPane.WARNING_MESSAGE);
				consultaAsignadoA=false;
			}
			
		}catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null,"Debe ingresar un dato numerico","Error",JOptionPane.ERROR_MESSAGE);
			consultaAsignadoA=false;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Se ha presentado un Error","Error",JOptionPane.ERROR_MESSAGE);
			consultaAsignadoA=false;
		}
					
		return null;
	}

	//Metodo que valida los datos de Modificación antes de pasar estos al DAO
	public void validarModificacion(AsignadoA miAsignadoA) {
		AsignadoADao miAsignadoADao;
		if (miAsignadoA.getCientifico().length()>5) {
			miAsignadoADao = new AsignadoADao();
			miAsignadoADao.modificarAsignadoA(miAsignadoA);	
			modificaAsignadoA=true;
		}else{
			JOptionPane.showMessageDialog(null,"El nombre del Cliente debe ser mayor a 5 digitos","Advertencia",JOptionPane.WARNING_MESSAGE);
			modificaAsignadoA=false;
		}
	}

	//Metodo que valida los datos de Eliminación antes de pasar estos al DAO
	public void validarEliminacion(String codigo) {
		AsignadoADao miAsignadoADao=new AsignadoADao();
		miAsignadoADao.eliminarAsignadoA(codigo);
	}

	
	
	public AsignadoAController getAsignadoAController() {
		return AsignadoAController;
	}

	public void setController(AsignadoAController AsignadoAController) {
		this.AsignadoAController = AsignadoAController;
	}

}

