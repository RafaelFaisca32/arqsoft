package pt.isep.arqsoft.gorgeousSandwich.Shop.Domain;

import pt.isep.arqsoft.gorgeousSandwich.Shared.domain.patterns.IEntity;
import pt.isep.arqsoft.gorgeousSandwich.Shared.domain.patterns.IEntityId;
import pt.isep.arqsoft.gorgeousSandwich.Shared.domain.valueobjects.Name;
import pt.isep.arqsoft.gorgeousSandwich.Users.Domain.UserId;
import pt.isep.arqsoft.gorgeousSandwich.Util.Validations;

public class Manager implements IEntity<UserId> {
    private Name name;
    private UserId userId;

    public Manager(Name name, UserId userId) {
        Validations.notAnyNull(name,userId);
        Validations.notEmpty(name.getStringValue());
        this.name = name;
        this.userId = userId;
    }

    public Name getName() {
        return name;
    }

    @Override
    public boolean sameAs(IEntity<? extends IEntityId> otherEntity) {
        if (otherEntity instanceof Manager) {
            return userId.id().equals(((Manager) otherEntity).userId.id());
        }
        return false;
    }

    @Override
    public UserId obtainId() {
        return userId;
    }
}
