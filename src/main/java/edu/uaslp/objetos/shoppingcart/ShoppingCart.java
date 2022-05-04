package edu.uaslp.objetos.shoppingcart;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.OptionalDouble;

public class ShoppingCart {
    List<Item> shoppingCart = new ArrayList<>();
    int itemsCount = 0;
    public boolean isEmpty() {
        if (shoppingCart.size() > 0){
            return false;
        }
        return true;
    }


    public BigDecimal getTotalCost() {
        if (isEmpty()) {
            throw new EmptyShoppingCartException();
        }
        BigDecimal totalCost = BigDecimal.ZERO;

        for(Item item: shoppingCart){
            totalCost = totalCost.add(item.getUnitCost().multiply(BigDecimal.valueOf(item.getQuantity())));
        }

        return totalCost;

    }

    public void addItem(Item item) {
        for (Item item1: shoppingCart){
            if (item1.getCode() == item.getCode() && item1.getUnitCost().compareTo(item.getUnitCost()) == 0){
                item1.setQuantity(item1.getQuantity() + item.getQuantity());
                return;
            }
        }

        shoppingCart.add(item);
    }

    public int getItemsCount() {
        for (int i=0; i<shoppingCart.size(); i++){
            itemsCount = itemsCount + shoppingCart.get(i).getQuantity();
        }
        return itemsCount;
    }

    public List<Item> getItems() {
        return shoppingCart;
    }

    public void removeItem(String code) {
        for (Item item : shoppingCart){
            if (item.getCode() == code){
                item.setQuantity(item.getQuantity() - 1);
                if (item.getQuantity() == 0){
                    shoppingCart.remove(item);
                }
                break;
            }
        }
    }
}
