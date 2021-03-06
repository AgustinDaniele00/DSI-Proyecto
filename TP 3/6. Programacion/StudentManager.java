import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager 
{
    public static ArrayList<Student> students = new ArrayList<Student>();

	public static int registerStudent()
	{
        Scanner input = new Scanner(System.in);
        
		System.out.print("Ingrese su Nombre: ");
        String name = input.nextLine();

        System.out.println("Ingrese el apellido: ");
        String lastName = input.nextLine();

        System.out.println("Ingrese el legajo: ");
        int file = input.nextInt();
        
		System.out.print("DNI: ");
        int dni = input.nextInt();
        
		System.out.print("Email: ");
        String email = input.nextLine();
        
		System.out.print("Telefono: ");
        String phone = input.nextLine();
        
        Student student = new Student (name, lastName, file, dni, email, phone);

        return file;
    }
    
    public static int showStudent(int file)
	{
		int position = -1;
        int i = 0;
        
        for (Student student : students) 
        {
            if(file == student.getFile())
			{
				position = i;
			}
			i++;
        }

		return position;
	}
}