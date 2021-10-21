package com.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name = "numeritelefono")
@NamedQueries({
		@NamedQuery(name = "ERASE_CONTACT", query = "delete from Contatto where numerotelefono = :numero and refuser = :refuser"),
		@NamedQuery(name = "GET_CONTACT", query = "select c from Contatto c where c.refuser = :refuser") })
public class Contatto implements Serializable {

	private static final long serialVersionUID = -7565662470576630302L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idtelefono")
	private int idtelefono;

	@Column(name = "nomecontatto")
	private String nomecontatto;

	@Column(name = "numerotelefono")
	private String numerotelefono;

	@ManyToOne
	@JoinColumn(name = "refuser", nullable = false)
	private User refuser;

	public String getNumerotelefono() {
		return numerotelefono;
	}

	public void setNumerotelefono(String numerotelefono) {
		this.numerotelefono = numerotelefono;
	}

	public User getRefuser() {
		return refuser;
	}

	public void setRefuser(User refuser) {
		this.refuser = refuser;
	}

	public int getIdtelefono() {
		return idtelefono;
	}

	public void setIdtelefono(int idtelefono) {
		this.idtelefono = idtelefono;
	}

	public String getNomecontatto() {
		return nomecontatto;
	}

	public void setNomecontatto(String nomecontatto) {
		this.nomecontatto = nomecontatto;
	}

	public Contatto() {
	}

	public Contatto(String nome, String telefono, User refuser) {
		this.setNomecontatto(nome);
		this.setNumerotelefono(telefono);
		this.setRefuser(refuser);
	}

}
