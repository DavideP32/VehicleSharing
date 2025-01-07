package org.vehiclesharing.veicoli.entities;

import org.vehiclesharing.veicoli.entities.enums.Alimentazione;
import org.vehiclesharing.veicoli.entities.enums.Categoria;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "veicolo")
public class Veicolo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(columnDefinition = "ENUM('AUTO', 'SCOOTER', 'MONOPATTINO')")
	@Enumerated(EnumType.STRING)
	private Categoria categoria;
	
	@Column(length = 255)
	private String descrizione;
	
	@Column(columnDefinition = "ENUM('ELETTRICO', 'DIESEL', 'BENZINA', 'IBRIDA')")
	@Enumerated(EnumType.STRING)
	private Alimentazione alimentazione;
	
	@Column(length = 255)
	private String indirizzo;
	
	@Column(length = 255)
	private String coordinateGPS;
	
	@Column(name = "disponibilita_noleggio")
	private boolean disponibilitaNoleggio;
	
	@Lob
    @Column(name = "immagine_veicolo", columnDefinition = "BLOB")
    private byte[] immagine;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Alimentazione getAlimentazione() {
		return alimentazione;
	}

	public void setAlimentazione(Alimentazione alimentazione) {
		this.alimentazione = alimentazione;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getCoordinateGPS() {
		return coordinateGPS;
	}

	public void setCoordinateGPS(String coordinateGPS) {
		this.coordinateGPS = coordinateGPS;
	}

	public boolean isDisponibilitaNoleggio() {
		return disponibilitaNoleggio;
	}

	public void setDisponibilitaNoleggio(boolean disponibilitaNoleggio) {
		this.disponibilitaNoleggio = disponibilitaNoleggio;
	}

	public byte[] getImmagine() {
		return immagine;
	}

	public void setImmagine(byte[] immagine) {
		this.immagine = immagine;
	}
	
	
	
}
