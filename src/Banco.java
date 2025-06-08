import java.util.ArrayList;

public class Banco {
    private ArrayList<Cliente> clientes = new ArrayList<>();

    public void agregarCliente(String nombre, String dni, String direccion, String numeroCuenta) {
        Cliente cliente = new Cliente(nombre, dni, direccion, numeroCuenta);
        clientes.add(cliente);
        System.out.println("Cliente agregado con éxito");
    }

    public boolean traspasarDinero(String dniOrigen, String dniDestino, double cantidad) {
        Cliente origen = null;
        Cliente destino = null;
        for (Cliente c : clientes) {
            if (c.dni.equals(dniOrigen)) {
                origen = c;
            }
            if (c.dni.equals(dniDestino)) {
                destino = c;
            }
        }

        if (origen != null && destino != null) {
            if (cantidad <= origen.saldo) {
                origen.saldo -= cantidad;
                destino.saldo += cantidad;
                System.out.println("Traspaso exitoso");
                return true;
            } else {
                System.out.println("Fondos insuficientes en la cuenta de origen");
            }
        } else {
            System.out.println("Uno o ambos clientes no encontrados");
        }
        return false;
    }

    public Cliente getCliente(String dni) {
        for (Cliente c : clientes) {
            if (c.dni.equals(dni)) {
                return c;
            }
        }
        return null;
    }

    public void listarClientes() {
        for (Cliente c : clientes) {
            c.mostrarInformacion();
        }
    }
}
