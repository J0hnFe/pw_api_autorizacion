package uce.edu.ec.autorizacion.repository;

import uce.edu.ec.autorizacion.modelo.Usuario;

public interface IUsuarioRepo {
    public Usuario consultarPorNombre(String nombre);
    
}
