package edu.eci.pdsw.orderCalculator.injectors;

import com.google.inject.AbstractModule;

import edu.eci.pdsw.orderCalculator.calculator.BillCalculator;
import edu.eci.pdsw.orderCalculator.calculator.impl.BasicBillCalculator;
import edu.eci.pdsw.orderCalculator.calculator.impl.TaxBillCalculator;
import edu.eci.pdsw.orderCalculator.calculator.impl.TipBillCalculator;
import edu.eci.pdsw.orderCalculator.taxes.TaxValidator;
import edu.eci.pdsw.orderCalculator.taxes.impl.SpecialRegimeTaxValidator;
import edu.eci.pdsw.orderCalculator.taxes.impl.StandardTaxValidator;

@SuppressWarnings("unused")
public class CalculatorModule extends AbstractModule {
	
	@Override 
	protected void configure() {
	  
		bind(BillCalculator.class).to(TaxBillCalculator.class);
		bind(TaxValidator.class).to(SpecialRegimeTaxValidator.class);
		
	}
}
