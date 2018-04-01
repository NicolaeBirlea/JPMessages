/**
 * 
 */
package app.main;


import app.messages.Message;
import app.utils.GenerationFunctions;
import app.utils.Memory;

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
		
		Integer numberOfMessages =  10; // default value
		if (args.length > 0 && args[0].matches("\\d+")) {
			numberOfMessages = Integer.valueOf(args[0]);
		}
		
		for (int index = 0; index < numberOfMessages ; index++) {
			Message message = GenerationFunctions.generateMessage();
			message.handleMessage();
			System.out.println(message);
			System.out.println(Memory.getMemory());
		}
	}
	
}
