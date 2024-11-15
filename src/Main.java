import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {

        JustInvestSystem system = new JustInvestSystem();

        Scanner sc = new Scanner(System.in);

        AccessControl accessControl = new AccessControl();

        system.systemIntro();
        System.out.println("\n");

        while (true) {
        System.out.println("Please Choose one of the following options (1/2):");
        System.out.println("1-Sign up");
        System.out.println("2-Log in");
        int access = sc.nextInt();

        sc.nextLine();

            if (access == 1) {
                System.out.println("Sign up as a:");
                System.out.println("1-Client");
                System.out.println("2-Premium Client");
                System.out.println("3-Financial Advisor");
                System.out.println("4-Financial Planner");
                System.out.println("5-Teller");

                int role = sc.nextInt();
                while (role > 5 || role < 0) {
                    System.out.println("Please enter a number between 1-5");
                    role = sc.nextInt();
                }
                sc.nextLine();

                System.out.println("Enter username: ");
                String username = sc.nextLine();


                System.out.println("Enter password: ");
                String password = sc.nextLine();


                system.userSignUp(username, password, role);

                if (role == Roles.CLIENT.getValue()) {
                    System.out.println("\033[1mUser role is a \033[1;97mClient\033[0m\033[0m");
                }
                if (role == Roles.PREMIUM_CLIENT.getValue()) {
                    System.out.println("\033[1mUser role is a \033[1;97mPremium Client\033[0m\033[0m");
                }
                if (role == Roles.FINANCIAL_ADVISOR.getValue()) {
                    System.out.println("\033[1mUser role is a \033[1;97mFinancial Advisor\033[0m\033[0m");
                }
                if (role == Roles.FINANCIAL_PLANNER.getValue()) {
                    System.out.println("\033[1mUser role is a \033[1;97mFinancial Planner\033[0m\033[0m");
                }
                if (role == Roles.TELLER.getValue()) {
                    System.out.println("\033[1mUser role is a \033[1;97mTeller\033[0m\033[0m");
                }
            } else if (access == 2) {
                System.out.println("Enter username: ");
                String username = sc.nextLine();

                System.out.println("Enter password: ");
                String password = sc.nextLine();
                system.userLogin(username, password);
                if (system.UserHasAccess()) {
                    System.out.println();
                    //If user is a Client
                    while (system.userRole(username) == Roles.CLIENT.getValue()) {
                        System.out.println(username + " is logged in as: Client\n");
                        System.out.println("Your Authorized Operations Are: " + accessControl.permissions(system.userRole(username)));
                        system.printInfo();
                        int operation = sc.nextInt();
                        sc.nextLine();
                        accessControl.accessControl(Roles.CLIENT.name(), operation,username);
                    }
                    //If user is a Premium Client
                    while (system.userRole(username) == Roles.PREMIUM_CLIENT.getValue()) {
                        System.out.println(username + " is logged in as: Premium Client\n");
                        System.out.println("Your Authorized Operations Are: " + accessControl.permissions(system.userRole(username)));
                        system.printInfo();
                        int operation = sc.nextInt();
                        sc.nextLine();

                        accessControl.accessControl(Roles.PREMIUM_CLIENT.name(), operation,username);
                    }
                    while (system.userRole(username) == Roles.FINANCIAL_ADVISOR.getValue()) {
                        System.out.println(username + " is logged in as: Financial Advisor\n");
                        System.out.println("Your Authorized Operations Are: " + accessControl.permissions(system.userRole(username)));
                        system.printInfo();
                        int operation = sc.nextInt();
                        sc.nextLine();

                        accessControl.accessControl(Roles.FINANCIAL_ADVISOR.name(), operation,username);
                    }
                    while (system.userRole(username) == Roles.FINANCIAL_PLANNER.getValue()) {
                        System.out.println(username + " is logged in as: Financial Planner\n");
                        System.out.println("Your Authorized Operations Are: " + accessControl.permissions(system.userRole(username)));
                        system.printInfo();
                        int operation = sc.nextInt();
                        sc.nextLine();

                        accessControl.accessControl(Roles.FINANCIAL_PLANNER.name(), operation,username);
                    }
                    while (system.userRole(username) == Roles.TELLER.getValue()) {
                        System.out.println(username + " is logged in as: Teller\n");
                        System.out.println("Your Authorized Operations Are: " + accessControl.permissions(system.userRole(username)));
                        system.printInfo();
                        int operation = sc.nextInt();
                        sc.nextLine();

                        accessControl.accessControl(Roles.TELLER.name(), operation,username);
                    }
                }
            } else {
                System.out.println("Invalid Input!");
            }
        }
    }

}
