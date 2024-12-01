import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {

        JustInvestSystem system = new JustInvestSystem();

        Scanner sc = new Scanner(System.in);
        Employee employee = new Employee();


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

                if (role == Roles.FINANCIAL_ADVISOR.getValue() || role == Roles.FINANCIAL_PLANNER.getValue()) {
                    System.out.println("Please add your contact details:");
                    System.out.println("Enter Your Name: ");
                    String name = sc.nextLine();

                    System.out.println("Enter Your PhoneNumber: ");
                    String phoneNumber = sc.nextLine();

                    employee.contactDetails(username, name, phoneNumber, role);
                }

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
                        System.out.println(username + " is logged in as: Client");
                        Client client = new Client();
                        System.out.println("Your Authorized Operations Are: " + system.permissions(system.userRole(username)));
                        system.printInfo();
                        int operation = sc.nextInt();
                        sc.nextLine();
                        client.clientAccessControl(operation, username);
                    }
                    //If user is a Premium Client
                    while (system.userRole(username) == Roles.PREMIUM_CLIENT.getValue()) {
                        System.out.println(username + " is logged in as: Premium Client");
                        Client client = new Client();
                        System.out.println("Your Authorized Operations Are: " + system.permissions(system.userRole(username)));
                        system.printInfo();
                        int operation = sc.nextInt();
                        sc.nextLine();

                        client.premiumClientAccessControl(operation, username);
                    }
                    while (system.userRole(username) == Roles.FINANCIAL_ADVISOR.getValue()) {
                        System.out.println(username + " is logged in as: Financial Advisor");
                        System.out.println("Your Authorized Operations Are: " + system.permissions(system.userRole(username)));
                        system.printInfo();
                        int operation = sc.nextInt();
                        sc.nextLine();

                        employee.financialAdvisorAccessControl(operation, username);
                    }
                    while (system.userRole(username) == Roles.FINANCIAL_PLANNER.getValue()) {
                        System.out.println(username + " is logged in as: Financial Planner");
                        System.out.println("Your Authorized Operations Are: " + system.permissions(system.userRole(username)));
                        system.printInfo();
                        int operation = sc.nextInt();
                        sc.nextLine();

                        employee.financialPlannerAccessControl(operation, username);
                    }
                    while (system.userRole(username) == Roles.TELLER.getValue()) {
                        System.out.println(username + " is logged in as: Teller");
                        System.out.println("Your Authorized Operations Are: " + system.permissions(system.userRole(username)));
                        system.printInfo();
                        int operation = sc.nextInt();
                        sc.nextLine();

                        employee.tellerAccessControl(operation,username);
                    }


                }

            } else {
                System.out.println("Invalid Input!");
            }


        }
    }

}
