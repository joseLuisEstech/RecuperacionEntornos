import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BancoTest {

    private Banco banco;

    @BeforeEach
    void setUp() {
        banco = new Banco();
        banco.agregarCliente("Luis", "111A", "Calle A", "Cuenta1");
        banco.agregarCliente("Laura", "222B", "Calle B", "Cuenta2");
        banco.getCliente("111A").getCuenta().ingresar(500);
    }

    @Test
    void traspasarDinero() {
        assertFalse(banco.traspasarDinero("000X", "222B", 100));  // origen no existe
        assertFalse(banco.traspasarDinero("111A", "999Z", 100));  // destino no existe
        assertFalse(banco.traspasarDinero("000X", "999Z", 100));  // ambos no existen
        assertFalse(banco.traspasarDinero("111A", "222B", 600));  // saldo insuficiente

        assertTrue(banco.traspasarDinero("111A", "222B", 0.01));   // mínimo válido
        assertTrue(banco.traspasarDinero("111A", "222B", 499.99)); // traspaso total

        // Verificamos saldos finales
        assertEquals(0, banco.getCliente("111A").getCuenta().getSaldo(), 0.001);
        assertEquals(500, banco.getCliente("222B").getCuenta().getSaldo(), 0.001);

        assertFalse(banco.traspasarDinero("111A", "222B", 0.01)); // sin saldo
    }
}
