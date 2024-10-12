package Cursado2024.TP04.EJ08;

public class Producto implements Runnable {
    private char tipo; //'E': electrico, 'M': mecanico
    private ControladorProduccion controlador;

    public Producto (char type, ControladorProduccion controller) {
        this.tipo = type;
        this.controlador = controller;
    }

    public char getTipo() {
        return this.tipo;
    }

    public void run() {
        switch (this.tipo) {
            case 'E':
                this.controlador.llegaElectrico();
                break;
            case 'M':
                this.controlador.llegaMecanico();
                break;
            default:
                break;
        }
        this.controlador.sale();
    }
    
}
