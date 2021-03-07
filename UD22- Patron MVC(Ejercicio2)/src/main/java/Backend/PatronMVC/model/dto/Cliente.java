package Backend.PatronMVC.model.dto;
import java.time.LocalDate;
public class Cliente {
	
	private Integer idCliente;
	private String nombreCliente;
	private String apellidoCliente;
	private String direccionCliente;
	private Integer dniCliente;
	private String fechaCliente;
	
	/**
	 * @return the idCliente
	 */
	public Integer getIdCliente() {
		return idCliente;
	}
	/**
	 * @param idCliente the idCliente to set
	 */
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	/**
	 * @return the nombreCliente
	 */
	public String getNombreCliente() {
		return nombreCliente;
	}
	/**
	 * @param nombreCliente the nombreCliente to set
	 */
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	/**
	 * @return the edadCliente
	 */
	public String getApellidoCliente() {
		return apellidoCliente;
	}
	public void setApellidoCliente(String apellidoCliente) {
		this.apellidoCliente = apellidoCliente;
	}
	public String getDireccionCliente() {
		return direccionCliente;
	}
	public void setDireccionCliente(String direccionCliente) {
		this.direccionCliente = direccionCliente;
	}
	public Integer getDniCliente() {
		return dniCliente;
	}
	public void setDniCliente(Integer dniCliente) {
		this.dniCliente = dniCliente;
	}
	public String getFechaCliente() {
		return fechaCliente;
	}
	public void setFechaCliente() {
		LocalDate actual = LocalDate.now();

		this.fechaCliente =actual+"";
	}
	

}
