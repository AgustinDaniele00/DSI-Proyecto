import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main 
{
    public static void main(String[] args) 
    {
		int opc;

        Scanner input = new Scanner(System.in);

		StudentManager studentManager = new StudentManager();
		Student student1 = new Student("Agustin", "Daniele", 1, 42513143, "email1", "15697824");
        Student student2 = new Student("Lautaro", "Pairola", 2, 42513144, "email2", "15697825");
		Student student3 = new Student("Javier", "Castagno", 3, 42513145, "email3", "15697826");
		studentManager.students.add(student1);
		studentManager.students.add(student2);
		studentManager.students.add(student3);
		studentManager = loadDataStudents();

		TeacherManager teacherManager = new TeacherManager();
		Teacher teacher1 = new Teacher("Roberto", "Perez", 1, "123", "email1", "phone1", "title1");
        Teacher teacher2 = new Teacher("Manuel", "Sanchez", 2, "456", "email2", "phone2", "title2");
		Teacher teacher3 = new Teacher("Alberto", "Vivas", 3, "789", "email3", "phone3", "title3");
		teacherManager.teachers.add(teacher1);
		teacherManager.teachers.add(teacher2);
		teacherManager.teachers.add(teacher3);
		teacherManager = loadDataTeachers();

		CourseManager courseManager = new CourseManager();
		Course course1 = new Course("Robotica", "Para alumnos de ing.Sistemas");
		Course course2 = new Course("Aleman", "Para alumnos de todas las carreras");
		courseManager.courses.add(course1);
		courseManager.courses.add(course2);
		courseManager = loadDataCourses();
	
        do 
        {
            System.out.println("**********************************************************");
            System.out.println("                    GESTOR DE CURSOS");
			System.out.println("**********************************************************");
			System.out.println("1- Cargar Nuevo Curso.");
			System.out.println("2- Asignar docente a curso.");
			System.out.println("3- Planificar Curso.");
			System.out.println("4- Registrar inscripcion.");
			System.out.println("5- Verificar Cupo de Inscriptos a Curso.");
			System.out.println("6- Confirmar/cancelar cursos.");
            System.out.println("7- Salir.");
            System.out.println("**********************************************************");
            System.out.print("Ingrese el digito de lo que desea realizar: ");
            

            opc = input.nextInt();
			switch(opc)
			{
			case 1:
				courseManager.loadNewCourse(teacherManager);
				break;
			case 2:
                System.out.println("Listado de cursos: ");
                courseManager.showCourse();
                
                System.out.print("Eliga el curso a asignar el docente: ");
                int opcCourse = input.nextInt();

                teacherManager.assignTeacher(courseManager.courses.get(opcCourse - 1));
				break;
			case 3:
				Course.planCourse(courseManager, teacherManager);
				break;
			case 4:
				Student.registerStudent(courseManager, studentManager);
				break;
			case 5:
				Course.checkCoupons(courseManager);
				break;
			case 6:
				Course.modifyCourse(courseManager);
				break;
            }

        }while(opc != 7);
		
		System.out.println("ADIOS!!");

		saveDataStudents(studentManager);
		saveDataTeachers(teacherManager);
		saveDataCourses(courseManager);
	}
	
	public static StudentManager loadDataStudents() 
	{
	StudentManager studentManagerR = null;

	ObjectInputStream objectReader;

	try
	{
		objectReader = new ObjectInputStream(new FileInputStream("Students.json"));
		studentManagerR = (StudentManager) objectReader.readObject();
	}
	catch (FileNotFoundException e)
	{
		e.printStackTrace();
	}
	catch (IOException e)
	{
		e.printStackTrace();
	}
	catch (ClassNotFoundException e)
	{
		e.printStackTrace();
	}

	return studentManagerR;
	}

	public static void saveDataStudents (StudentManager studentManager)
	{
		try 
		{
			ObjectOutputStream objectWriter = new ObjectOutputStream(new FileOutputStream("Students.json"));
			objectWriter.writeObject(studentManager);
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public static TeacherManager loadDataTeachers() 
	{
		TeacherManager teacherManagerR = null;

		ObjectInputStream objectReader;

		try
		{
			objectReader = new ObjectInputStream(new FileInputStream("Teachers.json"));
			teacherManagerR = (TeacherManager) objectReader.readObject();
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}

		return teacherManagerR;
	}

	public static void saveDataTeachers (TeacherManager teacherManager)
	{
		try 
		{
			ObjectOutputStream objectWriter = new ObjectOutputStream(new FileOutputStream("Teachers.json"));
			objectWriter.writeObject(teacherManager);
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public static CourseManager loadDataCourses() 
	{
		CourseManager courseManagerR = null;

		ObjectInputStream objectReader;

		try
		{
			objectReader = new ObjectInputStream(new FileInputStream("Courses.json"));
			courseManagerR = (CourseManager) objectReader.readObject();
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}

		return courseManagerR;
	}

	public static void saveDataCourses (CourseManager courseManager)
	{
		try 
		{
			ObjectOutputStream objectWriter = new ObjectOutputStream(new FileOutputStream("Student.json"));
			objectWriter.writeObject(courseManager);
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}

