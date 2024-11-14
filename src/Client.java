import java.io.*;
import java.util.Random;

public class Client {

    int balance;

    public Client(){
        balance = 0;
    }

    public void addUserBalance(String username) throws IOException {
        Random rand = new Random();
        int balance = rand.nextInt(10000);
        String writtenString = username+","+balance;

        //Adds a random balance to a user, used for testing.
        BufferedWriter writer = new BufferedWriter(new FileWriter("userInformation.txt", true));
        writer.write(writtenString);
        writer.newLine();
        System.out.println("\033[92mBalance Deposited Successfully! \033[0m");
        writer.close();
    }

    public void viewUserBalance(String username) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("userInformation.txt"));
        String line;
        boolean foundUser = false;

        while ((line = reader.readLine()) != null) {
            String[] userInfo = line.split(",");
            String fileUserName = userInfo[0];
            String balanceAmount = userInfo[1];

            if (username.equals(fileUserName)){
                foundUser = true;
                balance = Integer.parseInt(balanceAmount);
            }
        }
        if(!foundUser) {
            System.out.println("User Not Found!");
        }
        System.out.println("--------------------------------------");
        System.out.println("Your account balance is: "+balance+"$");
        System.out.println("--------------------------------------");
    }

    public void viewInvestmentPortfolio(String username) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("userInformation.txt"));
        String line;
        boolean foundUser = false;

        while ((line = reader.readLine()) != null) {
            String[] userInfo = line.split(",");
            String fileUserName = userInfo[0];
            String balanceAmount = userInfo[1];

            if (username.equals(fileUserName)){
                foundUser = true;
                balance = Integer.parseInt(balanceAmount);
            }
        }
        if(!foundUser) {
            System.out.println("User Not Found!");
        }
        System.out.println("--------------------------------------");
        System.out.println("Your Investment Portfolio is:");
        System.out.println("Total Stocks Gain: "+0.21*balance);
        System.out.println("Total Stocks Loss: "+0.02*balance);
        System.out.println("--------------------------------------");
    }

    public void getFinancialAdvisorDetails(String username) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("viewClientFinancialAdvisor.txt"));
        String line;
        boolean foundUser = false;

        while ((line = reader.readLine()) != null) {

            String[] userInfo = line.split(",");

            String Userusername = userInfo[0];
            String fileUserName = userInfo[1];
            String fileName = userInfo[2];
            String filePhoneNumber = userInfo[3];

            if (username.equals(Userusername)) {
                foundUser = true;
                System.out.println("Financial advisor for user: "+username+" is: "+fileName);
                System.out.println(fileName+"'s phone number is: "+filePhoneNumber);
            }
        }
        if (!foundUser) {
            System.out.println("(getFinancialAdvisorDetails) User Not Found!");
        }


    }

    public void clientAccessControl(int operation, String  username) throws IOException {
        if (operation == 1){
            System.out.println("Permission GRANTED to View account balance");
            this.viewUserBalance(username);
        }
        if (operation== 2){
            System.out.println("Permission GRANTED to View investment portfolio");
            this.viewInvestmentPortfolio(username);
        }
        if (operation == 4){
            System.out.println("Permission GRANTED to View Financial Advisor contact info");
            this.getFinancialAdvisorDetails(username);
        }
        if (operation == 0){
            System.out.println("User: "+username+" is successfully logged out");
            System.exit(0);
        }

    }

    public void premiumClientAccessControl(int operation, String username) throws IOException {
        if (operation == 3){
            System.out.println("Permission GRANTED to Modify investment portfolio");
        }
        if (operation == 5){
            System.out.println("Permission GRANTED to View Financial Planner contact info");
            this.getFinancialPlannerDetails(username);
        }
        if (operation == 0){
            System.out.println("User: "+username+" is successfully logged out");
            System.exit(0);
        }
    }


    public void getFinancialPlannerDetails(String username) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("viewPremiumClientFinancialPlanner.txt"));
        String line;
        boolean foundUser = false;

        while ((line = reader.readLine()) != null) {

            String[] userInfo = line.split(",");

            String Userusername = userInfo[0];
            String fileName = userInfo[2];
            String filePhoneNumber = userInfo[3];

            if (username.equals(Userusername)) {
                foundUser = true;
                System.out.println("Financial planner for user: "+username+" is: "+fileName);
                System.out.println(fileName+"'s phone number is: "+filePhoneNumber);
            }
        }
        if (!foundUser) {
            System.out.println("(getFinancialPlannerDetails) User Not Found!");
        }


    }


}
