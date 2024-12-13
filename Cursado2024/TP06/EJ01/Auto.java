
public class Auto implements Runnable {

    private String patente;
    private String ingreso; //N: norte, S: sur
    private GestorTrafico gestor;

    public Auto(String pat, String ing, GestorTrafico gest) {
        this.patente = pat;
        this.ingreso = ing;
        this.gestor = gest;
    }

    public void run() {
        if (this.ingreso == "N") {
                gestor.entrarCocheDelNorte(this.patente);
                try {
                    // Simula cruce
                    Thread.sleep(2000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                gestor.salirCocheDelNorte(this.patente);
        } else {
                gestor.entrarCocheDelSur(this.patente);
                try {
                    // Simula cruce
                    Thread.sleep(2000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                gestor.salirCocheDelSur(this.patente);
        }
    }
}
