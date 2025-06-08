import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BancoTest {

    @Test
    void traspasarDinero() {
        Banco banco = new Banco();
        banco.agregarCliente("Luis", "111A", "Calle A", "Cuenta1");
        banco.agregarCliente("Laura", "222B", "Calle B", "Cuenta2");

        banco.getCliente("111A").ingresar(300);
        boolean resultado = banco.traspasarDinero("111A", "222B", 200);

        assertTrue(resultado);
        assertEquals(100, banco.getCliente("111A").saldo);
        assertEquals(200, banco.getCliente("222B").saldo);
    }
}
