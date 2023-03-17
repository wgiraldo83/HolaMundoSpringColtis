package com.ucoltis.HolaMundoSpring.servicio;

import com.ucoltis.HolaMundoSpring.domain.Persona;
import java.util.List;

public interface PersonaService {
    public List<Persona> listaPersonas();
    public void guardar(Persona persona);
    public void eliminar(Persona persona);
    public Persona encontrarPersona(Persona persona);
}
