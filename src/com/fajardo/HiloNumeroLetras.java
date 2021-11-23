package com.fajardo;

public class HiloNumeroLetras implements  Runnable{

    private int tipo;

    public HiloNumeroLetras(int tipo) {
        this.tipo = tipo;
    }

    @Override
    public void run() {
        while (true){
            switch (tipo){
                case 1:
                    for (int i=0; i<30; i++){
                        System.out.println("numero: " + i);
                    }
                    break;
                case  2:
                    for(char c = 'a'; c<'z'; c++){
                        System.out.println("letra: " + c);
                    }
                    break;
            }
        }
    }
}
