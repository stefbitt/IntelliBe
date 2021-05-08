package br.com.fiap.fiapinteliBe21;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.fiap.fiapinteliBe21.domain.Candidato;
import br.com.fiap.fiapinteliBe21.domain.Cliente;
import br.com.fiap.fiapinteliBe21.domain.Departamento;
import br.com.fiap.fiapinteliBe21.domain.FormTpItem;
import br.com.fiap.fiapinteliBe21.domain.Usuario;
import br.com.fiap.fiapinteliBe21.repository.CandidatoRepository;
import br.com.fiap.fiapinteliBe21.repository.ClienteRepository;
import br.com.fiap.fiapinteliBe21.repository.DepartamentoRepository;
import br.com.fiap.fiapinteliBe21.repository.FormTpItemRepository;
import br.com.fiap.fiapinteliBe21.repository.UsuarioRepository;

@SpringBootApplication
public class FiapInteliBe21Application implements CommandLineRunner {

	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private DepartamentoRepository departamentoRepository;
	@Autowired
	private FormTpItemRepository formTpItemRepository;
	@Autowired
	private CandidatoRepository candidatoRepository;

	public static void main(String[] args) {
		SpringApplication.run(FiapInteliBe21Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Usuario u1 = new Usuario(null, "PJ", 65039846000180l, "Consultoria Estefani Ltda", "estefani@gmail.com",
				"123456");
		Usuario u2 = new Usuario(null, "PJ", 65039846000180l, "Consultoria Estefani Ltda", "marcio@gmail.com",
				"654321");
		usuarioRepository.saveAll(Arrays.asList(u1, u2));

		Cliente c1 = new Cliente(65039846000180l, "PJ", "Consultoria Estefani Ltda", "estefani@gmail.com",
				"Rua Bragança,92", "torre 1 apto 128", "Jd Abril", "SBCampo", "SP", "Brasil", "065000123",
				"(011)2323-7899");
		Cliente c2 = new Cliente(29390486000101l, "PJ", "Consultoria Verônica Ltda", "ve@gmail.com", "Rua Mooca,22",
				"apto 128", "Jd Conceição", "Sto Andre", "SP", "Brasil", "065000123", "(011)2323-7899");

		Departamento d1 = new Departamento(null, "Depto TI - Sistemas de Cobrança", 65039846000180l, c1);
		Departamento d2 = new Departamento(null, "Depto Marketing", 65039846000180l, c1);
		Departamento d3 = new Departamento(null, "Depto Recursos Humanos", 65039846000180l, c1);
		Departamento d4 = new Departamento(null, "TI Informações Tecnológicas", 29390486000101l, c2);
		Departamento d5 = new Departamento(null, "IG Informações Gerenciais", 29390486000101l, c2);

		c1.getDepartamentos().addAll(Arrays.asList(d1, d2, d3));
		c2.getDepartamentos().addAll(Arrays.asList(d4, d5));

		clienteRepository.saveAll(Arrays.asList(c1, c2));
		departamentoRepository.saveAll(Arrays.asList(d1, d2, d3, d4, d5));

		FormTpItem it1 = new FormTpItem(1L, "Text");
		FormTpItem it2 = new FormTpItem(2L, "Multipla Escolha");
		formTpItemRepository.saveAll(Arrays.asList(it1, it2));
		
		Candidato cand1 = new Candidato(null, "Luana Antunes", "15893015010",(LocalDate.of(1980, Month.DECEMBER, 16)),
				"luana1@gmail.com", "(011)6166-7890");
		Candidato cand2 = new Candidato(null, "Adalberto Silva", "12703046820",(LocalDate.of(1990, Month.JANUARY, 16)),
				"beto1@gmail.com", "(011)6166-7890");
		candidatoRepository.saveAll(Arrays.asList(cand1, cand2));
		System.out.println("fim da carga ========");
	}
}
