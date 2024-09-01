package TP03.EJ02.OtraForma;

public class CriaturaOscura implements Runnable {
    private EnergiaSinc energia;
    private int inicioPeleaEpica, finPeleaEpica;

    public CriaturaOscura(EnergiaSinc energiaNueva, int turnosDeLaCriatura) {
        this.energia = energiaNueva;
        this.finPeleaEpica = turnosDeLaCriatura;
    }

    public void run() {
        for (inicioPeleaEpica = 0; inicioPeleaEpica < finPeleaEpica; inicioPeleaEpica++) {
            energia.drenarEnergia(3);
        }
    }
} 