package Cursado2024.Clasicos.Filosofos.Semaforos.ver2;

public class Filosofo implements Runnable {

    private String nombre;
    private Tenedor tenedorD;
    private Tenedor tenedorI;

    public Filosofo (String name, Tenedor teneD, Tenedor teneI) {
        this.nombre = name;
        this.tenedorD = teneD;
        this.tenedorI = teneI;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void run() {
        boolean verD = false, verI = false, der = false, izq = false;
        while(!(der && izq)) { //Intenta hasta poder cenar (cambiar por true para cenar por siempre)

            //this.pensar(); //Antes de intentar cenar, piensa (dejar este o el de la linea 37)

            verD = this.tenedorD.mirar();
            verI = this.tenedorI.mirar();
            if (verD && verI) { //Si puede observar a ambos
                der = this.tenedorD.tomar();
                izq = this.tenedorI.tomar();
                if (der && izq) { //Si logra tomar ambos
                    this.cenar();
                }
                if (der) { //Si lo tomo, lo deja
                    this.tenedorD.dejar();
                }
                if (izq) { //Si lo tomo, lo deja
                    this.tenedorI.dejar();
                }
            }
            if (verD) { //Si lo esta mirando, deja de mirarlo
                this.tenedorD.noMirar();
            }
            if (verI) { //Si lo esta mirando, deja de mirarlo
                this.tenedorI.noMirar();
            }

            //this.pensar(); //Luego de intentar cenar, piensa (dejar este o el de la linea 23)
        }
    }

    public void cenar() {
        try {
            System.out.println("--- "+this.nombre+" esta cenando... ---");
            Thread.sleep(10000); //10 segundos para terminar plato
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void pensar() {
        try {
            int secs = (int) (Math.random()*5)+2;
            System.out.println(this.nombre+" esta pensando por "+secs+" segundos...");
            Thread.sleep(1000*secs); //Tiempo pensando
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}