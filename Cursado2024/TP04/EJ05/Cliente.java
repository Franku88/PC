package Cursado2024.TP04.EJ05;

public class Cliente implements Runnable {
    private String nombre;
    private GestorImpresoras gestor;
    private char tipo;

    public Cliente(String nom, GestorImpresoras gest, char tip) {
        this.nombre = nom;
        this.gestor = gest; 
        this.tipo = tip;
    }

    public String getNombre() {
        return this.nombre;
    }

    public char getTipo() {
        return this.tipo;
    }

    public void run() {
        switch (this.tipo) {
            case 'A':
                    this.gestor.solicitarImpresoraA();
                break;
            case 'B':
                    this.gestor.solicitarImpresoraB();
                break;
            default:
                    this.gestor.solicitarImpresora();   
                break;
        }
    }

    /* SOLAMENTE RUN EN HILO (?) (no seguro, pero queda 
    mejor todos los solicitar dentro del gestor)*/
}
