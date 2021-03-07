package Backend.PatronMVC.model.service;

import javax.swing.JOptionPane;

import Backend.PatronMVC.controller.CientificoController;
import Backend.PatronMVC.model.dao.CientificoDao;
import Backend.PatronMVC.model.dto.Cientifico;

public class CientificoServ {
	private CientificoController CientificoController; 
	public static boolean consultaCientifico=false;
	public static boolean modificaCientifico=false;
	
	//Metodo de vinculación con el controller principal
	public void setCientificoController(CientificoController CientificoController) {
		this.setController(CientificoController);		
	}

	//Metodo que valida los datos de Registro antes de pasar estos al DAO
	public void validarRegistro(Cientifico miCientifico) {
		CientificoDao miCientificoDao;
		if (miCientifico.getDniCientifico().length() > 2) {
			miCientificoDao = new CientificoDao();
			miCientificoDao.registrarCientifico(miCientifico);						
		}else {
			JOptionPane.showMessageDialog(null,"El documento del Cientifico debe ser mas de 3 digitos","Advertencia",JOptionPane.WARNING_MESSAGE);
			
		}
		
	}
	
	//Metodo que valida los datos de consulta antes de pasar estos al DAO
	public Cientifico validarConsulta(String codigoCientifico) {
		CientificoDao miCientificoDao;
		
		try {
			int codigo=Integer.parseInt(codigoCientifico);	
			if (codigo > 99) {
				miCientificoDao = new CientificoDao();
				consultaCientifico=true;
				return miCientificoDao.buscarCientifico(codigo);						
			}else{
				JOptionPane.showMessageDialog(null,"El documento del Cientifico debe ser mas de 3 digitos","Advertencia",JOptionPane.WARNING_MESSAGE);
				consultaCientifico=false;
			}
			
		}catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null,"Debe ingresar un dato numerico","Error",JOptionPane.ERROR_MESSAGE);
			consultaCientifico=false;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Se ha presentado un Error","Error",JOptionPane.ERROR_MESSAGE);
			consultaCientifico=false;
		}
					
		return null;
	}

	//Metodo que valida los datos de Modificación antes de pasar estos al DAO
	public void validarModificacion(Cientifico miCientifico) {
		CientificoDao miCientificoDao;
		if (miCientifico.getNomApelsCientifico().length()>5) {
			miCientificoDao = new CientificoDao();
			miCientificoDao.modificarCientifico(miCientifico);	
			modificaCientifico=true;
		}else{
			JOptionPane.showMessageDialog(null,"El nombre del Cientifico debe ser mayor a 5 digitos","Advertencia",JOptionPane.WARNING_MESSAGE);
			modificaCientifico=false;
		}
	}

	//Metodo que valida los datos de Eliminación antes de pasar estos al DAO
	public void validarEliminacion(String codigo) {
		CientificoDao miCientificoDao=new CientificoDao();
		miCientificoDao.eliminarCientifico(codigo);
	}

	
	
	public CientificoController getCientificoController() {
		return CientificoController;
	}

	public void setController(CientificoController CientificoController) {
		this.CientificoController = CientificoController;
	}

}

