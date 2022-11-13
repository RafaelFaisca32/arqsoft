package pt.isep.arqsoft.gorgeousSandwich.Shared.domain.valueobjects;

import pt.isep.arqsoft.gorgeousSandwich.Shared.domain.patterns.IValueObject;

public class Quantity implements IValueObject {

    private final int value;

    public Quantity(final int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
