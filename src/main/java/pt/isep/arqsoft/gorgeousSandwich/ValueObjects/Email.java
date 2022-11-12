package pt.isep.arqsoft.gorgeousSandwich.ValueObjects;

public class Email {

    private final String email;

    public Email(String email) {
        if(isValid(email)){
            this.email = email;
        } else {
            throw new IllegalArgumentException("Invalid email");
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
