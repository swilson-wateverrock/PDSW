package edu.eci.pdsw.orderCalculator.calculator;

import static edu.eci.pdsw.orderCalculator.generators.Generators.orders;
import static org.quicktheories.QuickTheory.qt;

import org.junit.Test;

import edu.eci.pdsw.orderCalculator.calculator.impl.BasicBillCalculator;
import edu.eci.pdsw.orderCalculator.calculator.impl.TaxBillCalculator;
import edu.eci.pdsw.orderCalculator.calculator.impl.TipBillCalculator;
import edu.eci.pdsw.orderCalculator.model.Dish;
import edu.eci.pdsw.orderCalculator.model.DishType;
import edu.eci.pdsw.orderCalculator.model.Order;
import edu.eci.pdsw.orderCalculator.taxes.impl.SpecialRegimeTaxValidator;
import edu.eci.pdsw.orderCalculator.taxes.impl.StandardTaxValidator;

public class BillCalculatorTest {
	
	@Test
	public void BasicBillCalculationTest() {
		BasicBillCalculator calculator = new BasicBillCalculator();
		qt().forAll(orders().orderAnything()).check(orderList -> {
			Order order = new Order();
			int price = 0;
			for (Dish dish: orderList) {
				order.addDish(dish);
				price += dish.getPrice();
			}
			return price == calculator.calculatePrice(order);
		});
	}
	
	@Test
	public void TipBillCalculationTest() {
		TipBillCalculator calculator = new TipBillCalculator();
		qt().forAll(orders().orderAnything()).check(orderList -> {
			Order order = new Order();
			int price = 0;
			for (Dish dish: orderList) {
				order.addDish(dish);
				price += dish.getPrice();
			}
			if (price >= 15000) {
				price *= 1.1;
			}
			return price == calculator.calculatePrice(order);
		});
	}
	
	@Test
	public void StandardTaxBillCalculationTest() {
		TaxBillCalculator calculator = new TaxBillCalculator(new StandardTaxValidator());
		qt().forAll(orders().orderAnything()).check(orderList -> {
			Order order = new Order();
			int price = 0;
			for (Dish dish: orderList) {
				order.addDish(dish);
				price += dish.getPrice() * 1.19;
			}
			return price == calculator.calculatePrice(order);
		});
	}
	
	@Test
	public void SpecialRegimeTaxBillCalculationTest() {
		TaxBillCalculator calculator = new TaxBillCalculator(new SpecialRegimeTaxValidator());
		qt().forAll(orders().orderAnything()).check(orderList -> {
			Order order = new Order();
			int price = 0;
			for (Dish dish: orderList) {
				order.addDish(dish);
				if (dish.getType() == DishType.DRINK && dish.getCalories() >= 110) {
					price += dish.getPrice() * 1.29;				
				} else {
					price += dish.getPrice() * 1.19;
				}
				
			}
			return price == calculator.calculatePrice(order);
		});
	}

}
