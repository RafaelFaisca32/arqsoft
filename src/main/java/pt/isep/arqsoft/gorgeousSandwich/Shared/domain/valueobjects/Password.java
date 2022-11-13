package pt.isep.arqsoft.gorgeousSandwich.Shared.domain.valueobjects;

import pt.isep.arqsoft.gorgeousSandwich.Shared.exceptions.BusinessRuleViolationException;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;
import java.util.function.IntPredicate;

public class Password {

    private final String password;

    public Password(String password) throws BusinessRuleViolationException, InvalidKeySpecException, NoSuchAlgorithmException {
        if(isValid(password)){
            SecureRandom secureRandom = new SecureRandom();
            byte[] salt = secureRandom.generateSeed(12);
            PBEKeySpec pbeKeySpec = new PBEKeySpec(password.toCharArray(), salt, 10, 512);
            SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
            byte[] hash = skf.generateSecret(pbeKeySpec).getEncoded();
            this.password = Base64.getMimeEncoder().encodeToString(hash);
        }
        else {
            throw new BusinessRuleViolationException("Invalid password, it need to be at least " +
                    "8 characters long, with an Upper Case letter and contain a number");
        }
    }

    public String getPassword() {
        return password;
    }

    public boolean isValid(String password) {
        char uppercase;
        if(password!=null && !password.isEmpty() && password.length() >= 8
                && containsUpperCase(password) && containsNumber(password)){
            return true;
        } else {
            return false;
        }
    }

    private boolean containsUpperCase(String value) {
        return contains(value, i -> Character.isLetter(i) && Character.isUpperCase(i));
    }

    private boolean containsNumber(String value) {

        return contains(value, Character::isDigit);
    }

    private boolean contains(String value, IntPredicate predicate) {

        return value.chars().anyMatch(predicate);
    }
}
