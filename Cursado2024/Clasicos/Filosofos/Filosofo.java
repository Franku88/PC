package Cursado2024.Clasicos.Filosofos;

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
        boolean der = false, izq = false; //bools para verificar si tomo algun tenedor
        while(!(der && izq)) { //Intenta hasta poder cenar

            //this.pensar(); //Antes de intentar cenar, piensa (dejar este o el de la linea 37)

            der = this.tenedorD.tomar();
            izq = this.tenedorI.tomar();
            if (der && izq) { //Solo cena si logro tomar ambos
                this.cenar(); 
            }
            if (der) {
                this.tenedorD.dejar();
            }
            if (izq) {
                this.tenedorI.dejar();
            }

            this.pensar(); //Luego de intentar cenar, piensa (dejar este o el de la linea 23)
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