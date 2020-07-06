import java.util.Scanner;
import java.util.ArrayList;

public class CourseManager 
{
    public static ArrayList<Course> courses = new ArrayList<Course>();

    public static void loadNewCourse()
    {
        Scanner input = new Scanner(System.in);

        String name = "";
        String description = "";
        int opc;
        
		System.out.println("**********************************************************");
        System.out.println("                REGISTRO DE NUEVO CURSO");
		System.out.println("**********************************************************");
        
        System.out.print("Nombre del Curso: ");
        name = input.nextLine();
        
		System.out.print("Descripcion del Curso: ");
        description = input.nextLine();
        
        Course course = new Course(name, description);
        
        System.out.println("Quiere ingresar el docente a cargo? 1- Si/ 2- No");

        do
        {
            opc = input.nextInt();

            if (opc <1 || opc > 2)
            {
                System.out.println("Error al ingresar la opcion. Intentelo nuevamente.");
            }

        }while(opc <1 || opc > 2);

        if (opc == 1)
        {
            TeacherManager.assignTeacher(course);
        }
        
    }

    public static void showCourse()
    {
        int i = 1;

        for (Course course : courses) 
        {
            System.out.println(i++ + ". " + course.getName());
        }
    }
}