package edu.eci.pdsw.orderCalculator.generators;

public class Generators {
	
	public static OrderGenerator orders() {
		return new OrderGenerator();
	}
	
	public static DishGenerator dishes() {
		return new DishGenerator();
	}

}
