package edu.eci.pdsw.orderCalculator.services;

import java.util.LinkedList;
import java.util.List;

import com.google.inject.Inject;

import edu.eci.pdsw.orderCalculator.calculator.BillCalculator;
import edu.eci.pdsw.orderCalculator.model.Order;
import edu.eci.pdsw.orderCalculator.model.OrderCalculatorException;

public class OrdersManager {	

	private final BillCalculator cal;
    List<Order> orders = new LinkedList<>();
    
    @Inject
    OrdersManager(BillCalculator cal) {
        this.cal = cal;
    }

    public void placeOrder(Order o) {
        orders.add(o);
    }

    public Order findOrder(int n) throws OrderCalculatorException {
        if (n >= orders.size()) {
            throw new OrderCalculatorException("Order not found");
        }
        return orders.get(n);
    }

    public int calculateOrderTotal(int n) throws OrderCalculatorException {
        if (n >= orders.size()) {
            throw new OrderCalculatorException("Order not found");
        }
        return cal.calculatePrice(orders.get(n));
    }

	
}
