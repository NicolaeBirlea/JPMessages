package app.messages;

import app.objects.Sale;
import app.utils.Memory;

/**
 * simple message, has only a sale
 * @author nicol
 *
 */
public class BasicSaleMessage implements Message {
	
	public BasicSaleMessage(Sale sale) {
		super();
		this.sale = sale;
	}

	private Sale sale;

	public Sale getSale() {
		return sale;
	}

	public void setSale(Sale sale) {
		this.sale = sale;
	}
	
	/**
	 * this handler simply adds the message to the memory
	 */
	public void handleMessage() {
		Memory.getMemory().add(getSale());
	}
	
	public String toString() {
		return ("Normal Meessage - " + getSale().toString());
	} 
	
}
