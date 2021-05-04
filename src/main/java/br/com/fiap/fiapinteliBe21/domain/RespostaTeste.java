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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "T_IB_RESPOSTA_TESTE")
@SequenceGenerator(name="resposta",sequenceName="sq_tib_resposta",allocationSize=1)

public class RespostaTeste implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "resposta")
	@Column(name = "id_resp_teste")
	private Long idRespostaTeste;
	
	@NotNull(message = "Preenchimento obrigatório")
	@Column(name = "nr_pergunta")
	private Integer	nrPergunta;
	
	@NotNull(message = "Preenchimento obrigatório")
	@Column(name = "sq_perg_resp")
	private String sequPergResp;

	@NotNull(message = "Preenchimento obrigatório")
	@Column(name = "in_resposta_certa")
	private Boolean respostaCerta;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_inclusao")
	private Date dataInclusao;	

	@NotNull(message = "Preenchimento obrigatório")
	@Column(length=14)
	private Long	cnpjOuCpf;
	
	@NotNull(message = "Preenchimento obrigatório")
	@Column(name = "id_depto")
	private Long idDepto;
	
	@JsonIgnore      //Para não acontecer ciclo cruzado (looping Candidato x Respostateste)
	@ManyToOne
	private	Candidato	candidato;

	@JsonIgnore      //Para não acontecer ciclo cruzado (looping Formulario x RespostaTeste)
	@ManyToOne
	private	Formulario	formulario;
	
	@JsonIgnore      //Para não acontecer ciclo cruzado (looping ResultadoTeste x RespostaTeste)
	@ManyToOne
	private	ResultadoTeste	resultadoTeste;
	
	public RespostaTeste() {
	}
	
	public RespostaTeste(Long idRespostaTeste, @NotNull(message = "Preenchimento obrigatório") Integer nrPergunta,
			@NotNull(message = "Preenchimento obrigatório") String sequPergResp,
			@NotNull(message = "Preenchimento obrigatório") Boolean respostaCerta, Date dataInclusao,
			@NotNull(message = "Preenchimento obrigatório") Long cnpjOuCpf,
			@NotNull(message = "Preenchimento obrigatório") Long idDepto, Candidato candidato, Formulario formulario) {
		super();
		this.idRespostaTeste = idRespostaTeste;
		this.nrPergunta = nrPergunta;
		this.sequPergResp = sequPergResp;
		this.respostaCerta = respostaCerta;
		this.dataInclusao = dataInclusao;
		this.cnpjOuCpf = cnpjOuCpf;
		this.idDepto = idDepto;
		this.candidato = candidato;
		this.formulario = formulario;
	}

	public Long getIdRespostaTeste() {
		return idRespostaTeste;
	}

	public void setIdRespostaTeste(Long idRespostaTeste) {
		this.idRespostaTeste = idRespostaTeste;
	}

	public Integer getNrPergunta() {
		return nrPergunta;
	}

	public void setNrPergunta(Integer nrPergunta) {
		this.nrPergunta = nrPergunta;
	}

	public String getSequPergResp() {
		return sequPergResp;
	}

	public void setSequPergResp(String sequPergResp) {
		this.sequPergResp = sequPergResp;
	}

	public Boolean getRespostaCerta() {
		return respostaCerta;
	}

	public void setRespostaCerta(Boolean respostaCerta) {
		this.respostaCerta = respostaCerta;
	}

	public Date getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(Date dataInclusao) {
		this.dataInclusao = dataInclusao;
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

	public Candidato getCandidato() {
		return candidato;
	}

	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}

	public Formulario getFormulario() {
		return formulario;
	}

	public void setFormulario(Formulario formulario) {
		this.formulario = formulario;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
