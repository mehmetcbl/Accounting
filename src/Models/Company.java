/*
 * POWERED BY
 * 
 * OKAN ÜLKER - 17050111024
 * EMRE KÖRÜS - 16050111041
 * MEHMET ALİ CABİOĞLU - 16050111044
 */
package Models;


public class Company {
    private String companyName;
    private String companyOwner;
    private String companyPhoneNumber;
    private String companyEmail;
    private Long companyTaxNumber;
    private double balance = 0.0;
    private double debt = 0.0;
    private double claim = 0.0;

    public Company() {
    }
    
    public Company(String companyName, String companyOwner, String companyPhoneNumber, String companyEmail, Long companyTaxNumber) {
        this.companyName = companyName;
        this.companyOwner = companyOwner;
        this.companyPhoneNumber = companyPhoneNumber;
        this.companyEmail = companyEmail;
        this.companyTaxNumber = companyTaxNumber;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getCompanyOwner() {
        return companyOwner;
    }

    public String getCompanyPhoneNumber() {
        return companyPhoneNumber;
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    public Long getCompanyTaxNumber() {
        return companyTaxNumber;
    }

    public double getBalance() {
        return balance;
    }

    public double getDebt() {
        return debt;
    }

    public double getClaim() {
        return claim;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setCompanyOwner(String companyOwner) {
        this.companyOwner = companyOwner;
    }

    public void setCompanyPhoneNumber(String companyPhoneNumber) {
        this.companyPhoneNumber = companyPhoneNumber;
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }

    public void setCompanyTaxNumber(Long companyTaxNumber) {
        this.companyTaxNumber = companyTaxNumber;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setDebt(double debt) {
        this.debt = debt;
    }

    public void setClaim(double claim) {
        this.claim = claim;
    }

    @Override
    public String toString() {
                return companyName + " " + companyOwner + " " + companyPhoneNumber + " " + companyEmail + " " + companyTaxNumber + " " + balance + " " + debt + " " + claim ;
    }
    
    
    
}