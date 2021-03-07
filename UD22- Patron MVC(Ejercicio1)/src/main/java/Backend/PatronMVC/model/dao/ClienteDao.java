package Backend.PatronMVC.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

import Backend.PatronMVC.model.conexion.Conexion;
import Backend.PatronMVC.model.dto.Cliente;

/**
 * Clase que permite el acceso a la base de datos
 * CRUD
 *
 */
public class ClienteDao
{

	public void registrarCliente(Cliente miCliente)
	{
		Conexion conex= new Conexion();
		
		try {
			Statement st = conex.getConnection().createStatement();
			String sql="Insert into Cliente values("
                    +miCliente.getIdCliente()+","
                    +"\""+miCliente.getNombreCliente()+"\","
                    +"\""+miCliente.getApellidoCliente()+"\","
                    +"\""+miCliente.getDireccionCliente()+"\","
                    +miCliente.getDniCliente()+","
                    +"'"+miCliente.getFechaCliente()+"'"
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

	public Cliente buscarCliente(int codigo) 
	{
		Conexion conex= new Conexion();
		Cliente Cliente= new Cliente();
		boolean existe=false;
		try {
			String sql= "SELECT * FROM Cliente where id = ? ";
			PreparedStatement consulta = conex.getConnection().prepareStatement(sql);
			consulta.setInt(1, codigo);
			ResultSet res = consulta.executeQuery();
			while(res.next()){
				existe=true;
				Cliente.setIdCliente(Integer.parseInt(res.getString("id")));
				Cliente.setNombreCliente(res.getString("nombre"));
				Cliente.setApellidoCliente(res.getString("apellido"));
				Cliente.setDireccionCliente(res.getString("direccion"));
				Cliente.setDniCliente(Integer.parseInt(res.getString("dni")));
				Cliente.setFechaCliente();
		
			 }
			res.close();
			conex.desconectar();
			System.out.println(sql);
					
			} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "Error, no se conecto");
					System.out.println(e);
			}
		
			if (existe) {
				return Cliente;
			}
			else return null;				
	}

	public void modificarCliente(Cliente miCliente) {
		
		Conexion conex= new Conexion();
		try{
			String consulta="UPDATE Cliente SET id= ? ,nombre = ? , apellido=? , direccion=? , dni= ? , fecha= ? WHERE id= ? ";
			PreparedStatement estatuto = conex.getConnection().prepareStatement(consulta);
			
            estatuto.setInt(1, miCliente.getIdCliente());
            estatuto.setString(2, miCliente.getNombreCliente());
            estatuto.setString(3, miCliente.getApellidoCliente());
            estatuto.setString(4, miCliente.getDireccionCliente());
            estatuto.setInt(5, miCliente.getDniCliente());
            estatuto.setString(6, miCliente.getFechaCliente());
            estatuto.setInt(7, miCliente.getIdCliente());
            estatuto.executeUpdate();
            
          JOptionPane.showMessageDialog(null, " Se ha Modificado Correctamente ","Confirmación",JOptionPane.INFORMATION_MESSAGE);
          System.out.println(consulta);
         

        }catch(SQLException	 e){

            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error al Modificar","Error",JOptionPane.ERROR_MESSAGE);

        }
	}

	public void eliminarCliente(String codigo)
	{
		Conexion conex= new Conexion();
		try {
			String sql= "DELETE FROM Cliente WHERE id='"+codigo+"'";
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
