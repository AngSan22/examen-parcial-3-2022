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
        for (int i=0; i<shoppingCart.size(); i++){
            if(shoppingCart.get(i).getCode() == item.getCode() && shoppingCart.get(i).getUnitCost() == item.getUnitCost()){
                shoppingCart.get(i).setQuantity(shoppingCart.get(i).getQuantity() + item.getQuantity());
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

    public void removeItem(String item) {
    }
}
