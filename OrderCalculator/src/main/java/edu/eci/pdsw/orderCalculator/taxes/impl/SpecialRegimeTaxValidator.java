package edu.eci.pdsw.orderCalculator.taxes.impl;

import edu.eci.pdsw.orderCalculator.model.Dish;
import edu.eci.pdsw.orderCalculator.model.DishType;
import edu.eci.pdsw.orderCalculator.taxes.TaxValidator;

public class SpecialRegimeTaxValidator implements TaxValidator {

	@Override
	public float getPercentage(Dish dish) {
		if (dish.getType().equals(DishType.DRINK) && dish.getCalories() >= 110) {
			return 1.29f;
		} else { 
			return 1.19f;
		}
	}

}
