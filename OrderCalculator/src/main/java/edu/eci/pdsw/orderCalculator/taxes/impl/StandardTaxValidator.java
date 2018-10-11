package edu.eci.pdsw.orderCalculator.taxes.impl;

import edu.eci.pdsw.orderCalculator.model.Dish;
import edu.eci.pdsw.orderCalculator.taxes.TaxValidator;

public class StandardTaxValidator implements TaxValidator {

	@Override
	public float getPercentage(Dish dish) {
		return 1.19f;
	}

}
