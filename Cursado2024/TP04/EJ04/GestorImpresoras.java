package Cursado2024.TP04.EJ04;

public class GestorImpresoras {
    private Impresora[] impresoras;

    public GestorImpresoras(int cantImpresoras) {
        this.impresoras = new Impresora[cantImpresoras];
        this.inicializarImpresoras();
    }

    private void inicializarImpresoras() {
        for (int i = 0; i < this.impresoras.length; i++) {
            this.impresoras[i] = new Impresora(i);
        }
    }

    public int getCantidadImpresoras() {
        return this.impresoras.length;
    }

    public boolean ocupar(int imp) {
        // Ocupa impresora indicada, retorna falso si no es posible (esta ocupada)
        return this.impresoras[imp].ocupar();
    }

    public void desocupar(int imp) {
        // Desocupa impresora inidicada
        this.impresoras[imp].desocupar();
    }
}
