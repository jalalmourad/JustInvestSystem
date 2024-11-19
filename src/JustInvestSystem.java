
import java.io.*;
import java.security.NoSuchAlgorithmException;

public class JustInvestSystem
{
    PasswordGenerator passwordGenerator;
    boolean userHasAccess = false;

    public JustInvestSystem(){
        passwordGenerator = new PasswordGenerator();
    }

    /**
     *This method is responsible for user sign up
     */
    public void userSignUp(String username,String password, int role) throws NoSuchAlgorithmException, IOException {

        boolean len= false, uppercase= false, numerical= false, lowercase = false, specialChar = false, denylist = false ,usernameMatching = false;

        BufferedReader reader = new BufferedReader(new FileReader("commonPasswords.txt"));
            String line;

            //to check if the password is in the denylist (commonPasswords.txt)
            while ((line = reader.readLine()) != null) {
                String[] passwords = line.split(",");

                for (String p:passwords){
                    if (p.equals(password)){
                        System.out.println("\u001B[31mYour password is in a list of common weak passwords\u001B[0m");
                    }
                    else {
                        denylist = true;
                    }
                }
            }
            reader.close();

        if (password.length() > 8 && password.length()<12 ){
            len = true;
        }
        else {
            System.out.println("\u001B[31mYour password length should be between 8-12 characters.\u001B[0m");
        }


        if (password.matches(".*[!@#$%*&].*")){
            specialChar = true;
        }
        else {
            System.out.println("\u001B[31mYour password should contain at least one special character ( !, @, #, $, %, *, & )\u001B[0m");
        }
        if (password.matches(".*[A-Z].*")){
            uppercase = true;
        }
        else {
            System.out.println("\u001B[31mYour password should contain at least one Upper-case letter\u001B[0m");
        }
        if (password.matches(".*[a-z].*")){
            lowercase = true;
        }
        else {
            System.out.println("\u001B[31mYour password should contain at least one Lower-case letter\u001B[0m");
        }
        if (password.matches(".*\\d.*")){
            numerical = true;
        }
        else {
            System.out.println("\u001B[31mYour password should contain at least one numerical digit\u001B[0m");
        }
        if (!password.equals(username)){
            usernameMatching = true;
        }
        else {
            System.out.println("\u001B[31mYour password should not match your username\u001B[0m");
        }

        if (len && uppercase && numerical &&lowercase && specialChar && usernameMatching && denylist && !userAlreadyExists(username)){

            String salt= passwordGenerator.createSalt();
            String writtenString = username+","+salt+","+passwordGenerator.hashedPasswordWithSaltChecker(password,salt)+","+role;

            //if the conditions are met, create a new user.
            BufferedWriter writer = new BufferedWriter(new FileWriter("passwd.txt", true));
                    writer.write(writtenString);
                    writer.newLine();
                    System.out.println("User Created Successfully!");
                    System.out.println("\033[92mPlease Login with the user You Created\033[0m");

                    writer.close();
        }
        else {

            System.out.println("\u001B[33mPlease try again!\u001B[0m");
        }

    }

    /**
     *This method is responsible for the user login
     */
    public void userLogin(String username, String password) throws IOException, NoSuchAlgorithmException {

        BufferedReader reader = new BufferedReader(new FileReader("passwd.txt"));
        String line;
        boolean foundUser = false;

        while ((line = reader.readLine()) != null) {
            String[] userInfo = line.split(",");
            String fileUserName = userInfo[0];
            String fileSalt = userInfo[1];
            String hashedPass = userInfo[2];

                if (username.equals(fileUserName)){
                    foundUser = true;
                    if (passwordGenerator.hashedPasswordWithSaltChecker(password,fileSalt).equals(hashedPass)){
                        System.out.println("ACCESS GRANTED!");
                        userHasAccess = true;
                    }
                    else {
                        System.out.println("ACCESS DENIED");
                    }
                }
        }
        if(!foundUser) {
            System.out.println("User Not Found!");
        }
    }
    /**
     *This method returns the role of the user
     */
    public int userRole(String username) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("passwd.txt"));
        String line;
        boolean foundUser = false;

        int role = 0;
        while ((line = reader.readLine()) != null) {

            String[] userInfo = line.split(",");

            String fileUserName = userInfo[0];
            String userRole = userInfo[3];

            if (username.equals(fileUserName)) {
                foundUser = true;
                role = Integer.parseInt(userRole);
            }
        }
        if (!foundUser) {
            System.out.println("User Not Found!");
        }
        return role;
    }

    public boolean UserHasAccess() {
        return userHasAccess;
    }


    public void systemIntro(){
        System.out.println();
        System.out.println("justInvest System\n" +
                "--------------------------\n" +
                "Operations available on the system:\n" +
                "1. View account balance\n" +
                "2. View investment portfolio\n" +
                "3. Modify investment portfolio\n" +
                "4. View Financial Advisor contact info\n" +
                "5. View Financial Planner contact info\n" +
                "6. View money market instruments\n" +
                "7. View private consumer instruments");
    }


    public void printInfo(){
        System.out.println("Enter 0 to Log out");
        System.out.println("Which operations would you like to perform?");
    }

    public boolean userAlreadyExists(String username) throws IOException {

        boolean usernameExists = false;
        BufferedReader psswdReader = new BufferedReader(new FileReader("passwd.txt"));
        String lineReader;

        //to check if the user already exists
        while ((lineReader = psswdReader.readLine()) != null) {
            String[] users = lineReader.split(",");
            String userFileName = users[0];

            if (username.equals(userFileName)){
                usernameExists = true;
                System.out.println("\u001B[31mThis username already exists\u001B[0m");
            }
        }
        psswdReader.close();
        return usernameExists;
    }

}
