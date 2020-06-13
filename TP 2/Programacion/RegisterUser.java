import java.util.ArrayList;

public class RegisterUser 
{
    private ArrayList<User> users = new ArrayList<User>();

    public void registerUser(User user)
    {
        users.add(user);
    }

    public boolean logerUser(String email)
    {
        boolean flag = false;

        for (User user : users)
        {
            if (user.getEmail().compareTo(email) == 0)
            {
                flag = true;
                break;
            }
            else
            {
                flag = false;
            }
        }

        return flag;
    }
}