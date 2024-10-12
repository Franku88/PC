package Cursado2024.TP02.EJ02;

public class TesteoHilos{
    public static void main (String[] args){
        Thread miHilo = new MiEjecucion();
        miHilo.start();
        
        try { //Para que miHilo termine su ejecución antes del sout en main
            miHilo.join();    
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        System.out.println("En el main");
    }
} 
        

