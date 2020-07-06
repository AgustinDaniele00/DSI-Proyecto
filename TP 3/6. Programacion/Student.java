import java.util.Scanner;

public class Student 
{
    private String name;
    private String lastName;
    private int file;
    private int dni;
    private String email;
    private String phone;

    public Student(String name, String lastName, int file, int dni, String email, String phone) 
    {
        this.name = name;
        this.lastName = lastName;
        this.file = file;
        this.dni = dni;
        this.email = email;
        this.phone = phone;
    }

    public static void registerStudent()
    {
        Scanner input = new Scanner(System.in);

        System.out.println("Listado de Cursos: ");
        CourseManager.showCourse();

        System.out.println("Elige el curso al que te deseas inscribir: ");
        int opcCourse = input.nextInt();

        Course course = CourseManager.courses.get(opcCourse - 1);

        if (course.getPlannedCourse() == true)
        {
           if (course.checkCapacity() == true)
           {
               System.out.println("La persona esta registrada? 1-Si / 2-No");
               int opcRegister = input.nextInt();

               int file;

               if (opcRegister == 1)
               {
                   System.out.println("Ingrese el legajo de la persona: ");
                   file = input.nextInt();
               }
               else
               {
                   file = StudentManager.registerStudent();
               }

               int posStudent = StudentManager.showStudent(file);
               Student student = StudentManager.students.get(posStudent);
               course.addStudent(student);
               
               System.out.println("El estudiante " + student.name + " fue agregada al curso " + course.getName());
           }
           else
           {
               System.out.println("En el curso ya no hay cupos");
           }
        }
        else
        {
            System.out.println("El curso no a sido planificado");
        }

    }

    public String getName() 
    {
        return name;
    }
    public String getLastName() 
    {
        return lastName;
    }
    public int getFile() 
    {
        return file;
    }
    public int getDni() 
    {
        return dni;
    }
    public String getEmail() 
    {
        return email;
    }
    public String getPhone() 
    {
        return phone;
    }

    public void setName(String name) 
    {
        this.name = name;
    }
    public void setLastName(String lastName) 
    {
        this.lastName = lastName;
    }
    public void setFile(int file) 
    {
        this.file = file;
    }
    public void setDni(int dni) 
    {
        this.dni = dni;
    }
    public void setEmail(String email) 
    {
        this.email = email;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }
}