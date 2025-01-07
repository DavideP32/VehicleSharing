package org.vehiclesharing.veicoli.login;

import java.io.Serializable;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import org.vehiclesharing.veicoli.entities.enums.Ruolo;

@Component
@SessionScope
public class SessioneUtente implements Serializable {
	private long id;
	private String nome;
	private String email;
	private Ruolo ruolo;
	
	
	
	public SessioneUtente(long id, String nome, String email, Ruolo ruolo) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.ruolo = ruolo;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Ruolo getRuolo() {
		return ruolo;
	}
	public void setRuolo(Ruolo ruolo) {
		this.ruolo = ruolo;
	}
	
	
}
