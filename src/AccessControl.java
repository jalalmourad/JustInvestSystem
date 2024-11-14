import jdk.dynalink.Operation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AccessControl {

    private static final Map<String, Set<Integer>> ROLE_PERMISSIONS = new HashMap<>();
    static {
        ROLE_PERMISSIONS.put(Roles.CLIENT.name(),Set.of(1,2,4));
        ROLE_PERMISSIONS.put(Roles.PREMIUM_CLIENT.name(), Set.of(3,5));
        ROLE_PERMISSIONS.put(Roles.FINANCIAL_ADVISOR.name(), Set.of(1, 2, 3, 7));
        ROLE_PERMISSIONS.put(Roles.FINANCIAL_PLANNER.name(), Set.of(1, 2, 3, 6, 7));
        ROLE_PERMISSIONS.put(Roles.TELLER.name(), Set.of(1, 2));
    }

    private static final Map<Integer, String> OPERATION_DESCRIPTIONS = new HashMap<>();
    static {
        OPERATION_DESCRIPTIONS.put(1, "Permission \u001B[32mGRANTED\u001B[0m to View account balance");
        OPERATION_DESCRIPTIONS.put(2, "Permission \u001B[32mGRANTED\u001B[0m to View investment portfolio");
        OPERATION_DESCRIPTIONS.put(3, "Permission \u001B[32mGRANTED\u001B[0m to Modify investment portfolio");
        OPERATION_DESCRIPTIONS.put(4, "Permission \u001B[32mGRANTED\u001B[0m to View Financial Advisor contact info");
        OPERATION_DESCRIPTIONS.put(5, "Permission \u001B[32mGRANTED\u001B[0m to View Financial Planner contact info");
        OPERATION_DESCRIPTIONS.put(6, "Permission \u001B[32mGRANTED\u001B[0m to View money market instruments");
        OPERATION_DESCRIPTIONS.put(7, "Permission \u001B[32mGRANTED\u001B[0m to View private consumer instruments");
        OPERATION_DESCRIPTIONS.put(0, "User successfully logged out");
    }

    public void accessControl(String role,int operation,String username) throws IOException {
        if (operation == 0) {
            System.out.println("User: " + username + " is successfully logged out");
            System.exit(0);
        }

        Set<Integer> permissions = ROLE_PERMISSIONS.get(role.toUpperCase());

        if (permissions != null && permissions.contains(operation)) {
            System.out.println(OPERATION_DESCRIPTIONS.getOrDefault(operation, "Operation Not Available"));
        } else {
            System.out.println("Permission \u001B[31mDENIED\u001B[0m for this operation.");
        }
    }

    public String returnPermissionID(int permissionIndex){
        ArrayList<String> permissions = new ArrayList<>();
        permissions.add("1");
        permissions.add("2");
        permissions.add("3");
        permissions.add("4");
        permissions.add("5");
        permissions.add("6");
        permissions.add("7");
        return permissions.get(permissionIndex);
    }

    //Assign permissions for users
    public String permissions(int userID){
        if (userID == Roles.CLIENT.getValue()){
            return returnPermissionID(0)+", "+returnPermissionID(1)+", "+returnPermissionID(3);
        }
        if (userID == Roles.PREMIUM_CLIENT.getValue()){
            return returnPermissionID(2)+", "+returnPermissionID(4);
        }
        if (userID == Roles.FINANCIAL_ADVISOR.getValue()){
            return returnPermissionID(0)+", "+returnPermissionID(1)+", "+returnPermissionID(2)+", "+returnPermissionID(6);
        }
        if (userID == Roles.FINANCIAL_PLANNER.getValue()){
            return returnPermissionID(0)+", "+returnPermissionID(1)+", "+returnPermissionID(2)+", "+returnPermissionID(5)+", "+returnPermissionID(6);
        }
        if (userID == Roles.TELLER.getValue()){
            return returnPermissionID(0)+", "+returnPermissionID(1);
        }
        return "No Permissions";
    }


    public static void main(String[] args) throws IOException {
        AccessControl accessControl = new AccessControl();
    }
}
