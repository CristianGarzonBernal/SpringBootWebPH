package com.pacto.web.model;
// Generated 16/11/2018 12:49:47 PM by Hibernate Tools 5.2.8.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * RespuestaHtpHeroeId generated by hbm2java
 */
@Embeddable
public class RespuestaHtpHeroeId implements java.io.Serializable {

	private int idRespuesta;
	private int idHeroe;
	private int idPregunta;
	private String respuesta;

	public RespuestaHtpHeroeId() {
	}

	public RespuestaHtpHeroeId(int idRespuesta, int idHeroe, int idPregunta, String respuesta) {
		this.idRespuesta = idRespuesta;
		this.idHeroe = idHeroe;
		this.idPregunta = idPregunta;
		this.respuesta = respuesta;
	}

	@Column(name = "Id_Respuesta", nullable = false)
	public int getIdRespuesta() {
		return this.idRespuesta;
	}

	public void setIdRespuesta(int idRespuesta) {
		this.idRespuesta = idRespuesta;
	}

	@Column(name = "Id_Heroe", nullable = false)
	public int getIdHeroe() {
		return this.idHeroe;
	}

	public void setIdHeroe(int idHeroe) {
		this.idHeroe = idHeroe;
	}

	@Column(name = "Id_Pregunta", nullable = false)
	public int getIdPregunta() {
		return this.idPregunta;
	}

	public void setIdPregunta(int idPregunta) {
		this.idPregunta = idPregunta;
	}

	@Column(name = "Respuesta", nullable = false)
	public String getRespuesta() {
		return this.respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof RespuestaHtpHeroeId))
			return false;
		RespuestaHtpHeroeId castOther = (RespuestaHtpHeroeId) other;

		return (this.getIdRespuesta() == castOther.getIdRespuesta()) && (this.getIdHeroe() == castOther.getIdHeroe())
				&& (this.getIdPregunta() == castOther.getIdPregunta())
				&& ((this.getRespuesta() == castOther.getRespuesta()) || (this.getRespuesta() != null
						&& castOther.getRespuesta() != null && this.getRespuesta().equals(castOther.getRespuesta())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getIdRespuesta();
		result = 37 * result + this.getIdHeroe();
		result = 37 * result + this.getIdPregunta();
		result = 37 * result + (getRespuesta() == null ? 0 : this.getRespuesta().hashCode());
		return result;
	}

}
