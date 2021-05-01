/*
 * POWERED BY
 * 
 * OKAN ÜLKER - 17050111024
 * EMRE KÖRÜS - 16050111041
 * MEHMET ALİ CABİOĞLU - 16050111044
 */
package Models;

public abstract class Operation {
    
    private String operationType;
    private Product product;
    private double valueAddedTax;
    
    public Operation(String operationType, Product product, double valueAddedTax) {
        this.operationType = operationType;
        this.product = product;
        this.valueAddedTax = valueAddedTax;
    }
    
    public abstract void calculatePriceAfterValueAddedTax();

    public String getOperationType() {
        return operationType;
    }

    public Product getProduct() {
        return product;
    }

    public double getValueAddedTax() {
        return valueAddedTax;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setValueAddedTax(double valueAddedTax) {
        this.valueAddedTax = valueAddedTax;
    }

    @Override
    public String toString() {
         return operationType + " " + product + " " + valueAddedTax;
    }
    
}