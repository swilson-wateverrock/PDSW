package edu.eci.pdsw.orderCalculator.generators;

import org.quicktheories.core.Gen;
import org.quicktheories.generators.Generate;

import edu.eci.pdsw.orderCalculator.model.Dish;
import edu.eci.pdsw.orderCalculator.model.*;
import static org.quicktheories.generators.SourceDSL.*;

public class DishGenerator {
	
	public Gen<Dish> onlyDrinks() {
		return names().zip(drinkPrices(), drinkCalories(), (name, price, calories) -> new Dish(DishType.DRINK, name, price, calories));
	}
	
	public Gen<Dish> onlyPlates() {
		return names().zip(platePrices(), plateCalories(), (name, price, calories) -> new Dish(DishType.PLATE, name, price, calories));
	}
	
	public Gen<Dish> all() {
		return Generate.oneOf(onlyDrinks(), onlyPlates());
	}
	
	private Gen<String> names() {
		return strings().betweenCodePoints(65, 122).ofLengthBetween(6, 15);
	}
	
	private Gen<Integer> drinkPrices() {
		return integers().from(1500).upToAndIncluding(3500);
	}
	
	private Gen<Integer> platePrices() {
		return integers().from(12000).upToAndIncluding(25000);
	}
	
	private Gen<Integer> plateCalories() {
		return integers().from(2000).upToAndIncluding(6000);
	}
	
	private Gen<Integer> drinkCalories() {
		return integers().from(500).upToAndIncluding(2500);
	}

}
