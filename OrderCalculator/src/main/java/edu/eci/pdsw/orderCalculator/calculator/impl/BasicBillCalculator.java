package edu.eci.pdsw.orderCalculator.calculator.impl;

import edu.eci.pdsw.orderCalculator.calculator.BillCalculator;
import edu.eci.pdsw.orderCalculator.model.Dish;
import edu.eci.pdsw.orderCalculator.model.Order;

public class BasicBillCalculator implements BillCalculator {

	@Override
    public int calculatePrice(Order order) {
        int total = 0;
        for (Dish dish : order.getDishes()){
            total += dish.getPrice();
        }
        return total;
    }
}
