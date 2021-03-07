package Backend.PatronMVC.model.dto;

public class Proyecto {
	private String idProyecto;
	private String nombre;
	private Integer horas;
	/**
	 * @return the idProyecto
	 */
	public String getIdProyecto() {
		return idProyecto;
	}
	/**
	 * @param idProyecto the idProyecto to set
	 */
	public void setIdProyecto(String idProyecto) {
		this.idProyecto = idProyecto;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the horas
	 */
	public Integer getHoras() {
		return horas;
	}
	/**
	 * @param horas the horas to set
	 */
	public void setHoras(Integer horas) {
		this.horas = horas;
	}
	
	
}
