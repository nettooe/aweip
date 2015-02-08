package com.aweip.jsf.services;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import com.aweip.model.entityes.Car;

/**
 * The Class CarService.
 */
@ManagedBean(name = "carService")
@ApplicationScoped
public class CarService implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The Constant colors. */
	private final static String[] colors;

	/** The Constant brands. */
	private final static String[] brands;

	static {
		colors = new String[10];
		colors[0] = "Black";
		colors[1] = "White";
		colors[2] = "Green";
		colors[3] = "Red";
		colors[4] = "Blue";
		colors[5] = "Orange";
		colors[6] = "Silver";
		colors[7] = "Yellow";
		colors[8] = "Brown";
		colors[9] = "Maroon";

		brands = new String[10];
		brands[0] = "BMW";
		brands[1] = "Mercedes";
		brands[2] = "Volvo";
		brands[3] = "Audi";
		brands[4] = "Renault";
		brands[5] = "Fiat";
		brands[6] = "Volkswagen";
		brands[7] = "Honda";
		brands[8] = "Jaguar";
		brands[9] = "Ford";
	}

	/**
	 * Creates the cars.
	 * 
	 * @param size
	 *            the size
	 * @return the list
	 */
	public List<Car> createCars(int size) {
		List<Car> list = new ArrayList<Car>();
		for (int i = 0; i < size; i++) {
			list.add(new Car(getRandomId(), getRandomBrand(), getRandomYear(),
					getRandomColor(), getRandomPrice(), getRandomSoldState()));
		}

		return list;
	}

	/**
	 * Gets the random id.
	 * 
	 * @return the random id
	 */
	private String getRandomId() {
		return UUID.randomUUID().toString().substring(0, 8);
	}

	/**
	 * Gets the random year.
	 * 
	 * @return the random year
	 */
	private int getRandomYear() {
		return (int) (Math.random() * 50 + 1960);
	}

	/**
	 * Gets the random color.
	 * 
	 * @return the random color
	 */
	private String getRandomColor() {
		return colors[(int) (Math.random() * 10)];
	}

	/**
	 * Gets the random brand.
	 * 
	 * @return the random brand
	 */
	private String getRandomBrand() {
		return brands[(int) (Math.random() * 10)];
	}

	/**
	 * Gets the random price.
	 * 
	 * @return the random price
	 */
	public int getRandomPrice() {
		return (int) (Math.random() * 100000);
	}

	/**
	 * Gets the random sold state.
	 * 
	 * @return the random sold state
	 */
	public boolean getRandomSoldState() {
		return (Math.random() > 0.5) ? true : false;
	}

	/**
	 * Gets the colors.
	 * 
	 * @return the colors
	 */
	public List<String> getColors() {
		return Arrays.asList(colors);
	}

	/**
	 * Gets the brands.
	 * 
	 * @return the brands
	 */
	public List<String> getBrands() {
		return Arrays.asList(brands);
	}
}