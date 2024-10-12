package Cursado2024.TP02.EJ08;

public class Cliente {
    private String nombre;
    private int[] carroCompra;

    public Cliente(String nombre, int[] carro) {
        this.nombre = nombre;
        this.carroCompra = carro;
    }

    public String getNombre() {
        return this.nombre;
    }

    public int[] getCarroCompra() {
        return this.carroCompra;
    }
}
