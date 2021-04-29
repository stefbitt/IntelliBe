package br.com.fiap.fiapinteliBe21.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "T_IB_TIPO_ITEM")
public class FormTpItem implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tipo_item")
	private Long idTipoItens;

	@NotNull
	@Column(name = "ds_tipo_item")
	private String descTipoItem;

	public FormTpItem() {

	}

	public FormTpItem(Long idTipoItens, @NotNull String descTipoItem) {
		super();
		this.idTipoItens = idTipoItens;
		this.descTipoItem = descTipoItem;
	}

	public Long getIdTipoItens() {
		return idTipoItens;
	}

	public void setIdTipoItens(Long idTipoItens) {
		this.idTipoItens = idTipoItens;
	}

	public String getDescTipoItem() {
		return descTipoItem;
	}

	public void setDescTipoItem(String descTipoItem) {
		this.descTipoItem = descTipoItem;
	}

}
