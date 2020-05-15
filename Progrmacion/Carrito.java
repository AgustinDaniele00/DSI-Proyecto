import java.util.ArrayList;
import java.util.Scanner;

public class Carrito 
{
    private Usuario usuario;
    private ArrayList <Producto> Productos;

    public Carrito (Usuario usuario)
    {
        this.usuario = usuario;
        Productos = new ArrayList<Producto>();
    }
    
    public void AgregarCarrito(Producto producto)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("");
		System.out.print("Ingrese la cantidad del articulo: ");
        int cantidad = 0;
        boolean bandera = false;

        do {
            cantidad = input.nextInt();
            
			if(cantidad < 1)
			{
				System.out.println("Error de entrada. Vuelva a ingresar la cantidad");
            }
            
            if(cantidad > producto.getCantidadDisponible())
			{
				System.out.println("Error de stock. Vuelva a ingresar la cantidad");
			}
			
        }while(cantidad < 1 || cantidad > producto.getCantidadDisponible());

       for (Producto producto2 : Productos) 
       {
            if (producto2.equals(producto))
            {
                int cantidadNueva = producto2.getCantidadCarrito() + cantidad;
                producto2.setCantidadCarrito(cantidadNueva);
                int cantidadNuevaDisponible = producto2.getCantidadDisponible() - cantidad;
                producto2.setCantidadDisponible(cantidadNuevaDisponible);
                bandera = true;
            }
       }
    
       if (bandera == false)
       {
            Productos.add(producto);
            Producto prod = Productos.get(Productos.size() - 1);
            prod.setCantidadCarrito(cantidad);
            int cantidadNuevaDisponible = prod.getCantidadDisponible() - cantidad;
            prod.setCantidadDisponible(cantidadNuevaDisponible);
       }
    }

    public void MostrarCarrito()
    {
        System.out.println("");
        System.out.println("Tienes en tu carrito: ");

        float precioTotal = 0;

        for (Producto producto : Productos) 
        {
            precioTotal += producto.getPrecio() * producto.getCantidadCarrito(); 
            System.out.println(producto.getCantidadCarrito() + " " + producto.getNombre() + "  $ " + producto.getPrecio()*producto.getCantidadCarrito());
        }

        System.out.println("");
        System.out.println("El precio total es de: " + precioTotal);

        ElegirMedioPago(precioTotal);
    }

    public void ElegirMedioPago(float precio)
    {
        Scanner input = new Scanner(System.in);
        int medioPago = 0;

        System.out.println("");

        do
        {
            System.out.print("Elija el medio de pago. (1-Efectivo / 2-6 cuotas): ");
            medioPago = input.nextInt();

            if (medioPago < 1 || medioPago > 2)
            {
                System.out.println("Error de eleccion de pago. Intentelo nuevamente.");
            }
        }while (medioPago < 1 || medioPago > 2);
        
        System.out.println("");

        if (medioPago == 1)
        {
            System.out.println("El usuario" + " " + usuario.getNombre() + " " + "debera abonar: " + precio);
        }
        else
        {
            System.out.println("El usuario" + " " + usuario.getNombre() + " " + "debera abonar 6 cuotas de: " + precio/6);
        }  
    }
}