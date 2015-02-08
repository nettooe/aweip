package com.aweip.model.entityes;

import java.io.Serializable;

/**
 * The Class Car.
 */
public class Car implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6232582648939721687L;

	/** The id. */
	private String id;

	/** The brand. */
	private String brand;

	/** The year. */
	private int year;

	/** The color. */
	private String color;

	/** The price. */
	private int price;

	/** The sold state. */
	private boolean soldState;

	/**
	 * Instantiates a new car.
	 * 
	 * @param id
	 *            the id
	 * @param brand
	 *            the brand
	 * @param year
	 *            the year
	 * @param color
	 *            the color
	 * @param price
	 *            the price
	 * @param soldState
	 *            the sold state
	 */
	public Car(String id, String brand, int year, String color, int price,
			boolean soldState) {
		super();
		this.id = id;
		this.brand = brand;
		this.year = year;
		this.color = color;
		this.price = price;
		this.soldState = soldState;
	}

	/**
	 * Gets the id.
	 * 
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the id.
	 * 
	 * @param id
	 *            the new id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Gets the brand.
	 * 
	 * @return the brand
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * Sets the brand.
	 * 
	 * @param brand
	 *            the new brand
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}

	/**
	 * Gets the year.
	 * 
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * Sets the year.
	 * 
	 * @param year
	 *            the new year
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * Gets the color.
	 * 
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * Sets the color.
	 * 
	 * @param color
	 *            the new color
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * Gets the price.
	 * 
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * Sets the price.
	 * 
	 * @param price
	 *            the new price
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/**
	 * Checks if is sold state.
	 * 
	 * @return true, if is sold state
	 */
	public boolean isSoldState() {
		return soldState;
	}

	/**
	 * Sets the sold state.
	 * 
	 * @param soldState
	 *            the new sold state
	 */
	public void setSoldState(boolean soldState) {
		this.soldState = soldState;
	}

}
