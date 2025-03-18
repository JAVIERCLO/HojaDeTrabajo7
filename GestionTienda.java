import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestionTienda {
    private BinaryTree<String, Producto> arbolSKU;
    private BinaryTree<String, Producto> arbolNombre;

    public GestionTienda() {
        arbolSKU = new BinaryTree<>();
        arbolNombre = new BinaryTree<>();
    }

    // Agregar un producto al inventario
    public void agregarProducto(Producto producto) {
        arbolSKU.insertar(producto.getSKU(), producto);
        arbolNombre.insertar(producto.getNombre(), producto);
    }

    // Editar la descripción de un producto
    public void editarDescripcion(String SKU, String nuevaDescripcion) {
        Producto producto = arbolSKU.buscar(SKU);
        if (producto != null) {
            producto.setDescripcion(nuevaDescripcion);
            System.out.println("Descripción actualizada correctamente.");
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    // Editar las tallas disponibles con actualización de unidades
    public void editarTallasDisponibles(String SKU) {
        Scanner scanner = new Scanner(System.in);
        Producto producto = arbolSKU.buscar(SKU);
        
        if (producto != null) {
            System.out.println("Editando tallas para: " + producto.getNombre());

            // Obtener tallas disponibles
            List<String> tallasDisponibles = producto.getTallasDisponibles();
            if (tallasDisponibles == null) {
                tallasDisponibles = new ArrayList<>();
            }

            while (true) {
                System.out.print("Ingrese la talla (o escriba 'salir' para terminar): ");
                String talla = scanner.nextLine().trim();

                if (talla.toLowerCase().equals("salir")) {
                    break;
                }

                System.out.print("Ingrese la cantidad para la talla " + talla + ": ");
                
                try {
                    int cantidad = Integer.parseInt(scanner.nextLine().trim());
                    if (!tallasDisponibles.contains(talla)) {
                        tallasDisponibles.add(talla);
                    }
                    System.out.println("Talla " + talla + " actualizada con " + cantidad + " unidades.");
                } catch (NumberFormatException e) {
                    System.out.println("Error: Debe ingresar un número válido.");
                }
            }
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    // Buscar un producto por SKU
    public Producto buscarSKU(String SKU) {
        return arbolSKU.buscar(SKU);
    }

    // Buscar un producto por Nombre
    public Producto buscarNombre(String nombre) {
        return arbolNombre.buscar(nombre);
    }

    // Mostrar listado de productos ordenado por SKU
    public void mostrarListadoSKU() {
        System.out.println("Productos ordenados por SKU:");
        arbolSKU.inorden();
    }

    // Mostrar listado de productos ordenado por Nombre
    public void mostrarListadoNombre() {
        System.out.println("Productos ordenados por Nombre:");
        arbolNombre.inorden();
    }
}
