import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class Employee {


    public Employee(){

    }


    //Assigns a random Financial Advisor to a client
    public void returnRandomFinancialAdvisor(String username) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("contactDetails.txt"));
        String line;
        boolean foundUser = false;
        ArrayList<String> financialAdvisors = new ArrayList<>();
        int role = 0;
        Random random = new Random();
        while ((line = reader.readLine()) != null) {

            String[] userInfo = line.split(",");

            String fileUserName = userInfo[0];
            String fileName = userInfo[1];
            String filePhoneNumber = userInfo[2];
            String userRole = userInfo[3];

            if (userRole.equals("3")) {
                foundUser = true;

                String info = username+","+fileUserName+ "," +fileName+","+filePhoneNumber;
                financialAdvisors.add(info);
            }
        }

        if (!foundUser) {
            System.out.println("(returnRandomFinancialAdvisor)User Not Found!");
        }
        else {
            BufferedWriter financialAdvisorAllocation = new BufferedWriter(new FileWriter("viewClientFinancialAdvisor.txt", true));
            financialAdvisorAllocation.write(financialAdvisors.get(random.nextInt(financialAdvisors.size())));
            financialAdvisorAllocation.newLine();
            financialAdvisorAllocation.close();
        }
    }

    //Assigns a random Financial Advisor to a client
    public void returnRandomFinancialPlanner(String username) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("contactDetails.txt"));
        String line;
        boolean foundUser = false;
        ArrayList<String> financialAdvisors = new ArrayList<>();
        Random random = new Random();
        while ((line = reader.readLine()) != null) {

            String[] userInfo = line.split(",");

            String fileUserName = userInfo[0];
            String fileName = userInfo[1];
            String filePhoneNumber = userInfo[2];
            String userRole = userInfo[3];

            if (userRole.equals("4")) {
                foundUser = true;

                String info = username+","+fileUserName+ "," +fileName+","+filePhoneNumber;
                financialAdvisors.add(info);
            }
        }

        if (!foundUser) {
            System.out.println("(returnRandomFinancialPlanner)User Not Found!");
        }
        else {
            BufferedWriter financialAdvisorAllocation = new BufferedWriter(new FileWriter("viewPremiumClientFinancialPlanner.txt", true));
            financialAdvisorAllocation.write(financialAdvisors.get(random.nextInt(financialAdvisors.size())));
            financialAdvisorAllocation.newLine();
            financialAdvisorAllocation.close();
        }


    }

    public void contactDetails(String username,String name, String phoneNumber, int role) throws IOException {
        BufferedWriter financialAdvisorAllocation = new BufferedWriter(new FileWriter("contactDetails.txt", true));
        String info = username+","+name+","+phoneNumber+","+role;
        financialAdvisorAllocation.write(info);
        financialAdvisorAllocation.newLine();
        financialAdvisorAllocation.close();
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


    public static void main(String[] args) throws IOException {
        Employee e = new Employee();
       // e.returnRandomFinancialAdvisor();
       // System.out.println(e.returnRandomFinancialAdvisor());
    }

}
