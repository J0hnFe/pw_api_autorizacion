package uce.edu.ec.autorizacion.service.to;

import java.io.Serializable;

public class UsuarioTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3467562750133390736L;

	private String nombre;
	private String password;
	private String semilla;
	private Integer tiempoExpiracion;

	// SET y GET

	public Integer getTiempoExpiracion() {
		return tiempoExpiracion;
	}

	public void setTiempoExpiracion(Integer tiempoExpiracion) {
		this.tiempoExpiracion = tiempoExpiracion;
	}

	public String getSemilla() {
		return semilla;
	}

	public void setSemilla(String semilla) {
		this.semilla = semilla;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
