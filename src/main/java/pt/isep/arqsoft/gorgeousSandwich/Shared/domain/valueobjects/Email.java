package pt.isep.arqsoft.gorgeousSandwich.Shared.domain.valueobjects;

import pt.isep.arqsoft.gorgeousSandwich.Shared.exceptions.BusinessRuleViolationException;

public class Email {

    private final String email;

    public Email(String email) throws BusinessRuleViolationException{
        if(isValid(email)){
            this.email = email;
        } else {
            throw new BusinessRuleViolationException("Invalid email");
        }
    }

    public String getEmail() {
        return email;
    }

    public boolean isValid(String email) {
        if(email!=null && !email.isEmpty() && email.contains("@")){
            return true;
        } else {
            return false;
        }
    }
}
