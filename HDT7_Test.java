import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HDT7_Test {

    Database db = new Database();
    String nombreArchivo = "inventario_prueba.csv";
    
    @Test
    InsertTest(){
        
    }

    @Test
    searchTest(){
        
    }

    @Test
    public void testLeerData() {
        Database db = new Database();
        String nombreArchivo = "inventario_de_prueba.csv";
        try {
            db.leerData(nombreArchivo);
            List<Producto> inventario = db.getInventario();
            assertFalse(inventario.isEmpty(), "El inventario no debería estar vacío");

            // Verificar que al menos un producto tenga tallas disponibles
            boolean hayTallas = inventario.stream().anyMatch(p -> !p.getTallasDisponibles().isEmpty());
            assertTrue(hayTallas, "Al menos un producto debe tener tallas disponibles");

            // Verificar que un SKU específico existe
            String skuEjemplo = inventario.get(0).getSKU();
            assertTrue(inventario.stream().anyMatch(p -> p.getSKU().equalsIgnoreCase(skuEjemplo)), 
                       "El producto con ese SKU debería existir");

        } catch (IOException e) {
            fail("Error al leer el archivo: " + e.getMessage());
        }
    }

}
