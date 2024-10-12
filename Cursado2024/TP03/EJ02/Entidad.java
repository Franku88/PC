package Cursado2024.TP03.EJ02;

public class Entidad implements Runnable {
    private String nombre;
    private int modifica;
    private Energia energia; //Recurso compartido
    private double initialTime; //tiempo inicial de exe

    public Entidad(String nombre, int modifica, Energia en, double initialTime) {
        this.nombre = nombre;
        this.modifica = modifica;
        this.energia = en;
        this.initialTime = initialTime;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void run() {
        int hits = (int) ((Math.random()*5)+1); //cantidad de golpes (1-5)
        int vel = 0;
        String verbo;
        if (this.modifica > 0) {
            verbo = "revitaliza";
        } else {
            verbo = "drena";
        }
        System.out.println("("+(System.currentTimeMillis() - this.initialTime)/1000 +" secs) "+this.nombre+" realizará "+hits+" ataques.");
        System.out.println();
        for (int i = 0; i < hits; i++) {
            vel = (int) ((Math.random()*5)+3); //Espera entre 3 y 7 segundos
            synchronized(this.energia) {
                this.energia.alterar(modifica);
                System.out.println("("+(System.currentTimeMillis() - this.initialTime)/1000+" secs) "+this.nombre+" "+verbo+" "+Math.abs(this.modifica)+" puntos de energia.");
                System.out.println("\t\t <<<Energia actual: "+this.energia.getActual()+">>>");
                System.out.println("("+(System.currentTimeMillis() - this.initialTime)/1000+" secs) "+this.nombre+" descansando "+vel+" segundos...");
                System.out.println();
            }
            try {
                Thread.sleep(vel*1000); //Simula tiempo de accion
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
