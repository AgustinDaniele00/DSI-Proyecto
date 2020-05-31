import java.util.ArrayList;

public class RegisterSales 
{
    private ArrayList<Sale> sale = new ArrayList<Sale>();

    public void registerSales(String date, String user, float totalMount, ArrayList<ProductCart> products, int sellNumber)
    {
        sale.add(new Sale(date, user, totalMount, products, sellNumber));
    }

    public void showSales()
    {
        System.out.println("");
        System.out.println("**Detalles de la compra**");
        for (Sale sales : sale) 
        {
            if (sales.getSellReady() == false)
            {
                System.out.println("-----------------------------------------------");
                System.out.println( "-Fecha: " + sales.getDate() + "\n" 
                                    + "-Numero de venta: " + sales.gerSellNumber()+ "\n" 
                                    + "-Usuario: " + sales.getUser());
                System.out.println("-Productos: ");
                        
                for (ProductCart productCart : sales.getProductCart())   
                {
                    System.out.print("* " + productCart.getCantCart() + " " + productCart.getName() + " " + productCart.getPrice()*productCart.getCantCart() + "\n");
                }
                System.out.println("-Monto total: " + sales.getTotalMount());
                            
                sales.setSellReady(true);
            }
            else
            {
                System.out.println("No hay compras realizadas");
            }
        } 
    }
}