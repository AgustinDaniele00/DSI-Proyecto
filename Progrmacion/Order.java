import java.util.ArrayList;

public class Order 
{
    private String date;
    private ArrayList<ProductCart> products = new ArrayList<ProductCart>();

    public Order (String date, ArrayList<ProductCart> productos)
    {
        this.date = date;
        this.products = productos;
    }

    public String getDate()
    {
        return date;
    }

    public ArrayList<ProductCart> getProductCart()
    {
        return products;
    }
}