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
	
	@Column(name = "nm_depto", nullable=false,length=60)
	private String nomeDepto;

	@Column(length=14, nullable=false)
	private Long	cnpjOuCpf;

	@JsonIgnore      //Para não acontecer ciclo cruzado (looping cnpjOuCpf x deptos)
	@ManyToOne
	@JoinColumn(name="nr_cnpj_cpf_id")
	private	Cliente	cliente;

	public Departamento() {
	}


	public Departamento(Long idDepto, String nomeDepto, Long cnpjOuCpf, Cliente cliente) {
		super();
		this.idDepto = idDepto;
		this.nomeDepto = nomeDepto;
		this.cnpjOuCpf = cnpjOuCpf;
		this.cliente = cliente;
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

	public Long getCnpjOuCpf() {
		return cnpjOuCpf;
	}

	public void setCnpjOuCpf(Long cnpjOuCpf) {
		this.cnpjOuCpf = cnpjOuCpf;
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


	@Override
	public String toString() {
		return "Departamento [idDepto=" + idDepto + ", nomeDepto=" + nomeDepto + ", cnpjOuCpf=" + cnpjOuCpf
				+ ", cliente=" + cliente + "]";
	}


	
}
