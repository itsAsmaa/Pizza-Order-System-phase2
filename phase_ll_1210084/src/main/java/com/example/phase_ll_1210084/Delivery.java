package com.example.phase_ll_1210084;
//student name: asmaa Abed Al-Rahman Fares 
//Std.no:1210084
//Section :10L
public class Delivery extends PizaaOrder {
	// Attributes
	private double tripRate;
	private int zone;
	
	// Constructors
	public Delivery() {
		super();
		this.tripRate = 0.0;
		this.zone = 0;
	}
	
	public Delivery(String customerName, int pizzaSize, int numberOfToppings, double toppingPrice, double tripRate, int zone) {
		super(customerName, pizzaSize, numberOfToppings, toppingPrice);
		this.tripRate = tripRate;
		this.zone = zone;
	}

	public Delivery(String customerName, int pizzaSize, boolean onions, boolean olives, boolean greenPeppers, double tripRate, int zone) {
	}

	// Getters and Setters
	public double getTripRate() {
		return tripRate;
	}
	
	public void setTripRate(double tripRate) {
		this.tripRate = tripRate;
	}
	
	public int getZone() {
		return zone;
	}
	
	public void setZone(int zone) {
		this.zone = zone;
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
		return "Delivery Order for " + getCustomerName() + ":\n"
				+ "Size: " + size + "\n"
				+ "Number of toppings: " + getNumberOfToppings() + "\n"
				+ "Topping price: " + getToppingPrice() + "\n"
				+ "Trip rate: " + tripRate + "\n"
				+ "Zone: " + zone + "\n"
				+ "Order price: " + calculateOrderPrice() + "\n";
	}
	
	// calculateOrderPrice()
	@Override
	public double calculateOrderPrice() {
		return super.calculateOrderPrice() + (tripRate/100 * super.calculateOrderPrice() * zone);
	}
}