package com.ucoltis.HolaMundoSpring;

import com.ucoltis.HolaMundoSpring.dao.PersonaDao;
import com.ucoltis.HolaMundoSpring.domain.Persona;
import com.ucoltis.HolaMundoSpring.servicio.PersonaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller //Anotación que permite marcar la clase como el controlador
@Slf4j //Para dejar mensajes en consola
public class Controlador {

    @Autowired
    private PersonaService personaService;

    @GetMapping("/")
    public String inicio(Model model) {

        var personas = personaService.listaPersonas();
        model.addAttribute("personas", personas);
        return "index";
    }

    @GetMapping("/agregar")
    public String agregar(Persona persona) {
        return "modificar";
    }

    @PostMapping("/guardar")
    public String guardar(Persona persona) {
        personaService.guardar(persona);
        return "redirect:/";
    }

    @GetMapping("/editar/{idPersona}")
    public String editar(Persona persona, Model model) {
        persona = personaService.encontrarPersona(persona);
        model.addAttribute("persona", persona);
        return "modificar";
    }

    @GetMapping("/eliminar")
    public String eliminar(Persona personal) {
        personaService.eliminar(personal);
        return "redirect:/";
    }

}
