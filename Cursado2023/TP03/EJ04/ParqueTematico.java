package TP03.EJ04;

public class ParqueTematico {
    private int[] areas;

    public ParqueTematico(int cantAreas) {
        this.areas = new int[cantAreas];
        this.cargarAreas();
    }

    public int getCantidadAreas() {
        return areas.length;
    }

    private void cargarAreas() {
        //Da numero aleatoreo entre 1 y 5 para cada area del parque
        for (int i = 0; i < this.areas.length; i++) {
            this.areas[i] = (int)((Math.random()*3)+1);
        }
    }

    public synchronized void mostrarAreas() {
        for (int i = 0; i < this.areas.length; i++) {
            System.out.print("|"+this.areas[i]+"|");
        }
        System.out.println();
    }

    public synchronized void reservarArea(int area) {
        if (area < this.areas.length) {
            System.out.println(Thread.currentThread().getName()+" desea reservar el area "+area);
            if (verificaAreaLibre(area)) {
                try {
                    Thread.sleep(1500);
                    this.ocuparArea(area);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("--- Area "+area+" reservada por "+Thread.currentThread().getName()+"---");
            } else {
               System.out.println("--- El area "+area+" está totalmente ocupada ---"); 
            }
        }
    }

    private synchronized boolean verificaAreaLibre(int area) {
        return this.areas[area] > 0;
    }

    private synchronized void ocuparArea(int area) {
        this.areas[area] = this.areas[area]-1;
    }
}
