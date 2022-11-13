package pt.isep.arqsoft.gorgeousSandwich.Order.Domain;

import pt.isep.arqsoft.gorgeousSandwich.Shared.domain.patterns.EntityId;

public class OrderId extends EntityId {

    public OrderId() {
        super();
    }

    public OrderId(String id) {
        super(id);
    }
}
