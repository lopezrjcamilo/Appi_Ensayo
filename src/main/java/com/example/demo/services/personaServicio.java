package com.example.demo.services;

import com.example.demo.entity.persona;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class personaServicio {

    public List<persona> p = new ArrayList<>();

    public personaServicio() {
        p.add(new persona("Juan", 45, "juan@gmail.com"));
        p.add(new persona("Maria", 23, "maria@gmail.com"));
        p.add(new persona("Pedro", 15, "pedro@gmail.com"));
        p.add(new persona("Luisa", 35, "luisa@gmail.com"));
        p.add(new persona("Mateo", 25, "mateo@gmail.com"));
    }

    public List<persona> listaPersonas(){
        return p;
    }

    public persona buscarPersona(String nombre) {
        for (persona persona : p) {
            if (persona.getNombre().equals(nombre)) {
                return persona;
            }
        }
        return null;
    }

    public void eliminarPersona(String nombre) {
        p.removeIf(persona -> persona.getNombre().equals(nombre));
    }

    public void editarNombrePersona(String nombre, String nuevoNombre) {
        persona personaEncontrada = buscarPersona(nombre);
        if (personaEncontrada != null) {
            personaEncontrada.setNombre(nuevoNombre);
        }
    }

    public void agregarPersona(persona nuevaPersona) {
        p.add(nuevaPersona);
    }
}
