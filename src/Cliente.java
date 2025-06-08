import java.io.Serializable;

public class Cliente implements Serializable {
    public String nombre;
    public String dni;
    public String direccion;
    public double saldo;
    public String numeroCuenta;

    public Cliente(String nombre, String dni, String direccion, String numeroCuenta) {
        this.nombre = nombre;
        this.dni = dni;
        this.direccion = direccion;
        this.numeroCuenta = numeroCuenta;
        this.saldo = 0;
    }

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


    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("DNI: " + dni);
        System.out.println("Dirección: " + direccion);
    }
}
