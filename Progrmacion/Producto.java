public class Producto 
{
    private String nombre;
    private float precio;
    private int cantidadDisponible;
    private int cantidadCarrito;

    public Producto (String nombre, float precio, int cantidadDisponible, int cantidadCarrito)
    {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidadDisponible = cantidadDisponible;
        this.cantidadCarrito = cantidadCarrito;
    }

    public void setCantidadDisponible(int cantidad)
    {
        this.cantidadDisponible = cantidad;
    }

    public void setCantidadCarrito(int cantidad)
    {
        this.cantidadCarrito = cantidad;
    }

    public String getNombre()
    {
        return nombre;
    }

    public float getPrecio()
    {
        return precio;
    }

    public int getCantidadDisponible()
    {
        return cantidadDisponible;
    }

    public int getCantidadCarrito()
    {
        return cantidadCarrito;
    }
}