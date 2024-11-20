import org.junit.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.*;

public class JustInvestSystemTest {


    /**
     * This test is to check the Client role access control
     * Signed up with user:  system.userSignUp("SashaKim","Sasha1234!",Roles.CLIENT.getValue());
     * @throws NoSuchAlgorithmException
     * @throws IOException
     */
    @Test
    public void testAccessControlClient() throws NoSuchAlgorithmException, IOException {
        System.out.println();
        JustInvestSystem system = new JustInvestSystem();
        AccessControl accessControl = new AccessControl();
        //Login
        system.userLogin("SashaKim","Sasha1234!");

        System.out.println("CLIENT permissions: ");
        System.out.println("Expected value for the following operations: GRANTED, Real value:");
        accessControl.accessControl(Roles.CLIENT.name(), 1, "SashaKim");
        accessControl.accessControl(Roles.CLIENT.name(), 2, "SashaKim");
        accessControl.accessControl(Roles.CLIENT.name(), 4, "SashaKim");

        System.out.println("Expected value for the following operations: DENIED, Real value:");
        accessControl.accessControl(Roles.CLIENT.name(), 5, "SashaKim");
        accessControl.accessControl(Roles.CLIENT.name(), 3, "SashaKim");
        accessControl.accessControl(Roles.CLIENT.name(), 6, "SashaKim");
        accessControl.accessControl(Roles.CLIENT.name(), 7, "SashaKim");
    }

    /**
     * This test is to check the Premium Client role access control
     * Signed up with user:  system.userSignUp("NoorAbbasi","Noor12345!",Roles.PREMUIM_CLIENT.getValue());
     * @throws NoSuchAlgorithmException
     * @throws IOException
     */
    @Test
    public void testAccessControlPremiumClient() throws NoSuchAlgorithmException, IOException {
        System.out.println();
        JustInvestSystem system = new JustInvestSystem();
        AccessControl accessControl = new AccessControl();
        //Login
        system.userLogin("NoorAbbasi","Noor12345!");

        System.out.println("PREMIUM CLIENT permissions: ");
        System.out.println("Expected value for the following operations: GRANTED, Real value:");
        accessControl.accessControl(Roles.PREMIUM_CLIENT.name(), 5, "NoorAbbasi");
        accessControl.accessControl(Roles.PREMIUM_CLIENT.name(), 3, "NoorAbbasi");
        System.out.println("Expected value for the following operations: DENIED, Real value:");
        accessControl.accessControl(Roles.PREMIUM_CLIENT.name(), 1, "NoorAbbasi");
        accessControl.accessControl(Roles.PREMIUM_CLIENT.name(), 2, "NoorAbbasi");
        accessControl.accessControl(Roles.PREMIUM_CLIENT.name(), 4, "NoorAbbasi");
        accessControl.accessControl(Roles.PREMIUM_CLIENT.name(), 6, "NoorAbbasi");
        accessControl.accessControl(Roles.PREMIUM_CLIENT.name(), 7, "NoorAbbasi");
    }

    /**
     * This test is to check the FINANCIAL_ADVISOR role access control
     * Signed up with user:  system.userSignUp("JordanRiley","Jordan123!",Roles.FINANCIAL_ADVISOR.getValue());
     * @throws NoSuchAlgorithmException
     * @throws IOException
     */
    @Test
    public void testAccessControlFinancialAdvisor() throws NoSuchAlgorithmException, IOException {
        System.out.println();
        JustInvestSystem system = new JustInvestSystem();
        AccessControl accessControl = new AccessControl();
        //Login
        system.userLogin("JordanRiley","Jordan123!");

        System.out.println("Financial Advisor permissions: ");
        System.out.println("Expected value for the following operations: GRANTED, Real value:");
        accessControl.accessControl(Roles.FINANCIAL_ADVISOR.name(), 3, "JordanRiley");
        accessControl.accessControl(Roles.FINANCIAL_ADVISOR.name(), 1, "JordanRiley");
        accessControl.accessControl(Roles.FINANCIAL_ADVISOR.name(), 2, "JordanRiley");
        accessControl.accessControl(Roles.FINANCIAL_ADVISOR.name(), 7, "JordanRiley");
        System.out.println("Expected value for the following operations: DENIED, Real value:");
        accessControl.accessControl(Roles.FINANCIAL_ADVISOR.name(), 5, "JordanRiley");
        accessControl.accessControl(Roles.FINANCIAL_ADVISOR.name(), 4, "JordanRiley");
        accessControl.accessControl(Roles.FINANCIAL_ADVISOR.name(), 6, "JordanRiley");
    }

    /**
     * This test is to check the FINANCIAL_PLANNER role access control
     * Signed up with user:  system.userSignUp("HarperDiaz","Harper123!",Roles.FINANCIAL_ADVISOR.getValue());
     * @throws NoSuchAlgorithmException
     * @throws IOException
     */
    @Test
    public void testAccessControlFinancialPlanner() throws NoSuchAlgorithmException, IOException {
        System.out.println();
        JustInvestSystem system = new JustInvestSystem();
        AccessControl accessControl = new AccessControl();

        //Login
        system.userLogin("HarperDiaz","Harper123!");

        System.out.println("Financial Planner permissions: ");
        System.out.println("Expected value for the following operations: GRANTED, Real value:");
        accessControl.accessControl(Roles.FINANCIAL_PLANNER.name(), 3, "HarperDiaz");
        accessControl.accessControl(Roles.FINANCIAL_PLANNER.name(), 1, "HarperDiaz");
        accessControl.accessControl(Roles.FINANCIAL_PLANNER.name(), 2, "HarperDiaz");
        accessControl.accessControl(Roles.FINANCIAL_PLANNER.name(), 7, "HarperDiaz");
        accessControl.accessControl(Roles.FINANCIAL_PLANNER.name(), 6, "HarperDiaz");
        System.out.println("Expected value for the following operations: DENIED, Real value:");
        accessControl.accessControl(Roles.FINANCIAL_PLANNER.name(), 5, "HarperDiaz");
        accessControl.accessControl(Roles.FINANCIAL_PLANNER.name(), 4, "HarperDiaz");
    }

    /**
     * This test is to check the TELLER role access control
     * Signed up with user:  system.userSignUp("AlexHayes","Alex1234!",Roles.TELLER.getValue());
     * @throws NoSuchAlgorithmException
     * @throws IOException
     */
    @Test
    public void testAccessControlTeller() throws NoSuchAlgorithmException, IOException {
        System.out.println();
        JustInvestSystem system = new JustInvestSystem();
        AccessControl accessControl = new AccessControl();

        //Login
        system.userLogin("AlexHayes","Alex1234!");

        System.out.println("Teller permissions: ");
        System.out.println("Expected value for the following operations: GRANTED, Real value:");

        accessControl.accessControl(Roles.TELLER.name(), 1, "AlexHayes");
        accessControl.accessControl(Roles.TELLER.name(), 2, "AlexHayes");
        System.out.println("Expected value for the following operations: DENIED, Real value:");
        accessControl.accessControl(Roles.TELLER.name(), 3, "AlexHayes");
        accessControl.accessControl(Roles.TELLER.name(), 5, "AlexHayes");
        accessControl.accessControl(Roles.TELLER.name(), 4, "AlexHayes");
        accessControl.accessControl(Roles.TELLER.name(), 7, "AlexHayes");
        accessControl.accessControl(Roles.TELLER.name(), 6, "AlexHayes");

    }


}