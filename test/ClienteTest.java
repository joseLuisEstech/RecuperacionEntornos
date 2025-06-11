import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ClienteTest {

    private Cliente cliente;

    @BeforeEach
    void setUp() {
        cliente = new Cliente("Juan", "123A", "Calle X", "CuentaX");
    }

    @Test
    void ingresar() {
        assertFalse(cliente.getCuenta().ingresar(-0.01));  // valor negativo
        assertFalse(cliente.getCuenta().ingresar(0));      // límite inferior
        assertTrue(cliente.getCuenta().ingresar(0.01));    // límite válido mínimo
        assertTrue(cliente.getCuenta().ingresar(1000));    // valor alto

        assertEquals(1000.01, cliente.getCuenta().getSaldo(), 0.001);
    }

    @Test
    void sacar() {
        cliente.getCuenta().ingresar(500);

        assertFalse(cliente.getCuenta().sacar(-0.01));     // condición 1 falsa
        assertFalse(cliente.getCuenta().sacar(600));       // condición 2 falsa
        assertTrue(cliente.getCuenta().sacar(0.01));       // condición 1 y 2 verdaderas
        assertTrue(cliente.getCuenta().sacar(499.99));     // agota el saldo
        assertFalse(cliente.getCuenta().sacar(0.01));      // sin saldo suficiente

        assertEquals(0, cliente.getCuenta().getSaldo(), 0.001);
    }
}
