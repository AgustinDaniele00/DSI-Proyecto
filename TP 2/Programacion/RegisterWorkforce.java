import java.util.ArrayList;

public class RegisterWorkforce
{
    public static ArrayList<Workforce> Workforces = new ArrayList<Workforce>();

    public void registerWorkforce()
    {
        Workforces.add(new Workforce(1, 50, 53.6f));
        Workforces.add(new Workforce(2, 70, 87));
        Workforces.add(new Workforce(3, 100, 117.49f));
        Workforces.add(new Workforce(4, 120, 128.48f));
        Workforces.add(new Workforce(5, 160, 143.05f));
        Workforces.add(new Workforce(6, 200, 180.79f));

    }

    public void showWorkforce()
    {
        int i = 0;
        System.out.println("Opciones de mano de obra");

        for (Workforce workforce : Workforces) 
        {
            i++;

            System.out.println(i + "- " + "Aplicacion en pared: " + workforce.getWfThickness() + " $" + workforce.getWfPrice());
        }
    }
}