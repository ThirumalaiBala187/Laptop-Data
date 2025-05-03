package model.DAO;
import org.mindrot.jbcrypt.BCrypt;

public class PasswordUtil {
	
	public static String HashPassword(String password) {
		return BCrypt.hashpw(password, BCrypt.gensalt(12));
	}
	
	public static boolean ValidatePassword(String enteredPassword, String storedHash) {
		return BCrypt.checkpw(enteredPassword, storedHash);
	}
}
