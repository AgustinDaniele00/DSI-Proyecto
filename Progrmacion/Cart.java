import java.util.ArrayList;
import java.util.Scanner;

public class Cart 
{
    private ArrayList <ProductCart> ProdsCart;

    public void addCart(Product product, User user)
    {

        ProdsCart = user.getCart();

        Scanner input = new Scanner(System.in);
        System.out.println("");
		System.out.print("Ingrese la cantidad del articulo: ");
        int cant = 0;
        boolean flag = false;

        do {
            cant = input.nextInt();
            
			if(cant < 1)
			{
				System.out.println("Error de entrada. Vuelva a ingresar la cantidad");
            }
            
            if(cant > product.getCantAvailable())
			{
				System.out.println("Error de stock. Vuelva a ingresar la cantidad");
			}
			
        }while(cant < 1 || cant > product.getCantAvailable());

       for (ProductCart prod : ProdsCart) 
       {
            if (prod.getIdProd() == product.getId())
            {
                user.showProduct(cant, prod.getIdProd());
                user.addTotal(product.getPrice() * cant);
                int newCantAvaliable = product.getCantAvailable() - cant;
                product.setCantAvailable(newCantAvaliable);
                flag = true;
            }
       }
    
       if (flag == false)
       {
            user.addProduct(product.getId(), product.getName(), product.getPrice(), cant, product.getBrand());
            user.addTotal(product.getPrice() * cant);
            int newCantAvaliable = product.getCantAvailable() - cant;
            product.setCantAvailable(newCantAvaliable);
       }
    }

    public void finishBuy(User user, RegisterProducts products)
    {
        Scanner input = new Scanner(System.in);
        int deciding = 1;
        int deciding2 = 1;
        int deciding3;

        do
        {
            showCart(user);
            System.out.println("Quiere realizar la compra de su carrito? (1-Si/2-No)");
            do
            {
                deciding = input.nextInt();

                if (deciding < 1 || deciding >2)
                {
                    System.out.println("Error de ingreso. Intente nuevamente.");
                }

            }while(deciding < 1 || deciding >2);
            
            if(deciding == 1)
            {
                paymentMethod(user.getTotal(), user);
                deciding = 2;
            }
            else 
            {
                do
                {
                    System.out.println("Quiere modificar el carrito ? (1-Si/2-No)");

                    do
                    {
                        deciding2 = input.nextInt();

                        if (deciding2 < 1 || deciding2 >2)
                        {
                            System.out.println("Error de ingreso. Intente nuevamente.");
                        }

                    }while(deciding2 < 1 || deciding2 >2);

                    if (deciding2 == 1)
                    {
                        showCart(user);
                        System.out.println("Que producto desea modificar?");
                        do
                        {
                            deciding3 = input.nextInt();

                            if(deciding3 < 1 || deciding3 > user.getCart().size())
                            {
                                System.out.println("El producto no existe. Intentelo de nuevo");
                            }
   
                        }while(deciding3 < 1 || deciding3 > user.getCart().size());
                        
                        modifyCart(user, deciding3, products);
                    }
                    
                    if (user.getCart().size() == 0)
                    {
                        System.out.println("No hay elementos en el carrito.");
                        deciding2 = 2;
                    }
                    else
                    {
                        showCart(user);
                    }
                }while(deciding2 != 2);

                if (user.getCart().size() == 0)
                {
                    deciding = 2;
                }
                else
                {
                    System.out.println("Quiere realizar la compra de su carrito? (1-Si/2-No)");
                    do
                    {
                        deciding = input.nextInt();

                        if (deciding < 1 || deciding >2)
                        {
                            System.out.println("Error de ingreso. Intente nuevamente.");
                        }

                    }while(deciding < 1 || deciding >2);

                    if(deciding == 1)
                    {
                        paymentMethod(user.getTotal(), user);
                        deciding=2;
                    }
                }
            }  
        }while(deciding != 2 && deciding2 != 2);  
    }

    public void  modifyCart(User user, int id, RegisterProducts products)
    {
        int deciding = 1;
        int cant;
        int cantCart = 0;
        Scanner input = new Scanner(System.in);
        
        System.out.println("Desea eliminar el producto? (1-Si/2-No)");
        do
        {
            do
            {
                deciding = input.nextInt();
                if (deciding< 1 || deciding >2)
                {
                    System.out.println("Error de ingreso. Intentelo nuevamente.");
                }
            }while (deciding < 1 || deciding >2);

            if (deciding == 1)
            {
                int idProduct = user.deleteProdCart(id);
                deciding = 2;

                products.sumCantAvailable(idProduct, 5);
            }   
            else
            {
                System.out.println("Que cantidad desea eliminar?");
                do
                {
                    cant = input.nextInt();
                    for (ProductCart productCart : ProdsCart) 
                    {
                        if (productCart.getIdProd() == id)
                        {
                            cantCart = productCart.getCantCart();
                        }
                    }

                    if (cant > cantCart)
                    {
                        System.out.println("Error de ingreso. Intentalo nuevamente.");
                    }
                }while(cant > cantCart);

                int idProduct2 = user.restProduct(cant, id);
                products.sumCantAvailable(idProduct2, cant);
            }
        }while(deciding != 2); 
    }

    public void showCart(User user)
    {
        System.out.println("");
        System.out.println("Tienes en tu carrito: ");

        for (ProductCart productCart : ProdsCart) 
        {
            System.out.println(productCart.getCantCart() + " " + productCart.getName()+ " $" + productCart.getPrice()*productCart.getCantCart());
        }
       
        System.out.println("");
        System.out.println("El precio total es de: " + user.getTotal());  
    }

    public void paymentMethod(float price, User user)
    {
        Scanner input = new Scanner(System.in);
        int choose = 0;

        System.out.println("");

        do
        {
            System.out.print("Elija el medio de pago. (1-Efectivo / 2-6 cuotas): ");
            choose = input.nextInt();

            if (choose < 1 || choose > 2)
            {
                System.out.println("Error de eleccion de pago. Intentelo nuevamente.");
            }
        }while (choose < 1 || choose > 2);
        
        System.out.println("");

        if (choose == 1)
        {
            System.out.println("El usuario" + " " + user.getName() + " " + "debera abonar: " + price);
        }
        else
        {
            System.out.println("El usuario" + " " + user.getName() + " " + "debera abonar 6 cuotas de: " + price/6);
        }
    }
}