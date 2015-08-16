package br.edu.ftlf.ads.revenda.model;

import java.io.Serializable;

public abstract class Model implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (getClass() != obj.getClass())
			return false;
		Model other = (Model) obj;
		if (getId() != null && other.getId() != null) {
			return getId().equals(other.getId());
		}
		return false;
	}
	
	public boolean isNew() {
		return id == null;
	}
	
}
