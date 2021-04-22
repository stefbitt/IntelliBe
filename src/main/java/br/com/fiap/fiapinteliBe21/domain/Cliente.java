package br.com.fiap.fiapinteliBe21.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "T_IB_CLIENTE")
@SequenceGenerator(name="cliente",sequenceName="sq_tib_cliente",allocationSize=1)

public class Cliente implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente")
	@Column(name = "nr_cnpj_cpf")
	private Long cnpjOuCpf;

	@NotNull 
	@Column(name = "tp_cliente")
	private String tipoCliente;
	
	@NotNull 
	@Size(max = 60)
	@Column(name = "nm_cliente")
	private String nomeCliente;

	@NotNull 
	@Size(max = 60)
	@Column(name = "ds_email")
	private String descricaoEmail;
	
	@Size(max = 60)
	@Column(name = "ds_endereco")
	private String descricaoEndereco;
	
	@Size(max = 20)
	@Column(name = "ds_complemento")
	private String complementoEndereco;
	
	@Size(max = 30)
	@Column(name = "ds_bairro")
	private String bairro;
	
	@Size(max = 30)
	@Column(name = "ds_cidade")
	private String cidade;

	@Size(max = 2)
	@Column(name = "ds_estado")
	private String estado;
	
	@Size(max = 30)
	@Column(name = "ds_pais")
	private String pais;

	@Size(max = 20)
	@Column(name = "ds_cep")
	private String cep;

	@JsonManagedReference
	@OneToMany(mappedBy = "cliente")
	private	List<Departamento> departamentos = new ArrayList<Departamento>();
	
	public Cliente(Long cnpjOuCpf, @NotNull String tipoCliente, @NotNull @Size(max = 60) String nomeCliente,
			@NotNull @Size(max = 60) String descricaoEndereco, @NotNull @Size(max = 20) String complementoEndereco,
			@NotNull @Size(max = 30) String bairro, @NotNull @Size(max = 30) String cidade,
			@NotNull @Size(max = 2) String estado, @NotNull @Size(max = 30) String pais,
			@NotNull @Size(max = 20) String cep) {
		super();
		this.cnpjOuCpf = cnpjOuCpf;
		this.tipoCliente = tipoCliente;
		this.nomeCliente = nomeCliente;
		this.descricaoEndereco = descricaoEndereco;
		this.complementoEndereco = complementoEndereco;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.pais = pais;
		this.cep = cep;
	}

	public Cliente() {
		super();
	}

	public Long getCnpjOuCpf() {
		return cnpjOuCpf;
	}

	public void setCnpjOuCpf(Long cnpjOuCpf) {
		this.cnpjOuCpf = cnpjOuCpf;
	}

	public String getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	public String getDescricaoEmail() {
		return descricaoEmail;
	}
	
	public void setDescricaoEmail(String descricaoEmail) {
		this.descricaoEmail = descricaoEmail;
	}
	
	public String getDescricaoEndereco() {
		return descricaoEndereco;
	}

	public void setDescricaoEndereco(String descricaoEndereco) {
		this.descricaoEndereco = descricaoEndereco;
	}

	public String getComplementoEndereco() {
		return complementoEndereco;
	}

	public void setComplementoEndereco(String complementoEndereco) {
		this.complementoEndereco = complementoEndereco;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public List<Departamento> getDepartamentos() {
		return departamentos;
	}

	public void setDepartamentos(List<Departamento> departamentos) {
		this.departamentos = departamentos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cnpjOuCpf == null) ? 0 : cnpjOuCpf.hashCode());
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
		Cliente other = (Cliente) obj;
		if (cnpjOuCpf == null) {
			if (other.cnpjOuCpf != null)
				return false;
		} else if (!cnpjOuCpf.equals(other.cnpjOuCpf))
			return false;
		return true;
	}
	
}
