package Cursado2024.TP04.EJ05;

public class GestorImpresoras {
    private Impresora[] impresorasA;
    private Impresora[] impresorasB;
    
    public GestorImpresoras(int cantImpA, int cantImpB) {
        this.impresorasA = new Impresora[cantImpA];
        this.impresorasB = new Impresora[cantImpB];
        this.inicializarImpresoras();
    }

    private void inicializarImpresoras() {
        for (int i = 0; i < this.impresorasA.length; i++) {
            this.impresorasA[i] = new Impresora("A"+i, 'A');
        }
        for (int i = 0; i < this.impresorasB.length; i++) {
            this.impresorasB[i] = new Impresora("B"+i, 'B');
        }
    }

    public void solicitarImpresoraA() {
        int pos = (int) (Math.random()*this.impresorasA.length);
        boolean imprimio = false; //Si logra encontrar impresora libre
        int i = 0;
        while (!imprimio && i < this.impresorasA.length) { //Busca la primer impresora desocupada, si no, usa una aleatorea
            imprimio = this.impresorasA[i].ocupar(); //Intenta ocupar impresora
            if (imprimio) {
                this.impresorasA[i].desocupar();
            }
            i++;
        }
        if (!imprimio) { //Si no hay impresoras libres, espera alguna
            this.impresorasA[pos].esperar();
            this.impresorasA[pos].desocupar();
        }
    }

    public void solicitarImpresoraB() {
        int pos = (int) (Math.random()*this.impresorasB.length);
        boolean imprimio = false; //Si logra encontrar impresora libre
        int i = 0;
        while (!imprimio && i < this.impresorasB.length) { //Busca la primer impresora desocupada, si no, usa una aleatorea
            imprimio = this.impresorasB[i].ocupar(); //Intenta ocupar impresora
            if (imprimio) {
                this.impresorasB[i].desocupar();
            }
            i++;
        }
        if (!imprimio) { //Si no hay impresoras libres, espera alguna
            this.impresorasB[pos].esperar();
            this.impresorasB[pos].desocupar();
        }
    }

    public void solicitarImpresora() {
        int pos = (int) (Math.random()*(this.impresorasA.length + this.impresorasB.length));
        boolean imprimio = false; //Si logra encontrar impresora libre
        int i = 0;
        while (!imprimio && i < (this.impresorasA.length + this.impresorasB.length)) { //Busca la primer impresora A desocupada, si no, busca una B
            if (i < this.impresorasA.length) {
                imprimio = this.impresorasA[i].ocupar(); //Intenta ocupar impresora
                if (imprimio) {
                    this.impresorasA[i].desocupar();
                }
            } else {
                imprimio = this.impresorasB[(i-this.impresorasA.length)].ocupar(); //Intenta ocupar impresora
                if (imprimio) {
                    this.impresorasB[(i-this.impresorasA.length)].desocupar();
                }
            }
            i++;
        }
        if (!imprimio) { //Si no encontro ni A ni B libres, espera a cualquiera aleatoreamente
            if (pos < this.impresorasA.length) {
                this.impresorasA[pos].esperar();
                this.impresorasA[pos].desocupar();
            } else {
                pos = pos - this.impresorasA.length;
                this.impresorasB[pos].esperar();
                this.impresorasB[pos].desocupar();
            }
        }
    }
}