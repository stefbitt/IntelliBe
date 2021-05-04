package br.com.fiap.fiapinteliBe21.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "T_IB_CANDIDATO")

public class Candidato implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="candidato",sequenceName="SQ_TIB_CANDIDATO",allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "candidato")
	@Column(name = "id_candidato")
	private Long idCandidato;

	@NotNull(message = "Preenchimento obrigatório")
	@Size(min = 2, max = 60, message = "O tamanho deve ter entre 2 e 60 caracteres")
	@Column(name = "nm_candidato")
	private String nomeCandidato;
	
	@NotNull(message = "Preenchimento obrigatório")
	@CPF
	@Column(name = "nr_cpf")
	private Long cpf;

	@JsonFormat(pattern = "dd/MM/yyyy")
	@NotNull(message = "Preenchimento obrigatório")
	@Column(name = "dt_nascimento")
	private Date dataNascimento;
	
	@NotNull(message = "Preenchimento obrigatório")
	@Size(min = 2, max = 60, message = "O tamanho deve ter entre 2 e 60 caracteres")
	@Email
	@Column(name = "ds_email")
	private String email;

	@Pattern(regexp = "\\(\\d{3}\\)\\d{4}-\\d{4}", message = "O tamanho deve ter formato (999)9999-9999")
	@Column(name = "nr_telefone")
	private String telefone;

	@OneToMany(mappedBy = "candidato")
	private List<RespostaTeste> respostaTeste = new ArrayList<>();
	

	public Candidato() {
		super();
	}

	public Candidato(Long idCandidato,
			@NotNull(message = "Preenchimento obrigatório") @Size(min = 2, max = 60, message = "O tamanho deve ter entre 2 e 60 caracteres") String nomeCandidato,
			@NotNull(message = "Preenchimento obrigatório") @CPF Long cpf,
			@NotNull(message = "Preenchimento obrigatório") Date dataNascimento,
			@NotNull(message = "Preenchimento obrigatório") @Size(min = 2, max = 60, message = "O tamanho deve ter entre 2 e 60 caracteres") @Email String email,
			@Pattern(regexp = "\\(\\d{3}\\)\\d{4}-\\d{4}", message = "O tamanho deve ter formato (999)9999-9999") String telefone) {
		this.idCandidato = idCandidato;
		this.nomeCandidato = nomeCandidato;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.email = email;
		this.telefone = telefone;
	}

	public Long getIdCandidato() {
		return idCandidato;
	}

	public void setIdCandidato(Long idCandidato) {
		this.idCandidato = idCandidato;
	}

	public String getNomeCandidato() {
		return nomeCandidato;
	}

	public void setNomeCandidato(String nomeCandidato) {
		this.nomeCandidato = nomeCandidato;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public List<RespostaTeste> getRespostaTeste() {
		return respostaTeste;
	}

	public void setRespostaTeste(List<RespostaTeste> respostaTeste) {
		this.respostaTeste = respostaTeste;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idCandidato == null) ? 0 : idCandidato.hashCode());
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
		Candidato other = (Candidato) obj;
		if (idCandidato == null) {
			if (other.idCandidato != null)
				return false;
		} else if (!idCandidato.equals(other.idCandidato))
			return false;
		return true;
	}
	

}
