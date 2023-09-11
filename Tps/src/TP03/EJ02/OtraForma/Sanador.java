package TP03.EJ02.OtraForma;

public class Sanador implements Runnable {
    private EnergiaSinc energia;
    int inicioPeleaEpica, finPeleaEpica;

    public Sanador(EnergiaSinc energiaNueva, int turnosDelSanador) {
        this.energia = energiaNueva;
        this.finPeleaEpica = turnosDelSanador;
    }

    public void run() {
        for(inicioPeleaEpica = 0; inicioPeleaEpica < finPeleaEpica; inicioPeleaEpica++){
            energia.revitalizarEnergia(3);
        }
    }
}