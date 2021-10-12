package br.com.fiap.fiapinteliBe21;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.fiap.fiapinteliBe21.domain.Candidato;
import br.com.fiap.fiapinteliBe21.domain.Cliente;
import br.com.fiap.fiapinteliBe21.domain.Departamento;
import br.com.fiap.fiapinteliBe21.domain.FormItem;
import br.com.fiap.fiapinteliBe21.domain.FormTpItem;
import br.com.fiap.fiapinteliBe21.domain.Formulario;
import br.com.fiap.fiapinteliBe21.domain.RespostaTeste;
import br.com.fiap.fiapinteliBe21.domain.Usuario;
import br.com.fiap.fiapinteliBe21.repository.CandidatoRepository;
import br.com.fiap.fiapinteliBe21.repository.ClienteRepository;
import br.com.fiap.fiapinteliBe21.repository.DepartamentoRepository;
import br.com.fiap.fiapinteliBe21.repository.FormItemRepository;
import br.com.fiap.fiapinteliBe21.repository.FormTpItemRepository;
import br.com.fiap.fiapinteliBe21.repository.FormularioRepository;
import br.com.fiap.fiapinteliBe21.repository.RespostaTesteRepository;
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
	private RespostaTesteRepository respostaTesteRepository;
	@Autowired
	private CandidatoRepository candidatoRepository;
	@Autowired
	private FormularioRepository formularioRepository;
	@Autowired
	private FormItemRepository formItemRepository;

	public static void main(String[] args) {
		SpringApplication.run(FiapInteliBe21Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

//		TESTE CLIENTE - DEPTO - USUARIO
		
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
		
//		TESTE FORMULARIO - ITENS FORMULARIO - TIPO ITEM
		
		Formulario f1 = new Formulario(1l,"Formulario captação de Analista Sistemas","Vaga Analista de Sistema Sr.",
				(LocalDate.of(2021,5,15)),(LocalDate.of(2021,7,15)),"n","n",LocalTime.of(0,45,00),
				7.0,"https://pt.wikipedia.org/wiki/C%C3%B3digo_nativo",10,LocalDate.now(), c1);
		Formulario f2 = new Formulario(2l,"Formulario captação de Analista Sistemas","Vaga Analista de Sistema Pl.",
				(LocalDate.of(2021,5,15)),(LocalDate.of(2021,7,15)),"n","n",LocalTime.of(0,45,00),
				7.0,"https://pt.wikipedia.org/wiki/C%C3%B3digo_nativo",10,LocalDate.now(), c1);
		Formulario f3 = new Formulario(3l,"Formulario captação de Analista Sistemas","Vaga Analista de Sistema Jr.",
				(LocalDate.of(2021,5,15)),(LocalDate.of(2021,7,15)),"n","s",LocalTime.of(0,45,00),
				7.0,"https://pt.wikipedia.org/wiki/C%C3%B3digo_nativo",10,LocalDate.now(), c1);
		Formulario f4 = new Formulario(4l,"Formulario captação de Analista Sistemas","Vaga Analista de Sistema Tr.",
				(LocalDate.of(2021,5,15)),(LocalDate.of(2021,7,15)),"n","n",LocalTime.of(0,45,00),
				7.0,"https://pt.wikipedia.org/wiki/C%C3%B3digo_nativo",10,LocalDate.now(), c1);
	
		formularioRepository.saveAll(Arrays.asList(f1, f2, f3, f4));

		FormTpItem ti1 = new FormTpItem(1l,"Pergunta");
		FormTpItem ti2 = new FormTpItem(2l,"Resposta Multipla Escolha");
		FormTpItem ti3 = new FormTpItem(3l,"Resposta dissertativa - texto");
		FormTpItem ti10 = new FormTpItem(10l,"Resposta Correta");
		formTpItemRepository.saveAll(Arrays.asList(ti1, ti2, ti3,ti10));
	
		FormItem fi11 = new FormItem(0l,1,"O que significa a sigla MVC?",1,"1",ti1,f1); 
		FormItem fi12 = new FormItem(0l,1,"Um algorítmo.",2,"a",ti2,f1); 
		FormItem fi13 = new FormItem(0l,1,"Uma biblioteca.",3,"b",ti2,f1); 
		FormItem fi14 = new FormItem(0l,1,"Um framework Spring.",4,"c",ti2,f1); 
		FormItem fi15 = new FormItem(0l,1,"Um padrão em camadas.",5,"d",ti2,f1); 
		FormItem fi16 = new FormItem(0l,1,"nda",6,"e",ti2,f1); 
		FormItem fi17 = new FormItem(0l,1,"   ",7,"d",ti10,f1); 

		FormItem fi21 = new FormItem(0l,2,"O que significa um DECORATE?",1,"2",ti1,f1); 
		FormItem fi22 = new FormItem(0l,2,"Um algorítmo.",2,"a",ti2,f1); 
		FormItem fi23 = new FormItem(0l,2,"Uma Design Patterns.",3,"b",ti2,f1); 
		FormItem fi24 = new FormItem(0l,2,"Uma collection.",4,"c",ti2,f1); 
		FormItem fi25 = new FormItem(0l,2,"Um enums.",5,"d",ti2,f1); 
		FormItem fi26 = new FormItem(0l,2,"nda",6,"e",ti2,f1); 
		FormItem fi27 = new FormItem(0l,2,"   ",7,"b",ti10,f1); 

		FormItem fi31 = new FormItem(0l,3,"Qual das alternativas define Herança?",1,"3",ti1,f1); 
		FormItem fi32 = new FormItem(0l,3,"Um algorítmo.",2,"a",ti2,f1); 
		FormItem fi33 = new FormItem(0l,3,"Uma conceito onde os filhos herdam do pai métodos e atributos",3,"b",ti2,f1); 
		FormItem fi34 = new FormItem(0l,3,"Uma collection de Pais e Filhos.",4,"c",ti2,f1); 
		FormItem fi35 = new FormItem(0l,3,"Uma conceito onde o Pai herda do filho métodos e atributos",5,"d",ti2,f1); 
		FormItem fi36 = new FormItem(0l,3,"nda",6,"e",ti2,f1); 
		FormItem fi37 = new FormItem(0l,3,"   ",7,"b",ti10,f1); 
		
		FormItem fi41 = new FormItem(0l,4,"Qual maior vantagem do framework Spring?",1,"4",ti1,f1); 
		FormItem fi42 = new FormItem(0l,4,"Armazenar informações em um repositorio.",2,"a",ti2,f1); 
		FormItem fi43 = new FormItem(0l,4,"Gerar relatorios.",3,"b",ti2,f1); 
		FormItem fi44 = new FormItem(0l,4,"Eliminar trabalho repetitivo facilitando implementações.",4,"c",ti2,f1); 
		FormItem fi45 = new FormItem(0l,4,"Gerar documentações do processo de implementação.",5,"d",ti2,f1); 
		FormItem fi46 = new FormItem(0l,4,"nda",6,"e",ti2,f1); 
		FormItem fi47 = new FormItem(0l,4,"   ",7,"c",ti10,f1); 
		
		FormItem fi51 = new FormItem(0l,5,"O que é uma Collection?",1,"5",ti1,f1); 
		FormItem fi52 = new FormItem(0l,5,"Um algorítmo.",2,"a",ti2,f1); 
		FormItem fi53 = new FormItem(0l,5,"Uma Design Patterns.",3,"b",ti2,f1); 
		FormItem fi54 = new FormItem(0l,5,"Um método.",4,"c",ti2,f1); 
		FormItem fi55 = new FormItem(0l,5,"Uma lista de um mesmo tipo.",5,"d",ti2,f1); 
		FormItem fi56 = new FormItem(0l,5,"nda",6,"e",ti2,f1); 
		FormItem fi57 = new FormItem(0l,5,"   ",7,"d",ti10,f1); 
		
		FormItem fi61 = new FormItem(0l,6,"O que significa OO ?",1,"6",ti1,f1); 
		FormItem fi62 = new FormItem(0l,6,"Um paradigma.",2,"a",ti2,f1); 
		FormItem fi63 = new FormItem(0l,6,"Uma Design Patterns.",3,"b",ti2,f1); 
		FormItem fi64 = new FormItem(0l,6,"Uma código em Java.",4,"c",ti2,f1); 
		FormItem fi65 = new FormItem(0l,6,"Um método.",5,"d",ti2,f1); 
		FormItem fi66 = new FormItem(0l,6,"nda",6,"e",ti2,f1); 
		FormItem fi67 = new FormItem(0l,6,"   ",7,"a",ti10,f1); 
		
		FormItem fi71 = new FormItem(0l,7,"Quem é o Scrum?",1,"7",ti1,f1); 
		FormItem fi72 = new FormItem(0l,7,"Um paradigma.",2,"a",ti2,f1); 
		FormItem fi73 = new FormItem(0l,7,"Uma metodologia de sistemas funcional.",3,"b",ti2,f1); 
		FormItem fi74 = new FormItem(0l,7,"Um framework, uma gestão de projeto ágil.",4,"c",ti2,f1); 
		FormItem fi75 = new FormItem(0l,7,"Uma metodologia de Análise Estruturada de Sistmas.",5,"d",ti2,f1); 
		FormItem fi76 = new FormItem(0l,7,"nda",6,"e",ti2,f1); 
		FormItem fi77 = new FormItem(0l,7,"   ",7,"c",ti10,f1); //correta 
		
		FormItem fi81 = new FormItem(0l,8,"O que são Sprints dentro do Scrum?",1,"8",ti1,f1); 
		FormItem fi82 = new FormItem(0l,8,"Um cronograma mensal que deverá ser atualizado.",2,"a",ti2,f1); 
		FormItem fi83 = new FormItem(0l,8,"Uma lista de atividades que deverão ser executadas.",3,"b",ti2,f1); 
		FormItem fi84 = new FormItem(0l,8,"Datas de reuniões programadas.",4,"c",ti2,f1); 
		FormItem fi85 = new FormItem(0l,8,"Um periodo que um time trabalha para entregar uma quantidade definida de trabalho.",5,"d",ti2,f1); 
		FormItem fi86 = new FormItem(0l,8,"nda",6,"e",ti2,f1); 
		FormItem fi87 = new FormItem(0l,8,"   ",7,"d",ti10,f1); 
		
		FormItem fi91 = new FormItem(0l,9,"Quais os ciclos da Sprint ?",1,"9",ti1,f1); 
		FormItem fi92 = new FormItem(0l,9,"Ciclos semanais e quizenais ",2,"a",ti2,f1); 
		FormItem fi93 = new FormItem(0l,9,"Introdutorio, desenvolvimento, teste, implantação.",3,"b",ti2,f1); 
		FormItem fi94 = new FormItem(0l,9,"Levantamento, análise, desevolvimento, teste.",4,"c",ti2,f1); 
		FormItem fi95 = new FormItem(0l,9,"Planejamento, reunião diaria, revisão e retrospectiva.",5,"d",ti2,f1); 
		FormItem fi96 = new FormItem(0l,9,"nda",6,"e",ti2,f1); 
		FormItem fi97 = new FormItem(0l,9,"   ",7,"d",ti10,f1); 
		
		FormItem fi101 = new FormItem(0l,10,"Quanto tempo deve durar uma reunião diaria no Scrum?",1,"10",ti1,f1); 
		FormItem fi102 = new FormItem(0l,10,"1 hora.",2,"a",ti2,f1); 
		FormItem fi103 = new FormItem(0l,10,"15 minutos.",3,"b",ti2,f1); 
		FormItem fi104 = new FormItem(0l,10,"30 minutos.",4,"c",ti2,f1); 
		FormItem fi105 = new FormItem(0l,10,"45 minutos",5,"d",ti2,f1); 
		FormItem fi106 = new FormItem(0l,10,"nda",6,"e",ti2,f1); 
		FormItem fi107 = new FormItem(0l,10,"   ",7,"b",ti10,f1); 
		
		formItemRepository.saveAll(Arrays.asList(
		fi11,fi12,fi13,fi14,fi15,fi16,fi17,fi21,fi22,fi23,fi24,fi25,fi26,fi27,fi31,fi32,fi33,fi34,fi35,fi36,fi37,
		fi41,fi42,fi43,fi44,fi45,fi46,fi47,fi51,fi52,fi53,fi54,fi55,fi56,fi57,fi61,fi62,fi63,fi64,fi65,fi66,fi67,
		fi71,fi72,fi73,fi74,fi75,fi76,fi77,fi81,fi82,fi83,fi84,fi85,fi86,fi87,fi91,fi92,fi93,fi94,fi95,fi96,fi97,
		fi101,fi102,fi103,fi104,fi105,fi106,fi107));	
		
		Candidato cand1 = new Candidato(null,"Marcio Antunes", "12703046820",(LocalDate.of(1980,7,15)),"marcio@gmail.com","(011)2323-7899");
		Candidato cand2 = new Candidato(null,"Jose Augusto", "12703046820",(LocalDate.of(1960,1,12)),"jose@gmail.com","(011)2323-7899");
		Candidato cand3 = new Candidato(null,"Marcos Lima", "12703046820",(LocalDate.of(1970,6,15)),"mlima@gmail.com","(011)2323-7899");
		Candidato cand4 = new Candidato(null,"Flavio Medina", "12703046820",(LocalDate.of(1980,7,15)),"fmedina@gmail.com","(011)2323-7899");
		candidatoRepository.saveAll(Arrays.asList(cand1,cand2,cand3,cand4));

		//5 ok 5 erro  1-d,2-b,3-d,4-c,5-d,6-a,7-c,8-d,9-d,10-b	
		RespostaTeste rt41 = new RespostaTeste(0l,1,"d","s",LocalDate.now(),65039846000180l,1l,cand4,f1); 
		RespostaTeste rt42 = new RespostaTeste(0l,2,"b","s",LocalDate.now(),65039846000180l,1l,cand4,f1); 
		RespostaTeste rt43 = new RespostaTeste(0l,3,"d","s",LocalDate.now(),65039846000180l,1l,cand4,f1); 
		RespostaTeste rt44 = new RespostaTeste(0l,4,"c","s",LocalDate.now(),65039846000180l,1l,cand4,f1); 
		RespostaTeste rt45 = new RespostaTeste(0l,5,"d","s",LocalDate.now(),65039846000180l,1l,cand4,f1); 
		RespostaTeste rt46 = new RespostaTeste(0l,6,"c","n",LocalDate.now(),65039846000180l,1l,cand4,f1); 
		RespostaTeste rt47 = new RespostaTeste(0l,7,"b","n",LocalDate.now(),65039846000180l,1l,cand4,f1); 
		RespostaTeste rt48 = new RespostaTeste(0l,8,"a","n",LocalDate.now(),65039846000180l,1l,cand4,f1); 
		RespostaTeste rt49 = new RespostaTeste(0l,9,"a","n",LocalDate.now(),65039846000180l,1l,cand4,f1); 
		RespostaTeste rt410 = new RespostaTeste(0l,10,"c","n",LocalDate.now(),65039846000180l,1l,cand4,f1); 
		
		//7 ok 3 erro 1-d,2-b,3-d,4-c,5-d,6-a,7-c,8-d,9-d,10-b
		RespostaTeste rt21 = new RespostaTeste(0l,1,"a","n",LocalDate.now(),65039846000180l,1l,cand2,f1); 
		RespostaTeste rt22 = new RespostaTeste(0l,2,"b","s",LocalDate.now(),65039846000180l,1l,cand2,f1); 
		RespostaTeste rt23 = new RespostaTeste(0l,3,"d","s",LocalDate.now(),65039846000180l,1l,cand2,f1); 
		RespostaTeste rt24 = new RespostaTeste(0l,4,"c","s",LocalDate.now(),65039846000180l,1l,cand2,f1); 
		RespostaTeste rt25 = new RespostaTeste(0l,5,"d","s",LocalDate.now(),65039846000180l,1l,cand2,f1); 
		RespostaTeste rt26 = new RespostaTeste(0l,6,"d","n",LocalDate.now(),65039846000180l,1l,cand2,f1); 
		RespostaTeste rt27 = new RespostaTeste(0l,7,"c","s",LocalDate.now(),65039846000180l,1l,cand2,f1); 
		RespostaTeste rt28 = new RespostaTeste(0l,8,"d","s",LocalDate.now(),65039846000180l,1l,cand2,f1); 
		RespostaTeste rt29 = new RespostaTeste(0l,9,"d","s",LocalDate.now(),65039846000180l,1l,cand2,f1); 
		RespostaTeste rt210 = new RespostaTeste(0l,10,"d","n",LocalDate.now(),65039846000180l,1l,cand2,f1); 
		
		//Todas corretas 1-d,2-b,3-d,4-c,5-d,6-a,7-c,8-d,9-d,10-b
		RespostaTeste rt11 = new RespostaTeste(0l,1,"d","s",LocalDate.now(),65039846000180l,1l,cand1,f1); 
		RespostaTeste rt12 = new RespostaTeste(0l,2,"b","s",LocalDate.now(),65039846000180l,1l,cand1,f1); 
		RespostaTeste rt13 = new RespostaTeste(0l,3,"d","s",LocalDate.now(),65039846000180l,1l,cand1,f1); 
		RespostaTeste rt14 = new RespostaTeste(0l,4,"c","s",LocalDate.now(),65039846000180l,1l,cand1,f1); 
		RespostaTeste rt15 = new RespostaTeste(0l,5,"d","s",LocalDate.now(),65039846000180l,1l,cand1,f1); 
		RespostaTeste rt16 = new RespostaTeste(0l,6,"a","s",LocalDate.now(),65039846000180l,1l,cand1,f1); 
		RespostaTeste rt17 = new RespostaTeste(0l,7,"c","s",LocalDate.now(),65039846000180l,1l,cand1,f1); 
		RespostaTeste rt18 = new RespostaTeste(0l,8,"d","s",LocalDate.now(),65039846000180l,1l,cand1,f1); 
		RespostaTeste rt19 = new RespostaTeste(0l,9,"d","s",LocalDate.now(),65039846000180l,1l,cand1,f1); 
		RespostaTeste rt110 = new RespostaTeste(0l,10,"b","s",LocalDate.now(),65039846000180l,1l,cand1,f1); 

		//4 erro 6 ok 1-d,2-b,3-d,4-c,5-d,6-a,7-c,8-d,9-d,10-b
		RespostaTeste rt31 = new RespostaTeste(0l,1,"a","n",LocalDate.now(),65039846000180l,1l,cand3,f1); 
		RespostaTeste rt32 = new RespostaTeste(0l,2,"c","n",LocalDate.now(),65039846000180l,1l,cand3,f1); 
		RespostaTeste rt33 = new RespostaTeste(0l,3,"d","s",LocalDate.now(),65039846000180l,1l,cand3,f1); 
		RespostaTeste rt34 = new RespostaTeste(0l,4,"c","s",LocalDate.now(),65039846000180l,1l,cand3,f1); 
		RespostaTeste rt35 = new RespostaTeste(0l,5,"d","s",LocalDate.now(),65039846000180l,1l,cand3,f1); 
		RespostaTeste rt36 = new RespostaTeste(0l,6,"a","s",LocalDate.now(),65039846000180l,1l,cand3,f1); 
		RespostaTeste rt37 = new RespostaTeste(0l,7,"c","s",LocalDate.now(),65039846000180l,1l,cand3,f1); 
		RespostaTeste rt38 = new RespostaTeste(0l,8,"d","s",LocalDate.now(),65039846000180l,1l,cand3,f1); 
		RespostaTeste rt39 = new RespostaTeste(0l,9,"c","n",LocalDate.now(),65039846000180l,1l,cand3,f1); 
		RespostaTeste rt310 = new RespostaTeste(0l,10,"a","n",LocalDate.now(),65039846000180l,1l,cand3,f1); 
		
		respostaTesteRepository.saveAll(Arrays.asList(rt21,rt22,rt23,rt24,rt25,rt26,rt27,rt28,rt29,rt210,
				rt31,rt32,rt33,rt34,rt35,rt36,rt37,rt38,rt39,rt310,
				rt41,rt42,rt43,rt44,rt45,rt46,rt47,rt48,rt49,rt410,rt11,rt12,rt13,rt14,rt15,rt16,rt17,rt18,rt19,rt110));
	}
}	
