package com.ucoltis.HolaMundoSpring.dao;

import com.ucoltis.HolaMundoSpring.domain.Persona;
import org.springframework.data.repository.CrudRepository;

public interface PersonaDao extends CrudRepository<Persona, Long> {
    
}
