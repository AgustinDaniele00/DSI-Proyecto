import java.util.ArrayList;

public class RegisterOrder 
{
    private ArrayList<Order> order = new ArrayList<Order>();

    public void registerOrders(String date, ArrayList<ProductCart> products)
    {
        order.add(new Order(date, products));
    }

    public void showOrder()
    {
        System.out.println("");
        for (Order orders : order) 
        {
            System.out.println("**Detalles del pedido**");
            System.out.println("-----------------------------------------------");
            System.out.println( "-Fecha: " + orders.getDate());
            System.out.println("-Productos: ");                  
            for (ProductCart productCart : orders.getProductCart())   
            {
                System.out.print("* " + productCart.getCantCart() + " " + productCart.getName() + " " + productCart.getPrice()*productCart.getCantCart() + "\n");
            }                                 
        } 
    }
}