import java.util.Scanner;

public class PaymentMethod 
{
    float price = 0;
    User user;

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