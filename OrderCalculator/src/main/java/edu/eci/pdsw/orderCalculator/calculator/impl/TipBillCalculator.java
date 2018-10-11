package edu.eci.pdsw.orderCalculator.calculator.impl;

import edu.eci.pdsw.orderCalculator.calculator.BillCalculator;
import edu.eci.pdsw.orderCalculator.model.Dish;
import edu.eci.pdsw.orderCalculator.model.Order;

public class TipBillCalculator implements BillCalculator {

	@Override
	public int calculatePrice(Order order) {
		int total = 0;
        for (Dish dish : order.getDishes()){
            total += dish.getPrice();
        }
        if (total >= 15000) {
        	total *= 1.1;
        }
        return total;
	}

}
