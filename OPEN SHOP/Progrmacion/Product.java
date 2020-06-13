public class Product 
{
    private int id;
    private String name;
    private float price;
    private int cantAvailable;
    private String brand;

    public Product (int id, String name, float price, int cantAvailable, String brand)
    {
        this.id = id;
        this.name = name;
        this.price = price;
        this.cantAvailable = cantAvailable;
        this.brand = brand;
        
    }

    public void setCantAvailable(int cant)
    {
        this.cantAvailable = cant;
    }
    
    public int getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public float getPrice()
    {
        return price;
    }

    public int getCantAvailable()
    {
        return cantAvailable;
    }

    public String getBrand()
    {
        return brand;
    }

    public void restCantAvailable(int cant)
    {
        cantAvailable = cantAvailable - cant;
    }
}