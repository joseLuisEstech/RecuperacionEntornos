public class Cuenta {
    private String numero;
    private double saldo;

    public Cuenta(String numero) {
        this.numero = numero;
        this.saldo = 0;
    }

    public String getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    /**
    * Permite ingresar dinero a la cuenta del cliente
    *
    * @param cantidad Cantidad a ingresar (debe ser positiva)
    * @return true si el ingreso se realizo correctamente, false si no
    * */
    public boolean ingresar(double cantidad) {
        if (cantidad > 0) {
            saldo += cantidad;
            return true;
        }
        return false;
    }

    public boolean sacar(double cantidad) {
        if (cantidad > 0 && cantidad <= saldo) {
            saldo -= cantidad;
            return true;
        }
        return false;
    }

    public void consultarSaldo() {
        System.out.println("Saldo actual: " + saldo);
    }
}
