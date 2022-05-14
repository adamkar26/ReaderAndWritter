package com.SKP;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        int n = 10;
        int liczbaPisarzy = 2;
        int liczbaCzytelnikow = 10;
        Czytelnia czytelnia = new Czytelnia();

        Thread[] pisarze = new Thread[liczbaPisarzy];
        for (int i=0; i<liczbaPisarzy; i++)
            pisarze[i] = new Thread(new Pisarz(czytelnia,i, n));

        Thread[] czytelnicy = new Thread[liczbaCzytelnikow];
        for (int i=0; i<liczbaCzytelnikow; i++)
            czytelnicy[i] = new Thread(new Czytelnik(czytelnia,i, n));

        for(Thread watek: pisarze) watek.start();
        for(Thread watek: czytelnicy) watek.start();
        for(Thread watek: pisarze) watek.join();
        for(Thread watek: czytelnicy) watek.join();


    }
}
