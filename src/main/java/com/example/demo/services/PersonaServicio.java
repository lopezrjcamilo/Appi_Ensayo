package com.example.demo.services;

import com.example.demo.entity.Persona;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PersonaServicio {

    private Map<String, List<Persona>> categorias = new HashMap<>();
    private int nextId = 1;

    public PersonaServicio() {
        // Crear las categorías y agregar las personas correspondientes
        List<Persona> categoria1 = new ArrayList<>();
        categoria1.add(new Persona(getNextId(), "Juan", 45, "juan@gmail.com", "Categoria1"));
        categoria1.add(new Persona(getNextId(), "Maria", 23, "maria@gmail.com", "Categoria1"));
        List<Persona> categoria2 = new ArrayList<>();
        categoria2.add(new Persona(getNextId(), "Pedro", 15, "pedro@gmail.com", "Categoria2"));
        categoria2.add(new Persona(getNextId(), "Luisa", 35, "luisa@gmail.com", "Categoria2"));
        List<Persona> categoria3 = new ArrayList<>();
        categoria3.add(new Persona(getNextId(), "Mateo", 25, "mateo@gmail.com", "Categoria3"));

        // Agregar las categorías al mapa
        categorias.put("Categoria1", categoria1);
        categorias.put("Categoria2", categoria2);
        categorias.put("Categoria3", categoria3);
    }

    public int getNextId() {
        return nextId++;
    }

    public List<Persona> listaPersonasPorCategoria(String categoria) {
        return categorias.getOrDefault(categoria, new ArrayList<>());
    }

    public Persona buscarPersonaPorCategoria(String categoria, String nombre) {
        List<Persona> personasCategoria = categorias.get(categoria);
        if (personasCategoria != null) {
            for (Persona p : personasCategoria) {
                if (p.getNombre().equals(nombre)) {
                    return p;
                }
            }
        }
        return null;
    }

    public void eliminarPersonaPorCategoria(String categoria, String nombre) {
        List<Persona> personasCategoria = categorias.get(categoria);
        if (personasCategoria != null) {
            personasCategoria.removeIf(p -> p.getNombre().equals(nombre));
        }
    }

    public void editarNombrePersonaPorCategoria(String categoria, String nombre, String nuevoNombre) {
        List<Persona> personasCategoria = categorias.get(categoria);
        if (personasCategoria != null) {
            for (Persona p : personasCategoria) {
                if (p.getNombre().equals(nombre)) {
                    p.setNombre(nuevoNombre);
                }
            }
        }
    }

    public void agregarPersonaPorCategoria(String categoria, Persona nuevaPersona) {
        nuevaPersona.setId(getNextId());
        List<Persona> personasCategoria = categorias.getOrDefault(categoria, new ArrayList<>());
        personasCategoria.add(nuevaPersona);
        categorias.put(categoria, personasCategoria);
    }

    public Persona buscarPersonaPorId(int id) {
        for (List<Persona> personasCategoria : categorias.values()) {
            for (Persona persona : personasCategoria) {
                if (persona.getId() == id) {
                    return persona;
                }
            }
        }
        return null;
    }

    /*public void eliminarPersonaPorID(int id) {
        List<Persona> personasCategoria = categorias.get(id);
        if (personasCategoria != null) {
            personasCategoria.removeIf(p -> p.getId() == id);
        }
    }*/

    public void eliminarPersonaPorID(int id) {
        for (List<Persona> personasCategoria : categorias.values()) {
            personasCategoria.removeIf(p -> p.getId() == id);
        }
    }

}
