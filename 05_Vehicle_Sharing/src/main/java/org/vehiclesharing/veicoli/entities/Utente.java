package org.vehiclesharing.veicoli.entities;

import java.time.LocalDate;

import org.vehiclesharing.veicoli.entities.enums.Ruolo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Utente")
public class Utente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "utente_id")
	private long id;
	
	@Column(length = 75)
	private String nome;
	
	@Column(length = 75)
	private String cognome;
	
	 @Column(name = "data_nascita")
	private LocalDate dataNascita;
	
	@Column(length = 50, nullable = false, unique = true)
	private String email;
	
	@Column(length = 20, nullable = false)
	private String password;
	
	@Column(columnDefinition = "ENUM('ADMIN', 'UTENTE')")
	@Enumerated(EnumType.STRING)
	private Ruolo ruolo;
	
	
	
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Ruolo getRuolo() {
		return ruolo;
	}
	public void setRuolo(Ruolo ruolo) {
		this.ruolo = ruolo;
	}
	
	
	
	
	
}
