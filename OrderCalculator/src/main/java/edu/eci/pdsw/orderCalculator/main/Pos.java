package edu.eci.pdsw.orderCalculator.main;

import com.google.inject.Guice;
import com.google.inject.Injector;

import edu.eci.pdsw.orderCalculator.injectors.CalculatorModule;
import edu.eci.pdsw.orderCalculator.model.Dish;
import edu.eci.pdsw.orderCalculator.model.DishType;
import edu.eci.pdsw.orderCalculator.model.Order;
import edu.eci.pdsw.orderCalculator.model.OrderCalculatorException;
import edu.eci.pdsw.orderCalculator.services.OrdersManager;

public class Pos {

    public static void main(String a[]) throws OrderCalculatorException {
    	Injector injector = Guice.createInjector(new CalculatorModule());
        OrdersManager manager = injector.getInstance(OrdersManager.class);
        loadOrders(manager);

        System.out.println(manager.calculateOrderTotal(0));
        System.out.println(manager.calculateOrderTotal(1));
    }

    private static void loadOrders(OrdersManager manager) {

        Order order = new Order();
        order.addDish(new Dish(DishType.PLATE, "pizza", 7500, 266));
        order.addDish(new Dish(DishType.DRINK, "pepsi 300ml", 3900, 150));
        order.addDish(new Dish(DishType.PLATE, "hamburguesa", 8000, 295));
        order.addDish(new Dish(DishType.DRINK, "sprite 300ml", 2000, 150));

        manager.placeOrder(order);

        order = new Order();

        order.addDish(new Dish(DishType.PLATE, "pizza", 7500, 265));
        order.addDish(new Dish(DishType.PLATE, "pizza", 7500, 265));
        order.addDish(new Dish(DishType.PLATE, "pizza", 7500, 265));
        order.addDish(new Dish(DishType.DRINK, "pepsi litro", 5000, 450));

        manager.placeOrder(order);
    }
}