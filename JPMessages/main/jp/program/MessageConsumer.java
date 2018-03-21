/**
 * 
 */
package jp.program;


import jp.messages.Message;
import jp.utils.GenerationFunctions;
import jp.utils.Memory;

/**
 * test class, generates and prints messages
 * @author nicol
 *
 */
public class MessageConsumer {


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for (int index = 0; index < 10 ; index++) {
			Message message = GenerationFunctions.generateMessage();
			message.handleMessage();
			System.out.println(message);
			System.out.println(Memory.getMemory());
		}
	}
	
}
