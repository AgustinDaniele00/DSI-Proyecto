import java.util.Scanner;
import java.util.ArrayList;
import java.io.Serializable;

public class CourseManager implements Serializable
{
    public ArrayList<Course> courses = new ArrayList<Course>();

    public void loadNewCourse(TeacherManager TeacherManager)
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

    public void showCourse()
    {
        int i = 1;

        for (Course course : courses) 
        {
            System.out.println(i++ + ". " + course.getName());
        }
    }
}