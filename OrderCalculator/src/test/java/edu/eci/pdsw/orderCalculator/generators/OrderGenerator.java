package edu.eci.pdsw.orderCalculator.generators;

import static edu.eci.pdsw.orderCalculator.generators.Generators.dishes;
import static org.quicktheories.generators.SourceDSL.lists;

import java.util.List;

import org.quicktheories.core.Gen;

import edu.eci.pdsw.orderCalculator.model.Dish;

public class OrderGenerator {
	
	public Gen<List<Dish>> empty() {
		return lists().of(dishes().all()).ofSize(0);
	}
	
	public Gen<List<Dish>> orderAnything() {
		return lists().of(dishes().all()).ofSizeBetween(3, 7);
	}
	
	public Gen<List<Dish>> orderDrinks() {
		return lists().of(dishes().onlyDrinks()).ofSizeBetween(3, 7);
	}
	
	public Gen<List<Dish>> orderPlates() {
		return lists().of(dishes().onlyPlates()).ofSizeBetween(3, 7);
	}

}
