import java.util.ArrayList;
public class User
{
    private String name;
    private String lastName;
    private String dni;
    private String phone;
    private String country;
    private String email;
    private String userName;
    private String pass;
    private ArrayList <ProductCart> cart;
    private float totalCart;

    public User (String name, String lastName, String dni, String phone, String country, String email, String userName, String pass)
    {
        this.name = name;
        this.lastName = lastName;
        this.dni = dni;
        this.phone = phone;
        this.country = country;
        this.email = email;
        this.userName = userName;
        this.pass = pass;
        this.cart = new ArrayList<ProductCart>();
        this.totalCart = 0;
    }

    public String getName()
    {
        return name;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String getDni()
    {
        return dni;
    }

    public String getPhone()
    {
        return phone;
    }

    public String getCountry()
    {
        return country;
    }

    public String getEmail()
    {
        return email;
    }
    
    public String getPass()
    {
        return pass;
    }

    public String getUserName()
    {
        return userName;
    }

    public ArrayList <ProductCart> resetCart()
    {
       totalCart = 0; 
       return cart = new ArrayList<ProductCart>();
    }

    public ArrayList<ProductCart> getCart()
    {
        return cart;
    }

    public float getTotal()
    {
        return totalCart;
    }

    public void addTotal(float total)
    {
        this.totalCart = totalCart + total;
    }

    public void addProduct(int idProd, String name, float price, int cantCart, String brand)
    {
        this.cart.add(new ProductCart(idProd, name, price, cantCart, brand));
    }

    public int deleteProdCart(int idProd)
    {
        ProductCart productCart = cart.get(idProd-1);

        totalCart = totalCart - productCart.getPrice() * productCart.getCantCart();
           
        cart.remove(idProd-1);
        System.out.println("El producto se elimino correctamente");

        return productCart.getIdProd();
    }

    public int restProduct(int cant, int id)
    {
        ProductCart productCart = cart.get(id-1);
        
        productCart.setCantCart(productCart.getCantCart()-cant);
        totalCart = totalCart - productCart.getPrice() * cant;

        return productCart.getIdProd();
    }

    public void showProduct(int cant, int id)
    {
        for (ProductCart productCart : cart) 
        {
            if(productCart.getIdProd() == id)
            {
                productCart.setCantCart(productCart.getCantCart()+cant);                
            }
        }
    }
    
    public boolean logerUser(String email, String password)
    {
        if (email == getEmail() && password == getPass())
        {
            return true;
        }
        else
        {
            System.out.println("Los datos son incorrectos");
            return false;
        }
    }
}