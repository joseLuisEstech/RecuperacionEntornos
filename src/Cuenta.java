/**
 * Clase que representa una cuenta bancaria.
 * Contiene un número de cuenta y el saldo.
 */

public class Cuenta {
    private String numero;
    private double saldo;

    /**
     * Constructor para inicializar la cuenta con su número.
     *
     * @param numero Número de cuenta
     */
    public Cuenta(String numero) {
        this.numero = numero;
        this.saldo = 0;
    }

    /** @return Número de cuenta */
    public String getNumero() {
        return numero;
    }

    /** @return Saldo actual de la cuenta */
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

    /**
     * Retira una cantidad de dinero de la cuenta si hay saldo suficiente.
     *
     * @param cantidad Cantidad a retirar
     * @return true si el retiro fue exitoso
     */
    public boolean sacar(double cantidad) {
        if (cantidad > 0 && cantidad <= saldo) {
            saldo -= cantidad;
            return true;
        }
        return false;
    }

    /**
     * Muestra el saldo actual por consola.
     */
    public void consultarSaldo() {
        System.out.println("Saldo actual: " + saldo);
    }
}
