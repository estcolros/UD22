package Backend.PatronMVC.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import Backend.PatronMVC.model.conexion.Conexion;
import Backend.PatronMVC.model.dto.Proyecto;

public class ProyectoDao {

	public void registrarProyecto(Proyecto miProyecto)
	{
		Conexion conex= new Conexion();
		
		try {
			Statement st = conex.getConnection().createStatement();
			String sql= "INSERT INTO Proyectos VALUES ('"+miProyecto.getIdProyecto()+"', '"
					+miProyecto.getNombre()+"', '"+miProyecto.getHoras()+"');";
			st.executeUpdate(sql);
			JOptionPane.showMessageDialog(null, "Se ha registrado Exitosamente","Información",JOptionPane.INFORMATION_MESSAGE);
			System.out.println(sql);
			st.close();
			conex.desconectar();
			
		} catch (SQLException e) {
            System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null,"El codigo del Proyecto ya existe","Advertencia",JOptionPane.WARNING_MESSAGE);

		}
	}

	public Proyecto buscarProyecto(String codigoProyecto) 
	{
		Conexion conex= new Conexion();
		Proyecto Proyecto= new Proyecto();
		boolean existe=false;
		try {
			String sql= "SELECT * FROM Proyectos where id = ? ";
			PreparedStatement consulta = conex.getConnection().prepareStatement(sql);
			consulta.setString(1, codigoProyecto);
			ResultSet res = consulta.executeQuery();
			while(res.next()){
				existe=true;
				Proyecto.setIdProyecto(res.getString("id"));
				Proyecto.setNombre(res.getString("nombre"));
				Proyecto.setHoras(Integer.parseInt(res.getString("horas")));
			 }
			res.close();
			conex.desconectar();
			System.out.println(sql);
					
			} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "Error, no se conecto");
					System.out.println(e);
			}
		
			if (existe) {
				return Proyecto;
			}
			else return null;				
	}

	public void modificarProyecto(Proyecto miProyecto) {
		
		Conexion conex= new Conexion();
		try{
			String consulta="UPDATE Proyectos SET id= ? ,nombre = ? , horas=? WHERE id= ? ";
			PreparedStatement estatuto = conex.getConnection().prepareStatement(consulta);
			
            estatuto.setString(1, miProyecto.getIdProyecto());
            estatuto.setString(2, miProyecto.getNombre());
            estatuto.setInt(3, miProyecto.getHoras());
            estatuto.setString(5,miProyecto.getIdProyecto());
            estatuto.executeUpdate();
            
          JOptionPane.showMessageDialog(null, " Se ha Modificado Correctamente ","Confirmación",JOptionPane.INFORMATION_MESSAGE);
          System.out.println(consulta);
         

        }catch(SQLException	 e){

            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error al Modificar","Error",JOptionPane.ERROR_MESSAGE);

        }
	}

	public void eliminarProyecto(String codigo)
	{
		Conexion conex= new Conexion();
		try {
			String sql= "DELETE FROM Proyectos WHERE id='"+codigo+"'";
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
