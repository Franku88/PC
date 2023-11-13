package Parciales.SegundoParcial2020.BufferOscilante;

public class HiloInsertor implements Runnable {
    
    private BufferOscilante buffer;

    public HiloInsertor(BufferOscilante buff) {
        this.buffer = buff;
    }

    public void run() {
        while(true) {
            this.buffer.poner((int) (Math.random()*100)+1);
            try {
                Thread.sleep(((int) (Math.random()*3)+1)*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
