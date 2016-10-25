package server;

import commands.Calculation;
import factory.CommandFactory;

// Singleton
public class Protocol {
	private static Protocol protocol;
	
	private Protocol(){}
	
	public static Protocol getInstance(){
		if(protocol==null){
			return protocol = new Protocol();
		}
		return protocol;
	}

	public String process(String msg){
		//split the String into an array of Strings
		String arr[] = msg.split(" ");
		
		//create a factory for the command
		CommandFactory factory = new CommandFactory();
		
		//extract the command and create an Object using the factory
		String command = arr[0].trim().toLowerCase();
		Calculation calculation = factory.createCalculation(command);
		
		//return the result of the calculation
		return calculation.process(arr);

	}

}
