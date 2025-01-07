package org.vehiclesharing.veicoli.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.vehiclesharing.veicoli.entities.Veicolo;

@Repository
public interface VeicoloRepository extends JpaRepository<Veicolo, Long>{

	
}
