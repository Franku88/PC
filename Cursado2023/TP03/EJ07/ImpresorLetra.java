package TP03.EJ07;

public class ImpresorLetra {
    private char turno = 'A';

    public synchronized void imprimir(char letra, int veces) {
        if (letra == this.turno) {
            for (int i = 0; i < veces; i++) {
                System.out.print(letra);
            }
            this.turno = siguienteLetra(letra);
        }
    }
    

    private synchronized char siguienteLetra(char letra) {
        char siguiente = ' ';
        switch (letra) {
            case 'A':
                siguiente = 'B';
            break;
            case 'B':
                siguiente = 'C';
            break;
            case 'C':
                siguiente = 'A';
            break;
        }
        return siguiente;
    }

}
