package com.example.phase_ll_1210084;
import java.util.Date;

//student name: asmaa Abed Al-Rahman Fares 
//Std.no:1210084
//Section :10L

public abstract class PizaaOrder implements Comparable<PizaaOrder> {
	// Attributes
	private String customerName;
	private Date dateOrdered;
	public static final int SMALL = 1;
	public static final int MEDIUM = 2;
	public static final int LARGE = 3;
	private int pizzaSize;
	private int numberOfToppings;
	private double toppingPrice;
	
	// Constructors
	public PizaaOrder() {
		this("", 0, 0, 0.0);
	}
	
	public PizaaOrder(String customerName, int pizzaSize, int numberOfToppings, double toppingPrice) {
		this.customerName = customerName;
		this.pizzaSize = pizzaSize;
		this.numberOfToppings = numberOfToppings;
		this.toppingPrice = toppingPrice;
		dateOrdered = new Date();
	}
	
	// Getters and Setters
	public String getCustomerName() {
		return customerName;
	}
	
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	public Date getDateOrdered() {
		return dateOrdered;
	}
	
	public void setDateOrdered(Date dateOrdered) {
		this.dateOrdered = dateOrdered;
	}
	
	public int getPizzaSize() {
		return pizzaSize;
	}
	
	public void setPizzaSize(int pizzaSize) {
		this.pizzaSize = pizzaSize;
	}
	
	public int getNumberOfToppings() {
		return numberOfToppings;
	}
	
	public void setNumberOfToppings(int numberOfToppings) {
		this.numberOfToppings = numberOfToppings;
	}
	
	public double getToppingPrice() {
		return toppingPrice;
	}
	
	public void setToppingPrice(double toppingPrice) {
		this.toppingPrice = toppingPrice;
	}
	
	// toString()
	@Override
	public String toString() {
		String size;
		if (pizzaSize == SMALL) {
			size = "Small";
		} else if (pizzaSize == MEDIUM) {
			size = "Medium";
		} else {
			size = "Large";
		}
		return "Pizza Order for " + customerName + ":\n"
				+ "Size: " + size + "\n"
				+ "Number of toppings: " + numberOfToppings + "\n"
				+ "Topping price: " + toppingPrice + "\n"
				+ "Order price: " + calculateOrderPrice() + "\n";
	}
	
	// calculateOrderPrice()
	public double calculateOrderPrice() {
		return (numberOfToppings * toppingPrice) * pizzaSize;
	}
	
	// printOrderInfo()
	public void printOrderInfo() {
		System.out.println(customerName + ": " + calculateOrderPrice());
	}
	
	// compareTo()
	@Override
	public int compareTo(PizaaOrder other) {
		if (this.calculateOrderPrice() > other.calculateOrderPrice()) {
			return 1;
		} else if (this.calculateOrderPrice() < other.calculateOrderPrice()) {
			return -1;
		} else {
			return 0;
		}
	}
}
