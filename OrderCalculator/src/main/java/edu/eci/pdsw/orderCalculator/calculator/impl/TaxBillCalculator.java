package edu.eci.pdsw.orderCalculator.calculator.impl;

import com.google.inject.Inject;

import edu.eci.pdsw.orderCalculator.calculator.BillCalculator;
import edu.eci.pdsw.orderCalculator.model.Dish;
import edu.eci.pdsw.orderCalculator.model.Order;
import edu.eci.pdsw.orderCalculator.taxes.TaxValidator;

public class TaxBillCalculator implements BillCalculator {
	
	private final TaxValidator validator;
	
	@Inject
	public TaxBillCalculator(TaxValidator validator) {
		this.validator = validator;
	}

	@Override
	public int calculatePrice(Order order) {
		int total = 0;
        for (Dish dish : order.getDishes()){
            total += dish.getPrice() * validator.getPercentage(dish);
        }
        return total;
	}

}
