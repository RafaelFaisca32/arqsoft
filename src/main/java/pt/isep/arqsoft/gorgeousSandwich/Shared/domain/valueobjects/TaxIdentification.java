package pt.isep.arqsoft.gorgeousSandwich.Shared.domain.valueobjects;

import pt.isep.arqsoft.gorgeousSandwich.Shared.exceptions.BusinessRuleViolationException;

public class TaxIdentification {

    private final String taxIdentification;

    public TaxIdentification(String taxIdentification) throws BusinessRuleViolationException {
        if(isValid(taxIdentification)) {
            this.taxIdentification = taxIdentification;
        } else {
            throw new BusinessRuleViolationException("Invalid taxIdentification");
        }
    }

    public String getTaxIdentification() {
        return taxIdentification;
    }

    public boolean isValid(String taxIdentification) {
        if(taxIdentification!=null && !taxIdentification.isEmpty() && taxIdentification.length()==9){
            return true;
        } else {
            return false;
        }
    }
}
