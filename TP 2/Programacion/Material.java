public class Material 
{   
    private int id;
    private String materialName;
    private float materialPrice;

    public Material(int id, String materialName, float materialPrice)
    {
        this.id = id;
        this.materialName = materialName;
        this.materialPrice = materialPrice;
    }

    public int getMaterialID()
    {
        return id;
    }
    public String getMaterialName()
    {
        return materialName;
    }
    public float getMaterialPrice() 
    {
        return materialPrice;   
    }
    
    public void setMaterialId(int id)
    {
        this.id = id;
    }
    public void setMaterialName(String materialName)
    {
        this.materialName =  materialName;
    }
    public void setMaterialPrice(float materialPrice) 
    {
        this.materialPrice = materialPrice;   
    }
}