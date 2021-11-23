package com.fajardo;

public class HiloContador implements Runnable {
    private int contador;
    private final String nombre;
    private final int limiteContador;

    public HiloContador(String nombre, int limiteContador) {
        this.nombre = nombre;
        this.limiteContador = limiteContador;
    }

    @Override
    public void run() {

        while (contador < limiteContador) {
            System.out.println("Hilo [" + nombre + "] Contador ["+contador+"]");
            contador++;
        }

        System.out.println("Hilo [" + nombre + "] ha terminado");

    }


}
