package br.com.fiap.fiapinteliBe21.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "T_IB_USUARIO")

public class Usuario implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name="usuario",sequenceName="SQ_TIB_USUARIO",allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario")
	@Column(name = "id_usuario")
	private Long idUsuario;


	@Column(name = "tp_usuario",nullable=false,length=2)
	private String tipoUsuario;
	

	@Column(name = "nr_cnpj_cpf",nullable=false,length=15)
	private Long cnpjOuCpf;
	
	@Column(name="nm_usuario",nullable=false,length=100)
	private String nomeUsuario;


	@Column(name = "ds_email", unique=true, nullable=false,length=60)
	private String descricaoEmail;
	
	@Column(name = "ds_senha",nullable=false,length=32)
	private String senha;
	


	public Usuario(Long idUsuario, String tipoUsuario, Long cnpjOuCpf, String nomeUsuario, String descricaoEmail,
			String senha) {
		super();
		this.idUsuario = idUsuario;
		this.tipoUsuario = tipoUsuario;
		this.cnpjOuCpf = cnpjOuCpf;
		this.nomeUsuario = nomeUsuario;
		this.descricaoEmail = descricaoEmail;
		this.senha = senha;
	}

	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	public Long getIdUsuario() {
		return idUsuario;
	}


	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}


	public String getTipoUsuario() {
		return tipoUsuario;
	}


	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}


	public Long getCnpjOuCpf() {
		return cnpjOuCpf;
	}


	public void setCnpjOuCpf(Long cnpjOuCpf) {
		this.cnpjOuCpf = cnpjOuCpf;
	}


	public String getNomeUsuario() {
		return nomeUsuario;
	}


	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}


	public String getDescricaoEmail() {
		return descricaoEmail;
	}


	public void setDescricaoEmail(String descricaoEmail) {
		this.descricaoEmail = descricaoEmail;
	}


	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
