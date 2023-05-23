package com.company;

import java.util.Objects;
import java.util.SortedSet;
import java.util.TreeSet;

public final class Jugador extends Persona implements Cloneable {

    private String nombreUsuario;
    private String contrasenya;
    private SortedSet<Trofeo> coleccionTrofeos;

    public Jugador(String nombre, String apellidos, String nombreUsuario, String contrasenya) {
        super(nombre, apellidos);
        validarNombreUser(nombreUsuario);
        this.nombreUsuario = nombreUsuario;
        validarContrasenya(contrasenya);
        this.contrasenya = contrasenya;
        this.coleccionTrofeos = new TreeSet<>();
    }


    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        validarNombreUser(nombreUsuario);
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        validarContrasenya(contrasenya);
        this.contrasenya = contrasenya;
    }

    public SortedSet<Trofeo> getColeccionTrofeos() {
        return coleccionTrofeos;
    }

    private void validarNombreUser(String nombreUsuario) {
        if (nombreUsuario == null) {
            throw new IllegalArgumentException("No puede introducir un nombre nulo.");
        }

        if (nombreUsuario.length() < 3) {
            throw new IllegalArgumentException("No puede introducir un nombre que tenga menos de 3 caracteres.");
        }
    }

    private void validarContrasenya(String contrasenya) {
        if (contrasenya == null) {
            throw new IllegalArgumentException("No puede introducir una contrasenya nula.");
        }

        if (contrasenya.length() < 8) {
            throw new IllegalArgumentException("No puede introducir una contrasenya que tenga menos de 8 caracteres.");
        }
    }

    boolean tieneTrofeo(String nombreTrofeo) {
        for (Trofeo tf : coleccionTrofeos) {
            if (tf.getNombre().equals(nombreTrofeo)) {
                return true;
            }
        }

        return false;
    }


    void obsequiar(Trofeo trofeo) {
        if (!(tieneTrofeo(trofeo.getNombre()))) {
            coleccionTrofeos.add(trofeo);
        }
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Jugador jugadorClon = new Jugador(nombre, apellidos, nombreUsuario, contrasenya);
        for (Trofeo tf : coleccionTrofeos) {
            Trofeo trofClon = new Trofeo(tf.getNombre(), tf.getNombre(), tf.getRareza());
            jugadorClon.coleccionTrofeos.add(trofClon);
        }
        return jugadorClon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Jugador)) return false;
        Jugador jugador = (Jugador) o;
        return nombreUsuario.equals(jugador.nombreUsuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombreUsuario);
    }

    @Override
    public String toString() {
        return nombreUsuario +' '+ coleccionTrofeos +' ' +nombre + ' '+apellidos;
    }
}
