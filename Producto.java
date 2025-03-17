import java.util.List;

public class Producto {
//Atributos
    private String nombre;
    private String SKU;
    private String descripcion;
    private List<String> tallasDisponibles;
    private int cantidadPorTalla;
//Constructor
    
    public Producto(String SKU, String nombre, String descripcion, List<String> tallasDisponibles) {
        this.SKU = SKU;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tallasDisponibles = tallasDisponibles;
    }
//Getters
    //Nombre
    public String getNombre(){
        return nombre;
    }
    //SKU
    public String getSKU(){
        return SKU;
    } 
    //Descripción
    public String getDescripcion(){
        return descripcion;
    }
    //Tallas disponibles
    public List<String> getTallasDisponibles(){
        return tallasDisponibles;
    }
    //Cantidad por talla
    public int getCantidadPorTalla(){
        return cantidadPorTalla;
    }
}
