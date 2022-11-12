package pt.isep.arqsoft.gorgeousSandwich.Shared.domain.patterns;

import pt.isep.arqsoft.gorgeousSandwich.Util.Validations;

import java.util.Objects;
import java.util.Random;

public class EntityId implements IEntityId{
    private static final String CHARS_TO_STRING = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ01234567899";
    private static final int LEN = CHARS_TO_STRING.length();
    private String id;

    protected EntityId() {
        id=generateId();
    }

    protected EntityId(String id){
        Validations.matchesRegex(id,"^([a-zA-Z0-9]{8}-){2}[a-zA-Z0-9]{8}$");
        this.id=id;
    }

    private static String generateId() {
        Random randomObject = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 8; j++) {
                int randomNum = randomObject.nextInt(LEN);
                sb.append(CHARS_TO_STRING.charAt(randomNum));
            }
            if (i!=2) {
                sb.append("-");
            }
        } return sb.toString();
    }


    protected void setId(String id){
        this.id=id;
    }
    @Override
    public String id() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EntityId)) return false;
        EntityId entityId = (EntityId) o;
        return Objects.equals(id, entityId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
