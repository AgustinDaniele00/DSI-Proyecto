import java.util.ArrayList;

public class Sale
{
    private String date;
    private ArrayList<ProductCart> products = new ArrayList<ProductCart>();
    private String user;
    private float totalMount;
    
    
    public Sale (String date, String user, float totalMount,ArrayList<ProductCart> productos)
    {
        this.date = date;
        this.user = user;
        this.totalMount = totalMount;
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

    public String getUsuario()
    {
        return user;
    }

    public float getMontoTotal()
    {
        return totalMount;
    }
}

