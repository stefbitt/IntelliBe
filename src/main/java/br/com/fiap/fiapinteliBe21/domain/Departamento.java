package br.com.fiap.fiapinteliBe21.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "T_IB_DEPTO")
@SequenceGenerator(name="departamento",sequenceName="sq_tib_departamento",allocationSize=1)

public class Departamento implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "departamento")
	@Column(name = "id_depto")
	private Long idDepto;
	
	@NotNull 
	@Column(name = "nm_depto")
	@Size(max = 60)
	private String nomeDepto;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="nr_cnpj_cpf_id")
	private Cliente	cliente;

	public Departamento(Long idDepto, @NotNull @Size(max = 60) String nomeDepto) {
		super();
		this.idDepto = idDepto;
		this.nomeDepto = nomeDepto;
	}
	public Departamento() {
		super();
	}
	public Long getIdDepto() {
		return idDepto;
	}
	public void setIdDepto(Long idDepto) {
		this.idDepto = idDepto;
	}
	public String getNomeDepto() {
		return nomeDepto;
	}
	public void setNomeDepto(String nomeDepto) {
		this.nomeDepto = nomeDepto;
	}
	
	
}
