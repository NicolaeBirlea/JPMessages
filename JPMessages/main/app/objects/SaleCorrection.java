package app.objects;

/**
 * this class defines a correction for correction messages 
 * @author nicol
 *
 */
public class SaleCorrection {
	
	public SaleCorrection(Integer qantityCorrection, OperationType operationType) {
		super();
		this.qantityCorrection = qantityCorrection;
		this.operationType = operationType;
	}

	private Integer qantityCorrection;
	private OperationType operationType;
	
	public OperationType getOperationType() {
		return operationType;
	}
	public void setOperationType(OperationType operationType) {
		this.operationType = operationType;
	}
	public Integer getQantityCorrection() {
		return qantityCorrection;
	}
	public void setQantityCorrection(Integer qantityCorrection) {
		this.qantityCorrection = qantityCorrection;
	}
	
	public String toString() {
		return ("Sale Correction - Operation " + getOperationType().name + " - Quantity " + getQantityCorrection());
	} 

}
