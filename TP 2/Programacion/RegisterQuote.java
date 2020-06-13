import java.util.ArrayList;

public class RegisterQuote 
{
    private ArrayList<Quote> quotes = new ArrayList<Quote>();

    public void registerQuotes(User user, float price)
    {
        quotes.add(new Quote(user, price));
    }

    public void showQuotes()
    {
        System.out.println(" ");
        System.out.println("Registro de cortizaciones");
        System.out.println("----------------------------------");
        
        for (Quote quote : quotes) 
        {
            System.out.println("La cotizacion del usuario " + quote.getUser().getName() + " de la empresa " + quote.getUser().getCompany() + " es de $" + quote.getPrice());
        }
    }
}