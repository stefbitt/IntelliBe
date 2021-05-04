package br.com.fiap.fiapinteliBe21.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "T_IB_RESULTADO_TESTE")
@SequenceGenerator(name="resultado",sequenceName="sq_tib_resultado",allocationSize=1)

public class ResultadoTeste implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "resultado")
	@Column(name = "id_resultado")
	private Long idRespostaTeste;
	
	@NotNull(message = "Preenchimento obrigatório")
	@Column(name = "in_aprov_reprov")
	private Boolean candidatoAprovado;
	
	@NotNull(message = "Preenchimento obrigatório")
	@Column(name="qt_resposta_certa")
	private Integer	qtdeRespostaCerta;
	
	@NotNull(message = "Preenchimento obrigatório")
	@Column(name="qt_resposta_errada")
	private Integer	qtdeRespostaErrada;
	
	@NotNull(message = "Preenchimento obrigatório")
	@Column(name = "vl_perc_acerto")
	private Double percentualAcerto;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_inclusao")
	private Date dataInclusao;	
	
	@ManyToOne
	private	RespostaTeste	respostaTeste;
	
	public ResultadoTeste() {
	}

	public Long getIdRespostaTeste() {
		return idRespostaTeste;
	}

	public void setIdRespostaTeste(Long idRespostaTeste) {
		this.idRespostaTeste = idRespostaTeste;
	}

	public Boolean getCandidatoAprovado() {
		return candidatoAprovado;
	}

	public void setCandidatoAprovado(Boolean candidatoAprovado) {
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

	public Date getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(Date dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

	public RespostaTeste getRespostaTeste() {
		return respostaTeste;
	}

	public void setRespostaTeste(RespostaTeste respostaTeste) {
		this.respostaTeste = respostaTeste;
	}
	
	
}
