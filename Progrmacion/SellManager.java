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
        int itemNum;
        int deciding;
        boolean response = false;
        String date = "";

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
        System.out.println("Listado de productos");
        registerProducts.showProducts();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        date = dtf.format(now);

        registerSales.registerSales(date, user.getUserName(), user.getTotal(), user.getCart());

        registerSales.showSales();
    }
}