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

import com.fasterxml.jackson.annotation.JsonIgnore;

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

	@JsonIgnore      //Para não acontecer ciclo cruzado (looping cliente x deptos)
	@ManyToOne
	@JoinColumn(name="nr_cnpj_cpf_id")
	private Cliente	cliente;

	public Departamento(Long idDepto, @NotNull @Size(max = 60) String nomeDepto, Cliente cliente) {
		super();
		this.idDepto = idDepto;
		this.nomeDepto = nomeDepto;
		this.cliente = cliente;
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
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idDepto == null) ? 0 : idDepto.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Departamento other = (Departamento) obj;
		if (idDepto == null) {
			if (other.idDepto != null)
				return false;
		} else if (!idDepto.equals(other.idDepto))
			return false;
		return true;
	}
	
	
}
