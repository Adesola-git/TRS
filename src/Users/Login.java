package Users;

import java.util.Scanner;
public class Login {
    static void login()
        {
            new User_MainPage("Neel");
            System.out.print("please exit");
            String users[]={"Rahul","Neel","Adesola"};
            String passwords[]={"Rahul","Neel","Adesola"};
            //users[] and passwords[] are temporary arrays

            Scanner in = new Scanner(System.in);
            System.out.print("Enter Login id:-");
            String user_id = in.nextLine().trim();
            int user_position=-1;
            for(int i=0;i< users.length;i++)
            {
                if(users[i].equals(user_id))
                {
                    user_position=i;
                    break;
                }
            }
            if(user_position==-1)
            {
                login();
                return;
            }
            // Check if the Login Id exists in (users,admins)tables, if not show warning and call login again
            String password=null;
            // Check if the password is correct , if not show warning and ask again for password
            do {
                System.out.print("Enter Password:-");
                password = in.nextLine().trim();
            }while(!passwords[user_position].equals(password));
System.out.println("user login success");
        new User_MainPage(user_id);
        //    else if(userid in admins)
//    {
//        //create an admin_mainpage obejct with some identification detail of admin such as userid
//    }
//    else()
//    {
//      // user does not exist
//    }

        }

    public static void main(String[] args) {
        Login.login();
    }

    //ask for login id
    //ask for password
    //can be passed through verification steps to determine if the account belongs to users or admins


    //we can implement chain of responsibility pattern for login to avoid hard coding the checking conditions, because infuture we might have another types of user as well.
}
