public class Workforce 
{
    private int id;
    private int thickness;
    private float price;

    public Workforce(int id, int thickness, float price)
    {
        this.id = id;
        this.thickness = thickness;
        this.price = price;
    }

    public int getWfId()
    {
        return id;
    }
    public int getWfThickness()
    {
        return thickness;
    }
    public float getWfPrice() 
    {
        return price;
    }
}