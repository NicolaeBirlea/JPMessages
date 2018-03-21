package jp.messages;

import jp.objects.Sale;
import jp.utils.Memory;

/**
 * multiple duplicate sales are practically defined here
 * @author nicol
 *
 */
public class MultipleSaleMessage implements Message{
	
	public MultipleSaleMessage(Sale sale, Integer numberOfSales) {
		super();
		this.sale = sale;
		this.numberOfSales = numberOfSales;
	}
	private Sale sale;
	private Integer numberOfSales;
	
	public Sale getSale() {
		return sale;
	}
	public void setSale(Sale sale) {
		this.sale = sale;
	}
	public Integer getNumberOfSales() {
		return numberOfSales;
	}
	public void setNumberOfSales(Integer numberOfSales) {
		this.numberOfSales = numberOfSales;
	}
	
	/**
	 * this handler simply adds the same sale the numberOfSales times to the memory
	 */
	public void handleMessage() {
		for (int index = 0; index < getNumberOfSales(); index++) 
			Memory.getMemory().add(getSale());
	}
	
	public String toString() {
		return ("Multiple Meessage - " + getSale().toString() + " - repetitions " + getNumberOfSales());
	} 

}
