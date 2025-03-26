package com.example.phase_ll_1210084;
//student name: asmaa Abed Al-Rahman Fares 
//Std.no:1210084
//Section :10L
public class Seated extends PizaaOrder {
	// Attributes
	private double serviceCharge;
	private int numberOfPeople;
	
	// Constructors
	public Seated() {
		super();
		this.serviceCharge = 0.0;
		this.numberOfPeople = 0;
	}
	
	public Seated(String customerName, int pizzaSize, int numberOfToppings, double toppingPrice, double serviceCharge, int numberOfPeople) {
		super(customerName, pizzaSize, numberOfToppings, toppingPrice);
		this.serviceCharge = serviceCharge;
		this.numberOfPeople = numberOfPeople;
	}

	public Seated(String customerName, int pizzaSize, boolean onions, boolean olives, boolean greenPeppers, double serviceCharge, int numberOfPeople) {
	}

	// Getters and Setters
	public double getServiceCharge() {
		return serviceCharge;
	}
	
	public void setServiceCharge(double serviceCharge) {
		this.serviceCharge = serviceCharge;
	}
	
	public int getNumberOfPeople() {
		return numberOfPeople;
	}
	
	public void setNumberOfPeople(int numberOfPeople) {
		this.numberOfPeople = numberOfPeople;
	}
	
	// toString()
	@Override
	public String toString() {
		String size;
		if (getPizzaSize() == SMALL) {
			size = "Small";
		} else if (getPizzaSize() == MEDIUM) {
			size = "Medium";
		} else {
			size = "Large";
		}
		return "Seated Order for " + getCustomerName() + ":\n"
				+ "Size: " + size + "\n"
				+ "Number of toppings: " + getNumberOfToppings() + "\n"
				+ "Topping price: " + getToppingPrice() + "\n"
				+ "Service charge: " + serviceCharge + "\n"
				+ "Number of people: " + numberOfPeople + "\n"
				+ "Order price: " + calculateOrderPrice() + "\n";
	}
	
	// calculateOrderPrice()
	@Override
	public double calculateOrderPrice() {
		return super.calculateOrderPrice() + (serviceCharge * numberOfPeople);
	}
}