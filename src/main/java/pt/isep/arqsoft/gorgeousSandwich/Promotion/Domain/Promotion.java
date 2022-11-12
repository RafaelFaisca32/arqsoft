package pt.isep.arqsoft.gorgeousSandwich.Promotion.Domain;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import pt.isep.arqsoft.gorgeousSandwich.Shared.domain.patterns.IAggregateRoot;
import pt.isep.arqsoft.gorgeousSandwich.Shared.domain.patterns.IEntity;
import pt.isep.arqsoft.gorgeousSandwich.Shared.domain.patterns.IEntityId;
import pt.isep.arqsoft.gorgeousSandwich.Shared.domain.valueobjects.Percentage;
import pt.isep.arqsoft.gorgeousSandwich.Shared.domain.valueobjects.TimeOfEffect;

@Document("promotion")
public abstract class Promotion implements IAggregateRoot<PromotionId> {
    @Id
    private PromotionId id;
    private TimeOfEffect timeOfEffect;
    private Percentage percentage;

    private PromotionType type;

    Promotion(TimeOfEffect timeOfEffect, Percentage percentage, PromotionType type) {
        this.id = new PromotionId();
        this.timeOfEffect = timeOfEffect;
        this.percentage = percentage;
        this.type=type;
    }

    Promotion(PromotionId id, TimeOfEffect timeOfEffect, Percentage percentage, PromotionType type) {
        this.id = id;
        this.timeOfEffect = timeOfEffect;
        this.percentage = percentage;
        this.type=type;
    }

    @Override
    public boolean sameAs(IEntity<? extends IEntityId> otherEntity) {
        if (otherEntity instanceof Promotion) {
            Promotion otherPromotion = ((Promotion) otherEntity);
            return obtainId().id().equals(otherPromotion.obtainId().id());
        }
        return false;
    }

    @Override
    public PromotionId obtainId() {
        return id;
    }

    public TimeOfEffect getTimeOfEffect() {
        return timeOfEffect;
    }

    public Percentage getPercentage() {
        return percentage;
    }

    public PromotionType getType() {
        return type;
    }
}
