package com.SKP;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Czytelnia {

    private int pisarze = 0;
    private  int czytelnicy = 0;

    private final Lock blokada = new ReentrantLock();
    private final Condition wolne = blokada.newCondition();

    void poczatekPisania() throws  InterruptedException{
        blokada.lock();
        try{
            while (pisarze > 0 || czytelnicy > 0){
                wolne.await();
            }
            pisarze ++;
        }finally {
            blokada.unlock();
        }
    }

    void koniecPisania(){
        blokada.lock();
        try{
            pisarze--;
            wolne.signalAll();
        }finally {
            blokada.unlock();
        }
    }

    void poczatekCzytania() throws  InterruptedException{
        blokada.lock();
        try{
            while (pisarze > 0){
                wolne.await();
            }
            czytelnicy ++;
        }finally {
            blokada.unlock();
        }
    }

    void koniecCzytania(){
        blokada.lock();
        try{
            czytelnicy--;
            if(czytelnicy == 0){
                wolne.signalAll();
            }
        }finally {
            blokada.unlock();
        }
    }
}
