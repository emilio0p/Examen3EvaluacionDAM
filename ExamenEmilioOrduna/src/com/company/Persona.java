package com.company;

public abstract class Persona {

    String nombre;
    String apellidos;

    public Persona(String nombre, String apellidos) {
        validarNombre(nombre);
        this.nombre = nombre;
        validarApellidos(apellidos);
        this.apellidos = apellidos;
    }

    private void validarNombre(String nombre) {
        if (nombre == null) {
            throw new IllegalArgumentException("No puede introducir un nombre nulo.");
        }
    }

    private void validarApellidos(String apellidos) {
        if (apellidos == null) {
            throw new IllegalArgumentException("No puede introducir apellidos nulos.");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }
}
