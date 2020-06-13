public class User 
{
    private String name;
    private String lastName;
    private String company;
    private String addressWork;
    private String email;
    private String phone;
    private int bags;

    public User(String name, String lastName, String company, String addressWork, String email, String phone) 
    {
        this.name = name;
        this.lastName = lastName;
        this.company = company;
        this.addressWork = addressWork;
        this.email = email;
        this.phone = phone;
        this.bags = 0;
    }
    
    public String getName() 
    {
        return name;
    }
    public String getLastName() 
    {
        return lastName;
    }
    public String getCompany() 
    {
        return company;
    }
    public String getAddressWork() 
    {
        return addressWork;
    }
    public String getEmail() 
    {
        return email;
    }
    public String getPhone() 
    {
        return phone;
    }
    public int getBags()
    {
        return bags;
    }

    public void setName(String name) 
    {
        this.name = name;
    }
    public void setLastName(String lastName) 
    {
        this.lastName = lastName;
    }
    public void setCompany(String company) 
    {
        this.company = company;
    }
    public void setAddressWork(String addressWork) 
    {
        this.addressWork = addressWork;
    }
    public void setEmail(String email) 
    {
        this.email = email;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }
    public void setBags(int bags)
    {
        this.bags = bags;
    }    
}