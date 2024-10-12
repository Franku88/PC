package Cursado2024.TP03.EJ04;

public class ParqueTematico {
    private int[] areas; //Array de areas, su longitud las areas, cada entero los espacios

    public ParqueTematico(int cantAreas) {
        this.areas = new int[cantAreas];
        this.cargarAreas();
    }

    public int getCantidadAreas() {
        return areas.length;
    }

    private void cargarAreas() {
        //Establece un numero de entre 1 y 3 espacios a cada area
        for(int i = 0; i < this.areas.length; i++) {
            this.areas[i] = (int) (Math.random()*3)+1;
        }
    }

    private synchronized boolean areaLibre(int area) {
        return (this.areas[area] > 0);
    }

    private synchronized void ocuparArea(int area) {
        this.areas[area] = this.areas[area] - 1;
    }

    public synchronized void reservarArea(int area) {
        if (area < this.areas.length) {
            System.out.println(Thread.currentThread().getName()+" desea reservar el area "+area);
            if (this.areaLibre(area)) {
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
        } else {
            System.out.println("--- El area "+area+" no existe ---");
        }
    }

    public synchronized String mostrarAreas() {
        String cad = "";
        for (int i = 0; i < this.areas.length; i++) {
            cad = cad +"|Area "+i+": "+this.areas[i]+"|\n";
        }
        return cad;
    }
}
