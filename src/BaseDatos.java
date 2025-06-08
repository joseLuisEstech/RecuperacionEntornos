import java.io.*;
import java.util.ArrayList;

public class BaseDatos {
    private static final String ARCHIVO = "datos_bancarios.txt";
    private static final String RUTA = System.getProperty("user.dir");
    private static final String SEPARATOR = System.lineSeparator();
    private static final String FOLDER = "resources";
    private static final String RUTA_FINAL = RUTA + SEPARATOR + FOLDER + SEPARATOR + ARCHIVO;

    public void guardar(ArrayList<Cliente> lista) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(RUTA_FINAL))) {
            oos.writeObject(lista);
        } catch (FileNotFoundException exception) {
            System.out.println("Archivo no encontrado");
        } catch (IOException e) {
            System.out.println("Error de lectura/escritura");
        }
    }

    public ArrayList<Cliente> cargarTodos() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(RUTA_FINAL)))){
            return (ArrayList<Cliente>) ois.readObject();

        } catch (IOException e) {
            System.out.println("Error de entrada/salida");
        } catch (ClassNotFoundException e) {
            System.out.println("La clase libro no existe");
        }
        return null;
    }
}
