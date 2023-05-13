package com.example.demo.controller;

import com.example.demo.entity.persona;
import com.example.demo.services.personaServicio;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/buscarPersona/{nombre}")
    public persona buscarPersona(@PathVariable String nombre) {
        return servicio.buscarPersona(nombre);
    }

    @DeleteMapping("/eliminarPersona/{nombre}")
    public void eliminarPersona(@PathVariable String nombre) {
        servicio.eliminarPersona(nombre);
    }

    @PutMapping("/editarPersona/{nombre}/{nuevoNombre}")
    public  void editarPersona(@PathVariable String nombre, @PathVariable String nuevoNombre) {
        servicio.editarNombrePersona(nombre, nuevoNombre);
    }

    @PostMapping("/insertarPersona")
    public  void  insertarPersona(@RequestBody persona Persona ) {
        servicio.agregarPersona(Persona);
    }

}
