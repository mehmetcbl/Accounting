/*
 * POWERED BY
 * 
 * OKAN ÜLKER - 17050111024
 * EMRE KÖRÜS - 16050111041
 * MEHMET ALİ CABİOĞLU - 16050111044
 */
package Models;

import Interfaces.Discount;

public class InstantOperation extends Operation implements Discount{

    private double discount;
    
    public InstantOperation(
                            String operationType, 
                            Product product, 
                            double valueAddedTax,
                            double discount) {
        super(operationType, product, valueAddedTax);
        this.discount = discount;
    }

    @Override
    public void calculatePriceAfterDiscount() {
        getProduct().setPrice(getProduct().getPrice() - ((this.getProduct().getPrice())*(this.discount))/100);
    }

    @Override
    public void calculatePriceAfterValueAddedTax() {
        getProduct().setPrice(getProduct().getPrice() + ((this.getProduct().getPrice())*(getValueAddedTax()))/100);
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return super.toString() + " " + discount;
    }
    
}
