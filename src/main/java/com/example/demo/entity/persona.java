package com.example.demo.entity;

public class persona {
    private String nombre;
    private int edad;
    private String correoElectronico;
    private String categoria;

    public persona(String nombre, int edad, String correoElectronico, String categoria) {
        this.nombre = nombre;
        this.edad = edad;
        this.correoElectronico = correoElectronico;
        this.categoria = categoria;
    }

    // Getters y setters (incluyendo el de la nueva propiedad "categoria")

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

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    // toString() (incluyendo la nueva propiedad "categoria")

    @Override
    public String toString() {
        return "persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", correoElectronico='" + correoElectronico + '\'' +
                ", categoria='" + categoria + '\'' +
                '}';
    }
}
