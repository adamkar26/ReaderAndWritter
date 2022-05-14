package com.SKP;

public class Czytelnik implements Runnable {
    Czytelnia czytelnia;
    int id;
    int n;

    public Czytelnik(Czytelnia czytelnia, int id, int n) {
        this.czytelnia = czytelnia;
        this.id = id;
        this.n = n;
    }

    @Override
    public void run() {
        for(int i=0; i<n; i++){
            try {
                czytelnia.poczatekCzytania();
                System.out.println("Czytelnik "+ id+" czyta");
                czytelnia.koniecCzytania();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
