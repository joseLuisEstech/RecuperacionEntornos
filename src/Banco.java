import java.util.ArrayList;

public class Banco {
    private ArrayList<Cliente> clientes = new ArrayList<>();

    public void agregarCliente(String nombre, String dni, String direccion, String numeroCuenta) {
        Cliente cliente = new Cliente(nombre, dni, direccion, numeroCuenta);
        clientes.add(cliente);
        System.out.println("Cliente agregado con éxito");
    }

    public boolean traspasarDinero(String dniOrigen, String dniDestino, double cantidad) {
        Cliente origen = buscarClientePorDNI(dniOrigen);
        Cliente destino = buscarClientePorDNI(dniDestino);

        if (origen != null && destino != null) {
            if (cantidad <= origen.getCuenta().getSaldo()) {
                origen.getCuenta().sacar(cantidad);
                destino.getCuenta().ingresar(cantidad);
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
            if (c.getDni().equals(dni)) {
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

    private Cliente buscarClientePorDNI(String dni){
        for (Cliente c : clientes){
            if (c.getDni().equals(dni)){
                return c;
            }
        }
        return null;
    }
}
