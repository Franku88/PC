package TP04.EJ04;

import java.util.concurrent.Semaphore;

public class GestorImpresoras {
    private Semaphore semImpresoras;
    
    public GestorImpresoras(int cantImpresoras) {
        semImpresoras = new Semaphore(cantImpresoras);
    }

    public Semaphore getSemImpresoras() {
        return semImpresoras;
    }

    

}
