package emsi.dev.util;

import org.mindrot.jbcrypt.BCrypt;

// Securite des MDP (hashage + verifcation)
public class BCryptUtil {
	
	// Hasher un MDP
	public static String hash(String password) {
		return BCrypt.hashpw(password, BCrypt.gensalt());
	}
	
	// Verifier un MDP
	public static boolean check(String password, String hashed) {
		return BCrypt.checkpw(password, hashed);
	}

}
