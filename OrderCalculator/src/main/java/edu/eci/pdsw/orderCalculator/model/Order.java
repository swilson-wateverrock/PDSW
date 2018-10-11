package edu.eci.pdsw.orderCalculator.model;

import java.util.LinkedList;
import java.util.List;

public class Order {
	
    List<Dish> orders;

    public Order() {
        orders = new LinkedList<>();
    }

    public void addDish(Dish d) {
        orders.add(d);
    }

    public List<Dish> getDishes() {
        return orders;
    }

    @Override
    public String toString(){
        return orders.toString();
    }
    
}
