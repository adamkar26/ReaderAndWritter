package com.SKP;

public class Pisarz implements Runnable {
    Czytelnia czytelnia;
    int id;
    // ile cykli pisania
    int n;

    public Pisarz(Czytelnia czytelnia, int id, int n) {
        this.czytelnia = czytelnia;
        this.id = id;
        this.n = n;
    }

    @Override
    public void run() {
        for(int i=0; i<n; i++){
            try {
                czytelnia.poczatekPisania();
                System.out.println("Pisarz "+ id + " pisze");
                czytelnia.koniecPisania();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
