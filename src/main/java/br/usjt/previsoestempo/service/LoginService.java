package br.usjt.previsoestempo.service;

import br.usjt.previsoestempo.model.Usuario;
import br.usjt.previsoestempo.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public boolean validarUsuario(Usuario usuario){
        return !usuarioRepository.findOneByLoginAndSenha(usuario).isEmpty();
    }
}
