package org.vehiclesharing.veicoli.services;

import java.util.List;

import org.vehiclesharing.veicoli.entities.Veicolo;

public interface VeicoloService {
	
	List<Veicolo> getAllVeicoli();
	Veicolo getVeicoloById(long id);

	Veicolo aggiungiVeicolo(Veicolo veicolo);

	void cancellaVeicoloById(long id);

}
