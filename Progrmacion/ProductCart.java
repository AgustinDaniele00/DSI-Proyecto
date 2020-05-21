public class ProductCart 
{
    private int idProd;
    private String name;
    private float price;
    private String brand;
    private int cantCart;

    public ProductCart (int idProd, String name, float price, int cantCart, String brand)
    {
        this.idProd = idProd;
        this.name = name;
        this.price = price;
        this.cantCart = cantCart;
        this.brand = brand;
    }

    public int getIdProd()
    {
        return idProd;
    }

    public String getName()
    {
        return name;
    }

    public float getPrice()
    {
        return price;
    }

    public int getCantCart()
    {
        return cantCart;
    }

    public String getBrand()
    {
        return brand;
    }

    public void setIdProd(int idProd)
    {
        this.idProd = idProd;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setPrice(float price)
    {
        this.price = price;
    }

    public void setCantCart(int cantCart)
    {
        this.cantCart = cantCart;
    }
}