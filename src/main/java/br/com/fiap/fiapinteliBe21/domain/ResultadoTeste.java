package br.com.fiap.fiapinteliBe21.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "T_IB_RESULTADO_TESTE")
@SequenceGenerator(name="resultado",sequenceName="sq_tib_resultado",allocationSize=1)

	public class ResultadoTeste implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "resultado")
	@Column(name = "id_resultado")
	private Long idResultadoTeste;

	@NotNull(message = "Preenchimento obrigatório")
	@Column(name = "id_formulario")
	private Long idFormulario;

	@NotNull(message = "Preenchimento obrigatório")
	@Column(name = "id_candidato")
	private Long idCandidato;
	
	@NotNull(message = "Preenchimento obrigatório")
	@Column(name = "in_aprov_reprov")
	private String candidatoAprovado;
	
	@NotNull(message = "Preenchimento obrigatório")
	@Column(name="qt_resposta_certa")
	private Integer	qtdeRespostaCerta;
	
	@NotNull(message = "Preenchimento obrigatório")
	@Column(name="qt_resposta_errada")
	private Integer	qtdeRespostaErrada;
	
	@NotNull(message = "Preenchimento obrigatório")
	@Column(name = "vl_perc_acerto")
	private Double percentualAcerto;

	@NotNull(message = "Preenchimento obrigatório")
	@Column(name = "nr_cnpj_cpf")
	private Long cnpjOuCpf;

	@NotNull(message = "Preenchimento obrigatório")
	@Column(name = "id_depto")
	private Long idDepto;
	
	@NotNull(message = "Preenchimento obrigatório")
	@Column(name="dt_inclusao")
	private LocalDate dataInclusao;	

//	@OneToMany(mappedBy = "resultadoTeste")
//	
//	private List<ResultadoTeste> respostaTeste = new ArrayList<>();	
	
	public ResultadoTeste() {
	}

	public ResultadoTeste(Long idResultadoTeste, @NotNull(message = "Preenchimento obrigatório") Long idFormulario,
			@NotNull(message = "Preenchimento obrigatório") Long idCandidato,
			@NotNull(message = "Preenchimento obrigatório") String candidatoAprovado,
			@NotNull(message = "Preenchimento obrigatório") Integer qtdeRespostaCerta,
			@NotNull(message = "Preenchimento obrigatório") Integer qtdeRespostaErrada,
			@NotNull(message = "Preenchimento obrigatório") Double percentualAcerto,
			@NotNull(message = "Preenchimento obrigatório") Long cnpjOuCpf,
			@NotNull(message = "Preenchimento obrigatório") Long idDepto, LocalDate dataInclusao)
			{
		super();
		this.idResultadoTeste = idResultadoTeste;
		this.idFormulario = idFormulario;
		this.idCandidato = idCandidato;
		this.candidatoAprovado = candidatoAprovado;
		this.qtdeRespostaCerta = qtdeRespostaCerta;
		this.qtdeRespostaErrada = qtdeRespostaErrada;
		this.percentualAcerto = percentualAcerto;
		this.cnpjOuCpf = cnpjOuCpf;
		this.idDepto = idDepto;
		this.dataInclusao = dataInclusao;
	}

	public Long getIdResultadoTeste() {
		return idResultadoTeste;
	}

	public void setIdResultadoTeste(Long idResultadoTeste) {
		this.idResultadoTeste = idResultadoTeste;
	}

	public Long getIdFormulario() {
		return idFormulario;
	}

	public void setIdFormulario(Long idFormulario) {
		this.idFormulario = idFormulario;
	}

	public Long getIdCandidato() {
		return idCandidato;
	}

	public void setIdCandidato(Long idCandidato) {
		this.idCandidato = idCandidato;
	}

	public Long getCnpjOuCpf() {
		return cnpjOuCpf;
	}

	public void setCnpjOuCpf(Long cnpjOuCpf) {
		this.cnpjOuCpf = cnpjOuCpf;
	}

	public Long getIdDepto() {
		return idDepto;
	}

	public void setIdDepto(Long idDepto) {
		this.idDepto = idDepto;
	}

	public String getCandidatoAprovado() {
		return candidatoAprovado;
	}

	public void setCandidatoAprovado(String candidatoAprovado) {
		this.candidatoAprovado = candidatoAprovado;
	}

	public Integer getQtdeRespostaCerta() {
		return qtdeRespostaCerta;
	}

	public void setQtdeRespostaCerta(Integer qtdeRespostaCerta) {
		this.qtdeRespostaCerta = qtdeRespostaCerta;
	}

	public Integer getQtdeRespostaErrada() {
		return qtdeRespostaErrada;
	}

	public void setQtdeRespostaErrada(Integer qtdeRespostaErrada) {
		this.qtdeRespostaErrada = qtdeRespostaErrada;
	}

	public Double getPercentualAcerto() {
		return percentualAcerto;
	}

	public void setPercentualAcerto(Double percentualAcerto) {
		this.percentualAcerto = percentualAcerto;
	}

	public LocalDate getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(LocalDate dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

	@Override
	public String toString() {
		return "ResultadoTeste [idResultadoTeste=" + idResultadoTeste + ", idFormulario=" + idFormulario
				+ ", idCandidato=" + idCandidato + ", candidatoAprovado=" + candidatoAprovado + ", qtdeRespostaCerta="
				+ qtdeRespostaCerta + ", qtdeRespostaErrada=" + qtdeRespostaErrada + ", percentualAcerto="
				+ percentualAcerto + ", cnpjOuCpf=" + cnpjOuCpf + ", idDepto=" + idDepto + ", dataInclusao="
				+ dataInclusao + "]";
	}
	
}
