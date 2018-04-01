package app.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import app.messages.BasicSaleMessage;
import app.messages.CorrectionSaleMessage;
import app.messages.MultipleSaleMessage;
import app.objects.Operation;
import app.objects.Sale;
import app.utils.GenerationFunctions;
import app.utils.Memory;

/**
 * test class for the handler functions
 * as their name says each function is for a type of message handler
 * @author nicol
 *
 */
public class HandlerTests {
	
	@Before
	public void setUp() {
		Memory.emptyMemory();
	}

	@Test
	public void testBasicSaleHandler() {
		BasicSaleMessage basicSaleMessage = GenerationFunctions.generateRandomSaleMessage();
		basicSaleMessage.handleMessage();
		assertEquals(basicSaleMessage.getSale(), Memory.getMemory().get(0));
	}
	
	@Test
	public void testMultipleSaleHandler() {
		MultipleSaleMessage multipleSaleMessage = GenerationFunctions.generateMultipleSaleMessage();
		multipleSaleMessage.handleMessage();
		assertEquals(new Integer(Memory.getMemory().size()), multipleSaleMessage.getNumberOfSales());
		Memory.getMemory().stream().forEach(s -> assertEquals(multipleSaleMessage.getSale(), s));
	}
	
	@Test
	public void testCorrectionSaleHandler() {
		BasicSaleMessage basicSaleMessage = GenerationFunctions.generateRandomSaleMessage();
		Sale basicSaleCopy = basicSaleMessage.getSale().copySale();
		CorrectionSaleMessage correctionSaleMessage = GenerationFunctions.generateCorrectionSaleMessage();
		correctionSaleMessage.getSale().setProduct(basicSaleMessage.getSale().getProduct());
		basicSaleMessage.handleMessage();
		correctionSaleMessage.handleMessage();
		assertEquals(Memory.getMemory().size(), 2);
		assertEquals(Memory.getMemory().get(0).getQuantity(), 
				Operation.getValue(correctionSaleMessage.getSaleCorrection().getOperationType()).getCorrectFunction()
				.apply(basicSaleCopy, correctionSaleMessage.getSaleCorrection().getQantityCorrection()).getQuantity());
	}
	
	


}
