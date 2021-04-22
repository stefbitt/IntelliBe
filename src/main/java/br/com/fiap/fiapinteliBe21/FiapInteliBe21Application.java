package br.com.fiap.fiapinteliBe21;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.fiap.fiapinteliBe21.domain.Usuario;
import br.com.fiap.fiapinteliBe21.repository.UsuarioRepository;

@SpringBootApplication
public class FiapInteliBe21Application implements CommandLineRunner{
	@Autowired
	private	UsuarioRepository usuarioRepository;

	public static void main(String[] args) {
		SpringApplication.run(FiapInteliBe21Application.class, args);
	}
	
	
	@Override
	public void run(String... args) throws Exception {

		Usuario u1 = new Usuario(1l,"PJ",11222333000244l,"Consultoria Estefani Ltda", "estefani@gmail.com", "e10adc3949ba59abbe56e057f20f883e");
		Usuario u2 = new Usuario(2l,"PJ",11222333000244l,"Consultoria Estefani Ltda", "marcio@gmail.com","e10adc3949ba59abbe56e057f20f883e");
		usuarioRepository.saveAll(Arrays.asList(u1,u2));
	}
}

