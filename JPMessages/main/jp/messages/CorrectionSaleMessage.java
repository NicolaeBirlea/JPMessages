package jp.messages;


import jp.objects.Operation;
import jp.objects.Sale;
import jp.objects.SaleCorrection;
import jp.utils.Memory;

/**
 * correction sale message
 * this on top of the sale has a correction object attached 
 * (only the quantity is corrected, everything can be calculated from there, via price from product object)
 * @author nicol
 *
 */
public class CorrectionSaleMessage implements Message {
	
	public CorrectionSaleMessage(Sale sale, SaleCorrection saleCorrection) {
		super();
		this.sale = sale;
		this.saleCorrection = saleCorrection;
	}

	private Sale sale;
	private SaleCorrection saleCorrection;

	public Sale getSale() {
		return sale;
	}

	public void setSale(Sale sale) {
		this.sale = sale;
	}

	public SaleCorrection getSaleCorrection() {
		return saleCorrection;
	}

	public void setSaleCorrection(SaleCorrection saleCorrection) {
		this.saleCorrection = saleCorrection;
	}
	
	/**
	 * here we handle the correction message via the Operation define function
	 */
	public void handleMessage() {
		Memory.getMemory().stream()
			.filter(s -> s.getProduct().equals(getSale().getProduct()))
			.forEach(s -> Operation.getValue(getSaleCorrection().getOperationType()).getCorrectFunction().apply(s, getSaleCorrection().getQantityCorrection()));
		Memory.getMemory().add(getSale());
	}
	
	public String toString() {
		return ("Correction Meessage - " + getSale().toString() + " - Correction " + getSaleCorrection().toString());
	} 

}
