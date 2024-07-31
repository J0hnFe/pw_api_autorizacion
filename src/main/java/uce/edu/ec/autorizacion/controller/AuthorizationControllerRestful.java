package uce.edu.ec.autorizacion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uce.edu.ec.autorizacion.security.JwtUtils;
import uce.edu.ec.autorizacion.service.to.UserTO;
import uce.edu.ec.autorizacion.service.to.UsuarioTO;

@RestController
@RequestMapping("/autorizaciones")
@CrossOrigin
public class AuthorizationControllerRestful {

	@Autowired
	private AuthenticationManager authManager;

	@Autowired
	private JwtUtils utils;

	/**
	 * Primera de forma de resolver
	 * 
	 * Como esta enviando un RequestBody un GET no lo soporta y es necesario enviar
	 * por POST
	 * 
	 * @param user
	 * @return
	 */

	 // http://localhost:8081/API/v1.0/seguridad/autorizaciones/jwt
	@PostMapping(path = "/jwt", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String generarToken(@RequestBody UsuarioTO user) {
		this.autenticacion(user.getNombre(), user.getPassword()); // Esto es lo que envía el cliente, que luego se debe autenticar
		return this.utils.buildTokenJwt2(user.getNombre());
	}

	// 1:05:39 claseeeeeee

	/**
	 * Segunda forma de resolver
	 * 
	 * Como esta enviando un RequestBody un GET no lo soporta y es necesario enviar
	 * por POST
	 * 
	 * @param user
	 * @param semilla
	 * @param tiempo
	 * @return
	 */
	@PostMapping(path = "/jwt/path/{semilla}/{tiempo}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String generarToken2(@RequestBody UserTO user, @PathVariable String semilla, @PathVariable Integer tiempo) {
		this.autenticacion(user.getNombre(), user.getPassword());
		return this.utils.buildTokenJwt(user.getNombre(), semilla, tiempo);
	}

	private void autenticacion(String usuario, String password) {
		UsernamePasswordAuthenticationToken usuarioToken = new UsernamePasswordAuthenticationToken(usuario, password);
		Authentication auth = this.authManager.authenticate(usuarioToken);
		SecurityContextHolder.getContext().setAuthentication(auth);
	}

}
