/*
 * POWERED BY
 * 
 * OKAN ÜLKER - 17050111024
 * EMRE KÖRÜS - 16050111041
 * MEHMET ALİ CABİOĞLU - 16050111044
 */
package Models;

public class Product {
    private int barcode;
    private String name;
    private int stock;
    private double price;

    public Product(int barcode, String name, int stock, double price) {
        this.barcode = barcode;
        this.name = name;
        this.stock = stock;
        this.price = price;
    }

    public int getBarcode() {
        return barcode;
    }

    public String getName() {
        return name;
    }

    public int getStock() {
        return stock;
    }

    public double getPrice() {
        return price;
    }

    public void setBarcode(int barcode) {
        this.barcode = barcode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return barcode + " " + name + " " + stock + " " + price;
    }
}
