package server;

import commands.Calculation;
import factory.CommandFactory;

public class Protocol {



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
