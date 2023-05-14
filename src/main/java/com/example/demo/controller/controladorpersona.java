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

    @GetMapping("/listarPersonasPorCategoria/{categoria}")
    public List<persona> listaPersonaPorCategoria(@PathVariable String categoria) {
        return servicio.listaPersonasPorCategoria(categoria);
    }

    @GetMapping("/buscarPersonaPorCategoria/{categoria}/{nombre}")
    public persona buscarPersonaPorCategoria(@PathVariable String categoria, @PathVariable String nombre) {
        return servicio.buscarPersonaPorCategoria(categoria, nombre);
    }

    @DeleteMapping("/eliminarPersonaPorCategoria/{categoria}/{nombre}")
    public void eliminarPersonaPorCategoria(@PathVariable String categoria, @PathVariable String nombre) {
        servicio.eliminarPersonaPorCategoria(categoria, nombre);
    }

    @PutMapping("/editarPersonaPorCategoria/{categoria}/{nombre}/{nuevoNombre}")
    public void editarPersonaPorCategoria(@PathVariable String categoria, @PathVariable String nombre, @PathVariable String nuevoNombre) {
        servicio.editarNombrePersonaPorCategoria(categoria, nombre, nuevoNombre);
    }

    @PostMapping("/insertarPersonaPorCategoria/{categoria}")
    public void insertarPersonaPorCategoria(@PathVariable String categoria, @RequestBody persona Persona) {
        servicio.agregarPersonaPorCategoria(categoria, Persona);
    }
}
