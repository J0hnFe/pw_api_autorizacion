package uce.edu.ec.autorizacion.service;

import static java.util.Collections.emptyList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import uce.edu.ec.autorizacion.modelo.Usuario;
import uce.edu.ec.autorizacion.repository.IUsuarioRepo;

@Service
public class UsuarioServiceImpl implements UserDetailsService {

	@Autowired
	private IUsuarioRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario u = this.userRepo.consultarPorNombre(username);
		return new User(u.getNombre(), u.getPassword(), emptyList());
	}

}
