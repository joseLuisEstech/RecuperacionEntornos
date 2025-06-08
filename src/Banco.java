import java.util.ArrayList;

/**
 * Clase que gestiona las operaciones bancarias entre clientes.
 */

public class Banco {
    private ArrayList<Cliente> clientes = new ArrayList<>();

    /**
     * Agrega un nuevo cliente al banco.
     *
     * @param nombre Nombre del cliente
     * @param dni DNI del cliente
     * @param direccion Dirección del cliente
     * @param numeroCuenta Número de cuenta
     */
    public void agregarCliente(String nombre, String dni, String direccion, String numeroCuenta) {
        Cliente cliente = new Cliente(nombre, dni, direccion, numeroCuenta);
        clientes.add(cliente);
        System.out.println("Cliente agregado con éxito");
    }

    /**
     * Realiza un traspaso de dinero entre dos clientes.
     *
     * @param dniOrigen DNI del cliente origen
     * @param dniDestino DNI del cliente destino
     * @param cantidad Cantidad a traspasar
     * @return true si el traspaso fue exitoso
     */
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


    /**
     * Busca y devuelve un cliente por su DNI.
     *
     * @param dni DNI del cliente a buscar
     * @return Cliente encontrado o null si no existe
     */
    private Cliente buscarClientePorDNI(String dni){
        for (Cliente c : clientes){
            if (c.getDni().equals(dni)){
                return c;
            }
        }
        return null;
    }

    /**
     * Devuelve un cliente a partir de su DNI.
     *
     * @param dni DNI del cliente
     * @return Cliente si existe, null si no
     */
    public Cliente getCliente(String dni) {
        for (Cliente c : clientes) {
            if (c.getDni().equals(dni)) {
                return c;
            }
        }
        return null;
    }

    /**
     * Muestra la información de todos los clientes.
     */
    public void listarClientes() {
        for (Cliente c : clientes) {
            c.mostrarInformacion();
        }
    }


}
