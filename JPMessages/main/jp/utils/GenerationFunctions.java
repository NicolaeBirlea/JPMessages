package jp.utils;

import java.util.Random;

import jp.messages.BasicSaleMessage;
import jp.messages.CorrectionSaleMessage;
import jp.messages.Message;
import jp.messages.MultipleSaleMessage;
import jp.objects.OperationType;
import jp.objects.Product;
import jp.objects.Sale;
import jp.objects.SaleCorrection;

/**
 * class for message and object generations
 * @author nicol
 *
 */
public class GenerationFunctions {
	
	private final static Random random = new Random();
	
	/**
	 * generates a sale object
	 * @return Sale
	 */
	public static Sale generateRandomSale() {
		Product[] productArray = Product.values();
		return new Sale(productArray[random.nextInt(productArray.length)], random.nextInt(100));
	}
	
	/**
	 * generates a sale correction 
	 * @return SaleCorrection
	 */
	public static SaleCorrection generateRandomSaleCorrection() {
		OperationType[] OpTypeArray = OperationType.values();
		return new SaleCorrection(random.nextInt(10), OpTypeArray[random.nextInt(OpTypeArray.length)]);
	}
	
	/**
	 * generates a normal message 
	 * @return BasicSaleMessage
	 */
	public static BasicSaleMessage generateRandomSaleMessage() {
		return new BasicSaleMessage(generateRandomSale());
	}
	
	/**
	 * generates a multiple sale message
	 * @return MultipleSaleMessage
	 */
	public static MultipleSaleMessage generateMultipleSaleMessage() {
		return new MultipleSaleMessage(generateRandomSale(), random.nextInt(10));
	}
	
	/**
	 * generates a correction message
	 * @return CorrectionSaleMessage
	 */
	public static CorrectionSaleMessage generateCorrectionSaleMessage() {
		return new CorrectionSaleMessage(generateRandomSale(), generateRandomSaleCorrection());
	}
	
	/**
	 * this function is used for testing purposes, generates a random message
	 * normal messages have higher probability, correction messages are less frequent
	 * @return Message
	 */
	public static Message generateMessage() {
		if (random.nextInt(10) > 3) return generateRandomSaleMessage(); 
		if (random.nextInt(10) < 3) return generateMultipleSaleMessage(); 
		return generateCorrectionSaleMessage();
	}
	

}
