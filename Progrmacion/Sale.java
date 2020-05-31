import java.util.ArrayList;

public class Sale
{
    private String date;
    private ArrayList<ProductCart> products = new ArrayList<ProductCart>();
    private String user;
    private float totalMount;
    private int sellNumber;
    private boolean sellReady;
    
    
    public Sale (String date, String user, float totalMount,ArrayList<ProductCart> productos, int sellNumber)
    {
        this.date = date;
        this.user = user;
        this.totalMount = totalMount;
        this.products = productos;
        this.sellNumber = sellNumber;
        this.sellReady = false;
    }

    public String getDate()
    {
        return date;
    }

    public ArrayList<ProductCart> getProductCart()
    {
        return products;
    }

    public String getUser()
    {
        return user;
    }

    public float getTotalMount()
    {
        return totalMount;
    }

    public int gerSellNumber()
    {
        return sellNumber;
    }

    public boolean getSellReady()
    {
        return sellReady;
    }

    public void setSellReady(boolean sellReady)
    {
        this.sellReady = sellReady;
    }
}

