import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {

        PasswordGenerator passwordGenerator = new PasswordGenerator();
        JustInvestSystem system = new JustInvestSystem();

        Scanner sc = new Scanner(System.in);


        system.systemIntro();
        System.out.println("\n");

        System.out.println("Please Choose one of the following options (1/2):");
        System.out.println("1-Sign up" );
        System.out.println("2-Log in");
        int access = sc.nextInt();

        sc.nextLine();

        if (access == 1){
            System.out.println("Sign up as a:");
            System.out.println("1-Client");
            System.out.println("2-Premium Client");
            System.out.println("3-Financial Advisor");
            System.out.println("4-Financial Planner");
            System.out.println("5-Teller");

            int role = sc.nextInt();
            sc.nextLine();

            //TODO add an extra parameter for role in signUpUser


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
                System.out.println();
                System.out.println("Your Authorized Operations Are:");
            }

        }


    }
}
