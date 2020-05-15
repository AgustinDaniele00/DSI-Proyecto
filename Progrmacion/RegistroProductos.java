import java.util.ArrayList;

public class RegistroProductos 
{
    public static ArrayList <Producto> Productos = new ArrayList <Producto>();

    public void RegistrarProductos()
    {
        Productos.add(new Producto("Cafetera", 3300, 5, 0));
        Productos.add(new Producto("Celular", 25600, 5, 0));
        Productos.add(new Producto("Televisor", 43570, 5, 0));
        Productos.add(new Producto("Remera", 2500, 5, 0));
    }

    public void MostrarProductos()
    {
        for (Producto producto : Productos) 
        {
            System.out.println(producto.getCantidadDisponible() + " "+ producto.getNombre() + "  $ " + producto.getPrecio());
        }
    }

    public void VerificarStock()
    {
        System.out.println("");
        System.out.println("Hay stock de los productos");

        for (Producto producto : Productos) 
        {
            if (producto.getCantidadDisponible() >= 1)
            {
                System.out.println(producto.getNombre());
            }
        }
    }
}