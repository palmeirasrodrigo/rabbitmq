package dto;

import java.io.Serializable;

public class StockDto implements Serializable {
    private String productCode;
    private int amount;

    public StockDto() {
    }

    public StockDto(String productCode, int amount) {
        this.productCode = productCode;
        this.amount = amount;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
