package app.objects;

/**
 * products
 * this should be in database
 * @author nicol
 *
 */
public enum Product {
	APPLE(1, 110d),
	PEAR(2, 200d),
	POTATO(3, 50d),
	TOMATO(4, 75d);
	
	Integer index;
	Double price;
	
	Product(Integer index, Double price) {
		this.index = index;
		this.price = price;
	}

}
