public class Cliente {
    private String nombre;
    private String dni;
    private String direccion;
    private Cuenta cuenta;

    public Cliente(String nombre, String dni, String direccion, String numeroCuenta) {
        this.nombre = nombre;
        this.dni = dni;
        this.direccion = direccion;
        this.cuenta = new Cuenta(numeroCuenta);
    }


    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public String getDireccion() {
        return direccion;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("DNI: " + dni);
        System.out.println("Dirección: " + direccion);
        cuenta.consultarSaldo();
    }
}
