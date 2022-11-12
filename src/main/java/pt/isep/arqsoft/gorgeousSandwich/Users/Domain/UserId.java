package pt.isep.arqsoft.gorgeousSandwich.Users.Domain;

import pt.isep.arqsoft.gorgeousSandwich.Sandwich.Domain.SandwichId;
import pt.isep.arqsoft.gorgeousSandwich.Shared.domain.patterns.EntityId;

public class UserId extends EntityId {

    public UserId() {
    }

    public UserId(String id) {
        super(id);
    }

}
