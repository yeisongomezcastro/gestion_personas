package com.co.labo.docker.web.controller;

import com.co.labo.docker.domain.dto.PersonDTO;
import com.co.labo.docker.domain.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("personas")
public class PersonController {
    @Autowired
    PersonService personService;

    public static final String VISTA_LISTA = "lista";
    public static final String VISTA_FORMULARIO = "formulario";

    @GetMapping(value = "/lista")
    public String listar(Model model) {
        model.addAttribute("personas", personService.getAllContacts());
        return VISTA_LISTA;
    }

    @GetMapping("/crear")
    public String crear(Map model) {
        PersonDTO personDTO = new PersonDTO();
        model.put("persona", personDTO);
        return VISTA_FORMULARIO;
    }

    @PostMapping("/guardar")
    public String guardar(PersonDTO personDTO) {
        personService.savePerson(personDTO);

        return "redirect:" + VISTA_LISTA;
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable(value="id") String idPersona) {
        personService.deleteById(idPersona);

        return "redirect:../" + VISTA_LISTA;
    }

}
