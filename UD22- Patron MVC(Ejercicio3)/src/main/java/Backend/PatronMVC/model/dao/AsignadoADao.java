package Backend.PatronMVC.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import Backend.PatronMVC.model.conexion.Conexion;
import Backend.PatronMVC.model.dto.AsignadoA;


public class AsignadoADao {
	public void registrarAsignadoA(AsignadoA miAsignadoA)
	{
		Conexion conex= new Conexion();
		
		try {
			Statement st = conex.getConnection().createStatement();
			String sql="Insert into AsignadoA values("
                    +"\""+miAsignadoA.getCientifico()+"\" ,"
                    +"\""+miAsignadoA.getProyecto()+"\" "
                    + ");";

			st.executeUpdate(sql);
			JOptionPane.showMessageDialog(null, "Se ha registrado Exitosamente","Información",JOptionPane.INFORMATION_MESSAGE);
			System.out.println(sql);
			st.close();
			conex.desconectar();
			
		} catch (SQLException e) {
            System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "No se Registro");
		}
	}
	public AsignadoA buscarAsignadoA(String codigo) 
	{
		Conexion conex= new Conexion();
		AsignadoA AsignadoA= new AsignadoA();
		boolean existe=false;
		try {
			String sql= "SELECT * FROM AsignadoA where id = ? ";
			PreparedStatement consulta = conex.getConnection().prepareStatement(sql);
			consulta.setString(1, codigo);
			ResultSet res = consulta.executeQuery();
			while(res.next()){
				existe=true;
				
				AsignadoA.setCientifico(res.getString("Cientifico"));
				AsignadoA.setProyecto(res.getString("Proyecto"));
				
		
			 }
			res.close();
			conex.desconectar();
			System.out.println(sql);
					
			} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "Error, no se conecto");
					System.out.println(e);
			}
		
			if (existe) {
				return AsignadoA;
			}
			else return null;				
	}

	public void modificarAsignadoA(AsignadoA miAsignadoA) {
		
		Conexion conex= new Conexion();
		try{
			String consulta="UPDATE AsignadoA SET Cientifico= ? ,Proyecto = ?  WHERE id= ? ";
			PreparedStatement estatuto = conex.getConnection().prepareStatement(consulta);
			
            estatuto.setString(1, miAsignadoA.getCientifico());
            estatuto.setString(2, miAsignadoA.getProyecto());
            estatuto.setString(3, miAsignadoA.getCientifico());
            estatuto.executeUpdate();
            
          JOptionPane.showMessageDialog(null, " Se ha Modificado Correctamente ","Confirmación",JOptionPane.INFORMATION_MESSAGE);
          System.out.println(consulta);
         

        }catch(SQLException	 e){

            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error al Modificar","Error",JOptionPane.ERROR_MESSAGE);

        }
	}

	public void eliminarAsignadoA(String codigo)
	{
		Conexion conex= new Conexion();
		try {
			String sql= "DELETE FROM AsignadoA WHERE id='"+codigo+"'";
			Statement st = conex.getConnection().createStatement();
			st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, " Se ha Eliminado Correctamente","Información",JOptionPane.INFORMATION_MESSAGE);
            System.out.println(sql);
			st.close();
			conex.desconectar();
			
		} catch (SQLException e) {
            System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "No se Elimino");
		}
	}

}
