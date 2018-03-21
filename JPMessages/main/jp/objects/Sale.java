package jp.objects;


/**
 * main Sale object defines needed functions for ease of development
 * @author nicol
 *
 */
public class Sale {
	
	 public Sale(Product product, Integer quantity) {
		super();
		this.product = product;
		this.quantity = quantity;
	}

	private Product product;
	private Integer quantity;

	public Product getProduct() {
		return product;
	}
	
	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	public String toString() {
		return ("Sale - product " + getProduct().name() + " - quantity " + getQuantity());
	} 
	
	public boolean equals(Object obj) {
	    if (obj == null) {
	        return false;
	    }
	    
	    if (!Sale.class.isAssignableFrom(obj.getClass())) {
	        return false;
	    }
	    
	    final Sale sale = (Sale) obj;
		return this.getProduct().equals(sale.getProduct()) && this.getQuantity().equals(sale.getQuantity());
	} 
	
	public Sale copySale() {
		return new Sale(this.getProduct(), new Integer(this.getQuantity()));	
	}
		

}
