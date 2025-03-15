public class Producto {
//Atributos
    private String nombre;
    private String SKU;
    private String descripcion;
    private String tallasDisponibles;
    private int cantidadPorTalla;
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
    public String getTallasDisponibles(){
        return tallasDisponibles;
    }
    //Cantidad por talla
    public int getCantidadPorTalla(){
        return cantidadPorTalla;
    }
}
