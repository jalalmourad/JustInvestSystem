import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class PasswordGenerator {

    private String saltValue;
    private String saltedPasswordValue;

    public String createSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        saltValue = Base64.getEncoder().encodeToString(salt);
        return Base64.getEncoder().encodeToString(salt);
    }

    public String getSaltValue(){
        return saltValue;
    }

    public String hashedPasswordWithSaltChecker(String password, String salt) throws NoSuchAlgorithmException {

        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        String saltedPassword = password + salt;
        byte[] hash = digest.digest(saltedPassword.getBytes());
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            hexString.append(String.format("%02x", b));
        }
        return hexString.toString();
    }

    public String hashPasswordWithSalt(String password) throws NoSuchAlgorithmException {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            String saltedPassword = password + createSalt();
            byte[] hash = digest.digest(saltedPassword.getBytes());

            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                hexString.append(String.format("%02x", b));
            }
            saltedPasswordValue = hexString.toString();
            return hexString.toString();
    }

    public String getHashedPasswordValue() {
        return saltedPasswordValue;
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {

        PasswordGenerator passwordGenerator = new PasswordGenerator();

        String password = "Jalal123";

        String salt = passwordGenerator.createSalt();
        System.out.println("Salt: " + salt);

        String hashedPassword = passwordGenerator.hashPasswordWithSalt(password);
        System.out.println("Salted and Hashed Password: " + hashedPassword);


        System.out.println(passwordGenerator.hashedPasswordWithSaltChecker("Jalal123",passwordGenerator.getSaltValue()));
        if ((passwordGenerator.hashedPasswordWithSaltChecker("Jalal123",passwordGenerator.getSaltValue())).equals(hashedPassword)){
            System.out.println("MATCHH");
        }
    }
}
