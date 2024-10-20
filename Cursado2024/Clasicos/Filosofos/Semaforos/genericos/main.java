/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cursado2024.Clasicos.Filosofos.Semaforos.genericos;
import java.util.concurrent.Semaphore;
/**
 *
 * @author Usuario
 */
public class Main {
    public static void main(String[] args){
   
        Filosofo[] filosofos = new Filosofo[5]; 
        Mesa mesa = new Mesa();
        
        for (int i = 0; i < 5; i++) {
            filosofos[i] = new Filosofo(i, mesa);
            filosofos[i].start();
        }
    }
}
