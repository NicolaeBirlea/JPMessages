package jp.utils;

import java.util.ArrayList;
import java.util.List;

import jp.objects.Sale;

/**
 * database simulator, in memory object
 * some fucntions were defined for ease 
 * @author nicol
 *
 */

public class Memory {
	private static List<Sale> saleMemory = new ArrayList<Sale>();

	public static List<Sale> getMemory() {
		return saleMemory;
	}

	public static void setMemory(List<Sale> memory) {
		Memory.saleMemory = memory;
	}
	
	public static void emptyMemory() {
		saleMemory = new ArrayList<Sale>();
	}
}
