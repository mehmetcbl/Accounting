/*
 * POWERED BY
 * 
 * OKAN ÜLKER - 17050111024
 * EMRE KÖRÜS - 16050111041
 * MEHMET ALİ CABİOĞLU - 16050111044
 */
package Utils;

import Frames.LoginFrame;
import Models.Company;
import Models.FutureOperation;
import Models.InstantOperation;
import Models.Operation;
import Models.Product;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import models.User;

public class SystemFunctions {
    private static User user;
    private static Company company;
    private static ArrayList<Operation> operationList = new ArrayList();
    private static ArrayList<Product> productList = new ArrayList();

    public SystemFunctions() {
       
    }
    
    /**
     * CONTROL FUNCTIONS
     * @return 
     */
    public static boolean checkUser() {
        return user.equals(LoginFrame.defaultUser);
    }
    
    public static boolean checkCompany() {
        return user.getCompany() != null;
    }
    
    /**
     * DATABASE FUNCTIONS
     * @return 
     */
    public static void pullCompanyFromDataase() {
        
        File input = new File("CompanyInfo.txt");
		Scanner scanner;
		try {
			scanner = new Scanner(input);
			while(scanner.hasNext())
			{
                            String companyInfo = scanner.nextLine();
                            String [] arr = companyInfo.split(" ");
                                
				String companyName = arr[0];
                                String companyOwner= arr[1];
                                String companyPhoneNumber = arr[2];
                                String companyEmail = arr[3];
                                Long companyTaxNumber = Long.parseLong(arr[4]);
                                double balance = Double.parseDouble(arr[5]);
                                double debt = Double.parseDouble(arr[6]);
                                double claim = Double.parseDouble(arr[7]);
				company = new Company(companyName.replace("&", " "), companyOwner.replace("&", " "), companyPhoneNumber.replace("&", " "), companyEmail, companyTaxNumber);
                                company.setBalance(balance);
                                company.setDebt(debt);
                                company.setClaim(claim);
			}
			scanner.close();
			
		} catch (FileNotFoundException e) {
		}
    }
    
    public static void pullOperationsFromDatabase() {
        File input = new File("OperationInfo.txt");
	Scanner scanner;
            try {
		scanner = new Scanner(input);
		while(scanner.hasNext())
		{
                    String operation = scanner.nextLine();
                    String [] arr = operation.split(" ");
                    String operationType = arr[0];
                    int barcode = Integer.parseInt(arr[1]);
                    String name = arr[2];
                    int stock = Integer.parseInt(arr[3]);
                    double price = Double.parseDouble(arr[4]);
                    double valueAddedTax = Double.parseDouble(arr[5]);
                    double discount = Double.parseDouble(arr[6]);
                    Product product = new Product(barcode, name.replace("&", " "), stock, price); 
                    
                        if (arr.length > 7) {
                        
                            String deadline = arr[7];
                            double interestRate = Double.parseDouble(arr[8]);
                        
                            FutureOperation myFutureOperation = new FutureOperation(operationType, product, valueAddedTax, discount, deadline, interestRate);
                            operationList.add(myFutureOperation);
                        }
                        else{
                                    
                            InstantOperation myInstantOperation = new InstantOperation(operationType, product, valueAddedTax, discount);
                            operationList.add(myInstantOperation);
                        }     
                    }
                    scanner.close();
			
            } catch (FileNotFoundException e) {
      
	}    
    }
    
    public static void pullProductsFromDatabase() {
        File input = new File("ProductsInfo.txt");
	Scanner scanner;
            try {
		scanner = new Scanner(input);
		while(scanner.hasNext())
		{
                    String products = scanner.nextLine();
                    String [] arr = products.split(" ");
                    int barcode = Integer.parseInt(arr[0]);
                    String name = arr[1];
                    int stock = Integer.parseInt(arr[2]);
                    double price = Double.parseDouble(arr[3]);
                
                    Product myProduct = new Product(barcode, name.replace("&", " "), stock, price);
                    productList.add(myProduct);
                    }
                    scanner.close();
			
            } catch (FileNotFoundException e) {
       
	}    
           
           
    }
    
    public static void saveCompanyToDatabase(){
      
        try {
            File output = new File("CompanyInfo.txt");
            PrintWriter pr = new PrintWriter(output);
            
            String companyName = company.getCompanyName().replace(" ", "&");
            String companyOwner = company.getCompanyOwner().replace(" ", "&");
            String phoneNumber = company.getCompanyPhoneNumber().replace(" ", "&");
            pr.print(companyName + " ");
            pr.print(companyOwner + " ");
            pr.print(phoneNumber + " ");
            pr.print(company.getCompanyEmail() + " ");
            pr.print(company.getCompanyTaxNumber() + " ");
            pr.print(company.getBalance() + " ");
            pr.print(company.getDebt()+ " ");
            pr.print(company.getClaim());
            pr.println();
            pr.close();
        } catch (Exception ex) {
       
        } 
    }
    
    public static void saveOperationsToDatabase(){
        try {
            File output = new File("OperationInfo.txt");
            PrintWriter pr = new PrintWriter(output);
            
            for (int i = 0; i < operationList.size(); i++) {
                pr.print(operationList.get(i).getOperationType() + " ");
                pr.print(operationList.get(i).getProduct().getBarcode() + " ");
                String productName = operationList.get(i).getProduct().getName().replace(" ", "&");
                pr.print(productName + " ");
                pr.print(operationList.get(i).getProduct().getStock()+ " ");
                pr.print(operationList.get(i).getProduct().getPrice()+ " ");
                pr.print(operationList.get(i).getValueAddedTax()+ " ");
                
                    if(operationList.get(i) instanceof FutureOperation){
                        pr.print(((InstantOperation)(operationList.get(i))).getDiscount()+ " ");
                        pr.print(((FutureOperation)(operationList.get(i))).getDeadline() + " ");
                        pr.print(((FutureOperation)(operationList.get(i))).getInterestRate() + " ");
                        pr.println();
                    
                        
                    }
                    else{
                       pr.print(((InstantOperation)(operationList.get(i))).getDiscount()+ " ");
                       pr.println();                    
                    }
            
        }
          
            pr.close();
        } catch (Exception ex) {
      
        } 
    }
    
    public static void saveProductsToDatabase() {
        try {
            File output = new File("ProductsInfo.txt");
            PrintWriter pr = new PrintWriter(output);
            
            for (int i = 0; i < productList.size(); i++) {
                pr.print(productList.get(i).getBarcode() + " ");
                String productName = productList.get(i).getName().replace(" ", "&");
                pr.print(productName + " ");
                pr.print(productList.get(i).getStock() + " ");
                pr.print(productList.get(i).getPrice());
                pr.println();
            }
	
            pr.close();
        } catch (Exception ex) {
        } 
    }
    
    public static boolean isOperationAvailable(Operation operation) {
      
          
        if (operation.getOperationType().equals("Claim")) {
            
            for (int i = 0; i < productList.size(); i++) {
                
                if (productList.get(i).getBarcode() == operation.getProduct().getBarcode() && productList.get(i).getStock() >= operation.getProduct().getStock()) {
                    return true;
                }
            }
            return false;
        }
        
        return true;
    }
    
    public static void addOperation(Operation operation) {
        
        if (operation.getOperationType().equals("Claim")) {
            
            for (int i = 0; i < productList.size(); i++) {
                
                if (productList.get(i).getBarcode() == operation.getProduct().getBarcode()) {
                
                    productList.get(i).setStock(productList.get(i).getStock() - operation.getProduct().getStock());
                }
            }
            
            // for updating 'current' balance of company
            if (operation instanceof InstantOperation) {
            
                InstantOperation opp = (InstantOperation) operation;

                if (!(opp instanceof FutureOperation)) {
                    opp.calculatePriceAfterValueAddedTax();
                    opp.calculatePriceAfterDiscount();
                    company.setBalance(company.getBalance() + opp.getProduct().getPrice());
                }
                else {
                    ((FutureOperation)opp).calculatePriceAfterValueAddedTax();
                    ((FutureOperation)opp).calculatePriceAfterDiscount();
                    ((FutureOperation)opp).calculatePriceAfterInterestRate();
                    company.setClaim(company.getClaim() + opp.getProduct().getPrice());
                }
                opp.getProduct().setPrice(formatDouble(opp.getProduct().getPrice()));
                operationList.add(opp);
            
            }
            
        }
        
        else {
            
            //control for if same products in list
            boolean flag = false;
            
            for (int i = 0; i < productList.size(); i++) {
                
                if (productList.get(i).getBarcode() == operation.getProduct().getBarcode()) {
                
                    productList.get(i).setStock(productList.get(i).getStock() + operation.getProduct().getStock());
                    flag = true;
                }
            }
            
            if (!flag) {
                Product product = new Product(operation.getProduct().getBarcode(), operation.getProduct().getName(), operation.getProduct().getStock(), operation.getProduct().getPrice());
                productList.add(product);
            }
            
            // for updating 'current' balance of company
            if (operation instanceof InstantOperation) {
            
                InstantOperation opp = (InstantOperation) operation;

                if (!(opp instanceof FutureOperation)) {
                    opp.calculatePriceAfterDiscount();
                    opp.calculatePriceAfterValueAddedTax();
                    
                    company.setBalance(company.getBalance() - opp.getProduct().getPrice());
                }
                else {
                    ((FutureOperation)opp).calculatePriceAfterValueAddedTax();
                    ((FutureOperation)opp).calculatePriceAfterDiscount();
                    ((FutureOperation)opp).calculatePriceAfterInterestRate();
                    company.setDebt(company.getDebt()+ opp.getProduct().getPrice());
                }
                
                opp.getProduct().setPrice(formatDouble(opp.getProduct().getPrice()));
                operationList.add(opp);
            }
            
        }
        
        saveOperationsToDatabase();
        saveProductsToDatabase();
    }
    
    /**
     * UTILS
     * @param nextFrame
     * @param currentFrame 
     */
    public static void changeToFrame(javax.swing.JFrame nextFrame, javax.swing.JFrame currentFrame){
        nextFrame.setVisible(true);
        currentFrame.setVisible(false);
    }
    
    public static long getTimeDifference(String dateString) throws ParseException {
        SimpleDateFormat myFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date1 = new Date();
        Date date2 = myFormat.parse(dateString);
        long diff = date2.getTime() - date1.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }
    
     public static boolean checkRemindMe(){
   
      File input = new File("Selected.txt");
	Scanner scanner;
        String str;
        
            try {
		scanner = new Scanner(input);		
                str = scanner.nextLine();
  
                scanner.close();
			
            } catch (FileNotFoundException e) {
                return false;
	}
        return str.equalsIgnoreCase("true");
           
    }
    
     public static void saveRemindMeToDatabase(boolean flag){
        
         try {
            File output = new File("Selected.txt");
            PrintWriter pr = new PrintWriter(output);
            if(flag){
               pr.print("true");
            }
            else{
                pr.print("false");
            }            
            pr.close();
        } catch (Exception ex) {
            return;
        } 
    }
     
     public static double formatDouble(double value) {
         int places = 2;
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }   
    
    /**
     * GETTERS - SETTERS
     * @return 
     */
    public static Company getCompany() {
        return company;
    }

    public static void setCompany(Company company) {
        SystemFunctions.company = company;
    }

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        SystemFunctions.user = user;
    }

    public static ArrayList<Operation> getOperationList() {
        return operationList;
    }

    public static void setOperationList(ArrayList<Operation> operationList) {
        SystemFunctions.operationList = operationList;
    }    

    public static ArrayList<Product> getProductList() {
        
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getStock() == 0) {
                productList.remove(i);
            }
        }
        
        return productList;
    }

    public static void setProductList(ArrayList<Product> productList) {
        SystemFunctions.productList = productList;
    }
}
