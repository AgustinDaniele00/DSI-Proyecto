import java.util.Scanner;

public class Usuario 
{
    private String nombre;
    private String apellido;
    private String dni;
    private String telefono;
    private String pais;
    private String email;
    private String nombreUsuario;
    private String contrasenia;

    public Usuario (String nombre, String apellido, String dni, String telefono, String pais, String email, String nombreUsuario, String contrasenia)
    {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.telefono = telefono;
        this.pais = pais;
        this.email = email;
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
    }

    public String getNombre()
    {
        return nombre;
    }

    public String getApellido()
    {
        return apellido;
    }

    public String getDni()
    {
        return dni;
    }

    public String getTelefono()
    {
        return telefono;
    }

    public String getPais()
    {
        return pais;
    }

    public String getEmail()
    {
        return email;
    }
    
    public String getContrasenia()
    {
        return contrasenia;
    }

    public boolean LogearUsuario(String email, String contrasenia)
    {
        if (email == getEmail() && contrasenia == getContrasenia())
        {
            return true;
        }
        else
        {
            System.out.println("Los datos son incorrectos");
            return false;
        }
    }
}