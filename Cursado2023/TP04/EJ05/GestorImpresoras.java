package TP04.EJ05;

public class GestorImpresoras {
    private Impresora[] impresorasA;
    private Impresora[] impresorasB;
    
    public GestorImpresoras(Impresora[] impA, Impresora[] impB) {
        this.impresorasA = impA;
        this.impresorasB = impB;
    }

    public Impresora[] getImpresorasA() {
        return this.impresorasA;
    }
    
    public Impresora[] getImpresorasB() {
        return this.impresorasB;
    }
}
