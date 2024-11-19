import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class PasswordGenerator {

    private String saltValue;

    /**
     * This method is used to create a salt
     */
    public String createSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        saltValue = Base64.getEncoder().encodeToString(salt);
        return Base64.getEncoder().encodeToString(salt);
    }

    /**
     *This method returns the hashed value of the password with the salt
     */
    public String hashedPasswordWithSaltChecker(String password, String salt) throws NoSuchAlgorithmException {

        MessageDigest digest =MessageDigest.getInstance("SHA-256");
        String saltedPassword = password +salt;
        byte[] hash= digest.digest(saltedPassword.getBytes());
        StringBuilder hexString = new StringBuilder();
        for (byte b:hash) {
            hexString.append(String.format("%02x",b));
        }
        return hexString.toString();
    }
}
