public class Main {

    public static void main(String[] args) {
        Banco banco = new Banco();
        banco.agregarCliente("Alice", "111A", "Calle A", "CUENTA1");
        banco.agregarCliente("Bob", "222B", "Calle B", "CUENTA2");

        banco.getCliente("111A").ingresar(1000);
        banco.getCliente("111A").retirarDinero(200);
        banco.traspasarDinero("111A", "222B", 300);

        banco.listarClientes();
    }
}
