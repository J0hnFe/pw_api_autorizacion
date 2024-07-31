package uce.edu.ec.autorizacion.service.to;

import java.io.Serializable;

public class UserTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8293910810792255708L;
	private String nombre;
	private String password;

	// SET y GET

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
