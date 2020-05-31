import java.util.ArrayList;

public class Order 
{
    private String date;
    private ArrayList<ProductCart> products = new ArrayList<ProductCart>();
    private int orderNumber;

    public Order (String date, ArrayList<ProductCart> productos, int orderNumber)
    {
        this.date = date;
        this.products = productos;
        this.orderNumber = orderNumber;
    }

    public String getDate()
    {
        return date;
    }

    public ArrayList<ProductCart> getProductCart()
    {
        return products;
    }

    public int getOrderNumbre()
    {
        return orderNumber;
    }
}