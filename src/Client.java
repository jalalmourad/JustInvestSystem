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


}
