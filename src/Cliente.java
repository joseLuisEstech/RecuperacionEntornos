/**
 * Clase que representa a un cliente del banco
 * Contiene sus datos personales y su cuenta bancaria
 */
public class Cliente {
    private String nombre;
    private String dni;
    private String direccion;
    private Cuenta cuenta;

    /**
     * Constructor para crear un nuevo cliente.
     *
     * @param nombre Nombre del cliente
     * @param dni DNI del cliente
     * @param direccion Dirección del cliente
     * @param numeroCuenta Número de cuenta asociado
     */

    public Cliente(String nombre, String dni, String direccion, String numeroCuenta) {
        this.nombre = nombre;
        this.dni = dni;
        this.direccion = direccion;
        this.cuenta = new Cuenta(numeroCuenta);
    }

    /** @return Nombre del cliente */
    public String getNombre() {
        return nombre;
    }

    /** @return DNI del cliente */
    public String getDni() {
        return dni;
    }

    /** @return Dirección del cliente */
    public String getDireccion() {
        return direccion;
    }

    /** @return Cuenta asociada al cliente */
    public Cuenta getCuenta() {
        return cuenta;
    }

    /**
     * Muestra por pantalla la información del cliente y su saldo.
     */
    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("DNI: " + dni);
        System.out.println("Dirección: " + direccion);
        cuenta.consultarSaldo();
    }
}
