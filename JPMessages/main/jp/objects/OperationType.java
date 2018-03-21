package jp.objects;

public enum OperationType {
	ADD("+"),
	MULTIPLY("*") ,
	SUBSTRACT("-");
	
	String name;
	
	OperationType(String name) {
		this.name = name;
	}
}
