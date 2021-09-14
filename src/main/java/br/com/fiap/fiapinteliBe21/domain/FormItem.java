package br.com.fiap.fiapinteliBe21.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "T_IB_ITENS_FORM")
public class FormItem implements Serializable {

	private static final long serialVersionUID = 1L;

//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "id_itens_form")
//	private Long idItensForm;
	@Id
	@SequenceGenerator(name="itensform",sequenceName="SQ_TIB_ITENS_FORM",allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "itensform")
	@Column(name = "id_itens_form")
	private Long idItensForm;	

	@NotNull
	@Column(name = "nr_pergunta")
	private Integer numeroPergunta;

	@NotNull
	@Column(name = "ds_pergunta")
	private String descPergunta;

	@NotNull
	@Column(name = "nr_ordem")
	private Integer numeroOrdemPergunta;

	@NotNull
	@Column(name = "sq_perg_resp")
	private String sequenciaPergResp;

	@OneToOne
	@NotNull
	private FormTpItem formTpItem;

	@ManyToOne
	@JsonIgnore

	private Formulario formulario;

	public FormItem() {

	}

	public FormItem(Long idItensForm, @NotNull Integer numeroPergunta, @NotNull String descPergunta,
			@NotNull Integer numeroOrdemPergunta, @NotNull String sequenciaPergResp, @NotNull FormTpItem formTpItem,
			Formulario formulario) {
		super();
		this.idItensForm = idItensForm;
		this.numeroPergunta = numeroPergunta;
		this.descPergunta = descPergunta;
		this.numeroOrdemPergunta = numeroOrdemPergunta;
		this.sequenciaPergResp = sequenciaPergResp;
		this.formTpItem = formTpItem;
		this.formulario = formulario;
	}

	public Long getIdItensForm() {
		return idItensForm;
	}

	public void setIdItensForm(Long idItensForm) {
		this.idItensForm = idItensForm;
	}

	public String getDescPergunta() {
		return descPergunta;
	}

	public void setDescPergunta(String descPergunta) {
		this.descPergunta = descPergunta;
	}

	public Integer getNumeroOrdemPergunta() {
		return numeroOrdemPergunta;
	}

	public void setNumeroOrdemPergunta(Integer numeroOrdemPergunta) {
		this.numeroOrdemPergunta = numeroOrdemPergunta;
	}

	public String getSequenciaResposta() {
		return sequenciaPergResp;
	}

	public void setSequenciaResposta(String sequenciaPergResp) {
		this.sequenciaPergResp = sequenciaPergResp;
	}

	public Integer getNumeroPergunta() {
		return numeroPergunta;
	}

	public void setNumeroPergunta(Integer numeroPergunta) {
		this.numeroPergunta = numeroPergunta;
	}

	public String getSequenciaPergResp() {
		return sequenciaPergResp;
	}

	public void setSequenciaPergResp(String sequenciaPergResp) {
		this.sequenciaPergResp = sequenciaPergResp;
	}

	public FormTpItem getFormTpItem() {
		return formTpItem;
	}

	public void setFormTpItem(FormTpItem formTpItem) {
		this.formTpItem = formTpItem;
	}

	public Formulario getFormulario() {
		return formulario;
	}

	public void setFormulario(Formulario formulario) {
		this.formulario = formulario;
	}

}
