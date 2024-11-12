import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {

        PasswordGenerator passwordGenerator = new PasswordGenerator();
        JustInvestSystem system = new JustInvestSystem();

        Scanner sc = new Scanner(System.in);


        System.out.println("Please Choose one of the following options (1/2):");
        System.out.println("1-Sign up" );
        System.out.println("2-Log in");
        int access = sc.nextInt();

        sc.nextLine();

        if (access == 1){
            System.out.println("Enter username: ");
            String username = sc.nextLine();


            System.out.println("Enter password: ");
            String password = sc.nextLine();

            system.userSignUp(username,password);
        }

        if (access == 2){
            System.out.println("Enter username: ");
            String username = sc.nextLine();

            System.out.println("Enter password: ");
            String password = sc.nextLine();

            system.userLogin(username,password);

            if (system.UserHasAccess()){
                system.systemIntro();
            }

        }


    }
}
