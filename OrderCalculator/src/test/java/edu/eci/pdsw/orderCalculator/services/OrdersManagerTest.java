package edu.eci.pdsw.orderCalculator.services;

import static edu.eci.pdsw.orderCalculator.generators.Generators.orders;
import static org.quicktheories.QuickTheory.qt;

import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;

import edu.eci.pdsw.PBTClassifier;
import edu.eci.pdsw.orderCalculator.injectors.CalculatorModule;
import edu.eci.pdsw.orderCalculator.model.Dish;
import edu.eci.pdsw.orderCalculator.model.Order;
import edu.eci.pdsw.orderCalculator.model.OrderCalculatorException;

public class OrdersManagerTest {
	
	@Test
	public void validateOrderPlacement() {
		PBTClassifier classifier = new PBTClassifier("validateOrderPlacementTest");
		qt().forAll(orders().orderAnything()).check(orderList -> {
			Injector injector = Guice.createInjector(new CalculatorModule());
			OrdersManager manager = injector.getInstance(OrdersManager.class);
			Order order = new Order();
			for (Dish dish: orderList) {
				order.addDish(dish);
			}
			if (orderList.size() != 4) manager.placeOrder(order);
			try {
				manager.findOrder(0);
				classifier.collect("Orders found");
				return true;
			} catch (OrderCalculatorException e) {
				classifier.collect("Orders not found");
				return e.getMessage() == "Order not found";
			}
		});
		classifier.results();
	}
	
	@Test
	public void validateOrderSearching() {
		PBTClassifier classifier = new PBTClassifier("validateOrderSearchingTest");
		qt().forAll(orders().orderAnything()).check(orderList -> {
			Injector injector = Guice.createInjector(new CalculatorModule());
			OrdersManager manager = injector.getInstance(OrdersManager.class);
			Order order = new Order();
			for (Dish dish: orderList) {
				order.addDish(dish);
			}
			if (orderList.size() != 4) manager.placeOrder(order);
			try {
				if (manager.findOrder(0) == order) {
					classifier.collect("Orders found");
					return true;
				} else {
					return false;
				}
			} catch (OrderCalculatorException e) {
				classifier.collect("Orders not found");
				return e.getMessage() == "Order not found";
			}
		});
		classifier.results();
	}

}