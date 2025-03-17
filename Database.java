import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Database {
    private List<Producto> inventario;

    public Database() {
        inventario = new ArrayList<>();
    }

    public void leerData(String nombreArchivo) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            br.readLine();

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");

                if (datos.length < 4) {
                    System.err.println("Línea con datos insuficientes: " + linea);
                    continue;
                }

                try {
                    String SKU = datos[0].trim();
                    String nombre = datos[1].trim();
                    String descripcion = datos[2].trim();
                    
                    // Procesar la cantidad por talla
                    List<String> tallasDisponibles = new ArrayList<>();
                    if (!datos[3].trim().isEmpty()) {
                        String[] tallas = datos[3].trim().split("\\|");
                        for (String talla : tallas) {
                            tallasDisponibles.add(talla.trim());
                        }
                    }

                    // Crear objeto Producto y agregarlo a la lista
                    Producto producto = new Producto(SKU, nombre, descripcion, tallasDisponibles);
                    inventario.add(producto);

                } catch (Exception e) {
                    System.err.println("Error al procesar datos en línea: " + linea);
                }
            }
        }
    }

    public List<Producto> getInventario() {
        return inventario;
    }
}

