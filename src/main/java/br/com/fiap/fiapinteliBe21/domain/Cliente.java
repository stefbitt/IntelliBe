package br.com.fiap.fiapinteliBe21.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import br.com.fiap.fiapinteliBe21.domain.enums.TipoCliente;
import br.com.fiap.fiapinteliBe21.service.validation.ClienteInsert;

@Entity
@Table(name = "T_IB_CLIENTE")

@ClienteInsert
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "nr_cnpj_cpf")
	private Long cnpjOuCpf;

	@NotNull(message = "Preenchimento obrigatório")
	@Column(name = "tp_cliente")
	private Integer tipoCliente;

	@NotNull(message = "Preenchimento obrigatório")
	@Size(min = 2, max = 60, message = "O tamanho deve ter entre 2 e 60 caracteres")
	@Column(name = "nm_cliente")
	private String nomeCliente;

	@NotNull(message = "Preenchimento obrigatório")
	@Size(min = 2, max = 60, message = "O tamanho deve ter entre 2 e 60 caracteres")
	@Email
	@Column(name = "ds_email")
	private String descricaoEmail;

	@NotNull(message = "Preenchimento obrigatório")
	@Size(min = 2, max = 60, message = "O tamanho deve ter entre 2 e 60 caracteres")
	@Column(name = "ds_endereco")
	private String descricaoEndereco;

	@Size(min = 2, max = 30, message = "O tamanho deve ter entre 2 e 30 caracteres")
	@Column(name = "ds_complemento")
	private String complementoEndereco;

	@NotNull(message = "Preenchimento obrigatório")
	@Size(min = 2, max = 30, message = "O tamanho deve ter entre 2 e 30 caracteres")
	@Column(name = "ds_bairro")
	private String bairro;

	@NotNull(message = "Preenchimento obrigatório")
	@Size(min = 2, max = 30, message = "O tamanho deve ter entre 2 e 30 caracteres")
	@Column(name = "ds_cidade")
	private String cidade;

	@NotNull(message = "Preenchimento obrigatório")
	@Size(min = 2, max = 2, message = "O tamanho deve ter 2 caracteres")
	@Column(name = "ds_estado")
	private String estado;

	@NotNull(message = "Preenchimento obrigatório")
	@Size(min = 2, max = 30, message = "O tamanho deve ter entre 2 e 30 caracteres")
	@Column(name = "ds_pais")
	private String pais;

	@NotNull(message = "Preenchimento obrigatório")
	@Size(min = 2, max = 20, message = "O tamanho deve ter entre 2 e 60 caracteres")
	@Column(name = "ds_cep", nullable = false, length = 20)
	private String cep;

	@Pattern(regexp = "\\(\\d{3}\\)\\d{4}-\\d{4}", message = "O tamanho deve ter formato (999)9999-9999")
	@Column(name = "nr_telefone")
	private String telefone;

	@OneToMany(mappedBy = "cliente")
	private List<Departamento> departamentos = new ArrayList<>();

	public Cliente(Long cnpjOuCpf, String tipoCliente, String nomeCliente, @Email String descricaoEmail,
			String descricaoEndereco, String complementoEndereco, String bairro, String cidade, String estado,
			String pais, String cep, String telefone) {
		super();
		this.cnpjOuCpf = cnpjOuCpf;
		this.nomeCliente = nomeCliente;
		setTipoCliente(tipoCliente);
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

	public TipoCliente getTipoCliente() {
		return TipoCliente.toEnum(tipoCliente);
	}

	public void setTipoCliente(String tipo) {
		if (!tipo.equals("PF") && !tipo.equals("PJ")) {
			throw new RuntimeException("Tipo dever ser PF ou PJ");
		}
		TipoCliente tipoCliente = TipoCliente.valueOf(tipo);
		this.tipoCliente = tipoCliente.getCod();
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
