import java.util.ArrayList;

public class RegisterSales 
{
    private ArrayList<Sale> sale = new ArrayList<Sale>();
    public int i = 0;

    public void registerSales(String date, String user, float totalMount, ArrayList<ProductCart> products)
    {
        sale.add(new Sale(date, user, totalMount, products));
    }

    public void showSales()
    {
        System.out.println("");
        for (Sale sales : sale) 
        {
            i++;
            System.out.println( "-Fecha: " + sales.getDate() + "\n" 
                                + "-Numero de venta: " + i + "\n" 
                                + "-Usuario: " + sales.getUsuario());
            System.out.println("-Productos: ");                  
            for (ProductCart productCart : sales.getProductCart())   
            {
                System.out.print("* " + productCart.getCantCart() + " " + productCart.getName() + " " + productCart.getPrice()*productCart.getCantCart() + "\n");
            }
            System.out.println("-Monto total: " + sales.getMontoTotal());
                                            
        } 
    }
}