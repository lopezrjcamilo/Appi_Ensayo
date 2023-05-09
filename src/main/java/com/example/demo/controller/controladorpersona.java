package com.example.demo.controller;

import com.example.demo.entity.persona;
import com.example.demo.services.personaServicio;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class controladorpersona {

    private personaServicio servicio;

    public controladorpersona(personaServicio servicio) {
        this.servicio = servicio;
    }

    @GetMapping("/listarPersonas")
    public List<persona> listaPersona(){
        return servicio.listaPersonas();
    }


}
