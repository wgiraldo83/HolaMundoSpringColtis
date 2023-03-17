package com.ucoltis.HolaMundoSpring.servicio;

import com.ucoltis.HolaMundoSpring.dao.PersonaDao;
import com.ucoltis.HolaMundoSpring.domain.Persona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service //Le indica a la aplicación que esta es la capa de servicios
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    private PersonaDao PersonaDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Persona> listaPersonas() {
        return (List<Persona>) PersonaDao.findAll();
    }

    @Override
    public void guardar(Persona persona) {
        PersonaDao.save(persona);
    }

    @Override
    public void eliminar(Persona persona) {
        PersonaDao.delete(persona);
    }

    @Override
    @Transactional(readOnly = true)
    public Persona encontrarPersona(Persona persona) {
        return PersonaDao.findById(persona.getIdPersona()).orElse(null);
    }
    
}
