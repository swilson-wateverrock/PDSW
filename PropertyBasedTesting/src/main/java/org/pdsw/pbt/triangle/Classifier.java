package org.pdsw.pbt.triangle;

public class Classifier {
    public TriangleType classify(int x, int y, int z) {
    	if (x <= 0 || y <= 0 || z <= 0) {
                         
            return TriangleType.NotATriangle;

          } // TODO  Add the missing cases according to equivalence classes
          else {
          	if(x + y < z ||x+ z < y || y + z <x ) {
          	              
              	return TriangleType.NotATriangle;
          	}else if(x == y && y == z) {
          		             
              	return TriangleType.Equilateral;
          	}else if(x== y || y == z ||x== z) {
          		              
              	return TriangleType.Isosceles;
          	}
          	else {          		            
              	return  TriangleType.Scalene;
          	}
          	
          }
        
    }
}