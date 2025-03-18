import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        GestionTienda tienda = new GestionTienda();
        Scanner scanner = new Scanner(System.in);

        // Cargar datos desde el CSV
        Database database = new Database();
        String nombreArchivo = "inventario_de_prueba.csv";

        try {
            database.leerData(nombreArchivo);
            List<Producto> productos = database.getInventario();
            for (Producto producto : productos) {
                tienda.agregarProducto(producto);
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        //Menú
        while (true) {
            System.out.print("Seleccione una opción: ");
            System.out.println("1. Agregar producto");
            System.out.println("2. Editar descripción");
            System.out.println("3. Editar tallas");
            System.out.println("4. Buscar por SKU");
            System.out.println("5. Buscar por Nombre");
            System.out.println("6. Mostrar productos por SKU");
            System.out.println("7. Mostrar productos por Nombre");
            System.out.println("8. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            if (opcion == 8) {
                System.out.println("Gracias por usar el sistema de inventario");
                break;
            }

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el SKU: ");
                    String SKU = scanner.nextLine();
                    System.out.print("Ingrese el Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese la Descripción: ");
                    String descripcion = scanner.nextLine();

                    List<String> tallasDisponibles = new ArrayList<>();
                    while (true) {
                        System.out.print("Ingrese una talla o escriba salir: ");
                        String talla = scanner.nextLine();
                        if (talla.toLowerCase().equals("salir"))
                            { break;}
                        tallasDisponibles.add(talla);
                    }

                    tienda.agregarProducto(new Producto(SKU, nombre, descripcion, tallasDisponibles));
                    System.out.println("Producto agregado.");
                    break;

                case 2:
                    System.out.print("Ingrese el SKU: ");
                    String SKUdesc = scanner.nextLine();
                    System.out.print("Nueva descripción: ");
                    String nuevaDescripcion = scanner.nextLine();
                    tienda.editarDescripcion(SKUdesc, nuevaDescripcion);
                    break;

                case 3:
                    System.out.print("Ingrese el SKU: ");
                    String SKUtalla = scanner.nextLine();
                    tienda.editarTallasDisponibles(SKUtalla);
                    break;

                case 4:
                    System.out.print("Ingrese el SKU: ");
                    String SKUbuscar = scanner.nextLine();
                    Producto p1 = tienda.buscarSKU(SKUbuscar);
                    System.out.println((p1 != null) ? p1 : "No encontrado.");
                    break;

                case 5:
                    System.out.print("Ingrese el Nombre: ");
                    String nombreBuscar = scanner.nextLine();
                    Producto p2 = tienda.buscarNombre(nombreBuscar);
                    System.out.println((p2 != null) ? p2 : "No encontrado.");
                    break;

                case 6:
                    tienda.mostrarListadoSKU();
                    break;

                case 7:
                    tienda.mostrarListadoNombre();
                    break;

                default:
                    System.out.println("Ingresa una opción válida.");
            }
        }

        scanner.close();
    }
}
