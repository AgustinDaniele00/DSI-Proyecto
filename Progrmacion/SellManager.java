import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class SellManager 
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        RegisterProducts registerProducts = new RegisterProducts();
        Cart cart = new Cart();
        User user = new User("NOMBRE", "APELLIDO", "DNI", "TELEFONO", "PAIS", "EMAIL", "NOMBRE USUARIO", "CONTRASENIA");
        RegisterSales registerSales = new RegisterSales();
        RegisterOrder registerOrder = new RegisterOrder();
        int itemNum;
        int deciding;
        boolean response = false;
        String date = "";
        int answer;
 
        System.out.println("*****INTERFAZ DE VENTAS Y PEDIDOS*****");
        do 
        {
            System.out.println("");
            System.out.println("Elija una opcion:"+ "\n" +"1-Realizar Compra" + "\n" + "2-Mostrar Pedido" + "\n" + "3-Salir");
            do
            {
                answer = input.nextInt();
                if(answer < 1 || answer >3) 
                {
                    System.out.println("Intentelo nuevamente, esa opcion no esta disponible.");
                }
            }while(answer < 1 || answer >3);
            
            if (answer == 1)
            {
                registerProducts.registerProducts();;
                System.out.println("Listado de productos");
                registerProducts.showProducts();
                registerProducts.verifyStock();
    
                System.out.println("");
                System.out.println("Ingrese Usuario");
    
                do
                {
                    response = user.logerUser("EMAIL","CONTRASENIA");
    
                }while(response == false);
    
                System.out.println("");
                System.out.println("Usuario logeado correctamente");
    
                do
                {
                    do
                    {
                        System.out.println("");
                        System.out.print("Precione el numero del producto: ");
                        itemNum = input.nextInt();
    
                        if(itemNum < 1 || itemNum > RegisterProducts.Products.size())
                        {
                            System.out.println("Error de eleccion.Inentelo nuevamente");
                        }
    
                    }while(itemNum < 1 || itemNum > RegisterProducts.Products.size());
    
                    Product product = RegisterProducts.Products.get(itemNum - 1);
                    cart.addCart(product, user);
    
                    System.out.print("Quieres agregar otro producto? (1-Si/0-No): ");
                    deciding = input.nextInt();
               
                }while(deciding == 1);
    
                cart.finishBuy(user, registerProducts);
                System.out.println("");
    
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                LocalDateTime now = LocalDateTime.now();
                date = dtf.format(now);
    
                registerSales.registerSales(date, user.getUserName(), user.getTotal(), user.getCart());
    
                registerSales.showSales();
            }
            else if (answer == 2)
            {
                registerOrder.registerOrders(date, user.getCart());
                registerOrder.showOrder();
            }
        }while (answer != 3);

        System.out.println("Adios");
    }
}