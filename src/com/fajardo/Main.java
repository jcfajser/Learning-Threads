package com.fajardo;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        System.out.println("Lets go learning Threads...");
        System.out.println("************************************");

        //executeSynchronousTask();
        //executeAsynchronousTaskRunnable();
        //executeAsynchronousTaskTrhead();
        //executeThreadNumerosLetras();
        //executeThreadContadores();

        LearnStreams learnStreams = new LearnStreams();
        learnStreams.practiceParallelStreams();

    }

    private static void executeThreadContadores(){
        System.out.println("Comienza ejecucion de hilos de contadores");
        HiloContador hiloContador1 = new HiloContador("hiloContador1", 4);
        HiloContador hiloContador2 = new HiloContador("hiloContador2", 5);
        HiloContador hiloContador3 = new HiloContador("hiloContador3", 2);
        HiloContador hiloContador4 = new HiloContador("hiloContador4", 4);

        Thread t1 = new Thread(hiloContador1);
        Thread t2 = new Thread(hiloContador2);
        Thread t3 = new Thread(hiloContador3);
        Thread t4 = new Thread(hiloContador4);

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        try {
            /*este metodo detiene el thread principal hasta que no se terminen de
            ejecutar estos se ejecutara las siguientes lineas*/
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Termina ejecucion de hilos de contadores");
    }

    private static void executeThreadNumerosLetras(){

        int tipoNumeros = 1;
        int tipoLetras = 2;
        // creamos los hilos
        HiloNumeroLetras hiloNumeroLetras1 = new HiloNumeroLetras(tipoNumeros);
        HiloNumeroLetras hiloNumeroLetras2 = new HiloNumeroLetras(tipoLetras);

        // ejecutamos los hilos
        Thread thread1 = new Thread(hiloNumeroLetras1);
        thread1.start();

        (new Thread(hiloNumeroLetras2)).start();
    }

    private static void executeAsynchronousTaskTrhead() {
        /*
         * El siguiente bloque de codigo es la ejecucion de hilos cuando se extiende la clase Trhead
         */
        System.out.println("Ejecucion tarea Asyncrona");
        // Obtenemos las instancias de los Hilos
        HiloThread hiloThread1 = new HiloThread("unoAsyncronaTrhead");
        HiloThread hiloThread2 = new HiloThread("dosAsyncronaThread");
        HiloThread hiloThread3 = new HiloThread("tresAsyncronaThread");

        //iniciamos la ejecucion de cada uno de los hilos
        hiloThread1.start(); // de esta manera se hace si se extiende la clase Thread
        hiloThread2.start();
        hiloThread3.start();
    }

    private static void executeAsynchronousTaskRunnable() {
        /*
         * El siguiente bloque de codigo es la ejecucion de hilos cuando se implementa la interface Runnable
         */
        System.out.println("Ejecucion tarea Asyncrona");
        // Obtenemos las instancias de los Hilos
        HiloRunnable hiloRunnable1 = new HiloRunnable("unoAsyncrona");
        HiloRunnable hiloRunnable2 = new HiloRunnable("dosAsyncrona");
        HiloRunnable hiloRunnable3 = new HiloRunnable("tresAsyncrona");

        /*iniciamos la ejecucion de cada uno de los hilos, en este caso es necesario crear un objeto de la clase Thread
        que es la que nos provee del metodo para iniciar los hilos*/
        (new Thread(hiloRunnable1)).start();
        (new Thread(hiloRunnable2)).start();
        (new Thread(hiloRunnable3)).start();
    }

    private static void executeSynchronousTask() {
        System.out.println("Ejecucion tarea Asyncrona");
        synchronousTask("uno");
        synchronousTask("dos");
        synchronousTask("tres");
    }

    private static void synchronousTask(String nombreTarea) {
        try {
            System.out.println("Inicia ejecucion de la tarea sincrona: [" + nombreTarea + "] Hora inicio: " + LocalTime.now());
            Thread.sleep(3000);
            System.out.println("Fin de la ejecucion de la tarea sincrona: [" + nombreTarea + "] Hora fin: " + LocalTime.now());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("************************************");
    }
}
