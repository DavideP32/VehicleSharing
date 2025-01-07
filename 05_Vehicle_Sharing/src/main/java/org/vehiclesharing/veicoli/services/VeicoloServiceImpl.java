package org.vehiclesharing.veicoli.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vehiclesharing.veicoli.entities.Veicolo;
import org.vehiclesharing.veicoli.repositories.VeicoloRepository;

@Service
public class VeicoloServiceImpl implements VeicoloService {

	@Autowired
	VeicoloRepository veicoloRepository;

	@Override
	public List<Veicolo> getAllVeicoli() {
		List<Veicolo> veicoli = veicoloRepository.findAll();
		return veicoli;
	}

	@Override
	public Veicolo getVeicoloById(long id) {
		Optional<Veicolo> optional = veicoloRepository.findById(id);
		
		if(optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}

	@Override
	public Veicolo aggiungiVeicolo(Veicolo veicolo) {
		veicolo.setId(0L);
		veicoloRepository.save(veicolo);
		return veicolo;
	}


	@Override
	public void cancellaVeicoloById(long id) {
		veicoloRepository.deleteById(id);
	}
	
	
}
