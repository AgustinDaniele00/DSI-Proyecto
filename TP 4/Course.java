import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Scanner;
import java.io.Serializable;

public class Course implements Serializable
{
    private String name;
    private String description;
    private Teacher teacher;
    private String date;
    private String schedule;
    private String classroom;
    private int minAlumns;
    private int maxAlumns;
    private Date deadline;
    private boolean plannedCourse;
    private boolean confirmedCourse;
    private ArrayList<Student> students = new ArrayList<Student>();

    public Course(String name, String description) 
    {
        this.name = name;
        this.description = description;
        teacher = null;
        date = "";
        schedule = "";
        classroom = "";
        minAlumns = 0;
        maxAlumns = 0;
        deadline = null;
        plannedCourse = false;
        confirmedCourse = false;
    }

    public static void planCourse(CourseManager CourseManager, TeacherManager TeacherManager)
    {
        Scanner input = new Scanner(System.in);

		System.out.println("**********************************************************");
        System.out.println("                    PLANIFICAR CURSOS");
		System.out.println("**********************************************************");
        
        CourseManager.showCourse();

		System.out.print("Eliga el curso que quiere planificar: ");
        int opcCourse = input.nextInt();
        
        Course course = CourseManager.courses.get(opcCourse - 1);
        System.out.println("Curso elegido: " + course.getName());
        
        if (course.getTeacher() == null)
        {
            TeacherManager.assignTeacher(course);
        }
        else
        {
            System.out.println("Docente: " + course.getTeacher());
        }
		
		System.out.print("Ingrese la Fechas de Dictado: ");
        String date = input.nextLine();
        course.setDate(date);
        
        input.nextLine();
        
		System.out.print("Ingrese el Horario de Dictado: ");
        String schedule = input.nextLine();
        course.setSchedule(schedule);
        
		System.out.print("Ingrese el Aula: ");
        String classroom = input.nextLine();
        course.setClassroom(classroom);
        
		System.out.print("Ingrese el Cupo Minimo de Alumnos: ");
        int minAlumns = input.nextInt();
        course.setMinAlumns(minAlumns);
        
		System.out.print("Ingrese el Cupo Maximo de Alumnos: ");
        int maxAlumns = input.nextInt();
        course.setMaxAlumns(maxAlumns);
        
        System.out.println("Ingrese la fecha limite de inscripcion con el siguiente formato DD/MM/YYYY");
        String entry = input.nextLine();
        Date deadline = enterDate(entry);
        course.setDeadline(deadline);

        course.setPlannedCourse(true);
    }

    public static Date enterDate(String entry) 
    {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date deadline = null;
        try 
        {
            deadline = formato.parse(entry);
        } 
        catch (ParseException ex) 
        {
            System.out.println(ex);
        }

        return deadline;
    }

    public boolean checkCapacity()
    {
        if (students.size() == maxAlumns)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public void addStudent(Student student)
    {
        students.add(student);
    }

    public boolean verifySpace()
    {
        if(students.size() >= minAlumns)
        {
            return true;
        }
        else
        {
            return false;
        } 
    }

    public static void checkCoupons(CourseManager CourseManager)
	{
        Scanner input = new Scanner(System.in);
        
        System.out.println("Listado de Cursos:");
        CourseManager.showCourse();

		System.out.print("Eliga el curso que usted desea: ");
        int opcCourse = input.nextInt();
        Course course = CourseManager.courses.get(opcCourse - 1);
		
		if(course.getPlannedCourse() == false)
		{
			System.out.println("El curso todavia no fue planificado.");
		}
		else 
		{
            if(course.verifySpace() == true)
            {
                System.out.println("El curso ya alcanzo el cupo minimo de alumnos");
            }
            else
            {
                System.out.println("El curso todavia no alcanzo el cupo minimo de alumnos");
            } 
		}
    }
    
    public static void modifyCourse(CourseManager CourseManager)
	{
        Scanner input = new Scanner(System.in);
        
        System.out.println("Listado de Cursos:");
        CourseManager.showCourse();
		
		System.out.print("Eliga El curso que desea modificar: ");
        int opc = input.nextInt();
        Course course = CourseManager.courses.get(opc - 1);
		
		if(course.getPlannedCourse() == false)
		{
			System.out.println("El curso todavia no fue planificado este");
		}
		else 
		{
			System.out.println("Eliga la opcion que desee. 1-Confirmar / 2-Cancelar");
			int opcConfirm = input.nextInt();
			boolean opc2;
			if(opcConfirm == 1) 
			{
				opc2 = true;
				System.out.println("El curso " + course.name + " fue confirmado");
			}
			else 
			{
                opc2 = false;
                course.setPlannedCourse(false);
				System.out.println("El curso " + course.name + " fue cancelado");
            }
                
            course.setConfirmedCourse(opc2);
		}
    }

    public String getName() 
    {
        return name;
    }
    public String getDescription() 
    {
        return description;
    }
    public Teacher getTeacher() 
    {
        return teacher;
    }
    public String getDate() 
    {
        return date;
    }
    public String getSchedule() 
    {
        return schedule;
    }
    public String getClassroom() 
    {
        return classroom;
    }
    public int getMinAlumns() 
    {
        return minAlumns;
    }
    public int getMaxAlumns() 
    {
        return maxAlumns;
    }
    public Date getDeadline() 
    {
        return deadline;
    }
    public boolean getPlannedCourse()
    {
        return plannedCourse;
    }
    public boolean getConfirmedCourse()
    {
        return confirmedCourse;
    }

    public void setName(String name) 
    {
        this.name = name;
    }
    public void setDescription(String description) 
    {
        this.description = description;
    }
    public void setTeacher(Teacher teacher) 
    {
        this.teacher = teacher;
    }
    public void setDate(String date) 
    {
        this.date = date;
    }
    public void setSchedule(String schedule) 
    {
        this.schedule = schedule;
    }
    public void setClassroom(String classroom) 
    {
        this.classroom = classroom;
    }
    public void setMinAlumns(int minAlumns) 
    {
        this.minAlumns = minAlumns;
    }
    public void setMaxAlumns(int maxAlumns) 
    {
        this.maxAlumns = maxAlumns;
    }
    public void setDeadline(Date deadline) 
    {
        this.deadline = deadline;
    }
    public void setPlannedCourse(boolean plannedCourse) 
    {
        this.plannedCourse = plannedCourse;
    }
    public void setConfirmedCourse(boolean confirmedCourse) 
    {
        this.confirmedCourse = confirmedCourse;
    }
    
}