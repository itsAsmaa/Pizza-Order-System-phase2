# 🍕 Pizza Order System 

## Project Overview 

Welcome to the Pizza Order System! 🍕 This project allows users to place and manage different types of pizza orders: **ToGo**, **Delivery**, and **Seated**. The application calculates the price of each order based on various factors such as pizza size, toppings, and additional charges (e.g., trip rates, service charges).

This system uses JavaFX for the graphical user interface (GUI), providing a smooth user experience while managing pizza orders. 🖥️

### Key Features:
- 🍕 **Multiple Pizza Order Types**:
  - **ToGo**: A basic pizza order.
  - **Delivery**: Includes a trip rate and zone calculation for delivery orders.
  - **Seated**: Includes service charges based on the number of people.

- 💰 **Price Calculation**: The total price of an order is dynamically calculated based on:
  - Pizza size (Small, Medium, Large)
  - Number of toppings selected
  - Topping price
  - Additional charges like trip rates and service fees

- 🔄 **Order Sorting**: Orders are automatically sorted based on their price, from the lowest to the highest.

- 🖨️ **Order Display**: Once the orders are sorted, you can view a detailed list of customer names and their respective order prices.

- 🧹 **Reset Functionality**: Allows users to clear all entered data and reset the system.

## Project Files 📁

### 1. **PizaaOrder.java** 
This abstract class serves as the base for all pizza orders. It defines common attributes such as customer name, pizza size, toppings, and their respective prices.

- **Key Methods**:
  - `calculateOrderPrice()`: Calculates the price of the order based on the pizza size and toppings.
  - `compareTo()`: Compares pizza orders based on the total price.
  - `toString()`: Provides a string representation of the order details.

### 2. **Delivery.java**
The `Delivery` class extends `PizaaOrder` and adds functionality for delivery orders, including trip rates and delivery zones.

- **Key Methods**:
  - `calculateOrderPrice()`: Overrides the base class method to include additional delivery charges based on the trip rate and zone.
  - `toString()`: Displays the delivery-specific details, including trip rate and zone.

### 3. **Seated.java**
The `Seated` class extends `PizaaOrder` and adds service charges and the number of people being served.

- **Key Methods**:
  - `calculateOrderPrice()`: Includes the service charge and the number of people in the price calculation.
  - `toString()`: Displays the seated-specific details, including service charges.

### 4. **ToGo.java**
The `ToGo` class extends `PizaaOrder` and represents a basic pizza order with no additional charges (other than the toppings).

### 5. **Driver.java**
This is the main class with the GUI logic powered by JavaFX. It allows users to input their pizza order details, process the order, and display or reset orders.

- **Key Features**:
  - The GUI lets users input customer name, order type, pizza size, toppings, and other optional parameters like service charge or delivery trip rates.
  - **Buttons**:
    - **Process Order**: Adds the order to the list.
    - **Print Orders**: Displays a list of all orders sorted by price.
    - **Reset**: Clears the input fields and resets the system.

## How to Use the Application 🎮

1. **Launch the Application**: Run `Driver.java` to start the GUI.
2. **Place an Order**:
   - Choose the **order type** (ToGo, Delivery, Seated).
   - Select the **pizza size** (Small, Medium, Large).
   - Choose toppings 🍅 (Onions, Olives, Green Peppers).
   - Set **topping price** 💲 and enter additional charges (e.g., **trip rate** for Delivery or **service charge** for Seated).
3. **Process Order**: Click the "Process Order" button to add the order to the system and calculate the price.
4. **Print Orders**: Click "Print Orders" to view a list of all orders sorted by their price.
5. **Reset**: Click "Reset" to clear all input fields and start fresh.

## Example Interaction 📝

- **Place a Delivery Order**:
  - Customer: "Rana"
  - Pizza Size: Medium
  - Toppings: 3 (Onions, Olives, Green Peppers)
  - Trip Rate: $15
  - Zone: 2

  **Price Calculation**: 
  - Order Price: `$36.0`

- **Place a Seated Order**:
  - Customer: "Jamal"
  - Pizza Size: Small
  - Toppings: 1 (Olives)
  - Service Charge: $5
  - Number of People: 4

  **Price Calculation**:
  - Order Price: `$25.0`

## Requirements 🖥️

- **Java 8 or higher** is required to run the program.
- **JavaFX** for the GUI.

## Conclusion 🌟

This project is a fun and interactive way to manage pizza orders! 🍕 You can place delivery, seated, or to-go orders and calculate the total prices based on toppings and additional charges. It's designed to be user-friendly with a graphical interface, making it easy to process and view pizza orders. Enjoy the pizza-making experience! 🍕🎉

---

Thank you for using the Pizza Order System! 🍕
