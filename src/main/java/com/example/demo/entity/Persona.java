package com.example.demo.entity;

public class Persona {
    private int id;
    private String nombre;
    private int edad;
    private String correo;
    private String categoria;

    public Persona() {
    }

    public Persona(int id, String nombre, int edad, String correo, String categoria) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.correo = correo;
        this.categoria = categoria;
    }

    // Getters y setters (incluyendo el de la nueva propiedad "id")

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    // toString() (incluyendo la nueva propiedad "id")

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", correo='" + correo + '\'' +
                ", categoria='" + categoria + '\'' +
                '}';
    }
}
