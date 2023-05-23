package com.company;

import java.util.Objects;

public final class Trofeo implements Comparable<Trofeo> {

    static final String RESET = "\033[0m";

    private String nombre;
    private String descripcion;
    private String rareza;


    public Trofeo(String nombre, String descripcion, String rareza) {
        validarNombre(nombre);
        this.nombre = nombre;
        validarDescripcion(descripcion);
        this.descripcion = descripcion;
        validarRareza(rareza);
        this.rareza = rareza;
    }


    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        validarDescripcion(descripcion);
        this.descripcion = descripcion;
    }

    public String getRareza() {
        return rareza;
    }

    private void validarNombre(String nombre) {
        if (nombre == null) {
            throw new IllegalArgumentException("No puede introducir un nombre nulo.");
        }

        if (nombre.length() < 3) {
            throw new IllegalArgumentException("No puede introducir un nombre que tenga menos de 3 caracteres.");
        }
    }

    private void validarDescripcion(String descripcion) {
        if (descripcion == null) {
            throw new IllegalArgumentException("No puede introducir una descripcion nula.");
        }

        if (descripcion.isBlank() || descripcion.isEmpty()) {
            throw new IllegalArgumentException("No puede introducir una descripcion vacía.");
        }
    }

    private void validarRareza(String rareza) {
        if ((!(rareza.equals("\033[1;33m"))) && (!(rareza.equals("\033[1;97m"))) && (!(rareza.equals("\033[1;93m")))) {
            throw new IllegalArgumentException("No puede introducir una rareza distinta de bronce, plata, oro.");
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Trofeo)) return false;
        Trofeo trofeo = (Trofeo) o;
        return nombre.equals(trofeo.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    @Override
    public int compareTo(Trofeo o) {
        return nombre.compareTo(o.nombre);
    }

    @Override
    public String toString() {
        return rareza + nombre + ": " + descripcion + RESET;
    }
}
