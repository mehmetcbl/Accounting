/*
 * POWERED BY
 * 
 * OKAN ÜLKER - 17050111024
 * EMRE KÖRÜS - 16050111041
 * MEHMET ALİ CABİOĞLU - 16050111044
 */
package Models;

import Interfaces.InterestRate;
import Utils.SystemFunctions;
import java.text.ParseException;

public class FutureOperation extends InstantOperation implements InterestRate {

    private String deadline; // DD MM YYYY 
    private double interestRate;

    public FutureOperation(String operationType, Product product, double valueAddedTax, double discount, String deadline, double interestRate) {
        super(operationType, product, valueAddedTax, discount);
        this.deadline = deadline;
        this.interestRate = interestRate;
    }
    
    @Override
    public void calculatePriceAfterInterestRate() {
        try {
            getProduct().setPrice(getProduct().getPrice() + (getProduct().getPrice()/100)*SystemFunctions.getTimeDifference(getDeadline())*getInterestRate());
        } catch (ParseException ex) {
            System.out.println("Wrong Date Format!!");
        }
    }

    public String getDeadline() {
        return deadline;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public String toString() {
        return super.toString()+" "+ deadline + " " + interestRate + " ";
    }
}
