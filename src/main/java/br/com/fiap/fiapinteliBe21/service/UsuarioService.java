package br.com.fiap.fiapinteliBe21.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.fiapinteliBe21.domain.Usuario;
import br.com.fiap.fiapinteliBe21.repository.UsuarioRepository;
import br.com.fiap.fiapinteliBe21.service.exception.EntityNotFoundException;
import br.com.fiap.fiapinteliBe21.util.CriptografiaUtils;


@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
   
    public Usuario 	buscarEmailEsenha(String email, String senha) {
    	try {
    		String senhaCriptografada = criptografarSenha(senha);
    		System.out.println("Senha criptografada = " + senhaCriptografada);
    		System.out.println("Email  " + email);
    		Usuario usuario = usuarioRepository.findByEmailAddress(email, senhaCriptografada );
    		return usuario;

    	} catch (Exception e) {
			throw new EntityNotFoundException("Busca de Email não encontrado " + email);
		}
	}

	public Usuario insert(Usuario usuario) {
		usuario.setIdUsuario(null);
		usuario.setSenha(criptografarSenha(usuario.getSenha()));
		return usuarioRepository.save(usuario);
	}
	
	public String criptografarSenha(String senha) {
		try {
			return CriptografiaUtils.criptografar(senha);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}	
}
