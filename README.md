# Shopping Cart Pricing System (Java)

## Overview

This project is a simple Java backend application that simulates the pricing logic of an e-commerce shopping cart.
It calculates the subtotal, tax, discount, shipping fees, and final price for items added to a shopping cart.

The project was built to practice Java object-oriented programming, collections, service design, and unit testing.

## Features

* Add products to a shopping cart
* Calculate subtotal based on product price and quantity
* Apply tax percentage
* Apply discount percentage
* Calculate shipping fees
* Generate a full price breakdown for the cart
* Display cart items and totals in the console
* Unit tests for pricing calculations

## Technologies Used

* Java
* Maven
* JUnit
* Git & GitHub

## Project Structure

* `model` – Contains Product, CartItem, and ShoppingCart classes
* `service` – Contains PricingService for all pricing calculations
* `config` – Global settings for tax, discount, and shipping rules
* `test` – Unit tests for validating pricing logic

## Example Output

Cart Items:
Laptop (x2) - $2000
Phone (x1) - $1200

Price Summary:
Subtotal: $3200
Tax: $384
Discount: $384
Shipping: $160
Final Price: $3360

## Purpose

This project was created as part of learning Java and practicing how backend systems calculate prices in e-commerce applications.
