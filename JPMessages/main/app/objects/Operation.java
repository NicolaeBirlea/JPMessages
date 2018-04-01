package app.objects;

import java.util.function.BiFunction;

/**
 * here we actually define the operations and their corresponding function for usage
 * @author nicol
 *
 */
public enum Operation {
	
	ADD(OperationType.ADD,((sale, correction) -> {sale.setQuantity(sale.getQuantity() + correction); return sale;})),
	MULTIPLY(OperationType.MULTIPLY,((sale, correction) -> {sale.setQuantity(sale.getQuantity() * correction); return sale;})) ,
	SUBSTRACT(OperationType.SUBSTRACT,((sale, correction) -> {sale.setQuantity(sale.getQuantity() - correction); return sale;}));
	
	private OperationType operationType;
	private BiFunction<Sale,Integer, Sale> correctFunction;
	
	Operation(OperationType operation, BiFunction<Sale,Integer, Sale> correctFunction ) {
		this.operationType = operation;
		this.correctFunction = correctFunction;
	}

	public OperationType getOperationType() {
		return operationType;
	}

	public BiFunction<Sale,Integer, Sale> getCorrectFunction() {
		return correctFunction;
	}
	
	public static Operation getValue(OperationType type) {
		for (Operation e : Operation.values()) {
			if (e.getOperationType() == type) {
				return e;
			}
		}
		return null; // not found
	}

}
