package com.example.phase_ll_1210084;
//student name: asmaa Abed Al-Rahman Fares 
//Std.no:1210084
//Section :10L
public class ToGo extends PizaaOrder {
	// Constructors
	public ToGo() {
		super();
	}
	
	public ToGo(String customerName, int pizzaSize, int numberOfToppings, double toppingPrice) {
		super(customerName, pizzaSize, numberOfToppings, toppingPrice);
	}

	public ToGo(String customerName, int pizzaSize, boolean onions, boolean olives, boolean greenPeppers) {
	}
}
