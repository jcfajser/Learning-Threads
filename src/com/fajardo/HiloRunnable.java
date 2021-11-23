package com.fajardo;

import java.time.LocalTime;

public class HiloRunnable implements  Runnable{

    private String nombreTareaAsincrona;

    public HiloRunnable(String nombreTareaAsincrona) {
        this.nombreTareaAsincrona = nombreTareaAsincrona;
    }

    @Override
    public void run() {
        // Nucleo del hilo
        try {

            System.out.println("Inicia ejecucion de la tarea asincrona: ["+ nombreTareaAsincrona + "] Hora inicio: " + LocalTime.now());
            Thread.sleep(3000);
            System.out.println("Fin de la ejecucion de la tarea asincrona: [" + nombreTareaAsincrona + "] Hora fin: " +  LocalTime.now());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
