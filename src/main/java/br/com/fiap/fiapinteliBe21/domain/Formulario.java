package br.com.fiap.fiapinteliBe21.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "T_IB_FORMULARIO")
public class Formulario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_formulario")
	private Long idFormulario;

	@NotNull
	@Column(name = "nm_formario")
	private String nomeFormulario;

	@NotNull
	@Column(name = "ds_vaga")
	private String descVaga;

	@NotNull
	@Future
	@Column(name = "dt_inicio_teste")
	private LocalDate dtInicioTeste;

	@NotNull
	@Column(name = "dt_final_teste")
	private LocalDate dtFinalTeste;

	@NotNull
	@Column(name = "hr_tempo_teste")
	private LocalTime hrTempoTeste;

	@NotNull
	@Column(name = "vl_nota_min")
	private Short valorNotaMinima;

	@NotNull
	@Column(name = "nm_publico_link")
	private String nomePublicoLink;

	@NotNull
	@Column(name = "qt_questoes_form")
	private Integer qtQuestoesForm;

	@NotNull
	@Column(name = "dt_criacao_form")
	private LocalDate dtCriacaoForm;

	@OneToOne
	@NotNull
	private Cliente cliente;
	
	@OneToMany(mappedBy = "formulario")
	private List<FormItem> formItem;

	public Formulario() {
		super();
	}

	public Formulario(Long idFormulario, @NotNull String nomeFormulario, @NotNull String descVaga,
			@NotNull LocalDate dtInicioTeste, @NotNull LocalDate dtFinalTeste, @NotNull LocalTime hrTempoTeste,
			@NotNull Short valorNotaMinima, @NotNull String nomePublicoLink, @NotNull Integer qtQuestoesForm,
			@NotNull LocalDate dtCriacaoForm, @NotNull Cliente cliente) {
		super();
		this.cliente = cliente;
		this.descVaga = descVaga;
		this.dtCriacaoForm = dtCriacaoForm;
		this.dtFinalTeste = dtFinalTeste;
		this.dtInicioTeste = dtInicioTeste;
		this.hrTempoTeste = hrTempoTeste;
		this.idFormulario = idFormulario;
		this.nomeFormulario = nomeFormulario;
		this.nomePublicoLink = nomePublicoLink;
		this.qtQuestoesForm = qtQuestoesForm;
		this.valorNotaMinima = valorNotaMinima;
	}

	public Long getIdFormulario() {
		return idFormulario;
	}

	public void setIdFormulario(Long idFormulario) {
		this.idFormulario = idFormulario;
	}

	public String getNomeFormulario() {
		return nomeFormulario;
	}

	public void setNomeFormulario(String nomeFormulario) {
		this.nomeFormulario = nomeFormulario;
	}

	public String getDescVaga() {
		return descVaga;
	}

	public void setDescVaga(String descVaga) {
		this.descVaga = descVaga;
	}

	public LocalDate getDtInicioTeste() {
		return dtInicioTeste;
	}

	public void setDtInicioTeste(LocalDate dtInicioTeste) {
		this.dtInicioTeste = dtInicioTeste;
	}

	public LocalDate getDtFinalTeste() {
		return dtFinalTeste;
	}

	public void setDtFinalTeste(LocalDate dtFinalTeste) {
		this.dtFinalTeste = dtFinalTeste;
	}

	public LocalTime getHrTempoTeste() {
		return hrTempoTeste;
	}

	public void setHrTempoTeste(LocalTime hrTempoTeste) {
		this.hrTempoTeste = hrTempoTeste;
	}

	public Short getValorNotaMinima() {
		return valorNotaMinima;
	}

	public void setValorNotaMinima(Short valorNotaMinima) {
		this.valorNotaMinima = valorNotaMinima;
	}

	public String getNomePublicoLink() {
		return nomePublicoLink;
	}

	public void setNomePublicoLink(String nomePublicoLink) {
		this.nomePublicoLink = nomePublicoLink;
	}

	public Integer getQtQuestoesForm() {
		return qtQuestoesForm;
	}

	public void setQtQuestoesForm(Integer qtQuestoesForm) {
		this.qtQuestoesForm = qtQuestoesForm;
	}

	public LocalDate getDtCriacaoForm() {
		return dtCriacaoForm;
	}

	public void setDtCriacaoForm(LocalDate dtCriacaoForm) {
		this.dtCriacaoForm = dtCriacaoForm;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<FormItem> getFormItem() {
		return formItem;
	}

	public void setFormItem(List<FormItem> formItem) {
		this.formItem = formItem;
	}
	
	

}
