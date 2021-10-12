package br.com.fiap.fiapinteliBe21.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.fiapinteliBe21.domain.Formulario;
import br.com.fiap.fiapinteliBe21.domain.ResultadoTeste;
import br.com.fiap.fiapinteliBe21.service.exception.DataIntegrityException;
@Service
public class CalcularCandidatosAprovados {
	@Autowired
	private FormularioService formularioService;

	public CalcularCandidatosAprovados() {
	}

	public String verificarCandidatoAprovado(ResultadoTeste resultadoTeste) {
		
		String aprovadoReprovado = null;
		Formulario formulario = formularioService.buscar(resultadoTeste.getIdFormulario());
		if (formulario.getQtQuestoesForm() != (resultadoTeste.getQtdeRespostaCerta()
				+ resultadoTeste.getQtdeRespostaErrada())) {
						System.out.println("Divergencia totais informado e apurado de questoes");
			throw new DataIntegrityException("Divergencia totais informado e apurado de questoes");
		}
		if (resultadoTeste.getQtdeRespostaCerta() >= formulario.getValorNotaMinima()) {
			aprovadoReprovado = "s";
		}else {
			aprovadoReprovado = "n";
		}
						System.out.println(" resp certa / form.notamin " + 
						resultadoTeste.getQtdeRespostaCerta() + " / " + formulario.getValorNotaMinima());
						System.out.println("campo aprovadoReprova " + aprovadoReprovado);
		return aprovadoReprovado;
	}

	public Double calcularPercentualAcerto(ResultadoTeste resultadoTeste) {

		Formulario formulario = formularioService.buscar(resultadoTeste.getIdFormulario());
		Double percentualAcerto = 
				(resultadoTeste.getQtdeRespostaCerta() / (double) (formulario.getQtQuestoesForm()) *100) ;
		
		return percentualAcerto;
	}
}
