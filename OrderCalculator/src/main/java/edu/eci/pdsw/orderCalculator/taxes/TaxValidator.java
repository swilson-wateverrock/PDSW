package edu.eci.pdsw.orderCalculator.taxes;

import edu.eci.pdsw.orderCalculator.model.Dish;

public interface TaxValidator {
	
	float getPercentage(Dish dish);

}
