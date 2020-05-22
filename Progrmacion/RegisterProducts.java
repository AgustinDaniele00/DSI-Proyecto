import java.util.ArrayList;

public class RegisterProducts 
{
    public static ArrayList <Product> Products = new ArrayList <Product>();

    public void registerProducts()
    {
        Products.add(new Product(1, "Cafetera", 3300, 5, "Philips"));
        Products.add(new Product(2, "Celular", 25600, 5, "Lg"));
        Products.add(new Product(3, "Televisor", 43570, 5, "Noblex"));
        Products.add(new Product(4, "Remera", 2500, 5, "Nike"));
    }

    public ArrayList<Product> getProducts()
    {
        return Products;
    }

    public void showProducts()
    {
        int i=0;
        for (Product product : Products) 
        {
            i++;
            System.out.println( i + "- " + product.getCantAvailable() + " "+ product.getName() + "  $ " + product.getPrice());
        }
    }

    public void verifyStock()
    {
        System.out.println("");
        System.out.println("Hay stock de los productos");

        for (Product product : Products) 
        {
            if (product.getCantAvailable() >= 1)
            {
                System.out.println(product.getName());
            }
        }
    }

    public void sumCantAvailable(int id, int cant)
    {
        for (Product product : Products) 
        {
            if(product.getId() == id)
            {
                if(cant == 5)
                {
                    product.setCantAvailable(5);
                }
                else
                {
                    product.setCantAvailable(product.getCantAvailable() + cant);   
                
                }
            }
        }
    }
}