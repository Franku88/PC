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
public class Mesa {
    private Semaphore tenedores = new Semaphore(5);   
    
    public void agarrarTenedores() throws InterruptedException{
        tenedores.acquire(2);               
    }
    
    public void soltarTenedores() throws InterruptedException{
        tenedores.release(2);               
    }
}
