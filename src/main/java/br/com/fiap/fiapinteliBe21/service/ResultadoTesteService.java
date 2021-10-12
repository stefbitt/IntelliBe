package br.com.fiap.fiapinteliBe21.service;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.fiap.fiapinteliBe21.domain.RespostaTeste;
import br.com.fiap.fiapinteliBe21.domain.ResultadoTeste;
import br.com.fiap.fiapinteliBe21.repository.RespostaTesteRepository;
import br.com.fiap.fiapinteliBe21.repository.ResultadoTesteRepository;
import br.com.fiap.fiapinteliBe21.service.exception.DataIntegrityException;

@Service
public class ResultadoTesteService {
	@Autowired
	private RespostaTesteRepository respostaTesteRepository;
	@Autowired
	private ResultadoTesteRepository resultadoTesteRepository;
	@Autowired
	private CalcularCandidatosAprovados calcularAprovados;

	/*
	 * Buscar Resposta de Teste por CnpjOuCpf / idFormulario
	 */
	public Boolean gerarResultadoTeste(Long cnpjOuCpf, Long idFormulario) {
		boolean gerouResultadoTeste;
		List<RespostaTeste> listas = respostaTesteRepository.
							findByCnpjOuCpfAndFormulario(cnpjOuCpf, idFormulario);

		if (listas.isEmpty()) {
			gerouResultadoTeste = false;
			return gerouResultadoTeste;
		}
		List<ResultadoTeste> list = listar(cnpjOuCpf, idFormulario);
		if (!list.isEmpty()) {
			throw new DataIntegrityException("Já foi gerado Resultado Teste para esse Ciente / formulário "
					+ cnpjOuCpf + " / " + idFormulario );
		}

		
		ResultadoTeste resultadoTeste = null;
		
		for (RespostaTeste rt : listas) {
			if  (resultadoTeste == null ) {
				resultadoTeste = primeiroResultadoTeste(rt);
						System.out.println("chamou primeiroResultadoTeste(rt);= " + resultadoTeste);
			}
			
						System.out.println("cnpj= " + rt.getCnpjOuCpf() + "form= " + rt.getFormulario().getIdFormulario() + "cand= "
								+ rt.getCandidato().getIdCandidato() + "nr_perg= " + rt.getNrPergunta() + "seq_perg_resp= "
								+ rt.getSequPergResp());
						System.out.println("resultado = " + resultadoTeste);
			if (rt.getCandidato().getIdCandidato() == resultadoTeste.getIdCandidato()) {
				if (rt.getRespostaCerta().equals("s")) {
					resultadoTeste.setQtdeRespostaCerta(resultadoTeste.getQtdeRespostaCerta() + 1);
				}else {
					resultadoTeste.setQtdeRespostaErrada(resultadoTeste.getQtdeRespostaErrada() + 1);
				}
			}else {
				String aprovadoReprovado = calcularAprovados.verificarCandidatoAprovado(resultadoTeste);
						System.out.println("retorno verificarCandidatoAprovado = " + aprovadoReprovado );
				resultadoTeste.setCandidatoAprovado(aprovadoReprovado);
				
				Double percentualAcerto = calcularAprovados.calcularPercentualAcerto(resultadoTeste);
				resultadoTeste.setPercentualAcerto(percentualAcerto);
						System.out.println("RT para incluir = " + resultadoTeste );
				
				resultadoTesteRepository.save(resultadoTeste);
				
				resultadoTeste = novoResultadoTeste(rt);
						System.out.println("RT Novo = " + resultadoTeste );
			}
		}
		System.out.println("======== fim for ============");
		String aprovadoReprovado = calcularAprovados.verificarCandidatoAprovado(resultadoTeste);
						System.out.println("retorno verificarCandidatoAprovado = " + aprovadoReprovado );
		resultadoTeste.setCandidatoAprovado(aprovadoReprovado);
		
		Double percentualAcerto = calcularAprovados.calcularPercentualAcerto(resultadoTeste);
		resultadoTeste.setPercentualAcerto(percentualAcerto);
						System.out.println("RT para incluir = " + resultadoTeste );

		resultadoTesteRepository.save(resultadoTeste);
		return gerouResultadoTeste = true;
	}


	private ResultadoTeste novoResultadoTeste(RespostaTeste rt) {
		ResultadoTeste  resultadoTeste = new ResultadoTeste();
		resultadoTeste.setIdResultadoTeste(null);
		resultadoTeste.setIdFormulario(rt.getFormulario().getIdFormulario());
		resultadoTeste.setIdCandidato(rt.getCandidato().getIdCandidato());
		resultadoTeste.setCnpjOuCpf(rt.getCnpjOuCpf());
		resultadoTeste.setIdDepto(rt.getIdDepto());
		resultadoTeste.setQtdeRespostaCerta(0);
		resultadoTeste.setQtdeRespostaErrada(0);
		resultadoTeste.setPercentualAcerto(0.0);
		resultadoTeste.setDataInclusao(LocalDate.now());
		if (rt.getRespostaCerta().equals("s")) {
			resultadoTeste.setQtdeRespostaCerta(1);
		}else {
			resultadoTeste.setQtdeRespostaErrada(1);
		}
		return resultadoTeste;
	}
	private ResultadoTeste primeiroResultadoTeste(RespostaTeste rt) {
		ResultadoTeste  resultadoTeste = new ResultadoTeste();
		resultadoTeste.setIdResultadoTeste(0l);
		resultadoTeste.setIdFormulario(rt.getFormulario().getIdFormulario());
		resultadoTeste.setIdCandidato(rt.getCandidato().getIdCandidato());
		resultadoTeste.setCnpjOuCpf(rt.getCnpjOuCpf());
		resultadoTeste.setIdDepto(rt.getIdDepto());
		resultadoTeste.setPercentualAcerto(0.0);
		resultadoTeste.setQtdeRespostaCerta(0);
		resultadoTeste.setQtdeRespostaErrada(0);
		resultadoTeste.setDataInclusao(LocalDate.now());
		return resultadoTeste;
	}
	/*
	 * Retorna Lista Resposta de Teste por CnpjOuCpf / idFormulario order by candidatoAprovado 
	 */
	public List<ResultadoTeste> listar(Long cnpjOuCpf, Long idFormulario) {
		List<ResultadoTeste> list = resultadoTesteRepository.
							findByCnpjOuCpfAndFormulario(cnpjOuCpf, idFormulario);
		return list;
	}
/*
	 * Deletar ResultadoTeste por:  cnpjOuCpf, idFormulario
	 */
	public void deletar(Long cnpjOuCpf, Long idFormulario) {
		resultadoTesteRepository.deleteById(cnpjOuCpf, idFormulario);
	}
}
