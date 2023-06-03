package com.example.demo.controller;

import com.example.demo.entity.Persona;
import com.example.demo.services.PersonaServicio;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class ControladorPersona {

    private final PersonaServicio servicio;

    public ControladorPersona(PersonaServicio servicio) {
        this.servicio = servicio;
    }

    @GetMapping("/listarPersonasPorCategoria/{categoria}")
    public List<Persona> listaPersonaPorCategoria(@PathVariable String categoria) {
        return servicio.listaPersonasPorCategoria(categoria);
    }

    @GetMapping("/buscarPersonaPorCategoria/{categoria}/{nombre}")
    public Persona buscarPersonaPorCategoria(@PathVariable String categoria, @PathVariable String nombre) {
        return servicio.buscarPersonaPorCategoria(categoria, nombre);
    }

    @DeleteMapping("/eliminarPersonaPorCategoria/{categoria}/{id}")
    public void eliminarPersonaPorCategoria(@PathVariable String categoria, @PathVariable int id) {
        servicio.eliminarPersonaPorCategoria(categoria, String.valueOf(id));
    }

    @PutMapping("/editarPersonaPorCategoria/{categoria}/{id}/{nuevoNombre}")
    public void editarPersonaPorCategoria(@PathVariable String categoria, @PathVariable int id, @PathVariable String nuevoNombre) {
        servicio.editarNombrePersonaPorCategoria(categoria, String.valueOf(id), nuevoNombre);
    }

    @PostMapping("/insertarPersonaPorCategoria/{categoria}")
    public void insertarPersonaPorCategoria(@PathVariable String categoria, @RequestBody Persona persona) {
        servicio.agregarPersonaPorCategoria(categoria, persona);
    }

    @GetMapping("/buscarPersonaPorId/{id}")
    public Persona buscarPersonaPorId(@PathVariable int id) {
        return servicio.buscarPersonaPorId(id);
    }

    /*@DeleteMapping("/eliminarPersonaPorID/{id}")
    public void eliminarPersonaPorID(@PathVariable String categoria, @PathVariable int id) {
        servicio.eliminarPersonaPorID(categoria, Integer.parseInt(String.valueOf(id)));
    }*/

    @DeleteMapping("/eliminarPersonaPorID/{id}")
    public void eliminarPersonaPorID( @PathVariable("id") int id) {
        servicio.eliminarPersonaPorID(id);
    }


}
