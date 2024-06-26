package pt.isep.arqsoft.gorgeousSandwich.Shared.domain.valueobjects;

import pt.isep.arqsoft.gorgeousSandwich.Shared.exceptions.BusinessRuleViolationException;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.function.IntPredicate;

public class Password {

    private final String password;

    public Password(String password) throws BusinessRuleViolationException, NoSuchAlgorithmException {
        if(isValid(password)){
            this.password = password;
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
