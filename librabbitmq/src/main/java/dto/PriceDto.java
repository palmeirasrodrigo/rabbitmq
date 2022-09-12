package dto;

import java.io.Serializable;

public class PriceDto implements Serializable {
    private String productCode;
    private double price;

    public PriceDto() {
    }

    public PriceDto(String productCode, double price) {
        this.productCode = productCode;
        this.price = price;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
