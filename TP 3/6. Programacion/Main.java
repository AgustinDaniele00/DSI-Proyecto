import java.util.Scanner;

public class Main 
{
    public static void main(String[] args) 
    {
		int opc;

        Scanner input = new Scanner(System.in);

		Student student1 = new Student("Agustin", "Daniele", 1, 42513143, "email1", "15697824");
        Student student2 = new Student("Lautaro", "Pairola", 2, 42513144, "email2", "15697825");
        Student student3 = new Student("Javier", "Castagno", 3, 42513145, "email3", "15697826");
		Teacher teacher1 = new Teacher("Roberto", "Perez", 1, "123", "email1", "phone1", "title1");
        Teacher teacher2 = new Teacher("Manuel", "Sanchez", 2, "456", "email2", "phone2", "title2");
        Teacher teacher3 = new Teacher("Alberto", "Vivas", 3, "789", "email3", "phone3", "title3");
		Course course1 = new Course("Robotica", "Para alumnos de ing.Sistemas");
        Course course2 = new Course("Aleman", "Para alumnos de todas las carreras");
	
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
				CourseManager.loadNewCourse();
				break;
			case 2:
                System.out.println("Listado de cursos: ");
                CourseManager.showCourse();
                
                System.out.print("Eliga el curso a asignar el docente: ");
                int opcCourse = input.nextInt();

                TeacherManager.assignTeacher(CourseManager.courses.get(opcCourse - 1));
				break;
			case 3:
				Course.planCourse();
				break;
			case 4:
				Student.registerStudent();
				break;
			case 5:
				Course.checkCoupons();
				break;
			case 6:
				Course.modifyCourse();
				break;
            }

        }while(opc != 7);
		
		System.out.println("ADIOS!!");
    }
}