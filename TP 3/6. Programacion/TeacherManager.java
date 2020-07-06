import java.util.Scanner;
import java.util.ArrayList;

public class TeacherManager 
{
    public static ArrayList<Teacher> teachers = new ArrayList<Teacher>(); 
    
	public static void assignTeacher(Course course)
	{
        Scanner input = new Scanner(System.in);
        
        int choice;
        
        System.out.print("Ingrese el Legajo del Docente: ");
        
        do 
        {
		    int teacherFile = input.nextInt();
            choice = searchTeacher(teacherFile);
            
		    if(choice != -1)
		    {
			    Teacher teacher = teachers.get(choice);
                course.setTeacher(teacher);

			    System.out.println("El docente " + teacher.getName() + " fue registrado en el curso " + course.getName());
		    }
		    else
		    {
			    System.out.print("Error al ingresar el legajo. Intentelo nuevamente.");
		    }
		}while(choice == -1);
    }
    
    public static int searchTeacher(int teacherFile)
	{
        int position = -1;
        int i = 0;
        
        for (Teacher teacher : teachers) 
        {
            if (teacherFile == teacher.getFile())
            {
                position = i;
            }

            i++;
        }

		return position;
	}
}