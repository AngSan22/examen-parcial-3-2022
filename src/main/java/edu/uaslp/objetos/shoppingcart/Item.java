package edu.uaslp.objetos.shoppingcart;

import java.math.BigDecimal;

public class Item {
    private String code;
    private String providerCode;
    private int quantity;
    private BigDecimal unitCost;

    public Item(String code, String providerCode, BigDecimal unitCost, int quantity) {
        if (code == null || code == ""){
            throw new InvalidDataException("Null or empty string not allowed for item code");
        }if (providerCode == null || providerCode == ""){
            throw new InvalidDataException("Null or empty string not allowed for provider code");
        }if (unitCost.compareTo(new BigDecimal("0")) <= 0){
            throw new InvalidDataException("Cost must be greater than zero");
        }if (quantity < 0 || quantity > 5) {
            throw new InvalidDataException("Quantity must be greater than zero and lower than 5");
        }
        this.code = code;
        this.providerCode = providerCode;
        this.unitCost = unitCost;
        this.quantity = quantity;
    }

    public Item() {

    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setProviderCode(String providerCode) {
        this.providerCode = providerCode;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setUnitCost(BigDecimal unitCost) {
        this.unitCost = unitCost;
    }

    public String getCode() {
        return code;
    }

    public String getProviderCode() {
        return providerCode;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getUnitCost() {
        return unitCost;
    }
}
