
# Diseño de pruebas para los distintos tipos de calculadora

## BasicBillCalculator

Esta calculadora no hace uso de la clase `TaxValidator` .

```java
public class CalculatorModule extends AbstractModule {
  @Override 
  protected void configure() {

  /*
	* En este caso es innecesario vincular un Tax Validator, se vincula
	* por defecto al StandardTaxValidator.
	*/
   bind(BillCalculator.class).to(BasicBillCalculator.class);
	bind(TaxValidator.class).to(StandardTaxValidator.class);

  }
}
```

Al ejecutar la clase `main` con esta configuración, se arrojan los siguientes resultados:

```
21400
27500
```

## TipBillCalculator

Esta calculadora, al igual que la `BasicBillCalculator` no hace uso de la clase `TaxValidator`.

```java
public class CalculatorModule extends AbstractModule {
  @Override 
  protected void configure() {
  
	/*
	 * En este caso es innecesario vincular un Tax Validator, se vincula
	 * por defecto al StandardTaxValidator.
	 */
    bind(BillCalculator.class).to(TipBillCalculator.class);
	 bind(TaxValidator.class).to(StandardTaxValidator.class);
	
  }
}
```

Al ejecutar la clase `main` con esta configuración, se arrojan los siguientes resultados:

```
23540
30250
```

## TaxBillCalculator

Se deben tener en cuenta los casos para dos `TaxValidator` diferentes: `StandardTaxValidator` y `SpecielRegimeTaxValidator`.

### StandardTaxValidator

```java
public class CalculatorModule extends AbstractModule {
  @Override 
  protected void configure() {
  
	bind(BillCalculator.class).to(TaxBillCalculator.class);
	bind(TaxValidator.class).to(StandardTaxValidator.class);
	
  }
}
```

Al ejecutar la clase `main` con esta configuración, se arrojan los siguientes resultados:

```
25466
32725
```

### SpecialRegimeTaxValidator

```java
public class CalculatorModule extends AbstractModule {
  @Override 
  protected void configure() {
      
	bind(BillCalculator.class).to(TaxBillCalculator.class);
	bind(TaxValidator.class).to(SpecialRegimeTaxValidator.class);
	
  }
}
```

Al ejecutar la clase `main` con esta configuración, se arrojan los siguientes resultados:

```
26056
33225
```