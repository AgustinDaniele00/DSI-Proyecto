import java.util.ArrayList;

public class RegisterOrder 
{
    private ArrayList<Order> order = new ArrayList<Order>();

    public void registerOrders(String date, ArrayList<ProductCart> products, int orderNumber)
    {
        order.add(new Order(date, products, orderNumber));
    }

    public void showOrder()
    {
        System.out.println("");
        System.out.println("**Detalles del pedido**");

        for (Order orders : order) 
        {
            if (orders.gerOrderReady() == false)
            {
                System.out.println("-----------------------------------------------");
                System.out.println( "-Fecha: " + orders.getDate());
                System.out.println("-Numero de pedido: " + orders.getOrderNumbre());
                System.out.println("-Productos: ");
                 
                for (ProductCart productCart : orders.getProductCart())   
                {
                    System.out.print("* " + productCart.getCantCart() + " " + productCart.getName() + " " + productCart.getPrice()*productCart.getCantCart() + "\n");
                }
                            
                orders.setOrderReady(true);
            }
            else
            {
                System.out.println("No hay pedidos para realizar.");
            }

        } 
    }
}