package com.example.demo.services;

import com.example.demo.entity.persona;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class personaServicio {

    private Map<String, List<persona>> categorias = new HashMap<>();

    public personaServicio() {
        // Crear las categorías y agregar las personas correspondientes
        List<persona> categoria1 = new ArrayList<>();
        categoria1.add(new persona("Juan", 45, "juan@gmail.com", "Categoria 1"));
        categoria1.add(new persona("Maria", 23, "maria@gmail.com", "Categoria 1"));
        List<persona> categoria2 = new ArrayList<>();
        categoria2.add(new persona("Pedro", 15, "pedro@gmail.com", "Categoria 2"));
        categoria2.add(new persona("Luisa", 35, "luisa@gmail.com", "Categoria 2"));
        List<persona> categoria3 = new ArrayList<>();
        categoria3.add(new persona("Mateo", 25, "mateo@gmail.com", "Categoria 3"));

        // Agregar las categorías al mapa
        categorias.put("Categoria 1", categoria1);
        categorias.put("Categoria 2", categoria2);
        categorias.put("Categoria 3", categoria3);
    }

    public List<persona> listaPersonasPorCategoria(String categoria) {
        return categorias.getOrDefault(categoria, new ArrayList<>());
    }

    public persona buscarPersonaPorCategoria(String categoria, String nombre) {
        List<persona> personasCategoria = categorias.get(categoria);
        if (personasCategoria != null) {
            for (persona p : personasCategoria) {
                if (p.getNombre().equals(nombre)) {
                    return p;
                }
            }
        }
        return null;
    }

    public void eliminarPersonaPorCategoria(String categoria, String nombre) {
        List<persona> personasCategoria = categorias.get(categoria);
        if (personasCategoria != null) {
            personasCategoria.removeIf(p -> p.getNombre().equals(nombre));
        }
    }

    public void editarNombrePersonaPorCategoria(String categoria, String nombre, String nuevoNombre) {
        List<persona> personasCategoria = categorias.get(categoria);
        if (personasCategoria != null) {
            for (persona p : personasCategoria) {
                if (p.getNombre().equals(nombre)) {
                    p.setNombre(nuevoNombre);
                }
            }
        }
    }

    public void agregarPersonaPorCategoria(String categoria, persona nuevaPersona) {
        List<persona> personasCategoria = categorias.getOrDefault(categoria, new ArrayList<>());
        personasCategoria.add(nuevaPersona);
        categorias.put(categoria, personasCategoria);
    }
}
