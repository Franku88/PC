package TP03.EJ01;

import java.util.logging.Level;
import java.util.logging.Logger;

public class VerificarCuenta implements Runnable {
    private CuentaBanco cb = new CuentaBanco();

    public void run() {
        for(int i = 0; i<4; i++){
            try {
                if (cb.hacerRetiro(10)) {
                    System.out.println("La cuenta está sobregirada.");
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(VerificarCuenta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

