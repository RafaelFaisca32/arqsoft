package pt.isep.arqsoft.gorgeousSandwich.Users.Domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import pt.isep.arqsoft.gorgeousSandwich.Sandwich.Domain.Sandwich;
import pt.isep.arqsoft.gorgeousSandwich.ValueObjects.Email;
import pt.isep.arqsoft.gorgeousSandwich.ValueObjects.Password;
import pt.isep.arqsoft.gorgeousSandwich.ValueObjects.TaxIdentification;
import pt.isep.arqsoft.gorgeousSandwich.ValueObjects.Username;

@Document("user")
public class User {

    @Id
    private UserId id;
    private Email email;
    private Password password;
    private TaxIdentification taxIdentification;
    private Username username;

    public User(Email email, Password password, TaxIdentification taxIdentification, Username username) {
        id = new UserId();
        this.email = email;
        this.password = password;
        this.taxIdentification = taxIdentification;
        this.username = username;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public Password getPassword() {
        return password;
    }

    public void setPassword(Password password) {
        this.password = password;
    }

    public TaxIdentification getTaxIdentification() {
        return taxIdentification;
    }

    public void setTaxIdentification(TaxIdentification taxIdentification) {
        this.taxIdentification = taxIdentification;
    }

    public Username getUsername() {
        return username;
    }

    public void setUsername(Username username) {
        this.username = username;
    }
}
