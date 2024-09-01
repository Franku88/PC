package TP04.EJ05;

public class Cliente implements Runnable {
    private String nombre;
    private GestorImpresoras gestor;
    private char tipo;

    public Cliente(String nom, GestorImpresoras gest, char tip) {
        this.nombre = nom;
        this.gestor = gest; 
        this.tipo = tip;
    }

    public void run() {
        switch (this.tipo) {
            case 'A':
                    solicitarImpresoraA();
                break;
            case 'B':
                    solicitarImpresoraB();
                break;
            default:
                    solicitarImpresora();   
                break;
        }
    }

    public void solicitarImpresoraA() {
        Impresora[] a = gestor.getImpresorasA();
        boolean flag = false;
        //Impresora a tomar si no encuentra una libre
        int pos = (int) Math.random()*a.length;
        int i = 0;  

        //Busca la primer impresora desocupada, si no, usa una aleatorea
        while (!flag && i < a.length) {
            if (!a[i].getEstado()) {
                flag = true;
                pos = i;
            } else {
                i++;
            }
        }
        imprimirDocumento(a[pos]);
    }

    public void solicitarImpresoraB() {
        Impresora[] b = gestor.getImpresorasB();
        boolean flag = false;
        //Impresora a tomar si no encuentra una libre
        int pos = (int) Math.random()*b.length;
        int i = 0;  

        //Busca la primer impresora desocupada, si no, usa una aleatorea
        while (!flag && i < b.length) {
            if (!b[i].getEstado()) {
                flag = true;
                pos = i;
            } else {
                i++;
            }
        }
        imprimirDocumento(b[pos]);
    }

    public void solicitarImpresora() {
        Impresora[] a = gestor.getImpresorasA();
        boolean flag = false;
        //Impresora a tomar si no encuentra una libre
        int pos = (int) Math.random()*a.length;
        int i = 0;  

        //Busca la primer impresora desocupada, si no, usa una aleatorea
        while (!flag && i < a.length) {
            if (!a[i].getEstado()) {
                flag = true;
                pos = i;
            } else {
                i++;
            }
        }
        
        if (flag) {
            imprimirDocumento(a[pos]);
        } else {
            solicitarImpresoraB();
        }
    }

    public void imprimirDocumento(Impresora i) {
        int secs = (int)(Math.random()*10)+1;
        i.usar();
        try {
            System.out.println("Imprimiendo en impresora "+i.getId()+" para "+this.nombre+", espere "+secs+" segundos...");
            Thread.sleep(secs*1000);
            i.dejar();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getNombre() {
        return this.nombre;
    }

    public char getTipo() {
        return this.tipo;
    }
}
