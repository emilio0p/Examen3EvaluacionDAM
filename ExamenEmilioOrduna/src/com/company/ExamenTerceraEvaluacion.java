package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class ExamenTerceraEvaluacion implements Examen {
    @Override
    public void metodo1() {
        List<Trofeo> listaTrofeos = new ArrayList<>();

        Trofeo t1 = null;
        Trofeo t2 = null;
        Trofeo t3 = null;

        try {
            t1 = new Trofeo("Crimera vez", "Has jugado por primera vez", "\033[1;93m");
            listaTrofeos.add(t1);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }

        try {
            t2 = new Trofeo("Aegunda vez", "Has jugado por segunda vez", "\033[1;97m");
            listaTrofeos.add(t2);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }

        try {
            t3 = new Trofeo("bercera vez", "Has jugado por tercera vez", "\033[1;33m");
            listaTrofeos.add(t3);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }

        Collections.sort(listaTrofeos);

        for (Trofeo tf : listaTrofeos) {
            System.out.println(tf);
        }

        Collections.sort(listaTrofeos, new TrofeoDescripcionComparator());

        ListIterator listIt = listaTrofeos.listIterator();

        while (listIt.hasNext()) {
            Trofeo tf = (Trofeo) listIt.next();
            System.out.println(tf);
        }

    }

    @Override
    public void metodo2() {
        Jugador j1 = null;
        Trofeo t1 = null;

        try {
            j1 = new Jugador("Emilio", "Orduna Pena", "Emi1423", "oansoasngoajsgn");
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }

        try {
            t1 = new Trofeo("Trofeo 1", "Trofeo otorgado al primer player.",
                    "\033[1;93m");
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }

        j1.obsequiar(t1);

        Jugador j2 = null;

        try {
            j2 = (Jugador) j1.clone();
            j2.setNombreUsuario("NuevoNombre");
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        Trofeo t2 = null;

        try {
            t2 = new Trofeo("Trofeo 2", "Trofeo otorgado por ser el mejor.",
                    "\033[1;33m");
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }

        j2.obsequiar(t2);

        System.out.println(j1);
        System.out.println(j2);

    }

    @Override
    public void metodo3() {

        List<Jugador> listaJugadores = new ArrayList<>();

        File file = new File("Jugadores.csv");

        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String line = null;

            while ((line = br.readLine()) != null) {
                String[] atributos = line.split(",");
                String nombre = atributos[0];
                String apellidos = atributos[1];
                String nombreUser = atributos[2];
                String contrasenya = atributos[3];

                listaJugadores.add(new Jugador(nombre, apellidos, nombreUser, contrasenya));
            }

            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Jugador jug : listaJugadores) {
            jug.setContrasenya("Abcd1234");
        }

        try {
            File file1 = new File("JugadoresReseteados.csv");

            FileWriter fw = new FileWriter(file1);
            BufferedWriter bw = new BufferedWriter(fw);

            for (Jugador jug : listaJugadores) {
                bw.write(jug.getNombre() + "," + jug.getApellidos() + "," + jug.getNombreUsuario() + "," +
                        jug.getContrasenya());
                bw.newLine();
            }
            bw.close();
            fw.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void play() {

        int eleccion;

        do {


            eleccion = menu();


            switch (eleccion) {
                case 1:
                    System.out.println("------ METODO 1 ------");
                    metodo1();
                    break;

                case 2:
                    System.out.println("------ METODO 2 ------");
                    metodo2();
                    break;

                case 3:
                    System.out.println("------ METODO 3 ------");
                    metodo3();
                    break;

                default:
                    break;
            }

        } while (eleccion >= 1 && eleccion <= 3);

    }

    @Override
    public int menu() {
        System.out.println("1 -> Metodo 1");
        System.out.println("2 -> Metodo 2");
        System.out.println("3 -> Metodo 3");
        System.out.print("Introduzca el numero del metodo que desea utilizar: ");
        int num = SC.nextInt();
        return num;
    }
}
