package br.com.fiap.fiapinteliBe21;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.fiap.fiapinteliBe21.domain.Cliente;
import br.com.fiap.fiapinteliBe21.domain.FormTpItem;
import br.com.fiap.fiapinteliBe21.domain.Usuario;
import br.com.fiap.fiapinteliBe21.repository.ClienteRepository;
import br.com.fiap.fiapinteliBe21.repository.DepartamentoRepository;
import br.com.fiap.fiapinteliBe21.repository.FormTpItemRepository;
import br.com.fiap.fiapinteliBe21.repository.UsuarioRepository;

@SpringBootApplication
public class FiapInteliBe21Application implements CommandLineRunner {
	
	@Autowired
	private	UsuarioRepository usuarioRepository;
	@Autowired
	private	ClienteRepository clienteRepository;
	@Autowired
	private	DepartamentoRepository departamentoRepository;
	
	@Autowired private FormTpItemRepository formTpItemRepository;

	public static void main(String[] args) {
		SpringApplication.run(FiapInteliBe21Application.class, args);
	}
	
	
	@Override
	public void run(String... args) throws Exception {

		Usuario u1 = new Usuario(null,"PJ",11222333000244l,"Consultoria Estefani Ltda", "estefani@gmail.com", "e10adc3949ba59abbe56e057f20f883e");
		Usuario u2 = new Usuario(null,"PJ",11222333000244l,"Consultoria Estefani Ltda", "marcio@gmail.com","e10adc3949ba59abbe56e057f20f883e");
	//	usuarioRepository.saveAll(Arrays.asList(u1,u2));
		
		Cliente c1 = new Cliente(11222333000244l,"PJ","Consultoria Estefani Ltda","estefani@gmail.com","Rua Bragança,92",
				"torre 1 apto 128","Jd Abril","SBCampo","SP","Brasil","065000123","55(11)2323-7899");
		Cliente c2 = new Cliente(33222333000255l,"PJ","Consultoria Verônica Ltda","ve@gmail.com","Rua Mooca,22",
				"apto 128","Jd Conceição","Sto Andre","SP","Brasil","065000123", "55(11)2323-7899");
		
//		Departamento d1 = new Departamento(null, "Depto TI - Sistemas de Cobrança",11222333000244l,c1);
//		Departamento d2 = new Departamento(null, "Depto Marketing", 11222333000244l,c1);
//		Departamento d3 = new Departamento(null, "Depto Recursos Humanos", 11222333000244l,c1);
//		Departamento d4 = new Departamento(null, "TI Informações Tecnológicas", 33222333000255l,c2);
//		Departamento d5 = new Departamento(null, "IG Informações Gerenciais", 33222333000255l,c2);
//		
//		c1.getDepartamentos().addAll(Arrays.asList (d1, d2, d3));
//		c2.getDepartamentos().addAll(Arrays.asList (d4, d5));
//	
	//	clienteRepository.saveAll(Arrays.asList(c1,c2));
//		departamentoRepository.saveAll(Arrays.asList(d1,d2, d3, d4, d5));
		
		
		FormTpItem it1 = new FormTpItem(1L, "Text");
		FormTpItem it2 = new FormTpItem(2L, "Multipla Escolha");
		formTpItemRepository.saveAll(Arrays.asList(it1, it2));
		
	}
}

