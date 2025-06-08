import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ClienteTest {

    @Test
    void ingresar() {
        Cliente cliente = new Cliente("Juan", "123A", "Calle X", "CuentaX");
        boolean resultado = cliente.ingresar(100);
        assertTrue(resultado);
        assertEquals(100, cliente.saldo);
    }

    @Test
    void sacar() {
        Cliente cliente = new Cliente("Ana", "456B", "Calle Y", "CuentaY");
        cliente.ingresar(50);
        boolean resultado = cliente.sacar(20);
        assertTrue(resultado);
        assertEquals(30, cliente.saldo);
    }
}
