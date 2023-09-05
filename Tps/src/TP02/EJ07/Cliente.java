package TP02.EJ07;

public class Cliente { 
    private String nombre; 
    private int[] carroCompra; 
    //Constructor y métodos de acceso
    
    public Cliente(String nom, int[] arr) {
        this.nombre = nom;
        this.carroCompra = arr;
    }

    public String getNombre() {
        return this.nombre;
    }

    public int[] getCarroCompra() {
        return this.carroCompra;
    }

    public void setNombre(String nom) {
        this.nombre = nom;
    }

    public void setCarroCompra(int[] arr) {
        this.carroCompra = arr;
    }

    
}