import java.util.ArrayList;

public class RegisterMaterial 
{
    public static ArrayList<Material> Materials = new ArrayList<Material>();

    public void registerMaterials()
    {
        Materials.add(new Material(1, "Material 1", 15));
        Materials.add(new Material(2, "Material 2", 20));
        Materials.add(new Material(3, "Material 3", 25));
        Materials.add(new Material(4, "Material 4", 30));

    }

    public void showMaterials()
    {
        int i = 0;
        System.out.println("Lista de Materiales");

        for (Material material : Materials) 
        {
           i++;

           System.out.println(i + "- " + material.getMaterialName() + " $" + material.getMaterialPrice());
        }
    }
}