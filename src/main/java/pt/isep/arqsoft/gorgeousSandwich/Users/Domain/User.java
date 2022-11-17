package pt.isep.arqsoft.gorgeousSandwich.Users.Domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import pt.isep.arqsoft.gorgeousSandwich.Shared.domain.patterns.IEntity;
import pt.isep.arqsoft.gorgeousSandwich.Shared.domain.patterns.IEntityId;
import pt.isep.arqsoft.gorgeousSandwich.Shared.domain.valueobjects.Email;
import pt.isep.arqsoft.gorgeousSandwich.Shared.domain.valueobjects.Password;
import pt.isep.arqsoft.gorgeousSandwich.Shared.domain.valueobjects.TaxIdentification;
import pt.isep.arqsoft.gorgeousSandwich.Shared.domain.valueobjects.Username;

@Document("user")
public class User implements IEntity<UserId> {

    @Id
    private UserId id;
    @Indexed(unique = true)
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

    @Override
    public boolean sameAs(IEntity<? extends IEntityId> otherEntity) {
        if (otherEntity instanceof User){
            return obtainId().equals(((User) otherEntity).obtainId());
        }
        return false;
    }

    @Override
    public UserId obtainId() {
        return id;
    }
}
