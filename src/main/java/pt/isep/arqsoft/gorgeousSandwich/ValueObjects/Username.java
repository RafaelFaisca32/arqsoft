package pt.isep.arqsoft.gorgeousSandwich.ValueObjects;

public class Username {

    private final String username;

    public Username(String username) {
        if(isValid(username)){
            this.username = username;
        } else {
            throw new IllegalArgumentException("Invalid username");
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
