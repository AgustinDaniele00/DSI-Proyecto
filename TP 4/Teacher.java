import java.io.Serializable;

public class Teacher implements Serializable
{
    private String name;
    private String lastName;
    private int file;
    private String dni;
    private String email;
    private String phone;
    private String title;

    public Teacher(String name, String lastName, int file, String dni, String email, String phone, String title) 
    {
        this.name = name;
        this.lastName = lastName;
        this.file = file;
        this.dni = dni;
        this.email = email;
        this.phone = phone;
        this.title = title;
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
    public String getDni() 
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
    public String getTitle() 
    {
        return title;
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
    public void setDni(String dni) 
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
    public void setTitle(String title) 
    {
        this.title = title;
    }
}