package org.vehiclesharing.veicoli.dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.vehiclesharing.veicoli.entities.enums.Ruolo;

public class UtenteDto {

	private long id;
	private String nome, cognome;
	private LocalDate dataNascita;
	private String email;
	private Ruolo ruolo;

	
	public UtenteDto() {
	}
	
	
	
	public UtenteDto(long id, String nome, String cognome, LocalDate dataNascita, String email, Ruolo ruolo) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
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
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public LocalDate getDataNascita() {
		return dataNascita;
	}
	public void setDataNascita(LocalDate dataNascita) {
		this.dataNascita = dataNascita;
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
	@Override
	public String toString() {
		return "UtenteDto [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", dataNascita=" + dataNascita
				+ ", email=" + email + ", ruolo=" + ruolo + "]";
	}
	
	
	
}
