import java.util.Scanner;

public class GestorVenta 
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        RegistroProductos registroProductos = new RegistroProductos();
        Usuario usuario = new Usuario("NOMBRE", "APELLIDO", "DNI", "TELEFONO", "PAIS", "EMAIL", "NOMBRE USUARIO", "CONTRASENIA");
        Carrito carrito = new Carrito(usuario);
        int numeroArticulo;
        int decision;
        boolean respuesta = false;

        registroProductos.RegistrarProductos();

        System.out.println("Listado de productos");
        registroProductos.MostrarProductos();
        registroProductos.VerificarStock();

        System.out.println("");
        System.out.println("Ingrese Usuario");

        do
        {
            respuesta = usuario.LogearUsuario("EMAIL","CONTRASENIA");

        }while(respuesta == false);

        System.out.println("");
        System.out.println("Usuario logeado correctamente");

        do
        {
            do
            {
                System.out.println("");
                System.out.print("Precione el numero del producto: ");
                numeroArticulo = input.nextInt();

                if(numeroArticulo < 1 || numeroArticulo > RegistroProductos.Productos.size())
                {
                    System.out.println("Error de eleccion.Inentelo nuevamente");
                }

            }while(numeroArticulo < 1 || numeroArticulo > RegistroProductos.Productos.size());

            Producto producto = RegistroProductos.Productos.get(numeroArticulo - 1);
            carrito.AgregarCarrito(producto);

            System.out.print("Quieres agregar otro producto? (1-Si/0-No): ");
            decision = input.nextInt();
           
        }while(decision == 1);

        carrito.MostrarCarrito();
        System.out.println("");
        System.out.println("¡¡Gracias por su compra!!");
    }
}