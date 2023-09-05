package TP03.EJ01;

public class CuentaBanco {
    private int balance = 50;
    
    public CuentaBanco() {
    }

    public synchronized int getBalance() {
        return balance;
    }

    public synchronized boolean hacerRetiro(int retiro) throws InterruptedException {
        boolean flag = this.tieneDineroSuficiente(retiro);
        if (flag) {
            System.out.println(Thread.currentThread().getName() + " está realizando un retiro de: " + retiro + ".");
            Thread.sleep(1000);
            retiroBancario(retiro);
            System.out.println(Thread.currentThread().getName() + ": Retiro realizado.");
            System.out.println(Thread.currentThread().getName() + ": Los fondos son de: " + this.getBalance());
        } else {
            System.out.println("No hay suficiente dinero en la cuenta para realizar el retiro Sr." + Thread.currentThread().getName());
            System.out.println("Su saldo actual es de " + this.getBalance());
            Thread.sleep(1000);
        }
        return flag;
    }

    private synchronized void retiroBancario(int retiro) {
        balance = balance - retiro;
    }

    public synchronized boolean tieneDineroSuficiente(int valor) {
        return this.balance >= valor;
    }
}