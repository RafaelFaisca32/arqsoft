package pt.isep.arqsoft.gorgeousSandwich.ValueObjects;

public class TaxIdentification {

    private final String taxIdentification;

    public TaxIdentification(String taxIdentification) {
        if(isValid(taxIdentification)) {
            this.taxIdentification = taxIdentification;
        } else {
            throw new IllegalArgumentException("Invalid taxIdentification");
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
