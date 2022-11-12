package pt.isep.arqsoft.gorgeousSandwich.Users.Domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import pt.isep.arqsoft.gorgeousSandwich.Shared.domain.valueobjects.Email;
import pt.isep.arqsoft.gorgeousSandwich.Shared.domain.valueobjects.Password;
import pt.isep.arqsoft.gorgeousSandwich.Shared.domain.valueobjects.TaxIdentification;
import pt.isep.arqsoft.gorgeousSandwich.Shared.domain.valueobjects.Username;

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

    public Password getPassword() {
        return password;
    }

    public TaxIdentification getTaxIdentification() {
        return taxIdentification;
    }

    public Username getUsername() {
        return username;
    }

}
