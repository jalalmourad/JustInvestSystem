import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {

        PasswordGenerator passwordGenerator = new PasswordGenerator();
        JustInvestSystem system = new JustInvestSystem();

        Scanner sc = new Scanner(System.in);
        Employee employee = new Employee();

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
            while (role>5 || role<0){
                System.out.println("Please enter a number between 1-5");
                role = sc.nextInt();
            }
            sc.nextLine();


            System.out.println("Enter username: ");
            String username = sc.nextLine();


            System.out.println("Enter password: ");
            String password = sc.nextLine();

            if (role == 3 || role == 4){
                System.out.println("Please add your contact details:");
                System.out.println("Enter Your Name: ");
                String name = sc.nextLine();

                System.out.println("Enter Your PhoneNumber: ");
                String phoneNumber= sc.nextLine();

                employee.contactDetailsFinancialAdv(username,name,phoneNumber,role);
            }

            system.userSignUp(username,password,role);

            if (role == 1){
                System.out.println("\033[1mUser role is a \033[1;97mClient\033[0m\033[0m");
            }
            if (role == 2){
                System.out.println("\033[1mUser role is a \033[1;97mPremium Client\033[0m\033[0m");
            }
            if (role == 3){
                System.out.println("\033[1mUser role is a \033[1;97mFinancial Advisor\033[0m\033[0m");
            }
            if (role == 4){
                System.out.println("\033[1mUser role is a \033[1;97mFinancial Planner\033[0m\033[0m");
            }
            if (role == 5){
                System.out.println("\033[1mUser role is a \033[1;97mTeller\033[0m\033[0m");
            }



        }

        if (access == 2){
            System.out.println("Enter username: ");
            String username = sc.nextLine();

            System.out.println("Enter password: ");
            String password = sc.nextLine();

            system.userLogin(username,password);

            if (system.UserHasAccess()){
                System.out.println();

                //If user is a Client
                while (system.userRole(username) == 1){
                    System.out.println("Your Authorized Operations Are: 1, 2, 4");
                    System.out.println("Enter 0 to Log out");
                    System.out.println("Which operations would you like to perform?");
                    int operation = sc.nextInt();
                    sc.nextLine();
                    Client client = new Client();
                    if (operation == 1){
                        client.viewUserBalance(username);
                    }
                    if (operation== 2){
                        client.viewInvestmentPortfolio(username);
                    }
                    if (operation == 4){
                        employee.getFinancialAdvisorDetails(username);
                    }
                    if (operation == 0){
                        System.out.println("User: "+username+" is successfully logged out");
                        break;
                    }
                    else {
                        System.out.println("\nYou cannot perform this operation");
                    }
                }

                //If user is a Premium Client
                while (system.userRole(username) == 2){
                    System.out.println("Your Authorized Operations Are: 3, 5");
                    System.out.println("Enter 0 to Log out");
                    System.out.println("Which operations would you like to perform?");
                    int operation = sc.nextInt();
                    sc.nextLine();
                    Client client = new Client();

                    if (operation == 3){
                        client.viewUserBalance(username);
                    }

                    if (operation == 5){
                        employee.getFinancialAdvisorDetails(username);
                    }
                    if (operation == 0){
                        System.out.println("User: "+username+" is successfully logged out");
                        break;
                    }
                    else {
                        System.out.println("\nYou cannot perform this operation");
                    }
                }


            }

        }


    }
}
