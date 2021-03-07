package Backend.PatronMVC.controller;

import Backend.PatronMVC.model.dto.Video;
import Backend.PatronMVC.model.service.VideoServ;
import Backend.PatronMVC.view.VentanaBuscarVideo;
import Backend.PatronMVC.view.VentanaPrincipal;
import Backend.PatronMVC.view.VentanaRegistroVideo;

public class VideoController {

	private VideoServ VideoServ;
	private VentanaPrincipal miVentanaPrincipal;
	private VentanaRegistroVideo miVentanaRegistroVideo;
	private VentanaBuscarVideo miVentanaBuscarVideo;



	public VideoServ getVideoServ() {
		return VideoServ;
	}

	public void setVideoServ(VideoServ VideoServ) {
		this.VideoServ = VideoServ;
	}

	public VentanaPrincipal getMiVentanaPrincipal() {
		return miVentanaPrincipal;
	}

	public void setMiVentanaPrincipal(VentanaPrincipal miVentanaPrincipal) {
		this.miVentanaPrincipal = miVentanaPrincipal;
	}

	public VentanaRegistroVideo getMiVentanaRegistroVideo() {
		return miVentanaRegistroVideo;
	}

	public void setMiVentanaRegistroVideo(VentanaRegistroVideo miVentanaRegistroVideo) {
		this.miVentanaRegistroVideo = miVentanaRegistroVideo;
	}

	public VentanaBuscarVideo getMiVentanaBuscarVideo() {
		return miVentanaBuscarVideo;
	}

	public void setMiVentanaBuscarVideo(VentanaBuscarVideo miVentanaBuscarVideo) {
		this.miVentanaBuscarVideo = miVentanaBuscarVideo;
	}

	// Hace visible las vistas de Registro y Consulta
	public void mostrarVentanaRegistroVideo() {
		miVentanaRegistroVideo.setVisible(true);
	}

	public void mostrarVentanaConsultaVideo() {
		miVentanaBuscarVideo.setVisible(true);
	}

	// Llamadas a los metodos CRUD de la capa service para validar los datos de las
	// vistas
	public void registrarVideo(Video miVideo) {
		VideoServ.validarRegistro(miVideo);
	}

	public Video buscarVideo(String codigoVideo) {
		return VideoServ.validarConsulta(codigoVideo);
	}

	public void modificarVideo(Video miPersona) {
		VideoServ.validarModificacion(miPersona);
	}

	public void eliminarVideo(String codigo) {
		VideoServ.validarEliminacion(codigo);
	}

	
	
	



}
