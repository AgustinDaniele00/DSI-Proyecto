import java.util.Scanner;

public class Manager
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        RegisterMaterial registerMaterial = new RegisterMaterial();
        RegisterWorkforce registerWorkforce = new RegisterWorkforce();
        RegisterQuote registerQuote = new RegisterQuote();
        RegisterUser registerUser = new RegisterUser();
        User user;
        String name = " ", lastName = " ", company = " ", addressWork = " ", email = " ", phone = " ";
        int option;
        int option2;
        int materialNum;
        int workforceNum;
        int answer;
        boolean empty = true;

        System.out.println("*****INTERFAZ DE COMPRA AISLANTE Y CONTRATACION DE MANO DE OBRA*****");

        registerMaterial.registerMaterials();
        registerWorkforce.registerWorkforce();

        do
        {
            do
            {
                if (empty == true)
                {
                    empty = false;
                    option2 = 1;
                }
                else
                {
                    System.out.println("    Elija una opcion:"+ "\n" +"1-Registrar usuario" + "\n" + "2-Ingresar usuario");
                    option2 = input.nextInt();
                }
                

                if(option2 == 1)
                {
                    System.out.print("Ingrese el nombre del usuario: ");
                    name = input.next();
                    System.out.print("Ingrese el apellido del usuario: ");
                    lastName = input.next();
                    System.out.print("Ingrese el nombre de la empresa: ");
                    company = input.next();
                    System.out.print("Ingrese el domicilio de la empresa: ");
                    addressWork = input.next();
                    System.out.print("Ingrese el email del usuario: ");
                    email = input.next();
                    System.out.print("Ingrese el telefono del usuario: ");
                    phone = input.next();
                }
                else
                {
                    boolean login;
                    String email2;

                    do
                    {
                        System.out.print("Ingrese el email del usuario: ");
                        email2 = input.next();
                        login = registerUser.logerUser(email2);

                        if(login != true)
                        {
                            System.out.println("Email no valido, intentelo nuevamente.");
                        }
                    }
                    while(login != true);
                }

                if (option2 <1 || option2 >2)
                {
                    System.out.println("No es una opcion valida. Ingrese la opcion nuevamente.");
                }

            }while(option2 <1 || option2 >2);

            user = new User(name, lastName, company, addressWork, email, phone);
            registerUser.registerUser(user);
            Quote quote = new Quote(user);

            float totalPrice = 0;
            float cantM2 = 0;

            System.out.println("----------------------------------------------------------------------------------");
            System.out.println("    Elija una opcion:"+ "\n" +"1-Realizar cotizacion estandar" + "\n" + "2-Realizar cotizacion personalizada");
            System.out.println("----------------------------------------------------------------------------------");

            do
            {
                option = input.nextInt();

                if(option < 1 || option > 2)
                {
                    System.out.println("No es una opcion valida. Ingrese la opcion nuevamente.");
                }
            }while (option < 1 || option > 2);
            

            if (option == 1)
            {
                registerMaterial.showMaterials();

                do
                {
                    System.out.println("");
                    System.out.print("Precione el numero del material: ");
                    materialNum = input.nextInt();

                    if(materialNum < 1 || materialNum > RegisterMaterial.Materials.size())
                    {
                        System.out.println("Error de eleccion de material. Ingrece la opcion nuevamente");
                    }

                }while(materialNum < 1 || materialNum > RegisterMaterial.Materials.size());

                System.out.println("Ingrese la cantidad de metros cuadrado que desea cubrir: ");
                cantM2 = input.nextFloat();
                
                Material material = RegisterMaterial.Materials.get(materialNum - 1);
                Workforce workforce = RegisterWorkforce.Workforces.get(3 - 1);
            
                totalPrice = quote.quote(user, material, workforce, cantM2);
            }
            else
            {

                registerMaterial.showMaterials();

                do
                {
                    System.out.println("");
                    System.out.print("Precione el numero del material: ");
                    materialNum = input.nextInt();

                    if(materialNum < 1 || materialNum > RegisterMaterial.Materials.size())
                    {
                        System.out.println("Error de eleccion de material. Ingrece la opcion nuevamente");
                    }

                }while(materialNum < 1 || materialNum > RegisterMaterial.Materials.size());

                registerWorkforce.showWorkforce();

                do
                {
                    System.out.println("");
                    System.out.print("Precione el numero de la mano de obra que desea: ");
                    workforceNum = input.nextInt();

                    if (workforceNum < 1 || workforceNum > RegisterWorkforce.Workforces.size())
                    {
                        System.out.println("Error de eleccion de mano de obra. Ingrese la opcion nuevamente.");
                    }

                }while(workforceNum < 1 || workforceNum > RegisterWorkforce.Workforces.size());

                System.out.println("Ingrese la cantidad de metros cuadrado que desea cubrir: ");
                cantM2 = input.nextFloat();

                Material material = RegisterMaterial.Materials.get(materialNum - 1);
                Workforce workforce = RegisterWorkforce.Workforces.get(workforceNum - 1);
                    
                totalPrice = quote.quote(user, material, workforce, cantM2);
            }
            
            registerQuote.registerQuotes(user, totalPrice);
            
            System.out.println("Quiere realizar otra cotizacion? (1-Si/2-No)");
            do
            {
                answer = input.nextInt();
                if(answer < 1 || answer > 2)
                {
                    System.out.println("Error de eleccion. Ingrese la opcion nuevamente.");
                }
            }while(answer < 1 || answer > 2);
            
        } while (answer != 2);

        registerQuote.showQuotes();
    }
}