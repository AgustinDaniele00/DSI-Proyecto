public class Quote 
{
    private User user;
    private float price;

    public Quote(User user)
    {
        this.user = user;
        this.price = 0;
    }

    public Quote(User user, float price)
    {
        this.user = user;
        this.price = price;
    }

    public User getUser()
    {
        return user;
    }
    public float getPrice()
    {
        return price;
    }

    public float quote(User user, Material material, Workforce workforce, float cantM2)
    {
        float pricePerBags = 0;
        float workforcePrice = 0;
        float totalPrice = 0;

        pricePerBags = pricePerBags(workforce.getWfThickness(), cantM2, material.getMaterialPrice());
        workforcePrice = workforcePrice(cantM2, workforce.getWfPrice());

        totalPrice = pricePerBags + workforcePrice;

        System.out.println("La cotizacion del usuario total es de $" + totalPrice);

        return totalPrice;
    }

    public float pricePerBags(int thickness, float m2, float pricePerBag)
    {
        float m2PerBag = 0;
        int cantBags = 0;
        float total = 0;
        
        m2PerBag = (thickness * 4.5f) / 100;
        cantBags = (int) Math.ceil(m2  / m2PerBag);
        total = cantBags * pricePerBag;

        System.out.println("Se necitaran " + cantBags + " de bolsas para completar los " + m2 + " metros cuadrados. El precio por bolsa es de $" + pricePerBag + ", total $" + total +".");
        return total;
    }

    public float workforcePrice(float m2, float workforcePrice)
    {
        float total = 0;
        
        total = m2 * workforcePrice;

        System.out.println("El precio por aplicar material aisalente en " + m2 + " metros cuadrados a un precio por metro cuadrado de $" + workforcePrice + " es de $" + total);
       
        return total;
    }
}