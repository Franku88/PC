package Parciales.SegundoParcial2020.BufferOscilante;

public class HiloExtractor implements Runnable {
    
    private BufferOscilante buffer;

    public HiloExtractor(BufferOscilante buff) {
        this.buffer = buff;
    }

    public void run() { 
        while(true) {
            this.buffer.sacar();
            try {
                Thread.sleep(((int) (Math.random()*3)+1)*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
