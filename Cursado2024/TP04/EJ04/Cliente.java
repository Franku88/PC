package Cursado2024.TP04.EJ04;
import java.util.Random;

public class Cliente implements Runnable {
    private String nombre;
    private GestorImpresoras gestor;

    public Cliente (String nom, GestorImpresoras gest) {
        this.nombre = nom;
        this.gestor = gest;
    }    

    public String getNombre() {
        return this.nombre;
    }

    public void run() {
        boolean pudoImprimir = false;
        int i = 0;
        while(!pudoImprimir) { //Si no encuentra impresora, sigue buscando
            try {
                i = (new Random()).nextInt(this.gestor.getCantidadImpresoras()); //Elige impresora aleatoreamente
                pudoImprimir = this.gestor.ocupar(i); //Intenta usar impresora i
                if(pudoImprimir) { //Si fue posible
                    Thread.sleep(((new Random()).nextInt(5)+5)*1000); //Simula tiempo de uso
                    this.gestor.desocupar(i); // Libera impresora
                }
            } catch (Exception e) {
                e.printStackTrace();        
            }
        }
    }

}
