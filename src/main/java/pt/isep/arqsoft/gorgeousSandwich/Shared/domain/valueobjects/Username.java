package pt.isep.arqsoft.gorgeousSandwich.Shared.domain.valueobjects;

import pt.isep.arqsoft.gorgeousSandwich.Shared.exceptions.BusinessRuleViolationException;

public class Username {

    private final String username;

    public Username(String username) throws BusinessRuleViolationException {
        if(isValid(username)){
            this.username = username;
        } else {
            throw new BusinessRuleViolationException("Invalid username");
        }
    }

    public String getUsername() {
        return username;
    }

    public boolean isValid(String username) {
        if(username!=null && !username.isEmpty()){
            return true;
        } else {
            return false;
        }
    }
}
