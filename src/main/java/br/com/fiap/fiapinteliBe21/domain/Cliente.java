package br.com.fiap.fiapinteliBe21.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;

@Entity
@Table(name = "T_IB_CLIENTE")
public class Cliente implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "nr_cnpj_cpf")
	private Long cnpjOuCpf;

	@Column(name = "tp_cliente", nullable=false,length=2)
	private String tipoCliente;
	
	@Column(name = "nm_cliente", nullable=false,length=60)
	private String nomeCliente;

	@Email
	@Column(name = "ds_email", nullable=false,length=60)
	private String descricaoEmail;
	
	@Column(name = "ds_endereco",  nullable=false,length=60)
	private String descricaoEndereco;
	
	@Column(name = "ds_complemento",  nullable=false,length=30)
	private String complementoEndereco;
	
	@Column(name = "ds_bairro",  nullable=false,length=40)
	private String bairro;
	
	@Column(name = "ds_cidade",  nullable=false,length=40)
	private String cidade;

	@Column(name = "ds_estado",  nullable=false,length=2)
	private String estado;
	
	@Column(name = "ds_pais" ,  nullable=false,length=40)
	private String pais;

	@Column(name = "ds_cep" ,  nullable=false,length=20)
	private String cep;

	@Column(name = "nr_telefone" ,  nullable=false,length=20)
	private String telefone;

	@OneToMany(cascade=CascadeType.ALL, mappedBy = "cliente")
	private	List<Departamento> departamentos = new ArrayList<>();


	public Cliente(Long cnpjOuCpf, String tipoCliente, String nomeCliente, @Email String descricaoEmail,
			String descricaoEndereco, String complementoEndereco, String bairro, String cidade, String estado,
			String pais, String cep, String telefone) {
		super();
		this.cnpjOuCpf = cnpjOuCpf;
		this.tipoCliente = tipoCliente;
		this.nomeCliente = nomeCliente;
		this.descricaoEmail = descricaoEmail;
		this.descricaoEndereco = descricaoEndereco;
		this.complementoEndereco = complementoEndereco;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.pais = pais;
		this.cep = cep;
		this.telefone = telefone;
	}

	public Cliente() {
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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public List<Departamento> getDepartamentos() {
		return departamentos;
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

	@Override
	public String toString() {
		return "Cliente [cnpjOuCpf=" + cnpjOuCpf + ", tipoCliente=" + tipoCliente + ", nomeCliente=" + nomeCliente
				+ ", descricaoEmail=" + descricaoEmail + ", descricaoEndereco=" + descricaoEndereco
				+ ", complementoEndereco=" + complementoEndereco + ", bairro=" + bairro + ", cidade=" + cidade
				+ ", estado=" + estado + ", pais=" + pais + ", cep=" + cep + ", telefone=" + telefone
				+ ", departamentos=" + departamentos + "]";
	}
	
}
